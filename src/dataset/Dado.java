package dataset;

public class Dado {
    private Object chave;
    private Object valor;

    public Dado(Object chave, Object valor) {
        this.chave = chave;
        this.valor = valor;
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
    public String toString() {
        return "{" +
                "chave=" + chave +
                ", valor=" + valor +
                '}';
    }
}
