package main;

import dataset.Dado;
import dataset.Dados;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Dado> dados = new ArrayList<>();
        try {
            dados = Dados.gerarDados("a", "crescente", 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Dado dado : dados) {
            System.out.println(dado);
        }

    }
}
