package ordenamento;

import java.util.ArrayList;

public interface AlgoritmoDeOrdenamento {
    static <T extends Comparable<T>> void sort(ArrayList<T> a) {
    }
    <T extends Comparable<T>> void sortArray(ArrayList<T> a);
}
