//task2       (Muhammad_Shahzeb_0047)
class Employe{
	String Name;
	int Id;
	int Salary;

	public void insert(String Name,int Id,int Salary){
        this.Name=Name;
        this.Id=Id;
		this.Salary=Salary;

	}
	public void increase(int sal){
		Salary+=sal;
	}
	public void annual(){
		Salary=Salary*12;
		System.out.print("Salary : "+Salary);
	}
	public void display(){
		System.out.println("Name : "+Name);
		System.out.println("Employe id : "+Id);
	}

	public static void main(String[] args ){
		Employe e1=new Employe();
		e1.insert("Shahzaib",47,3000);
		e1.increase(2000);
		e1.display();
		e1.annual();
	} 







}