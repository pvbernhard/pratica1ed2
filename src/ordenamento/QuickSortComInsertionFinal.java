package ordenamento;

import java.util.ArrayList;

public class QuickSortComInsertionFinal extends QuickSort {
    protected static int L;

    public QuickSortComInsertionFinal(int l) {
        L = l;
    }

    public static <T extends Comparable<T>> void sort(ArrayList<T> a,
                                                      int inicio, int fim) {
        sortMain(a, inicio, fim);
        InsertionSort.sort(a);
    }

    private static <T extends Comparable<T>> void sortMain(ArrayList<T> a,
                                                           int inicio, int fim) {
        int tamanho;

        if (inicio < fim) {
            tamanho = Math.abs(inicio + 1 - fim);
            if (tamanho > QuickSortComInsertionSort.L) {
                int posicaoPivo = particiona(a, inicio, fim);
                sortMain(a, inicio, posicaoPivo - 1);
                sortMain(a, posicaoPivo + 1, fim);
            }
        }
    }

    @Override
    public <T extends Comparable<T>> void sortArray(ArrayList<T> a) {
        sort(a, 0, a.size() - 1);
    }
}
