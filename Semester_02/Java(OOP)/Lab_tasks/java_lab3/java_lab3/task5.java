//task5       (Muhammad_Shahzeb_0047)
import java.util.Scanner;
class task5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = input.nextInt(); 

        boolean[][] seats = new boolean[rows][cols];

        int choice;
        do{
            System.out.println("\n1. Display Seats");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice=input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nSeats:");
                    for(int i=0; i<rows; i++) {
                        for(int j=0; j<cols; j++) {
                            if(seats[i][j])
                         {
                                System.out.print("Reserved"+ " ");
                            } 
                            else
                            {
                                System.out.print("Free"+" ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Enter row : ");
                    int row = input.nextInt() - 1;
                    System.out.print("Enter column : ");
                    int col = input.nextInt() - 1;

                    if(row >= 0 && row < rows && col >= 0 && col < cols) {
                        if(!seats[row][col]) 
                        {
                            seats[row][col]=true;
                            System.out.println("Reserved!");
                        } 
                        else
                        {
                            System.out.println("Already reserved.");
                        }
                    }
                     else 
                    {
                        System.out.println("Invalid input.");
                    }
                    break;
                case 3:
                    System.out.println("Program has been exited.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
    }
         while (choice != 3);

        
    }
}