/**
 * Retail Sports Equipment System
 * Author: Hariz, Syahir, A'liyah, Harith
 * Date: 13.6.2023 (Tuesday)
 */

import java.io.*; 
import java.util.*; 
public class ClassApp
{
    public static void main (String[] args)
    {
        try
        {
            // file input
            String fileAddress = "C:\\Users\\USER\\OneDrive\\Documents\\SEM 2\\CSC186\\project\\Retail Sports Equipment System - finalize\\fileInputPoly.txt";
            FileReader fr = new FileReader(fileAddress);
            BufferedReader br = new BufferedReader(fr);
            
            // file ouput
            FileWriter fw = new FileWriter("C:\\Users\\USER\\OneDrive\\Documents\\SEM 2\\CSC186\\project");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            StringTokenizer st;
            
            String mostSellingItem = "";
            String leastSellingItem = "";
            double totalPrice = 0.0;
            int totalItemsSold = 0;
            int noMostSellingItem = 0;
            int noLeastSellingItem = 0;
            
            int totalBasketball = 0;
            int totalVolleyball = 0;
            int totalFootball = 0;
            int totalBadmintonRacket = 0;
            int totalPingPong = 0;
            
            int i=0, j=0;
            Person p[] = new Person [16];
            Equipment e;
            
            String data = br.readLine();
            //st = new StringTokenizer(data, ";");

            while (data != null)
            {
                st = new StringTokenizer(data, ";");
                
                String name = st.nextToken();
                String email = st.nextToken();
                String phoneNo = st.nextToken();
                char typeOfPerson = st.nextToken().charAt(0);
                
                if (typeOfPerson == 'C')
                {
                    String password = st.nextToken();
                    String address = st.nextToken();
                    String itemName = st.nextToken();
                    int itemQuantity = Integer.parseInt(st.nextToken());
                    
                    e = new Equipment(itemName, itemQuantity);
                    p[i] = new Customer(name, email, phoneNo, typeOfPerson, password, address, e);
                }
                
                else
                {
                    String staffID = st.nextToken();
                    p[i] = new Staff(name, email, phoneNo, typeOfPerson, staffID);
                }
                
                i = i+1;
                data = br.readLine();                
            }
            
            pw.println("Staff: ");
            for (i = 0; i < p.length; i++) 
            {
                if (p[i] instanceof Staff)
                {
                    Staff s = (Staff)p[i]; // casting
                    for (j = 0; j < 1; j++) {
                        pw.println((i+1) + ". " + s.getName());
                    }
                }
                
                else if (p[i] instanceof Customer)
                {
                    Customer c = (Customer)p[i]; // casting
                    totalItemsSold += c.getEquipment().getQuantity();
                    totalPrice += c.getEquipment().getQuantity() * c.getEquipment().calcPrice();
            
                    if (c.getEquipment().getName().equalsIgnoreCase("Basketball"))
                        totalBasketball += c.getEquipment().getQuantity();
                        
                    else if (c.getEquipment().getName().equalsIgnoreCase("Volleyball"))
                        totalVolleyball += c.getEquipment().getQuantity();
                        
                    else if (c.getEquipment().getName().equalsIgnoreCase("Football"))
                        totalFootball += c.getEquipment().getQuantity();
                    
                    else if (c.getEquipment().getName().equalsIgnoreCase("Badminton racket"))
                        totalBadmintonRacket += c.getEquipment().getQuantity();
                        
                    else if (c.getEquipment().getName().equalsIgnoreCase("Ping pong paddle"))
                        totalPingPong += c.getEquipment().getQuantity();
                }
            } // end for
            
            
            // hottest selling item
            noMostSellingItem = 0;
            mostSellingItem = "";
            
            if (totalBasketball > noMostSellingItem){
                    noMostSellingItem = totalBasketball;
                    mostSellingItem = "Basketball";
            }   
            if (totalVolleyball > noMostSellingItem){ // 4>2
                    noMostSellingItem = totalVolleyball;
                    mostSellingItem = "Volleyball";
            }    
            if (totalFootball > noMostSellingItem){ // 3<4
                    noMostSellingItem = totalFootball;
                    mostSellingItem = "Football";
            }   
            if (totalBadmintonRacket > noMostSellingItem){//2 <4
                    noMostSellingItem = totalBadmintonRacket;
                    mostSellingItem = "Badminton racket";
            }   
            if (totalPingPong > noMostSellingItem) {
                    noMostSellingItem = totalPingPong; //6>4
                    mostSellingItem = "Ping pong paddle";
            }
            
            // least selling item
            noLeastSellingItem = 99999;
            leastSellingItem = "";
            
            if (totalBasketball < noLeastSellingItem){
                    noLeastSellingItem = totalBasketball;
                    leastSellingItem = "Basketball";
            }   
            if (totalVolleyball < noLeastSellingItem){
                    noLeastSellingItem = totalVolleyball;
                    leastSellingItem = "Volleyball";
            }    
            if (totalFootball < noLeastSellingItem){
                    noLeastSellingItem = totalFootball;
                    leastSellingItem = "Football";
            }   
            if (totalBadmintonRacket < noLeastSellingItem){
                    noLeastSellingItem = totalBadmintonRacket;
                    leastSellingItem = "Badminton racket";
            }   
            if (totalPingPong < noLeastSellingItem){
                    noLeastSellingItem = totalPingPong;
                    leastSellingItem = "Ping pong paddle";
            }
            
            
            
            
            pw.println("\n----------------------------------------\n");
            pw.println("Total basketballs sold: " + totalBasketball);
            pw.println("Total volleyballs sold: " + totalVolleyball);
            pw.println("Total footballs sold: " + totalFootball);
            pw.println("Total badminton rackets sold: " + totalBadmintonRacket);
            pw.println("Total ping pong paddles sold: " + totalPingPong);
            
            pw.println("\nTotal items sold: " + totalItemsSold);
            pw.println("Total price: RM" + totalPrice);
            pw.println("Hottest selling item: " + mostSellingItem + " (" + noMostSellingItem + ")");
            pw.println("Least selling item: " + leastSellingItem + " (" + noLeastSellingItem + ")");
                   
            br.close();
            pw.close();
        } // end try
    
        catch(FileNotFoundException fnf)
        {   System.out.println("Problem: " + fnf.getMessage());    }
    
        catch(EOFException eof)
        {   System.out.println("Problem: " + eof.getMessage()); }
    
        catch(IOException io)
        {   System.out.println("Problem: " + io.getMessage());  }
    } // end main
} // end class
