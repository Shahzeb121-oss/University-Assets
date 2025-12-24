class PartTime implements Tax{
String name;
double rate;
int hours;

public PartTime(String name, double rate, int hours){
this.name = name;
this.rate = rate;
this.hours = hours;
 }

public void calculateSalary() {
double salary = rate*hours;
System.out.println(name + " Salary: " + salary);
}

public void payTax(){
double salary = rate*hours;
//double tax= salary*0/10;
System.out.println(name + " paying tax on salary: " +salary);
}
}
