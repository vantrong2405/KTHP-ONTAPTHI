#include<iostream>
using namespace std ;
struct Node{
	Node* next ; 
	int data;
};

typedef Node *List ; // dinh nghia node co ten la list 

void insertFirst(int x , List &F){
	List p = new(Node);//tao 1 thang node moi ten la p
	p->data = x;
	p->next = NULL;
	if(F == NULL){
		F = p ;
	}else{
		p->next = F ;
		F = p ; 
	}
}

void insertLast(int x , List &F){
	List p = new(Node);//tao 1 thang node moi ten la p
	p->data = x;
	p->next = NULL;
	List q = F ; //coppy 1 thang dau tien
	if(F == NULL){
		F = p ;
	}else{
		while(q->next){
		q = q->next;
	}
      q->next = p ; 	
	}	
}

void deleteFirst(List &F){
	List q = F ;//coppy 1 thang dau tien
	F = F->next;//Nghi là con tro F chi thang vao nut 2 ( bo qua lun nut thu nhat ) vay bay gio thì nut thu 2 là nut dau tien
	delete(q);
}

void deleteLast(List &F){
	List q = F ; 
	while(q->next->next){
		q = q->next;
	}
	delete(q);
	q->next = NULL;
}

void printfList(List F){
	List p = F ; 
	cout<<"List current : ";
	while(p){
		cout<<p->data<<"\t ";
		p = p->next;
	}
}
 
int main(){
	int a ;  
	List F = NULL;
	cout<<"Nhap a : ";
	while(1){
		cin>>a;
		if(a == 0){
			deleteLast(F);
		   printfList(F);	
		}else{
			insertLast(a , F);
		}
	}
	return 0;
}
