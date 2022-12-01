import Entidades.Automato;
import Entidades.Estado;
import Entidades.Transformador;
import Entidades.Transicao;

import java.util.*;

public class Main {


    public static void imprimirDivs() {
        System.out.println("=================================================================================");
    }

    public static void restricoeseObservacoes() {
        imprimirDivs();
        System.out.println("                            restrições afn de entrada".toUpperCase(Locale.ROOT));
        imprimirDivs();
        System.out.println("O autômato deve ter no maximo:".toUpperCase(Locale.ROOT));
        System.out.println("-4 estados;".toUpperCase(Locale.ROOT));
        System.out.println("-8 transições".toUpperCase(Locale.ROOT));
        System.out.println("-3 símbolos".toUpperCase(Locale.ROOT));
        imprimirDivs();
        System.out.println("                             observações".toUpperCase(Locale.ROOT));
        imprimirDivs();
        System.out.println("-os estados, por definição, serão chamados de q0, q1, q2, q3;".toUpperCase(Locale.ROOT));
        System.out.println(("-os símbolos, por definição, podem ser apenas números naturais(1, 2, 3) ou" +
                "letras do alfabeto(a, b, c)").toUpperCase(Locale.ROOT));

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("conversor de autômatos finitos não determinísticos para autômatos finitos determinísticos.".toUpperCase(Locale.ROOT));
        boolean exit = false;

        List<Estado> estados = Main.definirEstados();
        List<String> alfabeto = Main.definirAlfabeto();
        List<Transicao> transicoes = Main.definirTransicoes(estados, alfabeto);

        Automato automato = new Automato(transicoes);

        System.out.println(automato);
    }

    public static List<Estado> definirEstados() {
        boolean exit = false;

        Scanner scanner = new Scanner(System.in);
        List<Estado> estados = new ArrayList<>();

        System.out.println("definindo os Estados: ".toUpperCase(Locale.ROOT));
        while (!exit) {
            System.out.println("digite o nome do estado:");
            String identificador = scanner.next();
            System.out.println("digite se o estado inicial:");
            Boolean isEstadoInicial = scanner.nextBoolean();
            System.out.println("digite se o estado é final:");
            Boolean isEstadoFinal = scanner.nextBoolean();
            estados.add(new Estado(identificador, isEstadoInicial, isEstadoFinal));
            System.out.println("1 - Continuar\n0 - sair\n".toUpperCase(Locale.ROOT));
            exit = scanner.nextInt() == 0;
        }

        return estados;
    }

    public static List<String> definirAlfabeto() {
        Scanner scanner = new Scanner(System.in);
        List<String> alfabeto = new ArrayList<>();

        System.out.println("definindo o alfabeto: ".toUpperCase(Locale.ROOT));
        System.out.println("digite os símbolos (separados por ,):");
        String[] simbolos = scanner.next().split(",");
        alfabeto.addAll(Arrays.asList(simbolos));

        return alfabeto;
    }

    public static List<Transicao> definirTransicoes(List<Estado> estados, List<String> alfabeto) {
        boolean exit = false;

        Scanner scanner = new Scanner(System.in);
        List<Transicao> transicoes = new ArrayList<>();
        System.out.println("definindo as transições: ".toUpperCase(Locale.ROOT));
        System.out.println("Separados por ',' e '-' para ausência de transição. Ex.: 'q1,q2,q3' ou '-'.");
        for (Estado estado : estados) {
            for (String simbolo : alfabeto) {
                System.out.println("'" + estado.getNome() + "' lendo '" + simbolo + "' vai para os estados:");

                String simbolos = scanner.next();

                //se o usuário digitar um "-", ele não quer definir uma transição
                if (!simbolo.equals("-")) {
                    String[] estadosDestinoNomes = simbolos.split(",");

                    List<Estado> estadosDestinoList = new ArrayList<>();

                    for (Estado estado1 : estados) {
                        boolean isEstadoDestino = false;
                        for (String estadoDestinoNome : estadosDestinoNomes) {
                            if (estado1.getNome().equals(estadoDestinoNome)) {
                                estadosDestinoList.add(estado1);
                            }
                        }
                    }

                    Transicao transicao = new Transicao(estado, simbolo, estadosDestinoList);
                    transicoes.add(transicao);
                }
            }
        }

        return transicoes;
    }
}
