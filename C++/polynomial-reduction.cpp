/*
  Name: polynomial-reduction.cpp
  Copyright: 2008
  Authors: Anurag Bhandari and Gourav Gupta
  Date: 19-11-08 16:00
  Description: Checks if a given polynomial is reducible over GF(2).
*/



#include<iostream.h>
#include<conio.h>
#include<math.h>

int division_x(int[]);
int division_xplus1(int[]);

int n;
int flag=0;

void main()
{
	clrscr();
	cout<<"Enter the degree of polynomial: ";
	cin>>n;
	int *a = new int [n+1];
	for(int i=0;i<n+1;i++)
	{
		cout<<"Enter the co-efficient of x^"<<i<<": ";
		cin>>a[i];
	}
	for(int j=n; j>=0; j--)
	{
		if(j!=0)
			cout<<a[j]<<"x^"<<j<<" + ";
		else
			cout<<a[j];
	}
	division_x(a);
	if(flag!=1)
		division_xplus1(a);
	if(flag==1)
		cout<<"\n\nReducible";
	else
		cout<<"\n\nIrreducible";
	getch();
}

int division_x(int a[])
{
	if(a[0]==0)
		flag=1;
	else
		flag=0;
	return(flag);
}

int division_xplus1(int a[])
{
	int *b= new int [n+1];
	int r=n+1;
	for(int x=0;x<n-1;x++)
	{
		for(int y=r;y>=0;y--)
		{
			if(y==r)
				b[y]=0;
			else if(y==r-1)
				b[y]=abs(a[y]-a[y+1]);
			else
				b[y]=a[y];
		}
		--r;
	}
	for(int z=0;z<=n+1;z++)
	{
		if(b[0]==0)
			flag=1;
		else
			flag=0;
	}
	return(flag);
}
