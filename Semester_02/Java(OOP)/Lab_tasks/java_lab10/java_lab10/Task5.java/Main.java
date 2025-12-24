class Main {
public static void main(String[] args) {
FullTime f = new FullTime("Shahzaib", 50000);
PartTime p = new PartTime("Ibrar", 20, 100);

f.calculateSalary();
p.calculateSalary();

f.payTax();
p.payTax();
}
}
