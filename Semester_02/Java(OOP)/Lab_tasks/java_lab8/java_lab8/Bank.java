class Bank{
    double getInterestRate(){
        return 0;
    }
}

class SBI extends Bank {
    double getInterestRate(){
        return 7.5;
    }
}

class ICICI extends Bank{
    double getInterestRate(){
        return 8.2;
    }
}

class HDFC extends Bank{
    double getInterestRate(){
        return 6.8;
    }
}

public class Main{
    public static void main(String[] args){
        Bank sbi = new SBI();
        Bank icici = new ICICI();
        Bank hdfc = new HDFC();

        System.out.println("SBI Interest: " + sbi.getInterestRate());
        System.out.println("ICICI Interest: " + icici.getInterestRate());
        System.out.println("HDFC Interest: " + hdfc.getInterestRate());
    }
}
