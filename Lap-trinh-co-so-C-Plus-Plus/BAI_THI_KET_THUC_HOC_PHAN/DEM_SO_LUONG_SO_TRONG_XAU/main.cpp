#include <iostream>
#include<cstring>
using namespace std;
string s,s1="";
int count=0;

int main(){
    cout << "Nhap s:"; cin>>s;
    s=s+" "; 
    for(int i=0;i<s.length();i++)
      if ((s[i]>='0')&&(s[i]<='9'))  s1=s1+s[i];//s1+=s[i]
      else{
      	if (s1.length()!=0){
          count++;
          s1="";
        }
	  }
    cout<<count;
    return 0;
}
