//task4       (Muhammad_Shahzeb_0047)
import java.util.Scanner;
class task4{

public static void main(String[] args){

Scanner scan = new Scanner(System.in);
String name[]=new String[6];
String choice="Ali";
for(int i=0;i<6;i++){

System.out.print("Please enter the name :");
name[i]=scan.nextLine();
if(choice.equals(name[i]))
{
System.out.print("Yes Ali is in the array.");
break;
}


}







}
}