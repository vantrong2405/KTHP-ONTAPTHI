#include <iostream>
#include <string.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	char ho[30] , ho_lot[30] , ten[30] , ho_va_ten[50] ;
	printf("nhap ho : "); gets(ho); fflush(stdin);
	printf("nhap ho lot : "); gets(ho_lot); fflush(stdin);
	printf("nhap ten : "); gets(ten); fflush(stdin);
	strcpy(ho_va_ten,ho);//coppy chuoi ho vao ho va ten ( tat ca nhung gi trong chuoi ho va ten luc dau se bi xoa )
	strcat(ho_va_ten," ");
	strcat(ho_va_ten,ho_lot); strcat(ho_va_ten," ");// noi chuoi
	strcat(ho_va_ten,ten);
	printf("hp va ten : "); puts(ho_va_ten);
	return 0;
}
