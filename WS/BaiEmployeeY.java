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
public class BaiEmployeeY {
    public static void main(String[] args)throws Exception {
        ObjectService service = new ObjectService(); 
        SoapObjectService p = service.getSoapObjectServicePort();
        String ma = "B23DCCN322";
        String qCode = "dmclBMam";
        List<EmployeeY> list = p.requestListEmployeeY(ma, qCode);
        Collections.sort(list,new Comparator<EmployeeY>(){
            @Override
            public int compare (EmployeeY e1,EmployeeY e2){
                return e1.getStartDate().compare(e2.getStartDate());
            }
        });
        p.submitListEmployeeY(ma, qCode, list);  
    }
}
