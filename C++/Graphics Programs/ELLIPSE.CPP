#include<iostream.h>
#include<graphics.h>
#include<conio.h>
#include<math.h>
void main()
{
float r,y,a,b,i,c,d,e,f,r2,r3,y2,y3,i2,i3,r4;
cout<<"enter the cetre of the circle : "<<endl;
cin>>a;
cin>>b;
cout<<endl<<"enter radius of cirlce"<<endl;
cin>>r;
cout<<"enter the cetre of the ellipse : "<<endl;
cin>>c;
cin>>d;
cout<<endl<<"enter its diameters :"<<endl;
cin>>r2>>r4;
cout<<"enter the cetre of the circle : "<<endl;
cin>>e;
cin>>f;
cout<<endl<<"enter radius of cirlce"<<endl;
cin>>r3;
int gd=DETECT,gm;
initgraph(&gd,&gm,"c:/tc/bgi");
for(i=a-r;i<=a+r;i=i+0.00015)
{
y=sqrt((r*r)-((i-a)*(i-a)))+b ;
putpixel(i,y,14);
putpixel(i,2*b-y,14);
}
 for(i2=c-r2;i2<=c+r2;i2=i2+0.00015)
{
y2=(sqrt((1-((i2-c)*(i2-c)/(r2*r2))))*(r4))+d;
putpixel(i2,y2,14);
putpixel(i2,2*d-y2,12);
}
 for(i3=e-r3;i3<=e+r3;i3=i3+0.00015)
{
y3=sqrt((r3*r3)-((i3-e)*(i3-e)))+f ;
putpixel(i3,y3,10);
putpixel(i3,2*f-y3,10);
}

getch();
closegraph();
}












































