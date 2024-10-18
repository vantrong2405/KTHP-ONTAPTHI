#include <iostream>
#include<math.h>
#define epsilon 0.0001
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
struct Diem{
	double hoanh ;
	double tung ;
};
Diem A , B , C , D ;
double S;
//=============// 
Diem Input(char c ){
	Diem Tam ;
	printf("Nhap diem %c\n",c);
	int code = 0 ;
	do{
	 printf("nhap hoanh do cua %c = ",c); code = scanf("%lf",&Tam.hoanh) ; fflush(stdin);
	  fflush(stdin);
	}while(code == 0);
	
	do{
	 printf("nhap tung do cua %c = ",c); code = scanf("%lf",&Tam.tung) ; fflush(stdin);
	}while(code == 0);	
	return Tam ;
}
//===================//
void Output(Diem A , char c ){
	printf("%c = (%lf,%lf) ",c,A.hoanh,A.tung);
}
//=================//
double KhoangCach(Diem A , Diem B ){
	return sqrt(pow(A.hoanh - B.hoanh,2) + pow(A.tung - B.tung,2));
}
//========//
double DienTich(Diem A , Diem B , Diem C){
	double a = 0 , b = 0  ,c = 0, S = 0 ;
	a = KhoangCach(B,C); 
	b = KhoangCach(A,C);
	c = KhoangCach(A,B);
	double p = (a+b+c)/2;
	S = sqrt(p*(p-a) * (p-b) * (p-c));
	return S ;
}
//=======================//
int KiemTra(Diem A , Diem B , Diem C , Diem D ){
	double Sabd = DienTich(A,B,D);
	double Sacd = DienTich(A,C,D);
	double Sbcd = DienTich(B,C,D);
	if(Sabd + Sacd + Sbcd - DienTich(A,B,C) >= epsilon) return 1 ; 
	else return 0 ;
} 
int main(int argc, char** argv) {
	printf("acb");
	A = Input('A'); B=Input('B'); C=Input('C'); 
	Output(A,'A'); Output(B,'B'); Output(C,'C');
	S = DienTich(A,B,C);
	if(S == 0 ) printf("\nkhong phai la tam giac ");
	else printf("\nDien tich cua tam giac : %.3lf ",S);
	D = Input('D'); Output(D,'D');
	if(KiemTra(A,B,C,D) == 1) printf("\nNam ngoai");
	else printf("\nNam trong ");
	return 0;
}
