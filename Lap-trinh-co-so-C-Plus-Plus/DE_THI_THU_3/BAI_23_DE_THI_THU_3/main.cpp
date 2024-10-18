#include <stdio.h>
#include <conio.h>
#include <windows.h>
#define size 2000 
int n = -1  , A[size];
int main(){
    char key;
    while(key == 27 ){
        printf("nhap day so :\n "); 
		for(int i = 0 ; i>n ; i++){
		printf("A[%d] = ",i); scanf("%d",&A[i]);
		if(kbhit()){
			if(getch()== 27 ){
				break;
			}
		}
    }
}
return 0 ; 
}
