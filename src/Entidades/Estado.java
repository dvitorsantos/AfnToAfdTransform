package Entidades;

public class Estado {
    private String nome;
    private Boolean isInicial;
    private Boolean isFinal;

    public Estado(String nome, Boolean isInicial, Boolean isFinal) {
        this.nome = nome;
        this.isInicial = isInicial;
        this.isFinal = isFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean isInicial() {
        return isInicial;
    }

    public void setInicial(Boolean inicial) {
        isInicial = inicial;
    }

    public Boolean isFinal() {
        return isFinal;
    }

    public void setFinal(Boolean aFinal) {
        isFinal = aFinal;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "nome='" + nome + '\'' +
                ", isInicial=" + isInicial +
                ", isFinal=" + isFinal +
                '}';
    }
}
