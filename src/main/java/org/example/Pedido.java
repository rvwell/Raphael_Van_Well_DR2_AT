package org.example;

import java.util.Objects;

public class Pedido {
    private final Entrega entrega;
    private final String tipoFrete;
    private final CalculadoraFrete calculadoraFrete;

    public Pedido(Entrega entrega, String tipoFrete) {
        this.entrega = Objects.requireNonNull(entrega, "Entrega não pode ser nula.");
        this.tipoFrete = Objects.requireNonNull(tipoFrete, "Frete não pode ser nulo.");
        if (tipoFrete.trim().isEmpty()) {
            throw new IllegalArgumentException("Frete não pode estar vazio.");
        }
        this.calculadoraFrete = criarCalculadoraFrete(tipoFrete);
    }

    private CalculadoraFrete criarCalculadoraFrete(String tipoFrete) {
        return switch (tipoFrete.toUpperCase()) {
            case "EXP" -> new FreteExpresso();
            case "PAD" -> new FretePadrao();
            case "ECO" -> new FreteEconomico();
            default -> throw new IllegalArgumentException("Frete inválido: " + tipoFrete);
        };
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public String getTipoFrete() {
        return tipoFrete;
    }

    public double calcularFrete() {
        return calculadoraFrete.calcular(entrega);
    }

    public boolean isFreteGratis() {
        return tipoFrete.equalsIgnoreCase("ECO") && entrega.getPeso() < 2;
    }
}
