#include <iostream>
#define size 20 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
FILE *f;// khai bao con tro f 
int A[size] , n ;
int main(int argc, char** argv) {
	f = fopen("test.txt","r");//doc file cua file text
	if(f== NULL){//neu file sai ( tuc la = NUll ) thi mo file ko thanh cong nguoc lai la thanh cong 
		printf("Mo file khong thanh cong ");
		return 1 ; 
	}
	// feof(f) da den cuoi dia chi . phu dinh !feof(f) chua den cuoi dia chi . dk ; chua den cuoi dia chi thi thuc hien vong lap 
    while(!feof(f)){// chi chay khi !feof  cua bien f neu bien f nam tren dia chi chua toi eof thi tra ve 0  , neu den cuoi thi tra ve 1    
    	fscanf(f,"%d",&A[n]);//doc du lieu cua file 
		n = n + 1 ;//tang them mang 
	}	
	for(int i = 0 ; i<n ; i++){
		printf("%d\t",A[i]);//in mang ra 
	}
	fclose(f);
	for(int i = 0 ;i<n;i++)
	   for(int j = n-1;j>i;j--)
	    if(A[j]<A[j-1]){
	    	int tam = A[j];
	    	A[j] = A[j-1];
	    	A[j-1] = tam ; 
		}
	printf("\n");
	for(int i = 0 ; i<n ; i++)
	   printf("%d\t",A[i]);
    f = fopen("result.txt","w");
    //nhap mang result
    	printf("\nnhap n : "); scanf("%d",&n);
    for(int i = 0 ; i<n;i++){
    	scanf("%d",&A[i]);
       fprintf(f,"%d\t",A[i]);
	}	
	//in file result ra 
	for(int i = 0 ; i<n ; i++)
	printf("%d\t",A[i]);
    
    fclose(f);
	return 0;
}
