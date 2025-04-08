package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            Entrega entrega1 = new Entrega("Rua das Flores, 123", 15.5, "João Silva");
            System.out.println("Entrega criada com sucesso: " + entrega1.getDestinatario() + " para " + entrega1.getEndereco() + ", peso: " + entrega1.getPeso() + "kg");

            Pedido pedidoExpresso = new Pedido(entrega1, "EXP");
            System.out.println("\nPedido Expresso criado para: " + pedidoExpresso.getEntrega().getDestinatario() + ", tipo de frete: " + pedidoExpresso.getTipoFrete());

            EtiquetaService etiquetaServiceExpresso = new EtiquetaService(new FreteExpresso());
            
            String etiquetaExpresso = etiquetaServiceExpresso.gerarEtiqueta(pedidoExpresso.getEntrega());
            String resumoExpresso = etiquetaServiceExpresso.gerarResumoPedido(pedidoExpresso.getEntrega(), pedidoExpresso.getTipoFrete());

            System.out.println("--- Pedido Expresso ---");
            System.out.println("Etiqueta:\n" + etiquetaExpresso);
            System.out.println("Resumo: " + resumoExpresso);
            System.out.println("Valor do frete calculado no Pedido: R$" + String.format("%.2f", pedidoExpresso.calcularFrete()));
            System.out.println("Frete grátis? " + pedidoExpresso.isFreteGratis());

            System.out.println("---");

            Entrega entrega2 = new Entrega("Avenida Principal, 456", 1.8, "Maria Oliveira");
            Pedido pedidoEconomico = new Pedido(entrega2, "ECO");
            EtiquetaService etiquetaServiceEconomico = new EtiquetaService(new FreteEconomico());
            String etiquetaEconomico = etiquetaServiceEconomico.gerarEtiqueta(pedidoEconomico.getEntrega());
            String resumoEconomico = etiquetaServiceEconomico.gerarResumoPedido(pedidoEconomico.getEntrega(), pedidoEconomico.getTipoFrete());

            System.out.println("--- Pedido Econômico ---");
            System.out.println("Etiqueta:" + etiquetaEconomico);
            System.out.println("Resumo: " + resumoEconomico);
            System.out.println("Valor do frete calculado no Pedido: R$" + String.format("%.2f", pedidoEconomico.calcularFrete()));
            System.out.println("Frete grátis? " + pedidoEconomico.isFreteGratis());

        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar pedido: " + e.getMessage());
        }
    }
}