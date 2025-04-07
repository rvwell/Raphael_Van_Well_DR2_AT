package org.example;

public class PromocaoService {

    public Entrega aplicarFretePromocional(Entrega entrega) {
        if (entrega.getPeso() > 10) {
            return new Entrega(entrega.getEndereco(), entrega.getPeso() - 1, entrega.getDestinatario());
        }
        return entrega;
    }
}
