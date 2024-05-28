
/**
 * Subclass of class Person
 */
public class Staff extends Person
{
    private String staffID;
    
    // normal constructor
    public Staff(String name, String email, String phoneNo, char typeOfPerson, String staffID)
    {
        super (name, phoneNo, email, typeOfPerson);
        this.staffID = staffID;
    }
}
