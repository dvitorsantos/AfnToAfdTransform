package Entidades;

import java.util.List;

public class Automato {
    private List<Transicao> transicoes;

    private List<String> alfabeto;

    private List<Estado> estados;

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

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

    public Automato(List<Transicao> transicoes, List<String> alfabeto, List<Estado> estados) {
        this.transicoes = transicoes;
        this.alfabeto = alfabeto;
        this.estados = estados;
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
