//task2       (Muhammad_Shahzeb_0047)
import java.util.Scanner;
class task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to check weather it is palindrome or not. : ");
        String text = input.nextLine(); 
        String reverse = "";

        for(int i=text.length()-1; i>=0; i--){
            reverse=reverse+text.charAt(i);
        }

        if(text.equals(reverse)){
            System.out.println("Palindrome.");
        }
         else
        {
            System.out.println("Not palindrome.");
        }
    }
}