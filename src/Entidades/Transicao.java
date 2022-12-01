package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Transicao {
    private Estado estado;
    private String simbolo;
    private List<Estado> estadosDestino;

    //pretendo utilizar na hora de verificar se o estado já foi avaliado no algoritmo
    private boolean flag;

    public Transicao(Estado estado, String simbolo, List<Estado> estadosDestino) {
        this.estado = estado;
        this.simbolo = simbolo;
        this.estadosDestino = estadosDestino;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Transicao{" +
                "estado=" + estado +
                ", simbolo=" + simbolo +
                ", estadosDestino=" + estadosDestino +
                '}';
    }
}

