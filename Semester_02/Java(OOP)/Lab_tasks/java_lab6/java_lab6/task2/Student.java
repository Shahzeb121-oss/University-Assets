class Student extends Person {
    String studentID;

    Student(String name, int age, String studentID) {
        super(name, age);
        this.studentID = studentID;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("StudentID: " + studentID);
    }
}