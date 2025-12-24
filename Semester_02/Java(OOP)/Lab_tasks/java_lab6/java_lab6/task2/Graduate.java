class Graduate extends Student {
    String researchTopic;

    Graduate(String name, int age, String studentID, String researchTopic) {
        super(name, age, studentID);
        this.researchTopic = researchTopic;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Research Topic: " + researchTopic);
    }
}