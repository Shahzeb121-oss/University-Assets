import java.util.Scanner;
public class distance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the distane in miles : ");
        double mile = scanner.nextDouble();
        
        double Km = mile * 1.60934;

        System.out.print("The distane after coversion into miles into km : " + Km  );

        scanner.close();
    }
}