package com.solicitud.afiliacion.controllers;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solicitud.afiliacion.controllers.AfiliacionController;
import com.solicitud.afiliacion.entities.Afiliacion;
import com.solicitud.afiliacion.services.AfiliacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AfiliacionControllerTest {

    @Mock
    private AfiliacionService afiliacionService;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private AfiliacionController afiliacionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarAfiliacion() throws Exception {

        // Simulacion json de entrada
        String jsonEntrada = "{\"id\":\"1\", \"primerNombre\":\"John\", \"tipoInscripcion\":\"empleador nacional\"}";

        // conversion de json a objeto Afiliacion
        Afiliacion afiliacion = new Afiliacion();
        afiliacion.setId("1");
        afiliacion.setPrimerNombre("John");
        afiliacion.setTipoInscripcion("empleador nacional");

        //  comportamiento esperado del servicio de afiliación
        when(afiliacionService.guardarAfiliacion(afiliacion, new ArrayList<>())).thenReturn(afiliacion);

        // metodo a probar
        ResponseEntity<Afiliacion> response = afiliacionController.guardarAfiliacion(jsonEntrada, new ArrayList<>());

        // Verificaciones
        assertEquals(afiliacion.getId(), response.getBody().getId());
        assertEquals(afiliacion.getPrimerNombre(), response.getBody().getPrimerNombre());
        assertEquals(afiliacion.getTipoInscripcion(), response.getBody().getTipoInscripcion());
    }
}
