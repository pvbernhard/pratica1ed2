package ordenamento;

import java.util.ArrayList;

public class InsertionSort implements AlgoritmoDeOrdenamento {

    public static <T extends Comparable<T>> void sortSubArray(ArrayList<T> a,
                                                              int esq, int dir) {
        T dado;
        int i, j;

        for (j = 1 + esq; j <= dir; j++) {
            dado = a.get(j);
            i = j - 1;
            while (i >= esq && a.get(i).compareTo(dado) > 0) {
                a.set(i + 1, a.get(i));
                i--;
            }
            a.set(i + 1, dado);
        }
    }

    public static <T extends Comparable<T>> void sort(ArrayList<T> a) {
        T dado;
        int i, j;

        for (j = 1; j < a.size(); j++) {
            dado = a.get(j);
            i = j - 1;
            while (i >= 0 && a.get(i).compareTo(dado) > 0) {
                a.set(i + 1, a.get(i));
                i--;
            }
            a.set(i + 1, dado);
        }
    }

    @Override
    public <T extends Comparable<T>> void sortArray(ArrayList<T> a) {
        sort(a);
    }

    public <T extends Comparable<T>> void sortSubarray(ArrayList<T> a, int esq, int dir) {
        sortSubArray(a, esq, dir);
    }
}
