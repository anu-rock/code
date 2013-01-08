/*
  Name: fibonacci-recursion.cpp
  Copyright: 2008
  Author: Anurag Bhandari
  Date: 12-08-08 06:35
  Description: Displays the Fibonacci series upto the input number of terms using RECURSION
*/

#include<iostream>

using namespace std;

int fibonacci(int);

int main()
{
    int n;
    cout<<"F I B O N A C C I   S E R I E S"<<endl;
    cout<<"-------------------------------"<<endl;
    cout<<"Enter the number of terms: ";
    cin>>n;
    cout<<"\nThe Fibonacci Series upto "<<n<<" terms is:"<<endl;
    for(int i=1;i<=n;i++)
            cout<<fibonacci(i)<<" ";
    cout<<"\n\n";
    system("PAUSE");
    return(0);
}

int fibonacci(int x)
{
    if(x==1)
            return 1;
    else if(x==2)
         return 1;
    else
        return(fibonacci(x-2)+fibonacci(x-1));
}
