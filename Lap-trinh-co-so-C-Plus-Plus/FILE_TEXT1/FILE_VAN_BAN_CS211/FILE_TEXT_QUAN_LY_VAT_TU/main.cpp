#include <iostream>
#define size 50
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
struct VatTu{
	char mavt[50];
	char tenvt[50];
	int soluong;
	double dongia;
	double thanhtien ; 
};
VatTu X ; 
//===============//
int n , A[size];
FILE *f;
//=============//
void Input(int &n){
	int code = 0 ;
	do{
		printf("nhap so luong vat tu  : "); code = scanf("%d",&n);
	}while(code == 0 );
}
//===============//
int GHIFILE(int &n , int A[] , char *tenfile){
	f = fopen(tenfile , "w");
	if(f == NULL){
		printf("Errol ! ");
		 return 1 ;
	} 
    for(int i = 0 ; i < n ; i++){
    	printf("=====Nhap thong tin cua vat tu thu %d :===============\n",i+1);
    	printf("Ma vat tu : "); fflush(stdin); gets(X.mavt);
    	printf("Ten vat tu : "); fflush(stdin);gets(X.tenvt);
    	printf("So luong : "); fflush(stdin); scanf("%d",&X.soluong);
    	printf("Don gia : "); fflush(stdin); scanf("%lf",&X.dongia);
    	printf("Thanh tien : "); fflush(stdin); scanf("%lf",&X.thanhtien);
    	fprintf(f,"%d",A[n]);//ghi ( tat ca nhung gi mik nham se thanh ghi ) 
	}
}
//=================//
int DOCFILE(int &n , int A[] , char *tenfile){
	f = fopen(tenfile,"r");// mo file 
	while(!feof(f)){
		fscanf(f,"%d",&A[n]);
		n = n + 1 ; 
		printf("==================Thong tin cua vat tu :=======================\n");
	for(int i = 0 ; i< n ; i++){
		printf("Thong tin cua vat tu thu %d :\n",i+1);
		printf("Ma vat tu :"); puts(X.mavt);printf("\n");
		printf("Ten vat tu :"); puts(X.tenvt);printf("\n");
		printf("So luong :"); printf("%d",X.soluong);printf("\n");
		printf("Don gia :"); printf("%.3lf",X.dongia);printf("\n");
		printf("Thanh tien :"); printf("%.3lf",X.thanhtien);printf("\n");
	}
}
	
}

int main(int argc, char** argv) {
	Input(n);
	GHIFILE(n,A,(char*)"data.txt");
	DOCFILE(n,A,(char*)"data.txt");
	return 0;
}
