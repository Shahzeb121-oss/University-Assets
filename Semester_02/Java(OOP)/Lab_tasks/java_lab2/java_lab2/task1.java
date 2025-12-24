//task1       (Muhammad_Shahzeb_0047)
import java.util.Scanner;

class task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char constant[] = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};

        System.out.print("Enter a character: ");
        char inputChar = input.next().charAt(0);

        boolean is_constant = false;

        for(int i=0; i<constant.length; i++) {
            if(inputChar == constant[i]) {
                is_constant = true;
                break;
            }
        }

        if(is_constant) 
        {
          System.out.print("It is a constant.");
        } 
        else
        {
          System.out.print("It is not a constant.");
        }
    }
}
