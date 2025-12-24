class Task2{
String Color;
int radious;

Circle(String Color,int radius){
this.Color=Color;
this.radius=radius;
}


double Calculate(){
return radius*radius*3.14;
}

int getradius(){
return radius;
}


String getcolor(){
return Color;
}

public static void main(String[]args){
Circle c1=new Circle("Red",5);
Circle c2=new Circlee("Blue",8);
System.out.println("area:"+c1.Calculate());
System.out.println("radius:"+c1.getradius());
System.out.println("area:"+c1.getcolor());
System.out.println("area:"+c2.Calculate());
System.out.println("radius:"+c2.getradius());
System.out.println("area:"+c2.getcolor());



}





}