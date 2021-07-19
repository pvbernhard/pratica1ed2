package main;

import ordenamento.*;
import relatorio.Relatorio;

public class Main {
    public static void main(String[] args) {
        Relatorio.geraRelatorio(
                new int[]{10, 100, 1000, 10000, 100000},
                50,
                new String[]{"aleatorio"},
                new String[]{"a", "b", "c"},
                new QuickSortComInsertionSort(15),
                false);
    }
}
