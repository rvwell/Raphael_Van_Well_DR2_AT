package org.example;

import java.util.Objects;

public class Entrega {
    private final String endereco;
    private final double peso;
    private final String destinatario;

    public Entrega(String endereco, double peso, String destinatario) {
        if (endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("O endereço não pode estar vazio.");
        }
        this.endereco = Objects.requireNonNull(endereco, "O endereço não pode ser nulo.");
        if (peso <= 0) {
            throw new IllegalArgumentException("O peso deve ser maior que zero.");
        }
        this.peso = peso;
        if (destinatario.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do destinatário não pode estar vazio.");
        }
        this.destinatario = destinatario;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getPeso() {
        return peso;
    }

    public String getDestinatario() {
        return destinatario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrega entrega = (Entrega) o;
        return Double.compare(entrega.peso, peso) == 0 && endereco.equals(entrega.endereco) && destinatario.equals(entrega.destinatario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endereco, peso, destinatario);
    }
}
