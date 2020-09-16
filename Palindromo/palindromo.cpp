#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
#include <locale.h>
using namespace std;
#define bool short
#define true 1
#define false 0

bool isFim(char *s){
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

bool palindromo(char *s) {
    char comp[1000];
    int tam = strlen(s) - 1;
    bool resp = 1;
    int i, j;
    for(i = 0, j = strlen(s)-1; i < strlen(s); i++, j--){
        comp[i] = s[j];
    }

    for(i = 0; i < strlen(s)-1; i++){
        if(s[i] == comp[i]){
            resp = 1;
        }
        else{
            resp = 0;
            i = strlen(s);
        }  
    }
    return resp;
}

int main() {
    setlocale (LC_ALL, "");
    char entrada [700][1000];
    int numEntrada = 0;

    // Leitura da entrada padrao
    do{
        lerLinha(entrada[numEntrada], 1000, stdin);
    }while (isFim(entrada[numEntrada++]) == false);
    numEntrada--;

    int i;
    for(i = 0; i < numEntrada; i++){
        int resp = palindromo(entrada[i]);
        if(resp == true)
            cout << "SIM" << endl;
        else 
            cout << "NAO" << endl;
    }
}


