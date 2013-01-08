#include<iostream>

using namespace std;

int a, b;
a = (b=5, b+3); //use of the comma operator to initialize 'a'
void increment(int, int);

int main()
{
	increment(a, b);
	cout<<a<<" "<<b;
	cout<<"\n";
	return(0);
}

void increment(int x, int y)
{
	++x;
	++y;
}
