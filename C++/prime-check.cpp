/*
  Name: prime-check.cpp
  Copyright: 2008
  Author: Anurag Bhandari
  Date: 11-08-08 22:47
  Description: Checks whether the entered number is prime
*/

#include<iostream>

using namespace std;

void repchar() //defining a function before main() does not require prototype declaration
{
     for(int i=0;i<50;i++)
             cout<<"=";
     cout<<"\n\n";
}

int main()
{
    int a,flag=1;
    cout<<"P R I M E  N U M B E R  C H E C K E R"<<endl; //decorative header
    repchar();
    cout<<"Enter the number: ";
    cin>>a;
    for(int x=2;x<a;x++) //check from numbers 2 to one less than the number itself
    {
            if(a%x == 0) //if the number in loop divides entered number complely,
                   flag=0; //we set the flag value to 0
    }
    cout<<"\n";
    if(flag==1)
               cout<<a<<" is indeed a prime number"<<endl;
    else
               cout<<a<<" is not a prime number"<<endl;
    cout<<"\n";
    system("PAUSE");
    return(0);
}
