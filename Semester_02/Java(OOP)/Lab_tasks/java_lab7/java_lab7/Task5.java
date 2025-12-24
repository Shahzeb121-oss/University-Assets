import java.util.Scanner;
class Task4{
	public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.print("Enter a String : ");
    String in=input.nextLine();
    if(in.endsWith("World")){
    System.out.print("Ends with World");
    }
    else{
    System.out.print("Does not ends with World");
    }
    }
	}
