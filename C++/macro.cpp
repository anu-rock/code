#include<iostream>
#include<fstream>
#include<string>

using namespace std;

int main()
{
	char line[1000];
	int flag=1;
	char macro[15] = {'M','A','C','R','O','\0'};
	ifstream read_line("ifile.txt");
	if(read_line.is_open())
	{
		while(!read_line.eof())
		{
			getline(read_line,line);
			for(i=0;line[i]!='\0';i++)
			{
				if(line[i]!=macro[i])
				{	flag=0;
					break;
				}
			}		
			if(flag==1)
			{
				
			
			
		}
	}
		

}

