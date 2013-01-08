#include<iostream.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>
void linebresenham(int,int,int,int);
 void main()
 {
 clrscr();
 int x,y,xc,yc,b,l,t1,t2 ;
 cout << " enter the cord " << endl;
 cin>>x>>y>>xc>>yc ;
 cout<<"Enter translation";
 cin>>t1>>t2;
 int gd = DETECT , gm ;
 initgraph(&gd,&gm, "c:/tc/bgi" );
 linebresenham(x,y,xc,yc);
 getch();
 closegraph();
 }
 void linebresenham(int xa,int ya,int xb,int yb)
 {
 int dx = abs(xa-xb), dy = abs(ya-yb);
 int p= 2*dy - dx;
 int a= 2*dy , b = 2*(dy-dx);
 int x,y, xend ;

 if(xa>xb)
 x= xb , y = yb ,xend = xa;
 else
 x=xa ,y= ya, xend = xb;
 putpixel(x,y,10);
  putpixel(x+t1,y+t2,10);
 while(x<=xend)
 {
 x++ ;
 if(p<0)
 p= p+a;
 else
 {
 y++;
 p =p+b;
 }

 putpixel(x,y,10);
 putpixel(x+t1,y+t2,10);
 }
 }
