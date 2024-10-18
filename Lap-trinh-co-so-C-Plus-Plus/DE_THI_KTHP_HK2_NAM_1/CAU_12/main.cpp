#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
double chieudai , chieurong , chuvi , dientich ;
int main(int argc, char** argv) {
	printf("Nhap chieu dai : "); scanf("%lf",&chieudai);
	printf("Nhap chieurong : "); scanf("%lf",&chieurong);
	chuvi = (chieudai + chieurong) * 2 ; 
	dientich = chieudai * chieurong ; 
	printf("\nChu vi : %lf",chuvi);
	printf("\nDientich : %lf",dientich);
	return 0;
}
