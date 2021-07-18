package main;

import dataset.Dado;
import dataset.Dados;
import ordenamento.MergeSort;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Dado> dados = new ArrayList<>();
        try {
            dados = Dados.gerarDados("c", "decrescente", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Dado dado : dados) {
            System.out.println(dado);
        }

        MergeSort.sort(dados);

        System.out.println("Ordenado:");
        for (Dado dado : dados) {
            System.out.println(dado);
        }

    }
}
