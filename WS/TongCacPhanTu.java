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
public class TongCacPhanTu {
    public static void main(String[] args) throws Exception{
        DataService service = new DataService();
        SoapDataService p = service.getSoapDataServicePort();
        String ma = "B23DCCN322";
        String qCode = "ptoOV1sA";
        List<Integer> list = (List<Integer>) p.getData(ma,qCode);
        int tong = 0;
        for(Integer x : list){
            tong += x;
        }
        p.submitDataInt(ma, qCode, tong);
    }
}
