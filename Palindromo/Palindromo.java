import java.util.Scanner;

class Palindromo {

   public static boolean isFim(String s) {
      return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static boolean ePalindromo(String palavra) {
      String contrario = "";
      for (int i = (palavra.length() - 1); i >= 0; i--) {
         contrario = contrario + palavra.charAt(i);
      }
      
      int dif = 0;
      for(int i = 0; i < palavra.length(); i++){
         if(palavra.charAt(i) > contrario.charAt(i) || palavra.charAt(i) < contrario.charAt(i)) 
            dif = 1;
      } 
      if(dif == 1)
         return false;
      else return true;
         
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

      for (int i = 0; i < numEntrada; i++) {
         if (ePalindromo(entrada[i]) == true)
            System.out.println("SIM");
         else
            System.out.println("NAO");
      }
   }
}
