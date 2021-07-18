package dataset;

public class Dado implements Comparable<Dado> {
    private final String tipo;
    private final Object chave;
    private Object valor;

    public Dado(Object chave, Object valor, String tipo) {
        this.chave = chave;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Object getChave() {
        return chave;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Dado d) {
        if ("a".equals(this.tipo)) {
            return ((String) this.chave).compareTo((String) d.chave);
        }

        Number chaveA = (Number) this.chave;
        Number chaveB = (Number) d.chave;
        if (chaveA.doubleValue() > chaveB.doubleValue()) {
            return 1;
        } else if (chaveA.equals(chaveB)) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "\"" + chave + "\""+
                ": " + valor +
                '}';
    }
}
