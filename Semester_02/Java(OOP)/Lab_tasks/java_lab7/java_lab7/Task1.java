import java.util.Scanner;
class Task1{
	public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a String : ");
    String in=input.nextLine();

    if(in.isEmpty()){
    System.out.print("String is empty");
    }
    else{
    System.out.print("String is not empty");
    }
	}
}