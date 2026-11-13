/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.rmi.*;
/**
 *
 * @author ASUS
 */

public class TicketSla implements java.io.Serializable {
    private static final long serialVersionUID = 20260517L;

    private String ticketId;
    private String priority;      // LOW, MEDIUM, HIGH, CRITICAL
    private int openedHoursAgo;
    private boolean breached;
    private String action;

    public TicketSla() { }
    public TicketSla(String ticketId, String priority, int openedHoursAgo) { 
        this.ticketId = ticketId;
        this.priority = priority;
        this.openedHoursAgo = openedHoursAgo;
    }
    // getter/setter cho tất cả thuộc tính
    public String getTicketId(){
        return ticketId;
    }
    public String getPriority(){
        return priority;
    }
    public int getOpenedHoursAgo(){
        return openedHoursAgo;
    }
    public boolean getBreached(){
        return breached;
    }
    public String getAction(){
        return action;
    }
    
    public void setTicketId(String ticketID){
        this.ticketId = ticketID;
    }
    public void setPriority(String priority){
        this.priority = priority;
    }
    public void setOpenedHoursAgo(int openedHoursAgo){
        this.openedHoursAgo = openedHoursAgo;
    }
    public void setBreached(boolean breached){
        this.breached = breached;
    }
    public void setAction(String action){
        this.action = action;
    }
    
    
}