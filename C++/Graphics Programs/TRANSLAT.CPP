#include<iostream.h>
#include<iostream.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>
void main()
{
int gd=DETECT,gm,x1,x2,y1,y2;
cout<<"enter coordinates";
cin>>x1>>x2>>y1>>y2;
int tx,ty;
cout<<"enter translation";
cin>>tx>>ty;
clrscr();
initgraph(&gd,&gm,"c:/tc/bgi");
line(x1,y1,x2,y2);
outtextxy((x1+x2)/2,(y1+y2)/2,"original");
line(x1+tx,y1+ty,x2+tx,y2+ty);
outtextxy((x1+x2)/2+tx,(y1+y2)/2+ty,"newer");
getch();
closegraph();
}

