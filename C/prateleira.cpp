#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void troca(char string1[], char string2[]){
	char temp[300];
	memcpy(temp, string1, 300);
	memcpy(string1, string2, 300);
	memcpy(string2,temp, 300);
}

int main(){

	int qtd_livros;
	scanf("%d \n", &qtd_livros);

	char livros[qtd_livros][300];

	for(int i = 0; i < qtd_livros; i++){
		memset(&livros[i], 0, 300);
	}

	for(int i = 0; i < qtd_livros; i++){
		scanf("%[^\n]", livros[i]);
		getchar();
	}
	int maior = 0;
	for(int i = 0; i < qtd_livros - 1; i++){
		for(int j = 0; j < 300; j++){
			if(livros[i][j] > livros[maior][j]){
				maior = i;
				break;
			}
		}
		troca(livros[i], livros[maior]);
	}	
	
	printf("--------------------------- \n");

	for(int j = 0; j < qtd_livros; j++){
		printf("%s \n", livros[j]);
	}	

	return 0;
}
