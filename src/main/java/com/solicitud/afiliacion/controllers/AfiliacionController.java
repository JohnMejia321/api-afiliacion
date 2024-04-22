package com.solicitud.afiliacion.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solicitud.afiliacion.entities.Afiliacion;
import com.solicitud.afiliacion.services.AfiliacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/afiliaciones")
public class AfiliacionController {

    @Autowired
    private AfiliacionService afiliacionService;

    @RequestMapping(
            path = "/guardar",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> guardarAfiliacion(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();
        HttpStatus httpStatus;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Afiliacion afiliacion = objectMapper.convertValue(payload.get("afiliacion"), Afiliacion.class);
            List<String> archivosPDFBase64 = (List<String>) payload.get("archivosPDFBase64");
            Afiliacion afiliacionGuardada = afiliacionService.guardarAfiliacion(afiliacion, archivosPDFBase64);
            response.put("Status", true);
            response.put("Message", "Afiliación guardada exitosamente");
            response.put("Code", HttpStatus.CREATED.value());
            httpStatus = HttpStatus.CREATED;
        } catch (Exception e) {
            response.put("Status", false);
            response.put("Message", "Error al procesar la solicitud: " + e.getMessage());
            response.put("Code", HttpStatus.INTERNAL_SERVER_ERROR.value());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(response, httpStatus);
    }
}
