class Employee{
String Name;
String Address;
int Sallry;
int join;

Employee(String Name,String Address,int Sallry,int join){
this.Name=Name;
this.Address=Address;
this.Sallry=Sallry;
this.join=join;
}

public void Print (){
System.out.println("Name:"+Name);
System.out.println("Address:"+Address);
System.out.println("Sallry:"+Sallry);
System.out.println("join:"+join);
System.out.println("\n");
}

public static void main(String[]args){
Employee E1=new Employee("Shahzaib"," xyz Colony",55000,2025);
Employee E2=new Employee("usama"," xyz Colony",55000,2025);
Employee E3=new Employee("Awais", "xyz Colony",55000,2025);
System.out.println("Information of Employees");
E1.Print();
E2.Print();
E3.Print();


}


}