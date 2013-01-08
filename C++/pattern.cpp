//pattern.cpp
//Author: Anurag Bhandari
//Used to display the type of pattern asked in TCS interview
//To run it, I recommend using gcc (on Linux) or Dev-C++ on Windows
#include<iostream>
 
/*Each and every entity (classes, objects, functions) in C++ 
libs (like iostream) are defined within the "std" namespace*/
using namespace std;
 
int main()
{
    int r,c; //we declare the row and column variables
    int count = 1; //the "count" variable goes on incrementing each time an element is printed
    for(r=1;r<=10;r++) //loop for rows
    {
                      for(c=1;c<=r;c++) //loop for columns
                      {
                                       cout<<count<<" "; //we print the elements
                                       count = count + 1; //we increment the counter
                      }
                      cout<<"\n"; //this is a new line after a row
    }
   /* use system("PAUSE") here which is the equivalent of getch(), except that it's a bit advanced*/
    return(0); //main() HAS to return something to be compatible with modern compilers (gcc)
} 
