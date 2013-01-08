#include<iostream.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>
void main()
{
clrscr();
int x1,x2;
int i;
int gd=DETECT,gm;
initgraph(&gd,&gm,"c:/tc/bgi");
cout<<"The orignial circle is with radius 100 and centre at 200,200\n";
cout<<"The type of transformation you want :";
cout<<"\nPlease choose your option: ";
cout<<"\n(1) Translation ";
cout<<"\n(2) Scaling ";
int choice;
cin>>choice;
int a[3][3],b[3][1],c[3][1];
a[1][1]=a[2][2]=a[3][3]=1;
a[2][1]=a[2][3]=a[1][3]=a[3][2]=a[3][1]=a[1][2]=0;
switch(choice)
{
case 1:
  {
  cout<<"\nEnter the t1 and t2 value";
  int t1,t2;
  cin>>t1>>t2;
  a[1][3]=t1;
  a[2][3]=t2;
  circle(200,200,100);
  float x,y;
  cleardevice();
  for(float i = 100;i<=300;i=i+0.5)
  {
  y = sqrt(100*100 -pow((i-200),2)) + 200;
  float y2,y3;
  y2 = 200-y;
  y3 = 200 +y2;
  putpixel(i,y,15);
  putpixel(i,y3,15);
  x=i+a[1][3];
  y=y+a[2][3];
  y3 = y3+a[2][3];
  putpixel(x,y,12);
  putpixel(x,y3,12);
  }
  }
  break;
case 2:
  {
  error: cout<<"\nEnter the value for sx and sy";
  float sx,sy;
  cin>>sx>>sy;
  if(sx!=sy)
  goto error;
  sx = sx/10;
  sy = sy/10;
  a[1][1]=sx;
  a[2][2]=sy;
  cleardevice();
  for(float i = 100;i<=300;i=i+0.5)
  {
  float x,y;
  y = sqrt(100*100 -pow((i-200),2)) + 200;
  float y2,y3;
  y2 = 200-y;
  y3 = 200 +y2;
  putpixel(i,y,15);
  putpixel(i,y3,15);
  x=i*a[1][1];
  y=y*a[2][2];
  putpixel(x,y,12);

  }

  }
  break;
}
getch();
closegraph();
}