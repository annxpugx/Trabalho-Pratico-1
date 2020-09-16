import java.util.*;

public class Ciframento {

    public static boolean isFim(String s) {
        return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

    public static String Cesar(String str){
        int k = 3;

        String criptografada = "";

        // criptografia de cesar
        for (int i = 0; i < str.length(); i++){
            criptografada += (char) (str.charAt(i) + k);
        }
        // voltando para string
        return criptografada;
    }
    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {
            MyIO.println(Cesar(entrada[i]));
        }
    }
}