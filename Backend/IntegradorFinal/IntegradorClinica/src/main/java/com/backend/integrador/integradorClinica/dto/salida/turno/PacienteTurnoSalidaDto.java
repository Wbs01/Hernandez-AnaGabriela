package com.backend.integrador.integradorClinica.dto.salida.turno;

public class PacienteTurnoSalidaDto {

    private Long id;
    private String nombre;
    private String apellido;

    public PacienteTurnoSalidaDto() {
    }

    public PacienteTurnoSalidaDto(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
