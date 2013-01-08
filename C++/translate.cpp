#include<iostream>

using namespace std;

int main()
{
	char input[500];
	cout<<"Enter text: ";
	gets(input);
	for(int i=0; input[i]!='\0'; i++)
	{
		if(input[i] == ' ' || input[i] == '.' || input[i] == ',' || input[i] == '(' || input[i] == ')' || input[i] == '\'')
			input[i] = input[i];
		else
			input[i] = ((int(input[i])+2)-97)%26 + 97;
	}
	cout<<"\nThe translated text is:"<<endl<<endl;
	for(int j=0; input[j]!='\0'; j++)
	{
		cout<<input[j];
	}
	cout<<"\n\n";
	return(0);
}
