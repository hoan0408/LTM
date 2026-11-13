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
public class SapXepKhachHang {
    public static void main(String [] args) throws Exception{
        ObjectService service = new ObjectService();
        SoapObjectService p = service.getSoapObjectServicePort();
        String ma = "B23DCCN322";
        String qCode = "9hr3Qe1q";
        
        List<Customer> list = p.requestListCustomer(ma,qCode);
        List<Customer> res = new ArrayList<>();
        for(Customer x : list){
            if(x.purchaseCount >= 6 && x.totalSpent >= 4000){
                res.add(x);
            }
        }
        Collections.sort(res, new Comparator<Customer>(){
            @Override
            public int compare(Customer a,Customer b){
                if(a.totalSpent != b.totalSpent){
                    return (int) (b.totalSpent - a.totalSpent);
                }
                return a.customerId.compareTo(b.customerId);
            }
        });
        p.submitListCustomer(ma,qCode,res);
    }
}
