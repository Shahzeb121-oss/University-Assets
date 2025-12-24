// Muhammad_Shahzeb_0047
public class Task1 {
    double radius;
    String color;

    public void calculate_Area() {
        double area = 3.14 * radius * radius;
        System.out.println("The area of the " + color + " circle is: " + area);
    }

    public static void main(String[] args) {
        Task1 red = new Task1();
        Task1 green = new Task1();

        red.radius = 5;
        red.color = "red";
        green.radius = 8;
        green.color = "green";

        System.out.println("Radius of red circle: " + red.radius);
        System.out.println("Radius of green circle: " + green.radius);

        red.calculate_Area();
        green.calculate_Area();
    }
}
