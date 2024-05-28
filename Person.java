
/**
 * Superclass of subclasses Customer and Staff
 */
public class Person
{
    protected String name;
    protected String email;
    protected String phoneNo;
    protected char typeOfPerson;
    
    // normal constructor
    public Person(String name, String email, String phoneNo, char typeOfPerson)
    {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.typeOfPerson = typeOfPerson;
    }
    
    // accessor methods
    public String getName()
    {
        return name;
    }
    
}
