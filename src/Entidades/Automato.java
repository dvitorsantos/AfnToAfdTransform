package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Automato {
    private List<Transicao> transicoes;

    private List<String> alfabeto;

    public List<String> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(List<String> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public List<Transicao> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(List<Transicao> transicoes) {
        this.transicoes = transicoes;
    }

    public Automato(List<Transicao> transicoes) {
        this.transicoes = transicoes;
    }

    public void addTransicao(Transicao transicao) {
        this.transicoes.add(transicao);
    }

    @Override
    public String toString() {
        return "Automato{" +
                "transicoes=" + transicoes +
                '}';
    }
}
