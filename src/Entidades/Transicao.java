package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Transicao {
    private List<Estado> estadoOrigem;
    private String simbolo;
    private List<Estado> estadosDestino;

    public Transicao() {
        this.estadoOrigem = new ArrayList<>();
        this.estadosDestino = new ArrayList<>();
    }

    public Transicao(List<Estado> estadoOrigem, String simbolo, List<Estado> estadosDestino) {
        this.estadoOrigem = estadoOrigem;
        this.simbolo = simbolo;
        this.estadosDestino = estadosDestino;
    }

    public List<Estado> getEstadoOrigem() {
        return estadoOrigem;
    }

    public void setEstadoOrigem(List<Estado> estadoOrigem) {
        this.estadoOrigem = estadoOrigem;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public List<Estado> getEstadosDestino() {
        return estadosDestino;
    }

    public void setEstadosDestino(List<Estado> estadosDestino) {
        this.estadosDestino = estadosDestino;
    }

    @Override
    public String toString() {
        return "Transicao{" +
                "estadoOrigem=" + estadoOrigem +
                ", simbolo='" + simbolo + '\'' +
                ", estadosDestino=" + estadosDestino +
                '}';
    }
}

