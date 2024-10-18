#include<iostream>
using namespace std ; 
struct Node{
	Node *next;
	int data ; 
};
typedef Node *List;
void insertFirst(int x , List &F){
	List p = new(Node);
	p->data =  x;
	p->next = NULL; 
	if(F == NULL){
		F  =  p ; 
	}else{
		p->next = F; 
		F = p; 
	}
}

void insertLast(int x , List &F ){
	List p = new(Node);
	p->data =  x;
	p->next = NULL; 
	if(F == NULL){
		F  =  p ; 
	}else{
		List q =  F; 
		while(q->next){
			q = q->next;
		}
		q->next = p ; 
	}
}

void deleteFirst(List &F){
	List p = F ;
	F = F->next;
	delete(p);
}

void deleteLast(List &F){
	List q = F ; 
	if(q->next){
		q = q->next;
	}
	delete(q->next);
	q->next = NULL;
}

void printfList(List F ){
	List p = F ; // coppy thang dau tien
	cout<<"List : "; 
	while(p){
		cout<<p->data<<"\t";
		p = p->next;
	}
}

int main(){
	int A[100] , i = 0 , a ; 
	List F = NULL;
	cout<<"Nhap phan tu : ";
	while(1){
		cin>>a;
		if(a == 0){
			deleteLast(F);
			printfList(F);
			break;
		}else{
		insertLast(a,F);	
	}
}
}
