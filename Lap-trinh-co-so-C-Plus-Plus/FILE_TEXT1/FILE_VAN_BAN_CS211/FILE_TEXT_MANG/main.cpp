#include <iostream>
#define size 20 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
FILE *f ;
int n , A[size];
int main(int argc, char** argv) {
    f = fopen("XemMang1.txt","r");//mo mang nao o che do nao  
    if(f == NULL){// kiem tra mang co mo dung hay khong
    	printf("Errol !");
    	return 1 ;
	}
	//Kiem tra xem den cuoi cua mang chua 
	while(!feof(f)){
		fscanf(f,"%d",&A[n]);
		n = n + 1 ;
	}
	printf("Nhap kich thuoc mang : "); 
	scanf("%d",&n);
	for(int i = 0 ; i<n ; i++){
		printf("A[%d] = ",i); scanf("%d",&A[i]); 
		fprintf(f,"%d",A[n]);//ghi 
	}
		//Xem Mang 
	for(int i = 0 ; i< n ; i++)
	  printf("%d\t",A[i]);
	//Sap Xep theo thu tu tang dan 
	for(int i = 0 ; i< n ; i++)
	   for(int j = i + 1 ; j <n ; j++)
	       if(A[i] > A[j]){
	       	int tam = A[i];
	       	A[i] = A[j];
	       	A[j] = tam ; 
	}
	printf("\nMang sau khi sap xep la :\n ");
	//Xem Mang 
	for(int i = 0 ; i< n ; i++)
	  printf("%d\t",A[i]);
	return 0;
}
