package ordenamento;

import java.util.ArrayList;

public class QuickSortComInsertionSort extends QuickSort {
    protected static int L;

    public QuickSortComInsertionSort(int l) {
        L = l;
    }

    public static <T extends Comparable<T>> void sort(ArrayList<T> a,
                                                      int inicio, int fim) {
        int tamanho;

        if (inicio < fim) {
            tamanho = Math.abs(inicio + 1 - fim);
            if (tamanho <= QuickSortComInsertionSort.L) {
                InsertionSort.sortSubArray(a, inicio, fim);
            } else {
                int posicaoPivo = particiona(a, inicio, fim);
                sort(a, inicio, posicaoPivo - 1);
                sort(a, posicaoPivo + 1, fim);
            }
        }
    }

    @Override
    public <T extends Comparable<T>> void sortArray(ArrayList<T> a) {
        sort(a, 0, a.size() - 1);
    }
}
