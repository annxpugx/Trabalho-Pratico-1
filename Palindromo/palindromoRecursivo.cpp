#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
using namespace std;
#define bool short
#define true 1
#define false 0

bool isFim(char *s) {
    return (strlen(s) >= 3 && s[0] == 'F' &&
        s[1] == 'I' && s[2] == 'M');
}

char *replaceChar(char *string, char toSearch, char toReplace)
{
    char *charPtr = strchr(string, toSearch);
    if (charPtr != NULL) *charPtr = toReplace;
    return charPtr;
}

void lerLinha(char *string, int tamanhoMaximo, FILE *arquivo)
{
    fgets(string, tamanhoMaximo, arquivo);
    replaceChar(string, '\r', '\0');
    replaceChar(string, '\n', '\0');
}

bool palindromo(char *s, int pos, int tam) {
    bool resp;
    int i, j;

    if(pos >= tam){
        resp = true;
    }
    else{
        if(s[pos] == s[tam])
            resp = palindromo(s, pos+1, tam-1);
        else{
            resp = false;
        }
    }

    return resp;
}

int main() {
    char entrada [700][1000];
    int numEntrada = 0;
    
    // Leitura da entrada padrao
    do {
        lerLinha(entrada[numEntrada], 1000, stdin);
    } while (isFim(entrada[numEntrada++]) == 0);
     // Desconsiderar ultima linha contendo a palavra FIM

    int i, j;
    for(i = 0; i < numEntrada-1; i++){
        int resp = palindromo(entrada[i], 0, strlen(entrada[i])-1);
        if(resp == 1)
            cout << "SIM" << endl;
        else 
            cout << "NAO" << endl;
    }
}


