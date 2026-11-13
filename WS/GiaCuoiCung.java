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
public class GiaCuoiCung {
    public static void main(String[] args) throws Exception{
        ObjectService service = new ObjectService();
        SoapObjectService p = service.getSoapObjectServicePort();
        String ma = "B23DCCN322";
        String qCode = "ODK9vBA2";
        ProductY product = p.requestProductY(ma,qCode);
        product.finalPrice = product.price * (1 + product.taxRate / 100) * ( 1 - product.discount/100);
        p.submitProductY(ma,qCode,product);
    }
}
