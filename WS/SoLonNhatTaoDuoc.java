/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;
import java.util.*;
import java.net.*;

/**
 *
 * @author ASUS
 */
public class SoLonNhatTaoDuoc {
    public static void main(String [] args) throws Exception{
    DataService service = new DataService();
    SoapDataService p = service.getSoapDataServicePort();
    
    String ma = "B23DCCN322";
    String qCode = "iyS5rqt5";
    List<Integer> list = (List<Integer>) p.getData(ma, qCode);
    List<String> strList = new ArrayList<>();
    for(Integer x : list){
        strList.add(x.toString());
    }
    Collections.sort(strList,new Comparator<String>(){
        @Override
        public int compare(String s1,String s2){
            String opt1 = s1 + s2;
            String opt2 = s2 + s1;
            return opt2.compareTo(opt1);
        }
    });
    StringBuilder sb = new StringBuilder();
    for(String s : strList) {
        sb.append(s);
    }
    String res = sb.toString();
    p.submitDataString(ma,qCode,res);
   }   
}
