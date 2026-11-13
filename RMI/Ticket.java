/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.rmi.registry.*;

/**
 *
 * @author ASUS
 */
public class Ticket {
  
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("36.50.135.242",1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        
        TicketSla ticket = (TicketSla) sv.requestObject("B23DCCN322", "7dfeOlJy");
   
        String priority = ticket.getPriority();
        int hours = ticket.getOpenedHoursAgo();
        boolean isBreached = false;
        if(priority.equalsIgnoreCase("CRITICAL") && hours > 2){
            isBreached = true;
        }
        else if(priority.equalsIgnoreCase("HIGH")&& hours > 8){
            isBreached = true;
        }
        else if(priority.equalsIgnoreCase("MEDIUM")&& hours > 24){
            isBreached = true;
        }
        else if(priority.equalsIgnoreCase("LOW")&& hours > 72){
            isBreached = true;
        }
        ticket.setBreached(isBreached);
        String action ="";
        if(!isBreached){
            action = "MONITOR";
        }
        else if(priority.equalsIgnoreCase("CRITICAL") || hours > 96){
            action = "ESCALATE_L2";
        }
        else {
            action = "ESCALATE_L1";
        }
        ticket.setAction(action);
        sv.submitObject("B23DCCN322", "7dfeOlJy", ticket);
    }
}
