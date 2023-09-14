package com.backend.integrador.integradorClinica.service;

import com.backend.integrador.integradorClinica.controller.dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.backend.integrador.integradorClinica.controller.dto.entrada.paciente.odontologo.OdontologoEntradaDto;
import com.backend.integrador.integradorClinica.controller.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.integrador.integradorClinica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {
    List<OdontologoSalidaDto> listarOdontologos();

    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

    OdontologoSalidaDto buscarOdontologoPorId(Long id);

    void eliminarOdontologo(Long id) throws ResourceNotFoundException;

    OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntradaDto odontologoModificacionEntradaDto) throws ResourceNotFoundException;
}

