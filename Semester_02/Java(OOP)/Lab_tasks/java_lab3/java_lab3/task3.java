//task3       (Muhammad_Shahzeb_0047)
class task3{
    public static void main(String[] args){
        int[][] matrix={
            {12,13,15,16},
            {11,110,121,17},
            {17,18,100,21}
        };

        System.out.println("Original Matrix:");
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); 
        }

        for(int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j]%2== 0){
                    matrix[i][j]=matrix[i][j]/2 ;
                }
            }
        }

        System.out.println("\nMatrix after dividing even numbers by 2 : ");
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nOdd numbers in the matrix : ");
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j]%2 != 0) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
        System.out.println();

        int sum=0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j]%2== 0) {
                    sum+=matrix[i][j];
                }
            }
        }

        System.out.println("\nSum of even numbers: " + sum);
    }
}