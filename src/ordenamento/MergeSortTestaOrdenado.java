package ordenamento;

import java.util.ArrayList;

public class MergeSortTestaOrdenado extends MergeSort {
    private static <T extends Comparable<T>> void MergeMain(ArrayList<T> a, ArrayList<T> t,
                                                            int esq, int dir) {
        int meio;

        if (esq < dir) {
            meio = (esq + dir) / 2;
            MergeMain(a, t, esq, meio);
            MergeMain(a, t, meio + 1, dir);
            if (a.get(meio).compareTo(a.get(meio + 1)) > 0) {
                Merge(a, t, esq, meio + 1, dir);
            }
        }
    }
}
