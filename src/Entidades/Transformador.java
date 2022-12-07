package Entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Transformador {
    Automato automato;

    List<List<Estado>> novoEstados;


    public Transformador(Automato automato) {
        this.automato = automato;
        this.novoEstados = new ArrayList<>();
    }

    //não finalizado
    public void toAFD(Automato automato) {
        int n = automato.getEstados().size();

        Estado[] estados = new Estado[automato.getEstados().size()];

        //executando combinação
        for (int i = 0; i <= n; i++) {
            printCombination(automato.getEstados().toArray(estados), n, i);
        }

        List<Transicao> novasTransicoes = new ArrayList<>();

        for (List<Estado> listaNovosEstados : novoEstados) {
            for (String letra : automato.getAlfabeto()) {
                Transicao novaTransicao = new Transicao();
                novaTransicao.setSimbolo(letra);
                for (Estado estado : listaNovosEstados) {
                    novaTransicao.getEstadoOrigem().add(estado);
                    for (Transicao transicao : automato.getTransicoes()) {
                        if (transicao.getEstadoOrigem().get(0).getNome().equals(estado.getNome()) && transicao.getSimbolo().equals(letra)) {
                            transicao.getEstadosDestino().forEach(novaTransicao.getEstadosDestino()::add);
                        }
                    }
                }
                removeDuplicates(novaTransicao.getEstadosDestino());
                novasTransicoes.add(novaTransicao);
            }
        }

        for (Transicao transicao : novasTransicoes) {
            String caracterFinal = "";

            for (Estado estado : transicao.getEstadoOrigem()) {
                if (estado.isFinal()) {
                    caracterFinal = "*";
                }
            }
            System.out.print(caracterFinal);
            for (Estado estado : transicao.getEstadoOrigem()) {
                System.out.print(estado.getNome());
            }

            System.out.print(" - " + transicao.getSimbolo() + " -> ");
            for (Estado estado : transicao.getEstadosDestino()) {
                System.out.print(estado.getNome());
            }
            System.out.println();
        }
    }

    void combinationUtil(Estado arr[], Estado data[], int start,
                         int end, int index, int r) {
        if (index == r) {
            List<Estado> estados = new ArrayList<>();
            for (int j = 0; j < r; j++) {
                estados.add(data[j]);
            }
            this.novoEstados.add(estados);
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }

    void printCombination(Estado arr[], int n, int r) {
        Estado data[] = new Estado[r];

        combinationUtil(arr, data, 0, n - 1, 0, r);
    }

    public void removeDuplicates(List<Estado> estados) {
        for (int i = 0; i < estados.size(); i++) {
            for (int j = i + 1; j < estados.size(); j++) {
                if (estados.get(i).getNome().equals(estados.get(j).getNome())) {
                    estados.remove(j);
                }
            }
        }
    }
}