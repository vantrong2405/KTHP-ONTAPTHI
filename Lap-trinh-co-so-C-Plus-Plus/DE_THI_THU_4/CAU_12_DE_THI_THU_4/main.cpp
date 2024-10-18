#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
struct PhanSo{
	int tu ; 
	int mau ; 
};
PhanSo A ;
//======//
PhanSo Input(PhanSo &A ){
  printf(" nhap tu : "); scanf("%d",&A.tu);
  printf(" nhap mau : "); scanf("%d",&A.mau);
  return A ; 
}
//
void Output(PhanSo A){
	printf("Phan So = %d/%d",A.tu,A.mau);
}
//=========//
int UCLN(int a , int b){
	if(a==b) return a ;
	if(a>b) return UCLN(a-b,b);
	else{
		return UCLN(a,b-a);
	}
}
//======//
PhanSo RutGon(PhanSo &A ){
	int uc = UCLN(A.tu,A.mau);
    A.tu = A.tu/ uc ; 
    A.mau = A.mau/ uc ; 
    return A ; 
}

int main(int argc, char** argv) {
    Input(A);
    Output(A);
    RutGon(A);
    printf("\n");
    Output(A);
	return 0;
}
