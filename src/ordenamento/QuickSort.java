package ordenamento;

import java.util.ArrayList;

public class QuickSort implements AlgoritmoDeOrdenamento {
    public static <T extends Comparable<T>> void sort(ArrayList<T> a,
                                                      int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = particiona(a, inicio, fim);
            sort(a, inicio, posicaoPivo - 1);
            sort(a, posicaoPivo + 1, fim);
        }
    }

    @Override
    public <T extends Comparable<T>> void sortArray(ArrayList<T> a) {
        sort(a, 0, a.size() - 1);
    }

    protected static <T extends Comparable<T>> int particiona(ArrayList<T> a,
                                                            int inicio, int fim) {
        int mediana = (inicio + fim) / 2;
        T pivo = a.get(mediana);
        int i = inicio + 1, f = fim;

        while (i <= f) {
            if (a.get(i).compareTo(pivo) <= 0) {
                i++;
            } else if (pivo.compareTo(a.get(f)) < 0) {
                f--;
            } else {
                T troca = a.get(i);
                a.set(i, a.get(f));
                a.set(f, troca);
                i++;
                f--;
            }
        }
        a.set(inicio, a.get(f));
        a.set(f, pivo);
        return f;
    }
}
