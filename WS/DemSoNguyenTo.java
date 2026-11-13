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
public class DemSoNguyenTo {
    public static int snt(int n){
        if(n < 2) return 0;
        for(int i = 2;i<= Math.sqrt(n);i++){
            if(n % i == 0){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) throws Exception{
        DataService service = new DataService();
        SoapDataService p = service.getSoapDataServicePort();
        String ma = "B23DCCN322";
        String qCode = "843h93kj";
        
        List<Integer> list = p.getData(ma, qCode);
        int cnt = 0;
        int sum = 0;
        for(int i = 0;i< list.size();i++){
            sum+= (i+1) * list.get(i);
            if(snt(list.get(i)) == 1){
                cnt++;
                
            }
        }
        String s = "primeCount=" + String.valueOf(cnt) + ";" + "checksum=" + String.valueOf(sum);
        p.submitDataString(ma,qCode,s);
    }
}
