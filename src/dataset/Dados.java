package dataset;

import java.util.ArrayList;
import java.util.Random;

public class Dados {

    public static ArrayList<Dado> gerarDados(String tipo, String ordem, int quantidade) throws Exception {
        ArrayList<Dado> dados = new ArrayList<>();

        Random random = new Random();

        int valor_int = 0;
        double valor_double = 0.0;
        String valor_string = gerarRandomString(10);

        int temp_int;
        int[] temp_ints = new int[30];
        double temp_double;

        for (int i = 0; i < quantidade; i++) {
            temp_int = random.nextInt(10) + 1;
            temp_double = random.nextDouble() * 10;

            valor_string = gerarProximaString(valor_string, temp_int - 1);
            valor_int += temp_int;
            valor_double += temp_double;

            switch (tipo) {
                case "a" -> adicionarDado(dados, valor_string, valor_double, ordem);
                case "b" -> adicionarDado(dados, valor_double, valor_string, ordem);
                case "c" -> {
                    for (int j = 0; j < 30; j++) {
                        temp_ints[j] = random.nextInt(1000) + 1;
                    }
                    adicionarDado(dados, valor_int, temp_ints, ordem);
                }
                default -> throw new Exception("gerarDados: tipo não encontrado.");
            }
        }

        return dados;
    }

    private static String gerarRandomString(int tamanho) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(tamanho)
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

    private static void adicionarDado(ArrayList<Dado> dados, Object chave, Object valor, String ordem) {
        Random random = new Random();
        if (ordem.equals("aleatorio")) {
            if (random.nextBoolean()) {
                ordem = "crescente";
            } else {
                ordem = "decrescente";
            }
        }
        if (ordem.equals("decrescente")) {
            dados.add(0, new Dado(chave, valor));
        } else {
            dados.add(new Dado(chave, valor));
        }

    }

}
