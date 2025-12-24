//task3       (Muhammad_Shahzeb_0047)
class task1{
    public static void main(String[] args){
        for(int i=1; i<=15; i++){
            if(i%3==0 && i%5==0)
            {
                System.out.println("FizzBuzz.");
            }
            else if(i%3==0)
            {
                System.out.println("Fizz.");
            }

            else if(i%5==0)
            {
                System.out.println("Buzz.");
            }
            else{
                System.out.print(i);
            }
        }
    }
}