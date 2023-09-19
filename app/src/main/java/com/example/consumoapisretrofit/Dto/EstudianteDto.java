package com.example.consumoapisretrofit.Dto;

import java.io.Serializable;

public class EstudianteDto implements Serializable {
    private String nombres;
    private String apellidos;
    private Integer edad;
    private String direccion;
    private String ciudad;
    private String pais;

    public EstudianteDto() {
    }

    public EstudianteDto(String nombres, String apellidos, Integer edad, String direccion, String ciudad, String pais) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public EstudianteDto(String string) {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
