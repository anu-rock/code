#include<iostream.h>
#include<conio.h>
#include<math.h>
#include<graphics.h>

void matrixmultiplication (int a[3][3], int b[3][3],int c[3][3])
{
int i,j,k,val;
i=j=k=1;
for(i=0;i<3;i++)
{
for(j=0;j<3;j++)
{
val=0;
for(k=0;k<3;k++)
{
val += a[i][k]*b[k][j];
}
c[i][j]=val;
}
}
}

void matrixmultiplication(int a[3][3],int b[3][1],int c[3][1])
{
c[1][1] = (a[1][1] * b[1][1])+(a[1][2] * b[2][1])+(a[1][3] * b[3][1]);
c[2][1] = (a[2][1] * b[1][1])+(a[2][2] * b[2][1])+(a[2][3] * b[3][1]);
c[3][1] = (a[3][1] * b[1][1])+(a[3][2] * b[2][1])+(a[3][3] * b[3][1]);
}

void rotationmatrix(float x, int a[3][3])
{
a[1][1]=cos(x);
a[1][2]=sin(x);
a[1][3]=0;
a[2][1]=-sin(x);
a[2][2]=cos(x);
a[2][3]=a[3][1]=a[3][2]=0;
a[3][3]=1;
}

void scalingmatrix(int a,int b, int c[3][3])
{
c[1][1]=a;
c[2][2]=b;
c[3][3]=1;
c[1][2]=c[1][3]=c[2][1]=c[2][3]=c[3][1]=c[3][2]=0;
}

void linedda(int xa,int ya,int xb,int yb)
{
	int dx = xb-xa, dy = yb-ya, steps, k;
	int xinc, yinc, x = xa, y = ya;
	if(abs(dx)>abs(dy))
	  steps = abs(dx);
	else
	  steps = abs(dy);
	xinc = dx/(int) steps;
	yinc = dy/(int) steps;
	putpixel(x,y,15);
	for(k=0;k<steps;k++)
	{
		x = x + xinc;
		y = y + yinc;
		putpixel(x,y,5);
	}
}

void main()
{
clrscr();
/*int a[3][3],b[3][3],c[3][3];
int i,j;
for(i=0;i<3;i++)
for(j=0;j<3;j++)
a[i][j]=i;

for(i=0;i<3;i++)
for(j=0;j<3;j++)
b[i][j]=i;
matrixmultiplication(a,b,c);
for(i=0;i<3;i++)
{
for(j=0;j<3;j++)
cout<<c[i][j]<<"\t";
cout<<"\n";
}
*/
int ac[3][1],bc[3][1];
cout<<"enter the first x coordinate: ";
cin>>ac[1][1];
cout<<"enter the first y coordinate: ";
cin>>ac[2][1];
ac[3][1]=1;

cout<<"\n\nenter the second x coordinate: ";
cin>>bc[1][1];
cout<<"enter the second y coordinate: ";
cin>>bc[2][1];
bc[3][1]=1;


float o;
int r[3][3];
int fc[3][1];
cout<<"enter the rotation angle: ";
cin>>o;
rotationmatrix(o,r);
matrixmultiplication(r,bc,fc);
int gd=DETECT,gm;
initgraph(&gd,&gm,"c:/tc/bgi");
linedda(ac[1][1],ac[2][1],bc[1][1],bc[2][1]);
linedda(ac[1][1],ac[2][1],fc[1][1],fc[2][1]);
getch();
}