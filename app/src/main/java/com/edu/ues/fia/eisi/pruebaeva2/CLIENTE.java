package com.edu.ues.fia.eisi.pruebaeva2;

public class CLIENTE {
    String idCLiente, nombre, apellido,sexo;
    Integer numArticulo;
    public String getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(String idCLiente) {
        this.idCLiente = idCLiente;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getNumArticulo() {
        return numArticulo;
    }

    public void setNumArticulo(Integer numArticulo) {
        this.numArticulo = numArticulo;
    }

    public CLIENTE() {
    }


    public CLIENTE(String idCLiente, String nombre, String apellido, String sexo, Integer numArticulo) {
        this.idCLiente = idCLiente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.numArticulo = numArticulo;
    }



}
