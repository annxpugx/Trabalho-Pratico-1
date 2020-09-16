public class Is {

    public static boolean isFim(String s) {
        return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isVogal(String str) {
        boolean resp = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 65 && str.charAt(i) != 69 && str.charAt(i) != 73 && str.charAt(i) != 79
                    && str.charAt(i) != 85) {
                resp = false;
                i = str.length();
            }
        }
        return resp;
    }

    public static boolean isConsoante(String str) {
        boolean resp = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 65 || str.charAt(i) == 69 || str.charAt(i) == 73 || str.charAt(i) == 79
                    || str.charAt(i) == 85 || str.charAt(i) == 65 || str.charAt(i) > 90) {
                resp = false;
                i = str.length();
            }
        }
        return resp;
    }

    public static boolean isInteiro(String str) {
        boolean resp = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 44 || str.charAt(i) > 57 || str.charAt(i) == ',' || str.charAt(i) == '.') {
                resp = false;
                i = str.length();
            }
        }
        return resp;
    }

    public static boolean isReal(String str) {
        boolean resp = true;
        int commas = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 44 || str.charAt(i) == 46)
                commas += 1;
            if (str.charAt(i) < 44 || str.charAt(i) > 57 || commas > 1) {
                resp = false;
                i = str.length();
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
            if (isVogal(entrada[i]))
                resp[0] = "SIM";
            else
                resp[0] = "NAO";

            if (isConsoante(entrada[i]))
                resp[1] = "SIM";
            else
                resp[1] = "NAO";

            if (isInteiro(entrada[i]))
                resp[2] = "SIM";
            else
                resp[2] = "NAO";

            if (isReal(entrada[i]))
                resp[3] = "SIM";
            else
                resp[3] = "NAO";
            MyIO.println(resp[0] + " " + resp[1] + " " + resp[2] + " " + resp[3]);
        }
    }
}