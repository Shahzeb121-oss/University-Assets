import java.util.Scanner;
class Task3{
	public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	String[] strings = new String[5];

	for(int i=0; i<=4; i++){
	System.out.print("Enter a String : ");
	strings[i]=input.nextLine();
	}

	for(int i=0; i<=4; i++){
	System.out.println(strings[i].toUpperCase()+" ");
	}
	}
}