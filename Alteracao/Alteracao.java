import java.util.*;

public class Alteracao {

    public static boolean isFim(String s) {
        return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String Aleatorio(String str, char a, char b) {
        char[] novo = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a)
                novo[i] = b;
            else
                novo[i] = str.charAt(i);
        }
        String novoStr = new String(novo);
        return novoStr;

    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;
        Scanner entrada2 = new Scanner(System.in);

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = entrada2.nextLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM
        entrada2.close();
        Random gerador = new Random();
        gerador.setSeed(4);

        for (int i = 0; i < numEntrada; i++) {
            char a = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
            char b = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
            System.out.println("a = " + a + " b = " + b);
            System.out.println(Aleatorio(entrada[i], a, b));
        }
    }
}