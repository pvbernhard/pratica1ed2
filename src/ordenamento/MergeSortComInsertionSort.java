package ordenamento;

import java.util.ArrayList;

public class MergeSortComInsertionSort extends MergeSort {
    protected static <T extends Comparable<T>> void MergeMain(ArrayList<T> a, ArrayList<T> t, int esq, int dir) {
        int meio;

        if (esq < dir) {
            meio = (esq + dir) / 2;

            if (Math.abs((meio) - (esq + 1)) <= 15) {
                InsertionSort.sortSubArray(a, esq, meio);
                for (int i = esq; i <= meio; i++) {
                    t.set(i, a.get(i));
                }
            } else {
                MergeMain(a, t, esq, meio);
            }

            if (Math.abs((dir + 1 ) - (meio + 1)) <= 15) {
                InsertionSort.sortSubArray(a, meio + 1, dir);
                for (int i = meio + 1; i <= dir; i++) {
                    t.set(i, a.get(i));
                }
            } else {
                MergeMain(a, t, meio + 1, dir);
            }

            Merge(a, t, esq, meio + 1, dir);
        }
    }

}
