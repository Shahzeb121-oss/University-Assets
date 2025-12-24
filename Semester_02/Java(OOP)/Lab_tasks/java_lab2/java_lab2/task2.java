//task2       (Muhammad_Shahzeb_0047)
import java.util.Scanner;
	class task2{
		public static void main(String[] args){
			Scanner abc = new Scanner (System.in);
        int integer[] = new int[10];
        int sum=0;
        for(int i=0; i<=9; i++){
        	System.out.print("Enter number : ");
        	 integer [i]=abc.nextInt();
        	if(integer[i]%4==0){
        		sum=sum+integer[i];
        	}
        }
		  System.out.print("The sum is : "+ sum);
			
		}
	}

