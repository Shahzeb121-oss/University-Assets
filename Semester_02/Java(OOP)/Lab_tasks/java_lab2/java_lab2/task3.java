//task3       (Muhammad_Shahzeb_0047)
import java.util.Scanner;
class task3{
	public static void main(String[] args){
		Scanner scan = new Scanner (System.in);
		System.out.print("Enter the number of rows : ");
		int row=scan.nextInt();

	System.out.print("Enter the number of columns : ");
		int col=scan.nextInt();

		int sum=0;
		int array1[][]=new int[row][col];
		int array2[][]=new int[row][col];

		for (int i=0;i<row; i++){
			for(int j=0; j<col; j++){
				System.out.print("Enter value of array 1 :");
                array1[i][j]=scan.nextInt();
			}
		}
		for(int i=0;i<row;i++){
        for(int j=0;j<col;j++)
{
System.out.print("Enter value of array 2 :");
 array2[i][j]=scan.nextInt();

}
}
for(int i=0;i<row;i++)
{System.out.print ("\n ");
for(int j=0;j<col;j++) {
System.out.print (array1[i][j]+array2[i][j]+"  ");
}
}
}
}