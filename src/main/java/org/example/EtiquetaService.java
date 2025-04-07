package org.example;

import java.util.Objects;

public class EtiquetaService {
    private final CalculadoraFrete calculadoraFrete;

    public EtiquetaService(CalculadoraFrete calculadoraFrete) {
        this.calculadoraFrete = Objects.requireNonNull(calculadoraFrete, "O frete não pode ser nulo.");
    }

    public String gerarEtiqueta(Entrega entrega) {
        double valorFrete = calculadoraFrete.calcular(entrega);
        return "Destinatário: " + entrega.getDestinatario() + "\nEndereço: " + entrega.getEndereco() + "\nValor do Frete: R$" + String.format("%.2f", valorFrete);
    }

    public String gerarResumoPedido(Entrega entrega, String tipoFrete) {
        double valorFrete = calculadoraFrete.calcular(entrega);
        return "Pedido para " + entrega.getDestinatario() + " com frete tipo " + tipoFrete + " no valor de R$" + String.format("%.2f", valorFrete);
    }
}
