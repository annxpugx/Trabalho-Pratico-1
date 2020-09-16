#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
using namespace std;
#define bool short
#define true 1
#define false 0

bool isFim(char *s){
    return (strlen(s) >= 3 && s[0] == 'F' &&
        s[1] == 'I' && s[2] == 'M');
}

void Maiusculo(char *palavra){
    for(int i = 0; i < strlen(palavra); i++){
        if(palavra[i] > 96)
            palavra[i] -= 32;
    }
}

char *replaceChar(char *string, char toSearch, char toReplace)
{
    char *charPtr = strchr(string, toSearch);
    if (charPtr != NULL) 
        *charPtr = toReplace;
    return charPtr;
}

void lerLinha(char *string, int tamanhoMaximo, FILE *arquivo)
{
    fgets(string, tamanhoMaximo, arquivo);
    replaceChar(string, '\r', '\0');
    replaceChar(string, '\n', '\0');
}

bool isVogal(char *str)
{
    bool resp = true;
    for (int i = 0; i < strlen(str); i++)
    {
        if (str[i] != 65 && str[i] != 69 && str[i] != 73 && str[i] != 79 && str[i] != 85)
        {
            resp = false;
            i = strlen(str);
        }
    }
    return resp;
}

bool isConsoante(char *str){
    bool resp = true;
    for (int i = 0; i < strlen(str); i++){
        if (str[i] < 65 || str[i] == 69 || str[i] == 73 || str[i] == 79 || str[i] == 85 || str[i] == 65 || str[i] > 90){
            resp = false;
            i = strlen(str);
        }
    }
    return resp;
}

bool isInteiro(char *str){
    bool resp = true;
    for (int i = 0; i < strlen(str); i++){
        if (str[i] < 44 || str[i] > 57 || str[i] == 44 || str[i] == 46){
            resp = false;
            i = strlen(str);
        }
    }
    return resp;
}

bool isReal(char *str){
    bool resp = true;
    int commas = 0;
    for (int i = 0; i < strlen(str)-1; i++){
        if (str[i] == 44 || str[i] == 46)
            commas+=1;
            if(commas > 1)
                return false;
        if (str[i] < 44 || str[i] > 57){
            resp = false;
            i = strlen(str);
        }
    }
    return resp;
}

int main()
{
    char entrada [700][1000];
    int numEntrada = 0;

    // Leitura da entrada padrao
    do{
        lerLinha(entrada[numEntrada], 1000, stdin);
    }while (isFim(entrada[numEntrada++]) == false);
    numEntrada--;

    char resp[4][4];

    for (int i = 0; i < numEntrada; i++){
        Maiusculo(entrada[i]);
        if (isVogal(entrada[i]) == true){
            cout << "SIM ";
        }else{
            cout << "NAO ";
        }

        if (isConsoante(entrada[i]) == true){
            cout << "SIM ";
        }else{
            cout << "NAO ";
        }

        if (isInteiro(entrada[i]) == true){
            cout << "SIM ";
        }else{
            cout << "NAO ";
        }

        if (isReal(entrada[i]) == true){
            cout << "SIM" << endl;
        }else{
            cout << "NAO" << endl;
        }
    }
}