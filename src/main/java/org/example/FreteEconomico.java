package org.example;

public class FreteEconomico implements CalculadoraFrete {
    @Override
    public double calcular(Entrega entrega) {
        return Math.max(0, entrega.getPeso() * 1.1 - 5);
    }
}
