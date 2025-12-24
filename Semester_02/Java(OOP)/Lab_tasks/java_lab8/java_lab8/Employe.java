class Employe{
         int calculateBonus(int salary){
            return salary/10;
        }
        
         int calculateBonus(int salary, int extraHours){
            return (salary/10) + (extraHours*500);
        }
    
    public static void main(String[] args){
        Employe emp = new Employe();
        System.out.println(emp.calculateBonus(50000));
        System.out.println(emp.calculateBonus(50000, 3));
    }

}