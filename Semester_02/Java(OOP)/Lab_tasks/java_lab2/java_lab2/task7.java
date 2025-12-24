 //task7       (Muhammad_Shahzeb_0047)
 class task7 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        int smallest = array[0];
        int largest = array[0];
        for (int i=1; i<array.length; i++) {
            if (array[i]<smallest) smallest = array[i];
            if (array[i]>largest) largest = array[i];
        }
        System.out.println("Smallest element: " + smallest);
        System.out.println("Largest element: " + largest);

        if(largest%2==0)
        {
        System.out.println("The largest element is a multiple of 2.");
        }

        else
        { 
        System.out.println("The largest element is not a multiple of 2.");
        }
    }
}
