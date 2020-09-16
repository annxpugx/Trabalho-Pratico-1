
public class Algebra {
    public static int qtd_Linhas = 200;

    public static boolean Bool(String str) {
        boolean resp = false;
        int qtd_Valores = (int) str.charAt(0) - 48;
        String troca = "";
        String valores = "";
        String troca_Not = "";
        String troca_And = "";
        String troca_Or = "";
        // System.out.println(qtd_Valores);
        int inicio = 2 * qtd_Valores + 2;

        for (int i = 2; i < inicio; i++) {
            if (str.charAt(i) != ' ')
                valores += str.charAt(i);
        }

        // mudando os A B C pelos valores recebidos
        for (int i = inicio; i < str.length(); i++) {
            if (str.charAt(i) == 'A' || str.charAt(i) == 'B' || str.charAt(i) == 'C') {
                if (str.charAt(i) == 'A')
                    troca += valores.charAt(0);
                else if (str.charAt(i) == 'B')
                    troca += valores.charAt(1);
                else if (str.charAt(i) == 'C')
                    troca += valores.charAt(2);
            } else
                troca += str.charAt(i);
        }

        String teste = "";

        for (int i = 0; i < troca.length(); i++) {
            if (troca.contains("),")) {
                if (troca.charAt(i) == ',' && troca.charAt(i - 1) == ')') {
                    teste += " ,";
                } else
                    teste += troca.charAt(i);
            } else
                teste += troca.charAt(i);
        }

        troca = "";
        troca += teste;
        //System.out.println(troca);

        while (troca.length() > 2) {

            //System.out.println("troca AQUI " + troca);
            // operacao de negacao
            //not(1) == 0 
            if (troca.contains("not")) {
                for (int i = 0; i < troca.length(); i++) {
                    if (troca.charAt(i) == 'n' && troca.charAt(i + 1) == 'o'
                            && (troca.charAt(i + 4) == '1' || troca.charAt(i + 4) == '0')) {
                        if (troca.charAt(i + 4) == '1') {
                            troca_Not += '0';
                            i += 5;
                        } else if (troca.charAt(i + 4) == '0') {
                            troca_Not += '1';
                            i += 5;
                        }
                    } else
                        troca_Not += troca.charAt(i);
                }
            } else {
                troca_Not += troca;
            }

            //System.out.println("trocaNot " + troca_Not);
            // operacao and
            if (troca_Not.contains("and")) {
                for (int i = 0; i < troca_Not.length(); i++) {
                    if (troca_Not.charAt(i) == 'a' && troca_Not.charAt(i + 1) == 'n'
                            && (troca_Not.charAt(i + 4) == '1' || troca_Not.charAt(i + 4) == '0')
                            && (troca_Not.charAt(i + 8) == '1' || troca_Not.charAt(i + 8) == '0')) {
                        if (i < troca_Not.length() - 10 && troca_Not.charAt(i + 10) == ','
                                && troca_Not.charAt(i + 9) == ' ') {
                            if (troca_Not.charAt(i + 4) == '0') {
                                troca_And += "and(0 ";
                                i += 9;
                            } else if (troca_Not.charAt(i + 4) == '1') {
                                i += 8;
                                troca_And += "and(" + troca_Not.charAt(i);
                            }
                        } else if (troca_Not.charAt(i + 9) == ')') {
                            if (troca_Not.charAt(i + 4) == '0') {
                                troca_And += "0";
                                i += 9;
                            } else if (troca_Not.charAt(i + 4) == '1') {
                                i += 8;
                                troca_And += troca_Not.charAt(i);
                                i++;
                            }
                        }
                    } else
                        troca_And += troca_Not.charAt(i);
                }
            } else {
                troca_And += troca_Not;
            }

            //System.out.println("trocaAnd " + troca_And);

            // operacao or
            for (int i = 0; i < troca_And.length(); i++) {
                if (troca_And.charAt(i) == 'o' && troca_And.charAt(i + 1) == 'r'
                        && (troca_And.charAt(i + 3) == '1' || troca_And.charAt(i + 3) == '0')
                        && (troca_And.charAt(i + 7) == '1' || troca_And.charAt(i + 7) == '0')) {
                    if (i < troca_And.length() - 9 && troca_And.charAt(i + 9) == ','
                            && troca_And.charAt(i + 8) == ' ') {
                        //System.out.println("cheguei aqui aaa");
                        if (troca_And.charAt(i + 3) == '1') {
                            troca_Or += "or(1 ";
                            i += 8;
                        } else if (troca_And.charAt(i + 3) == '0') {
                            //System.out.println("cheguei aqui bbb");
                            i += 7;
                            troca_Or += "or(" + troca_And.charAt(i) + " ";
                            i++;
                        }
                    } else if (troca_And.charAt(i + 8) == ')') {
                        //System.out.println(troca_Or);
                        if (troca_And.charAt(i + 3) == '1') {
                            troca_Or += "1";
                            i += 8;
                        } else if (troca_And.charAt(i + 7) == '1') {
                            //System.out.println("cheguei aqui ccc");
                            i += 7;
                            troca_Or += '1';
                            i++;
                        }else{
                                i += 7;
                                troca_Or += '0';
                                i++;
                            }
                    }
                } else
                    troca_Or += troca_And.charAt(i);
            }

            //System.out.println("trocaOr " + troca_Or);

            troca = "";
            troca_Not = "";
            troca_And = "";
            troca += troca_Or;
            troca_Or = "";

            // System.out.println("troca " + troca);
        }

        if(troca.equals("1") || troca.equals("1 "))
            resp = true;
        else
            resp = false;
        return resp;
    }

    public static void main(String[] args) {
        String[] entrada = new String[qtd_Linhas];
        int numEntrada = 0;
        entrada[numEntrada] = MyIO.readLine();
        while (entrada[numEntrada].charAt(0) != '0') {
            numEntrada++;
            entrada[numEntrada] = MyIO.readLine();
        }

        for (int i = 0; i < numEntrada; i++) {
            if (Bool(entrada[i]) == true)
                MyIO.println(1);
            else
                MyIO.println(0);
        }
    }
}