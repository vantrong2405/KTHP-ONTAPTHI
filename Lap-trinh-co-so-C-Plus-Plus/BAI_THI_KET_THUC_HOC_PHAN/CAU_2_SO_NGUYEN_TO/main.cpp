#include <iostream>
#include<math.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int N , A , B , C = 0  , i ;
//=====//
void Input(int &n){
	printf("nhap N : "); scanf("%d",&N);
}
//=====//
int TongLe(int &N){
	for(int i = 1 ; i<= N; i++){
		if(i % 2 == 1 && i % 3 == 0 ){
			A = A + i ;
		}
	}
	return A ; 
}
//====//
int Ktra(int &N){
	if(N<2) return 0 ; 
	for(int i = 2 ; i<=N/2 ; i++){
		if(N % i == 0){
			return 0 ; 
		} 
	}
	return 1 ; 
}
//=====//
void Snt(int &N){
	if(Ktra(N)) printf("YES\n");
	else{
		printf("NO\n");
	}
}
//====//
bool KTSCP(int &N ){
	if(sqrt(N) * sqrt(N) == N) return 1 ;
	return 0 ; 
}
//=======//
int SCP(int &N){
	for(int i = 1 ; i<=N ;i++){
		if(KTSCP(i)){
			printf("SCP = %d\t",i);
			C++ ;
		}
	}
	return C ;
}
int main(int argc, char** argv) {
	Input(N);
	printf("Tong cac so le chia het cho 3 la : %d\n",TongLe(N));
	Snt(N);
	printf("\nC = %d ",SCP(N));
	return 0;
}
