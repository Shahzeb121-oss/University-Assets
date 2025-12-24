//task6       (Muhammad_Shahzeb_0047)
import java.util.Scanner;

 class task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
    
        String eligible = (age >= 18) ? "You are eligible to vote." : "You are not eligible to vote.";
        
        System.out.println(eligible);
        
        scanner.close();
    }
}
