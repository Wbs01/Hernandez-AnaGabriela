package com.backend.integrador.integradorClinica.service.impl;

import com.backend.integrador.integradorClinica.controller.dto.entrada.modificacion.TurnoModificacionEntradaDto;
import com.backend.integrador.integradorClinica.controller.dto.entrada.paciente.odontologo.OdontologoEntradaDto;
import com.backend.integrador.integradorClinica.controller.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.integrador.integradorClinica.controller.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.integrador.integradorClinica.controller.dto.entrada.turno.TurnoEntradaDto;
import com.backend.integrador.integradorClinica.controller.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.integrador.integradorClinica.controller.dto.salida.paciente.PacienteSalidaDto;
import com.backend.integrador.integradorClinica.controller.dto.salida.turno.TurnoSalidaDto;
import com.backend.integrador.integradorClinica.exceptions.BadRequestException;
import com.backend.integrador.integradorClinica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    void deberiaInsertarUnTurnoConIdPaciente1ConIdOdontologo1() throws BadRequestException {

        //crear el paciente
        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Camila","Benitez",23145, LocalDate.of(2023,9,14),
                new DomicilioEntradaDto("Calle", 45632, "localidad","provincia"));

        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);
        Long paciente = pacienteSalidaDto.getId();

        //crear el odontologo
        OdontologoEntradaDto odontologoEntradaDto =
                new OdontologoEntradaDto("AXK201","Amada","Hernández");

        OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);
        Long odontologo = odontologoSalidaDto.getId();


        LocalDateTime fechaCita = LocalDateTime.of(2023, 9, 11, 10, 30);
        TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(paciente,odontologo,fechaCita);
        TurnoSalidaDto turnoSalidaDto = turnoService.registrarTurno(turnoEntradaDto);

        assertEquals(1L, turnoSalidaDto.getPacienteTurnoSalidaDto().getId());
        assertEquals(1L, turnoSalidaDto.getOdontologoTurnoSalidaDto().getId());

    }

    @Test
    @Order(2)
    void deberiaRetornarseUnaListaNoVaciaDeTurnos()
    {
        assertTrue(turnoService.listarTurnos().size()>0);
    }

    @Test
    @Order(3)
    void alIntentarActualizarElTurnoConId2_deberiaLanzarseUnaResourceNotFoundException()
    {
        TurnoModificacionEntradaDto turnoModificacionEntradaDto = new TurnoModificacionEntradaDto();
        turnoModificacionEntradaDto.setId(2L);
        assertThrows(ResourceNotFoundException.class, () ->
                turnoService.modificarTurno(turnoModificacionEntradaDto));
    }


}