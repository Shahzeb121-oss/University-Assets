//task1       (Muhammad_Shahzeb_0047)
class Book{
    String Title;
    String Author;
    Boolean Is_available;

public void insert(String Title,String Author,Boolean Is_available){
    this.Title=Title;
    this.Author=Author;
    this.Is_available=Is_available;

}
public void borrow(){
    if(Is_available==false){
        System.out.println("The book is already borrowed");
    }
    else{
        System.out.println("The book is borrowed"); 
        Is_available=false;
    }
}

public void Return(){
    if(!Is_available){
        System.out.println("The book is returned");
        Is_available=true;
    }
    else{
        System.out.println("The book is already available");
    }
}

public void display() {
    System.out.println("Title: " + Title);
    System.out.println("Author: " + Author);
    if(Is_available)
    {
        System.out.println("Status: Available");
    } 
    else
    {
        System.out.println("Status: Borrowed");
    }
}

public static void main(String[]args){
Book b1=new Book();
b1.insert("English","Shahzaib",true);
b1.borrow();
b1.borrow();
b1.Return();
b1.Return();
b1.display();

}
}