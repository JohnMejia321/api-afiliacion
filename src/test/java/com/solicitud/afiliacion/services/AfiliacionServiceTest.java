/*
package com.solicitud.afiliacion.services;

import static org.junit.jupiter.api.Assertions.*;

import com.solicitud.afiliacion.entities.Afiliacion;
import com.solicitud.afiliacion.repositories.AfiliacionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import io.minio.MinioClient;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfiliacionServiceTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @Mock
    private AfiliacionRepository afiliacionRepository;

    @Mock
    private MinioClient minioClient;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AfiliacionService afiliacionService;

    @Test
    public void testGuardarAfiliacion() throws Exception {
        // Mock de datos
        Afiliacion afiliacion = new Afiliacion();
        afiliacion.setPrimerNombre("John");
        afiliacion.setApellidoPaterno("Mejia");
        List<MultipartFile> archivosPDF = new ArrayList<>(); // Simula una lista de archivos

        // Mock de respuesta del servicio REST externo
        ResponseEntity<String> responseEntity = ResponseEntity.ok("{\"id\": \"12345\"}");
        when(restTemplate.getForEntity(anyString(), eq(String.class))).thenReturn(responseEntity);

        // Mock de llamada a MinioClient
        doNothing().when(minioClient).makeBucket(any());

        // Mock de llamada al repository
        when(afiliacionRepository.save(any(Afiliacion.class))).thenReturn(afiliacion);

        // Ejecutar método a probar
        Afiliacion result = afiliacionService.guardarAfiliacion(afiliacion, archivosPDF);

        // Verificar que se llamaron los métodos esperados
        verify(kafkaTemplate, times(1)).send(anyString(), anyString(), anyString());
        verify(minioClient, times(1)).makeBucket(any());
        verify(afiliacionRepository, times(1)).save(any(Afiliacion.class));

        // Verificar que el resultado no sea nulo
        assertNotNull(result);
        assertEquals("12345", result.getId()); // Verificar que el ID sea el esperado
    }
}
*/
