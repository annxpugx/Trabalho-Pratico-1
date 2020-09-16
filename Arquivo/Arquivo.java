import java.io.*;
import java.util.*;
public class Arquivo{
    public static void main (String[] args) throws Exception{
        int n = MyIO.readInt();
        RandomAccessFile saida = new RandomAccessFile("saida.txt", "rw");
        for(int i = 0; i < n; i++){
            double valor = MyIO.readDouble();
            saida.writeDouble(valor);
        }
        int len = (int) saida.getFilePointer();
        saida.close();

        saida = new RandomAccessFile("saida.txt", "r");
        
        for(int i = 8; i < len; i+=8){ 
            saida.seek(len-i);
            double aux = saida.readDouble();
            if(aux%1 == 0){
                MyIO.println((int) aux);
            }
            else
                MyIO.println(aux);
        }
    }
}