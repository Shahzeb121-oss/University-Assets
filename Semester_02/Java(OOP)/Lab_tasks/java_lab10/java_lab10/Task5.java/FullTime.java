class FullTime implements Tax{
String name;
double salary;

public FullTime(String name, double salary){
this.name = name;
this.salary = salary;
}

public void calculateSalary(){
System.out.println(name + " Salary: " + salary);
}

public void payTax(){
System.out.println(name + " paying tax on salary: " + salary);
}
}