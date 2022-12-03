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
    public static void toAFD(Automato automato) {
        List<Transicao> transicoes = automato.getTransicoes();
        Iterator<Transicao> iterator = transicoes.iterator();

        while (iterator.hasNext()) {
            Transicao transicao = iterator.next();
            if (transicao.getEstadosDestino().size() > 1) {
                StringBuilder novoEstadoNome = new StringBuilder();
                Boolean novoEstadoIsInicial = false;
                Boolean novoEstadoIsFinal = false;
                List<Estado> estadosDestino = new ArrayList<>(transicao.getEstadosDestino());

                for (Estado estado : estadosDestino) {
                    novoEstadoNome.append(estado.getNome());
                    novoEstadoIsInicial = estado.isInicial();
                    novoEstadoIsFinal = estado.isFinal();
                }

                Estado novoEstado = new Estado(novoEstadoNome.toString(), novoEstadoIsInicial, novoEstadoIsFinal);

                for (Transicao transicaoReceberNovoDestino : transicoes) {
                    List<Estado> transicaoReceberNovoDestinoEstadosDestino = transicaoReceberNovoDestino.getEstadosDestino();
                    if (transicaoReceberNovoDestinoEstadosDestino.equals(estadosDestino)) {
                        transicaoReceberNovoDestinoEstadosDestino.clear();
                        transicaoReceberNovoDestinoEstadosDestino.add(novoEstado);
                    }
                }

                List<Transicao> transicoesAdicionadas = new ArrayList<>();

                for (Transicao transicaoAtual : transicoes) {
                    for (Estado estado : estadosDestino) {
                        if (transicaoAtual.getEstado().equals(estado)) {
                            boolean transicaoJaAdicionada = false;
                            for (Transicao transicaoAdiconada : transicoesAdicionadas) {
                                if (transicaoAdiconada.getEstado().equals(novoEstado) && transicaoAdiconada.getSimbolo().equals(transicaoAtual.getSimbolo())) {
                                    transicaoAdiconada.getEstadosDestino().addAll(transicaoAtual.getEstadosDestino());
                                    transicaoJaAdicionada = true;
                                }
                            }

                            if (!transicaoJaAdicionada) {
                                Transicao novaTransicao = new Transicao(novoEstado, transicaoAtual.getSimbolo(), transicaoAtual.getEstadosDestino());
                                transicoesAdicionadas.add(novaTransicao);
                            }
                        }
                    }
                }

                transicoes.addAll(transicoesAdicionadas);
                iterator = transicoes.iterator();
            }
        }
    }
}
