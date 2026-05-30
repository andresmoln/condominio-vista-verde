package com.umg.vistaverde.model;

public class Pago {

    private int mes;
    private int anio;
    private double monto;
    private String estado;

    public Pago(int mes, int anio, double monto, String estado) {
        this.mes = mes;
        this.anio = anio;
        this.monto = monto;
        this.estado = estado;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public double getMonto() {
        return monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
