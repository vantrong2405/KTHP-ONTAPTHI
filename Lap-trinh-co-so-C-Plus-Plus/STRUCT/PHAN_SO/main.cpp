#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
struct PhanSo{
   int tu ;
   int mau ;
};
PhanSo A,B,C,D,E;
//==================//
PhanSo Input(char c ){
	printf("nhap phan so %c\n",c);
	PhanSo Tam;
	int code = 0 ;
	do{
		printf("Nhap tu so cua %c = ",c);
		code = scanf("%d",&Tam.tu); fflush(stdin);
	}while(code == 0 );
	//===================//
	do{
		printf("Nhap mau so cua %c = ",c);
		code = scanf("%d",&Tam.mau); fflush(stdin); 
	}while(code == 0 || Tam.mau == 0 );
	return Tam;
}
//==============//
void Output(PhanSo A , char c){
	printf("Phan So %c = ",c);
	printf("%d/%d\n",A.tu,A.mau);
}
//===================//
int UCLN(int a , int b ){
	if(a==b) return a ;
	if(a>b) return UCLN(a-b,b);
	else return UCLN(a,b-a);
}
//==================//
PhanSo RutGon(PhanSo A){
	PhanSo Tam = A ;
	int uc = UCLN(Tam.tu , Tam.mau);
	Tam.tu = A.tu/uc;
	Tam.mau= A.mau/uc;
	return Tam ;
}
//======================//
PhanSo Nhan(PhanSo A  , PhanSo B ){//phep nhan 2 phan so 
	PhanSo Tam ;
	Tam.tu = A.tu * B.tu;	
	Tam.mau = A.mau * B.mau;
	Tam = RutGon(Tam);
	return Tam ;
}
//=================//
int Chia(PhanSo A , PhanSo B , PhanSo &C){
	if(B.tu == 0 ) return 0 ;
	PhanSo Tam ;
	Tam.tu = B.mau;
	Tam.mau = B.tu;
	C= RutGon(Nhan(A,Tam));
	return 1 ;
}
//==============//
PhanSo Tong(PhanSo A , PhanSo B , PhanSo &C){
	int mc = A.mau * B.mau;
	A.tu = A.tu * B.mau;
	B.tu = B.tu * A.mau;
    PhanSo Tam;
	Tam.tu = A.tu + B.tu;
	Tam.mau= mc;
	Tam = RutGon(Tam);
	return Tam ;
}

int main(int argc, char** argv) {
    A = Input('A') ; Output(A,'A');
    B = Input('B') ; Output(B,'B');
  C = Nhan(A,B); Output(C,'C');	
//   if(Chia(A,B,D) == 0) printf("Khong chia duoc\n ");
//   else Output(D,'D');
//    E = Tong(A,B,E); Output(E,'E');
	return 0;
}
