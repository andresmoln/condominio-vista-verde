package com.umg.vistaverde.service;

import com.umg.vistaverde.model.Casa;
import com.umg.vistaverde.model.Condominio;
import com.umg.vistaverde.model.Pago;
import com.umg.vistaverde.model.Propietario;
import java.util.ArrayList;

public class CondominioService {

    private Condominio condominio;

    public CondominioService(Condominio condominio) {
        this.condominio = condominio;
    }

    public Casa obtenerCasa(int numeroCasa) {
        return condominio.getCasa(numeroCasa);
    }

    public boolean registrarPropietario(int numeroCasa, String nombre, String telefono, String correo) {
        Casa casa = obtenerCasa(numeroCasa);

        if (casa == null) {
            return false;
        }

        if (casa.tienePropietario()) {
            return false;
        }

        if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            return false;
        }

        Propietario propietario = new Propietario(nombre, telefono, correo, numeroCasa);
        casa.setPropietario(propietario);
        return true;
    }

    public boolean registrarPago(int numeroCasa, int mes, int anio) {
        Casa casa = obtenerCasa(numeroCasa);

        if (casa == null) {
            return false;
        }

        if (!casa.tienePropietario()) {
            return false;
        }

        if (casa.yaPago(mes, anio)) {
            return false;
        }

        for (int m = 1; m < mes; m++) {
            if (!casa.yaPago(m, anio)) {
                return false;
            }
        }

        Pago nuevoPago = new Pago(mes, anio, condominio.getCuotaMensual(), "Pagado");
        casa.agregarPago(nuevoPago);
        return true;
    }

    public double calcularTotalRecaudado(int mes, int anio) {
        double total = 0;
        for (Casa casa : condominio.getCasas()) {
            for (Pago pago : casa.getPagos()) {
                if (pago.getMes() == mes && pago.getAnio() == anio) {
                    total += pago.getMonto();
                }
            }
        }
        return total;
    }

    public double calcularTotalEsperado() {
        return 30 * condominio.getCuotaMensual();
    }

    public ArrayList<Casa> listarCasasMorosas(int mes, int anio) {
        ArrayList<Casa> morosas = new ArrayList<>();
        for (Casa casa : condominio.getCasas()) {
            if (casa.tienePropietario() && !casa.yaPago(mes, anio)) {
                morosas.add(casa);
            }
        }
        return morosas;
    }
    
    public double obtenerCuotaActual(){
        return condominio.getCuotaMensual();
    }
    
    public void actualizarCuota(double nuevaCuota){
        condominio.setCuotaMensual(nuevaCuota);
    }
    
}
