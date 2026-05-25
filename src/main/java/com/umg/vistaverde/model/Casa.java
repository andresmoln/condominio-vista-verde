package com.umg.vistaverde.model;

import java.util.ArrayList;

public class Casa {

    private int numeroCasa;
    private Propietario propietario;
    private ArrayList<Pago> pagos;

    public Casa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
        this.propietario = null;
        this.pagos = new ArrayList<>();
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }

    public boolean tienePropietario() {
        return propietario != null;
    }

    public void agregarPago(Pago pago) {
        pagos.add(pago);
    }

    public boolean yaPago(int mes, int anio) {
        for (Pago pago : pagos) {
            if (pago.getMes() == mes && pago.getAnio() == anio) {
                return true;
            }
        }
        return false;
    }

    public double getTotalPagado() {
        double total = 0;
        for (Pago pago : pagos) {
            total += pago.getMonto();
        }
        return total;
    }
}
