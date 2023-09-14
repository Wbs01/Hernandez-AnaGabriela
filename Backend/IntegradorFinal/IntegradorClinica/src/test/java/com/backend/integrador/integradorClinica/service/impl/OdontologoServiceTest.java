package com.backend.integrador.integradorClinica.service.impl;

import com.backend.integrador.integradorClinica.dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.backend.integrador.integradorClinica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.integrador.integradorClinica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.integrador.integradorClinica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.integrador.integradorClinica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    void deberiaInsertarUnOdontologODeNombreElenaConId1ConMatriculaAB1234()
    {
        OdontologoEntradaDto odontologoEntradaDto =
                new OdontologoEntradaDto("AXK201","Amada","Hernández");

        OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);

        assertEquals("Amada", odontologoSalidaDto.getNombre());
        assertEquals(1, odontologoSalidaDto.getId());
        assertEquals("AXK201", odontologoSalidaDto.getMatricula());

    }

    @Test
    @Order(2)
    void deberiaRetornarseUnaListaNoVaciaDeOdontologos()
    {
        assertTrue(odontologoService.listarOdontologos().size()>0);
    }

    @Test
    @Order(3)
    void alIntentarActualizarElOdontologoId2_deberiaLanzarseUnaResourceNotFoundException()
    {
        OdontologoModificacionEntradaDto odontologoModificacionEntradaDto = new OdontologoModificacionEntradaDto();
        odontologoModificacionEntradaDto.setId(2L);
        assertThrows(ResourceNotFoundException.class, () ->
                odontologoService.actualizarOdontologo(odontologoModificacionEntradaDto));
    }

}