package com.solicitud.afiliacion.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.solicitud.afiliacion.entities.Afiliacion;
import com.solicitud.afiliacion.repositories.AfiliacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.KafkaException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.UUID;
import java.util.Base64;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

@Service
public class AfiliacionService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private AfiliacionRepository afiliacionRepository;

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private RestTemplate restTemplate;

    public Afiliacion guardarAfiliacion(Afiliacion afiliacion, List<String> archivosPDFBase64) throws Exception {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8084/generatedId", String.class);
        String afiliacionIdRest = responseEntity.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(afiliacionIdRest);
        String idValue = jsonNode.get("id").asText();
        String afiliacionId = idValue;
        afiliacion.setId(afiliacionId);

        String bucketName = reemplazarEspacios(afiliacion.getPrimerNombre().toLowerCase()) + "-" +
                reemplazarEspacios(afiliacion.getApellidoPaterno().toLowerCase()) + "-" +
                afiliacion.getId().toLowerCase();

        subirArchivosMinio(bucketName, archivosPDFBase64);
        ObjectMapper objectMapperKakfa = new ObjectMapper();
        String jsonKakfa = objectMapperKakfa.writeValueAsString(afiliacion);

        kafkaTemplate.send("topic-solicitud-afiliacion",afiliacion.getId(),  jsonKakfa);

        return afiliacionRepository.save(afiliacion);
    }

    private void subirArchivosMinio(String bucketName, List<String> archivosPDFBase64) throws Exception {
        minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());

        int i = 1;
        for (String archivoBase64 : archivosPDFBase64) {
            byte[] decodedBytes = Base64.getDecoder().decode(archivoBase64);
            InputStream inputStream = new ByteArrayInputStream(decodedBytes);
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object("archivo" + i + ".pdf")
                            .stream(inputStream, decodedBytes.length, -1)
                            .contentType("application/pdf")
                            .build());
            i++;
        }
    }

    public String reemplazarEspacios(String texto) {
        return texto.replaceAll("\\s+", "-");
    }
}
