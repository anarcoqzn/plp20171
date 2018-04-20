#include <stdio.h>
#include <string.h>

int main(){
   
    int cont = 0;

    while(cont < 3){
        char palavra[30];
        int temVogal = 0;
        scanf("%s", palavra);

        for(int i = 0; i < 30; i++){
            if(palavra[i] == 'a' || palavra[i] == 'e' || palavra[i] == 'i' || palavra[i] == 'o' || palavra[i] == 'u'){
                temVogal = 1;
        
            }   
        }
        
        if(temVogal == 0){
            cont++;
            printf("%s\n", palavra); 
        }
        memset(&palavra, 0, 30);
    }
    
    return 0;
}