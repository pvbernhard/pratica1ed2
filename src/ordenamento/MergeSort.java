package ordenamento;

import java.util.ArrayList;

public class MergeSort {
    public static <T extends Comparable<T>> void sort(ArrayList<T> a) {
        ArrayList<T> temp = new ArrayList<>(a);

        MergeMain(a, temp, 0, a.size() - 1);
    }

    private static <T extends Comparable<T>> void MergeMain(ArrayList<T> a, ArrayList<T> t, int esq, int dir) {
        int meio;

        if (esq < dir) {
            meio = (esq + dir) / 2;
            MergeMain(a, t, esq, meio);
            MergeMain(a, t, meio + 1, dir);
            Merge(a, t, esq, meio + 1, dir);
        }
    }

    private static <T extends Comparable<T>> void Merge(ArrayList<T> a, ArrayList<T> t,
                                                        int esqPos, int dirPos, int dirFim) {
        int esqFim = dirPos - 1;
        int tempPos = esqPos;
        int numElem = dirFim - esqPos + 1;

        while(esqPos <= esqFim && dirPos <= dirFim) {
            if (a.get(esqPos).compareTo(a.get(dirPos)) <= 0) {
                t.set(tempPos++, a.get(esqPos++));
            } else {
                t.set(tempPos++, a.get(dirPos++));
            }
        }

        while(esqPos <= esqFim) {
            t.set(tempPos++, a.get(esqPos++));
        }

        while(dirPos <= dirFim) {
            t.set(tempPos++, a.get(dirPos++));
        }

        for (int i = 0; i < numElem; i++, dirFim--) {
            a.set(dirFim, t.get(dirFim));
        }
    }
}
