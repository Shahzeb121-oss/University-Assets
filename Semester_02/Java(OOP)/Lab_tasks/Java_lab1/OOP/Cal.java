//task9                                                 Muhammad_Shahzeb(0047)
import java.util.Scanner;
public class Cal {

    public static void main(String[] args) {
        Scanner operation = new Scanner(System.in);
                                                                                    
        System.out.print("Enter num1 : " ); 
        int num1 = operation.nextInt();

        System.out.print("Enter Num 2 : " );
        int num2 = operation.nextInt();
        
        System.out.println("1. Add , 2. Subtract , 3. Multiply , 4. Divide");

        System.out.print("Choose  (1-4): ");
        int choice = operation.nextInt();

        int result = 0;

        switch (choice) {
            case 1:
                result = num1+num2;
                break;
            case 2:
                result = num1-num2;
                break;
            case 3:
                result = num1*num2;
                break;
            case 4:
               result= num1/num2;    
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("Result : " + result);
        
    }
}