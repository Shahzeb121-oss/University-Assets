class Student {
    private String name;
    private int rollNumber;
    private char grade;

    public void setName(String name){
        this.name=name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber=rollNumber;
    }

    public void setGrade(char grade){
        this.grade=grade;
    }

    public String getName(){
        return name;
    }

    public int getRollNumber(){
        return rollNumber;
    }

    public char getGrade(){
        return grade;
    }

    public void displayDetails(){
        System.out.println("Name: "+name);
        System.out.println("Roll Number: "+rollNumber);
        System.out.println("Grade: "+grade);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Shahzaib");
        student.setRollNumber(47);
        student.setGrade('A');
        student.displayDetails();
    }
}
