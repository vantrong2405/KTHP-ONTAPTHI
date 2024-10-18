#include <iostream>
#include <cstring>
#include <string.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
	char ho[40];
	char ho_lot[40];
	char ten[40];
	char ho_va_ten[50];
int main(int argc, char** argv) {
	printf("Nhap ho:");fflush(stdin);gets(ho);
	printf("Nhap ho lot:");fflush(stdin);gets(ho_lot);
	printf("Nhap ten:");fflush(stdin);gets(ten);
	strcpy(ho_va_ten,ho);strcat(ho_va_ten,"");
	strcat(ho_va_ten,ho_lot);strcat(ho_va_ten,"");
	strcat(ho_va_ten,ten);printf("Ho ten la:");puts(ho_va_ten);
	return 0;
}
