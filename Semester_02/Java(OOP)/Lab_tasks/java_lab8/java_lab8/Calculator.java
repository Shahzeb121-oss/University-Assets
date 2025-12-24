class Calculator{

    int add (int a, int b){
    return a+b;
    }

    Double add (Double a , Double b){
    	return a+b;
    }

    String add (String a , String b){
    	return a+b;
    }



    public static void main(String[] args) {
	Calculator cal=new Calculator();
	System.out.println(cal.add(5,3));
	System.out.println(cal.add(2.5,3.7));
	System.out.println(cal.add("Hello ","World"));
}
}