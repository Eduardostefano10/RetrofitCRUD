package com.example.consumoapisretrofit.Model;

public class Estudiante {
    private long id;
    private String nombres;
    private Integer edad;
    private String direccion;
    private String ciudad;
    private String pais;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
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

    public Estudiante(long id, String nombres, int edad, String direccion, String ciudad, String pais) {
        this.id = id;
        this.nombres = nombres;
        this.edad = edad;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
    }
}
