package dataset;

import java.util.ArrayList;
import java.util.Random;

public class Dados {

    public static ArrayList<Dado> gerarDados(String tipo, String ordem, int quantidade) {
        ArrayList<Dado> dados = new ArrayList<>();

        Random random = new Random();

        int valor_int = 0;
        double valor_double = 0.0;
        String valor_string = gerarRandomString(15);

        int temp_int;
        double temp_double;
        ArrayList<Integer> temp_ints;

        for (int i = 0; i < quantidade; i++) {
            temp_int = random.nextInt(10) + 1;
            temp_double = random.nextDouble() * 10;
            temp_ints = new ArrayList<>();

            valor_string = gerarProximaString(valor_string, temp_int - 1);
            valor_int += temp_int;
            valor_double += temp_double;

            switch (tipo) {
                case "b" -> adicionarDado(dados, tipo, valor_double, valor_string, ordem);
                case "c" -> {
                    for (int j = 0; j < 30; j++) {
                        temp_ints.add(random.nextInt(10) + 1);
                    }
                    adicionarDado(dados, tipo, valor_int, temp_ints, ordem);
                }
                default -> adicionarDado(dados, tipo, valor_string, valor_double, ordem);
            }
        }

        return dados;
    }

    private static String gerarRandomString(int tamanho) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return "a" + random.ints(leftLimit, rightLimit + 1)
                .limit(tamanho - 1)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static String gerarProximaString(String s, int n) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        char temp;
        char[] tempString = s.toCharArray();

        for (int i = s.length() - 1; i >= 0; i--) {
            temp = tempString[i];
            temp += n;
            if (temp > rightLimit) {
                temp = (char) (temp % rightLimit + leftLimit);
                tempString[i] = temp;
            } else {
                tempString[i] = temp;
                break;
            }
        }

        return String.valueOf(tempString);
    }

    private static void adicionarDado(ArrayList<Dado> dados, String tipo, Object chave, Object valor, String ordem) {
        Random random = new Random();
        if (ordem.equals("aleatorio")) {
            if (random.nextBoolean()) {
                ordem = "crescente";
            } else {
                ordem = "decrescente";
            }
        }
        if (ordem.equals("decrescente")) {
            dados.add(0, new Dado(chave, valor, tipo));
        } else {
            dados.add(new Dado(chave, valor, tipo));
        }

    }

}
