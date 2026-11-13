/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;
import java.util.*;
/**
 *
 * @author ASUS
 */
public class KhachHang {
    public static void main(String [] args) throws Exception{
        ObjectService service = new ObjectService();
        SoapObjectService p = service.getSoapObjectServicePort();
        String ma = "B23DCCN322";
        String qCode = "JBJ83e8m";
        List<Customer> customer = p.requestListCustomer(ma, qCode);
        List<Customer> res = new ArrayList<>();
        for(Customer a : customer){
            if(a.getTotalSpent() > 500 && a.getPurchaseCount() > 2){
                res.add(a);
            }
        }
        p.submitListCustomer(ma,qCode,res);
    }
}
