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

    public double obtenerCuotaActual() {
        return condominio.getCuotaMensual();
    }

    public void actualizarCuota(double nuevaCuota) {
        condominio.setCuotaMensual(nuevaCuota);
    }

    public void guardarDatos() {
        try {
            java.io.BufferedWriter writer = new java.io.BufferedWriter(
                    new java.io.FileWriter("datos.txt")
            );
            for (Casa casa : condominio.getCasas()) {
                writer.write("CASA:" + casa.getNumeroCasa());
                writer.newLine();
                if (casa.tienePropietario()) {
                    writer.write("PROPIETARIO:"
                            + casa.getPropietario().getNombre() + "|"
                            + casa.getPropietario().getTelefono() + "|"
                            + casa.getPropietario().getCorreo()
                    );
                    writer.newLine();
                }
                for (Pago pago : casa.getPagos()) {
                    writer.write("PAGO:"
                            + pago.getMes() + "|"
                            + pago.getAnio() + "|"
                            + pago.getMonto() + "|"
                            + pago.getEstado()
                    );
                    writer.newLine();
                }
            }
            writer.write("CUOTA:" + condominio.getCuotaMensual());
            writer.newLine();
            writer.close();
        } catch (java.io.IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void cargarDatos() {
        java.io.File archivo = new java.io.File("datos.txt");
        if (!archivo.exists()) {
            return;
        }

        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.FileReader(archivo)
            );
            String linea;
            Casa casaActual = null;

            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("CASA:")) {
                    int numero = Integer.parseInt(linea.substring(5));
                    casaActual = condominio.getCasa(numero);

                } else if (linea.startsWith("PROPIETARIO:") && casaActual != null) {
                    String[] partes = linea.substring(12).split("\\|");
                    Propietario p = new Propietario(partes[0], partes[1], partes[2], casaActual.getNumeroCasa());
                    casaActual.setPropietario(p);

                } else if (linea.startsWith("PAGO:") && casaActual != null) {
                    String[] partes = linea.substring(5).split("\\|");
                    Pago pago = new Pago(
                            Integer.parseInt(partes[0]),
                            Integer.parseInt(partes[1]),
                            Double.parseDouble(partes[2]),
                            partes[3]
                    );
                    casaActual.agregarPago(pago);

                } else if (linea.startsWith("CUOTA:")) {
                    double cuota = Double.parseDouble(linea.substring(6));
                    condominio.setCuotaMensual(cuota);
                }
            }
            reader.close();
        } catch (java.io.IOException e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }
}
