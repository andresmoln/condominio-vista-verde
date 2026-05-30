package com.umg.vistaverde.model;

public class Propietario {

    private String nombre;
    private String telefono;
    private String correo;
    private int numeroCasa;

    public Propietario(String nombre, String telefono, String correo, int numeroCasa) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.numeroCasa = numeroCasa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }
}
