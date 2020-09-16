import java.util.Scanner;

class PalindromoRecursivo {

    public static boolean isFim(String s) {
        return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
     }

    public static boolean palindromo(String s){
    return palindromo(s, 0, s.length()-1);
    }

    public static boolean palindromo(String palavra, int i, int j) {
        boolean resp;
    if (i >= j) {
        resp = true;
    } else {
        if(palavra.charAt(i) != palavra.charAt(j))
            resp = false;
        else
            resp = palindromo(palavra, i+1, j-1);
    }
        return resp;
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

        for(int i = 0; i < numEntrada; i++){
            if(palindromo(entrada[i]))
                MyIO.println("SIM");
            else
                MyIO.println("NAO"); 
        }
    }
}