class Bike extends Vehicle {
    String helmetType;

    Bike(String brand, int speed, String helmetType) {
        super(brand, speed);
        this.helmetType = helmetType;
    }

    void showDetails() {
        super.showDetails();
        System.out.println("Helmet Type: " + helmetType);
    }
}
