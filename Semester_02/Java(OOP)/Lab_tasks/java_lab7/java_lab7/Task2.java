import java.util.Scanner;
class Task2{
public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.print("Enter a String :");
	String in=input.nextLine();
	int index=in.indexOf("a");
	if(index!=-1){
		System.out.print("The first index of 'a' is : "+index);
	}
	else{
		System.out.print("'a' not found in String ");
	}
}
}