#include <iostream>
#include<stdlib.h>
#include<time.h>
using namespace std ;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int i , n , random , Chan , Le , Tai , Xiu ;
char C , L ;
//===================//
//============//
void HamRanDom(int n ){
	int random ;
	srand(time(NULL));
	random =  1 + rand()%2;
	if(random == 1 ) printf("Rjp an CEO ");
	else printf("CEO an Rjp");	
}

int main(int argc, char** argv) {
	HamRanDom(n);  
	return 0;
}
