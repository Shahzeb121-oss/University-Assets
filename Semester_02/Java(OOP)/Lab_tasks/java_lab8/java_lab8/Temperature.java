class Temperature {
    private double celsius;

    public void setCelsius(double c) {
        celsius = c;
    }

    public double getFahrenheit() {
        return (celsius * 9 / 5) + 32;
    }
}

public class Main {
    public static void main(String[] args) {
        Temperature temp = new Temperature();
        temp.setCelsius(25);
        System.out.println("Fahrenheit: " + temp.getFahrenheit());
    }
}
