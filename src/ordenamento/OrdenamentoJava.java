package ordenamento;

import java.util.ArrayList;
import java.util.Collections;

public class OrdenamentoJava implements AlgoritmoDeOrdenamento {
    @Override
    public <T extends Comparable<T>> void sortArray(ArrayList<T> a) {
//        a.sort(Comparable::compareTo);
        Collections.sort(a);
    }
}
