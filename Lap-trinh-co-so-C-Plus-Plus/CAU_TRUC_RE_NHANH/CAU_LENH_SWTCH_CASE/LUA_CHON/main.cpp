#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int n ;
int main(int argc, char** argv) {
	int luachon ; 
	UchihaSasukeSusanno : 
	printf("============MENU=========\n");
	printf("1.Chay chuong trinh bai 1\n");
	printf("2.Chay chuong trinh bai 2\n");
	printf("3.Thoat\n");
	printf("=========================\n");
	printf("Ban hay chon: "); scanf("%d",&luachon);
    printf("Ban da chon chuc nang : %d\n",luachon);
    switch(luachon){
    	case 1 :{
    		
			break;
		}
    	//=======//
    	case 2 :{
            goto UchihaSasukeSusanno ; 
			break;
		} 
    	//========//
    	case 3:{
    		printf("Hen gap lai ! "); 
			break;
		}
  }
	return 0;
}
