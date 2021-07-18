package main;

import ordenamento.MergeSort;
import relatorio.Relatorio;

public class Main {
    public static void main(String[] args) {
        Relatorio.geraRelatorio(
                new int[]{10, 100, 1000, 10000},
                new String[]{"aleatorio"},
                new String[]{"a", "b", "c"},
                new MergeSort(),
                false);
    }
}
