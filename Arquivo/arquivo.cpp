#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
#include <fstream> // fluxo de arquivo
using std::ifstream; // insere fluxo de arquivo
using namespace std;

int main (){
    FILE *arquivo;
    //abrindo o arquivo
    arquivo = fopen("arquivo.txt", "wb");
    int len;
    cin >> len;
    float valor[100]; 
    for(int i = 0; i < len; i++){
        cin >> valor[i];
        fwrite(&valor[i], sizeof(float), 1, arquivo);
        //cout << sizeof(valor) << endl;
    }
    long int tam = ftell(arquivo);
    //cout << tam << endl;
    fclose(arquivo);

    arquivo = fopen("arquivo.txt", "rb");
    float aux;
    for(int i = sizeof(float); i <= tam; i+=sizeof(float)){ 
        fseek(arquivo, tam-i, SEEK_SET);
        fread(&aux, sizeof(float), 1, arquivo);
        cout << aux << endl; 
    }

}
