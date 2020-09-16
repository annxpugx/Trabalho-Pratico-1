public class IsRecursivo {

    public static boolean isFim(String s) {
        return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isVogal(String str, int pos, int tam) {
        boolean resp;
        if(pos >= tam){
            resp = true;
        }
        else{
            if (str.charAt(pos) != 65 && str.charAt(pos) != 69 && str.charAt(pos) != 73 && str.charAt(pos) != 79
                    && str.charAt(pos) != 85) {
                resp = false;
                pos = str.length();
            }
            else{
                resp = isVogal(str, pos+1, tam);
            }
        }
     
        return resp;
    }

    public static boolean isConsoante(String str, int pos, int tam) {
        boolean resp;
        if(pos >= tam){
            resp = true;
        }
        else{
            if (str.charAt(pos) < 65 || str.charAt(pos) == 69 || str.charAt(pos) == 73 || str.charAt(pos) == 79
                    || str.charAt(pos) == 85 || str.charAt(pos) == 65 || str.charAt(pos) > 90) {
                resp = false;
                pos = str.length();
            }
            else{
                resp = isConsoante(str, pos+1, tam);
            }
        }
        
            
        
        return resp;
    }

    public static boolean isInteiro(String str, int pos, int tam) {
        boolean resp;
        if(pos > tam){
            resp = true;
        }
        else{
            if (str.charAt(pos) < 44 || str.charAt(pos) > 57 || str.charAt(pos) == ',' || str.charAt(pos) == '.') {
                resp = false;
                pos = str.length();
            }
            else{
                resp = isInteiro(str, pos+1, tam);
            }
        }
        
        return resp;
    }

    public static boolean isReal(String str, int pos, int tam, int commas) {
        boolean resp;
        if(pos >= tam){
            resp = true;
        }
        else{
            if(str.charAt(pos) == 44 || str.charAt(pos) == 46)
                commas += 1;
            if (str.charAt(pos) < 44 || str.charAt(pos) > 57 || commas > 1) {
                resp = false;
                pos = str.length();
            }else{
                resp = isReal(str, pos+1, tam, commas);
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;

        String[] resp = new String[4];

        for (int i = 0; i < numEntrada; i++) {
            entrada[i] = entrada[i].toUpperCase();
            if (isVogal(entrada[i], 0, entrada[i].length()-1))
                resp[0] = "SIM";
            else
                resp[0] = "NAO";

            if (isConsoante(entrada[i], 0, entrada[i].length()-1))
                resp[1] = "SIM";
            else
                resp[1] = "NAO";

            if (isInteiro(entrada[i], 0, entrada[i].length()-1))
                resp[2] = "SIM";
            else
                resp[2] = "NAO";

            if (isReal(entrada[i], 0, entrada[i].length()-1, 0))
                resp[3] = "SIM";
            else
                resp[3] = "NAO";
            MyIO.println(resp[0] + " " + resp[1] + " " + resp[2] + " " + resp[3]);
        }
    }
}