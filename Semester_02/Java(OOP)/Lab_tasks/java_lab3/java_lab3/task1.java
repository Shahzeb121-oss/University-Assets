//task1       (Muhammad_Shahzeb_0047)
import java.util.Scanner;
class task1{
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
    int start,end,j;
    System.out.print("Enter starting number : ");
    start=input.nextInt();
    System.out.print("Enter ending number : ");
    end=input.nextInt();

    for(int i=start; i<=end; i++)
    {
    	for(j=2; j<=i; j++){
      if(i%j==0){
      	break;
      }

    	}
    	if(i==j){
    		System.out.print(j+" ");
    	}
    	else{
    		
    	}
    }
}
}