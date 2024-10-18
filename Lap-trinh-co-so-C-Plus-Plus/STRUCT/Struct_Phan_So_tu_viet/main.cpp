#include <iostream>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
struct PhanSo{
	int tu ;
	int mau ;
};
PhanSo A , B , C , D ,E , F ;
//============================//
int a , b ;
//==========================//
PhanSo Input(PhanSo A , char c ){
	int code = 0 ;
	PhanSo Tam ;
	printf("Nhap Phan So %c :\n",c);
	do{
		printf("Nhap tu so cua %c = ",c); code = scanf("%d",&Tam.tu); fflush(stdin);
	}while(code == 0 );
	
	do{
		printf("Nhap mau so cua %c = ",c); code = scanf("%d",&Tam.mau); fflush(stdin);
	}while(code == 0 || Tam.mau == 0  );
	return Tam ;//return ra A co bien la tu va mau 
}
//================================//
PhanSo Output(PhanSo A , char c){
	PhanSo Tam ;
	printf("%c = %d/%d\n",c,Tam.tu,Tam.mau);
}
//=============================//
int UCLN(int a , int b){
	if(a == b) return a ;
	if(a > b)  return UCLN(a-b,b);
	if(a < b)  return UCLN(a,b-a); 
}
//==========================//
PhanSo RutGon(PhanSo A ){
	PhanSo Tam = A ;
	int UC = UCLN(Tam.tu , Tam.mau );
	Tam.tu = A.tu / UC;
	Tam.mau = A.mau / UC ;
	return Tam ;
}
//==========================//
PhanSo Chia(PhanSo A , PhanSo B ){
	PhanSo Tam ;
	Tam.tu = A.tu * B.mau ;
	Tam.mau = A.mau * B.tu;
	Tam = RutGon(Tam);
	return Tam ;
}
//==========================//
PhanSo Cong(PhanSo A , PhanSo B ){
	PhanSo Tam ;
	int MC = A.mau * B.mau ;
	Tam.tu = A.tu * B.mau + B.tu * A.mau ;
	Tam.mau = MC ;
	Tam = RutGon(Tam);
	return Tam ;
}
//===========================//
int main(int argc, char** argv) {
    A = Input(A,'A'); Output(A,'A');
    B = Input(B,'B'); Output(B,'B');
    C = Chia(A,B); Output(C,'C'); 
    D = Cong(A,B); Output(D,'D');
	return 0;
}
