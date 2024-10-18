#include <iostream>
#define size 20 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
 
int A[size] , n ;
//=================//
int DocFile(char *tenfile , int A[] , int&n){
	FILE *f;// khai bao con tro f
	f = fopen(tenfile,"r");//doc file cua file text
	if(f== NULL){//neu file sai ( tuc la = NUll ) thi mo file ko thanh cong nguoc lai la thanh cong 
		printf("Mo file khong thanh cong ");
		return 0 ; 
	}
    while(!feof(f)){// chi chay khi !feof  cua bien f neu bien f nam tren dia chi chua toi eof thi tra ve 0  , neu den cuoi thi tra ve 1    
    	fscanf(f,"%d",&A[n]);//doc du lieu cua file 
		n = n + 1 ;//tang them mang 
	}
	//in mang 
		for(int i = 0 ; i<n ; i++){
		printf("%d\t",A[i]);//in mang ra 
	}
	fclose(f);
	return 1 ;
}
//=========================//
int GhiFile(char *tenfile , int A[] , int n ){
	FILE *f;// khai bao con tro f
	f = fopen(tenfile,"w");// ghi file
	if(f== NULL){//neu file sai ( tuc la = NUll ) thi mo file ko t	hanh cong nguoc lai la thanh cong 
		printf("Mo file khong thanh cong ");
		return 0 ; 
	}
	//In//
	for(int i = 0 ; i<n ; i++)
	   fprintf(f,"%d\t",A[i]);
	   for(int i=0;i<n;i++){
			printf("%d\t",A[i]);//in mang ra
		}
	fclose(f);
	return 1 ;	
}
//================//
void SapXep(int A[] , int n ){
	for(int i = 0 ;i<n;i++)
	   for(int j = n-1;j>i;j--)
	    if(A[j]<A[j-1]){
	    	int tam = A[j];
	    	A[j] = A[j-1];
	    	A[j-1] = tam ; 
	}
} 
int main(int argc, char** argv) {
   if(DocFile((char*)"test.txt",A,n)){
   	printf("\n");
   	SapXep(A,n);
   	GhiFile((char*)"result.txt",A,n);
   }
	return 0;
}
