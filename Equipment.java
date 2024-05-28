
/**
 * Class definition of Equipment
 */

public class Equipment
{
    private String itemName;
    private int itemQuantity;
    
    // normal constructor
    public Equipment(String in, int iq)
    {   
        itemName = in;
        itemQuantity = iq;
    }
    // getter methods
    public String getName() {
        return itemName;}
    public int getQuantity() {
        return itemQuantity;}
    // processor    
    public double calcPrice() 
    {
        double itemPrice; // local variable
        if (itemName.equalsIgnoreCase("Basketball"))
            itemPrice = 63.0;
        else if (itemName.equalsIgnoreCase("Volleyball"))
            itemPrice = 36.0;
        else if (itemName.equalsIgnoreCase("Football"))
            itemPrice = 86.0;
        else if (itemName.equalsIgnoreCase("Badminton racket"))
            itemPrice = 129.0;
        else
            itemPrice = 19.0;
        return itemPrice;
    }
   
}
