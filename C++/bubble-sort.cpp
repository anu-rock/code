/*
  Name: bubble-sort.cpp
  Copyright: 2008
  Author: Anurag Bhandari
  Date: 12-08-08 01:42
  Description: Implementation of the Bubble Sort Algorithm
*/
#include<iostream>

using namespace std;

int main()
{
	int arr[10] = {4,56,67,34,87,23,45,1,6,7}; //an array of numbers in any order
	int temp, swapped=2; //set the value of swapped to any number except 0 & 1
	while(swapped!=0) //external loop: for  passes
	{
		swapped = 2;
		for(int y=0;y<(10-1);y++) //internal loop: for iterations within a pass
		{
			if(arr[y]>arr[y+1])
			{
				temp = arr[y];
				arr[y] = arr[y+1];
				arr[y+1] = temp;
				swapped = 1; //it means that a swap operation was performed
			}
		}
		if(swapped == 2)
			swapped = 0;
			/*this means that for one whole pass, no swapping operation took place. Hence, "swapped" was not set to 1 and remained 2 (the initial value set in the starting of every pass). It means that swapped=0 indicates that the array has been sorted*/
	}
	cout<<"The sorted array is:"<<endl;
	for(int i=0;i<10;i++)
		cout<<arr[i]<<" ";
	cout<<"\n";
	return(0);
}