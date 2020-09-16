import java.util.*;

public class CiframentoRecursivo {

    public static boolean isFim(String s) {
        return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

    public static String Cesar(String criptografada, String str, int tam, int pos){
        int k = 3;

        // criptografia de cesar
        if(pos < tam){
            criptografada += (char)(str.charAt(pos) + k);
            criptografada = Cesar(criptografada, str, tam, pos+1);
        }
        
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

        String criptografada = "";
        for (int i = 0; i < numEntrada; i++) {
            MyIO.println(Cesar(criptografada, entrada[i], entrada[i].length(), 0));
        }
    }
}