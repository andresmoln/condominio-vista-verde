package com.umg.vistaverde.model;

import java.util.ArrayList;

public class Condominio {

    private ArrayList<Casa> casas;
    private double cuotaMensual;

    public Condominio() {
        this.cuotaMensual = 1500.00;
        this.casas = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            casas.add(new Casa(i));
        }
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public Casa getCasa(int numeroCasa) {
        if (numeroCasa < 1 || numeroCasa > 30) {
            return null;
        }
        return casas.get(numeroCasa - 1);
    }
}
