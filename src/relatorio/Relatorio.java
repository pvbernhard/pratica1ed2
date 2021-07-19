package relatorio;

import dataset.Dado;
import dataset.Dados;
import ordenamento.AlgoritmoDeOrdenamento;

import java.util.ArrayList;

public class Relatorio {
    public static void geraRelatorio(int[] quantidades, int tamanhoDoTeste, String[] ordens, String[] tipos,
                                     AlgoritmoDeOrdenamento algoritmo, boolean printar) {
        ArrayList<Dado> dados;
        ArrayList<ArrayList<Dado>> arrayDados = new ArrayList<>();
        ArrayList<ArrayList<Dado>> arrayDadosOrdenados = new ArrayList<>();
        ArrayList<Long> duracoes;

        ArrayList<String> titulos = new ArrayList<>();

        if (ordens.length <= 1) {
            if (tamanhoDoTeste > 1) {
                System.out.format("%9s\t%9s\t%9s\n", "Tamanho", "Tipo", "Tempo (ms) [Média: " + tamanhoDoTeste + "]");
            } else {
                System.out.format("%9s\t%9s\t%9s\n", "Tamanho", "Tipo", "Tempo (ms)");
            }
        } else {
            if (tamanhoDoTeste > 1) {
                System.out.format("%9s\t%9s\t%9s\t%9s\n", "Tamanho", "Ordem", "Tipo", "Tempo (ms) [Média: " + tamanhoDoTeste + "]");
            } else {
                System.out.format("%9s\t%9s\t%9s\t%9s\n", "Tamanho", "Ordem", "Tipo", "Tempo (ms)");
            }
        }
        for (int quantidade : quantidades) {
            for (String ordem : ordens) {
                for (String tipo : tipos) {
                    duracoes = new ArrayList<>();
                    for (int i = 0; i < tamanhoDoTeste; i++) {
                        dados = Dados.gerarDados(tipo, ordem, quantidade);

                        if (printar) {
                            if (ordens.length <= 1) {
                                if (tamanhoDoTeste > 1) {
                                    titulos.add("teste: " + tamanhoDoTeste + ", tamanho: " + quantidade + ", tipo: " + tipo);
                                } else {
                                    titulos.add("tamanho: " + quantidade + ", tipo: " + tipo);
                                }
                            } else {
                                if (tamanhoDoTeste > 1) {
                                    titulos.add("teste: " + tamanhoDoTeste + ", tamanho: " + quantidade + ", ordem: " + ordem + ", tipo: " + tipo);
                                } else {
                                    titulos.add("tamanho: " + quantidade + ", ordem: " + ordem + ", tipo: " + tipo);
                                }
                            }
                            arrayDados.add((ArrayList<Dado>) dados.clone());
                        }

                        long startTime = System.nanoTime();
                        algoritmo.sortArray(dados);
                        long endTime = System.nanoTime();
                        long duration = (endTime - startTime);

                        duracoes.add(duration);

                        if (printar) {
                            arrayDadosOrdenados.add((ArrayList<Dado>) dados.clone());
                        }

                        if (tamanhoDoTeste <= 1) {
                            if (ordens.length <= 1) {
                                System.out.format("%9d\t%9s\t%9.4f\n", quantidade, tipo, (duration / 1000000.0));
                            } else {
                                System.out.format("%9d\t%9s\t%9s\t%9.4f\n", quantidade, ordem, tipo, (duration / 1000000.0));
                            }
                        }
                    }
                    System.out.format("%9d\t%9s\t%9.4f\n", quantidade, tipo, (duracoes.stream().mapToDouble(d -> d).average().orElse(0.0) / 1000000.0));
                }
            }
        }

        if (printar) {
            for (int i = 0; i < arrayDados.size(); i++) {
                System.out.printf("%-10s\t[%s]\n", "Dados", titulos.get(i));
                for (Dado dado : arrayDados.get(i)) {
                    System.out.println(dado);
                }
                System.out.printf("%-10s\t[%s]\n", "Ordenados", titulos.get(i));
                for (Dado dado : arrayDadosOrdenados.get(i)) {
                    System.out.println(dado);
                }
            }
        }
    }
}
