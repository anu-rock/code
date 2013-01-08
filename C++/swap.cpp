#include<iostream>

using namespace std; 

int main()
{
	int a,b;
	cout<<"Enter 'a': ";
	cin>>a;
	cout<<"\nEnter 'b': ";
	cin>>b;
	a = a + b;
	b = a - b;
	a = a - b;
	cout<<"\n\nThe SWAPED numbers are: "<<endl;
	cout<<"a = "<<a<<endl;
	cout<<"b = "<<b<<endl;
	//system("PAUSE");
	return(0);
} 
