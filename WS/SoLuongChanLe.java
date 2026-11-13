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
public class SoLuongChanLe {
    public static void main(String [] args) throws Exception{
            DataService service = new DataService();
            SoapDataService p = service.getSoapDataServicePort();
            String ma = "B23DCCN322";
            String qCode = "QdAvAnyk";
            
            List<Integer> list = p.getData(ma,qCode);
            int sochan = 0;
            int sole = 0;
            for(Integer x : list){
                if(x % 2 == 0){
                    sochan += 1;
                }
                else {
                    sole += 1;
                }
            }
            List<String>  ans = new ArrayList<>();
            ans.add("EVEN=" + sochan);
            ans.add("ODD=" + sole);
            p.submitDataStringArray(ma,qCode,ans);
    }
}
