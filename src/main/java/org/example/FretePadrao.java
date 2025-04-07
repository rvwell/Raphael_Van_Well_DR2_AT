package org.example;

public class FretePadrao implements CalculadoraFrete {

    @Override
    public double calcular(Entrega entrega) {
        return entrega.getPeso() * 1.2;
    }
}
