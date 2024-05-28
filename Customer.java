
/**
 * Subclass of class Person
 */
public class Customer extends Person
{
    private String password;
    private String address;
    private Equipment e;        // composite object 
    
    // normal constructor
    public Customer(String name, String email, String phoneNo, char typeOfPerson, String password, String address, Equipment e)
   {   
       super(name, email, phoneNo, typeOfPerson);
       this.password = password;
       this.address = address;
       this.e = e;
   }
   
   public Equipment getEquipment() // get composite object
       {return e;}
}
