#include<iostream>
using namespace std ; 
struct Node{
	int Data ;
	Node *next ;
};
typedef  Node* List;

void insertFirst(int x , List &F){
	List p = new(Node);
	p->Data = x ; 
	p->next = F;
	F = p ;  	
}

void insertLast(int x , List &L ){
     List p = new(Node);
	 p->Data = x ; 
	 p->next = NULL;
	 if(L == NULL){
	 	L = p ; 
	}else{
		List q = L ; 
		while(q->next){
		 q = q->next;	
		}
		q->next = p ;
	}
}

void printList(List F){
	List p =  F ; 
	cout<<"List : "; 
    while(p){
    	cout<<p->Data<<"\t";
    	p =  p->next;
	}
}

void deletFirst(List &F){
    List p = F ; //tro den ptu dau tien cua F
    F = F->next;//F se bat dau tu phan tu thu 2 
    delete(p);//
}

void delet

int main(){
	List F = NULL ;
	int a ; 
	do{ 
	  cin>>a;
	  if(a == 0 ){
	  	deletFirst(F);
	  	printList(F);
	  	break;
	  }else{
	  	insertLast(a , F);
	  }
	}while(true);
  
	return 0 ; 
}
