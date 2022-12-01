package Entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Transformador {
    Automato automato;

    public Transformador(Automato automato) {
        this.automato = automato;
    }

    //não finalizado
    public Automato toAFD(Automato automato) {
        List<Transicao> transicoes = automato.getTransicoes();
        Iterator<Transicao> iterator = transicoes.iterator();

        while (iterator.hasNext()) {
            Transicao transicao = iterator.next();
            if (transicao.getEstadosDestino().size() > 1) {
                StringBuilder novoEstadoNome = new StringBuilder();
                List<Estado> estadosDestino = transicao.getEstadosDestino();
                estadosDestino.forEach(estado -> System.out.println(estado.getNome()));
                Estado novoEstado = new Estado(novoEstadoNome.toString(), false, transicao.getEstado().isFinal());
            }
        }

        return null;
    }
}
