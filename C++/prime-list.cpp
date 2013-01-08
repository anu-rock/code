/*
  Name: prime-list.cpp
  Copyright: 2008
  Author: Anurag Bhandari
  Date: 11-08-08 22:58
  Description: Generate the list of prime numbers from 1-100
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
    cout<<"P R I M E  N U M B E R  L I S T"<<endl; //decorative header
    repchar();
    cout<<"The prime numbers from 1-100 are: 1, 2 , 3";
    for(a=4;a<=100;a++) //we start from 4 because 1,2,3 are the first primary prime nos.
    {
                        for(int x=2;x<a;x++) //check from numbers 2 to one less than the number itself
                        {
                                    if(a%x == 0) //if the number in loop divides entered number complely,
                                           flag=0; //we set the flag value to 0
                        }
    if(flag==1)
               cout<<", "<<a;
    /*set flag to 1 again or else it will remain 0 if any 0 is encountered causing prime numbers to not be printed*/
    flag=1;
    }
    cout<<"\n";
    system("PAUSE");
    return(0);
}
