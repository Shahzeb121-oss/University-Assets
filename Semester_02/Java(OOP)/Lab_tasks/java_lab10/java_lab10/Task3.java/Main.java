class Main{
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.width = 5;
        r.height = 7;

        double area = r.area();
        System.out.println("The area of the rectangle is: " + area);
    }
}
