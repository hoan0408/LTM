/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.net.*;
import java.util.*;
import java.rmi.registry.*;
/**
 *
 * @author ASUS
 */
public class DinhCucBo {
    public static void main(String[] args) throws Exception {
        Registry rg = LocateRegistry.getRegistry("36.50.135.242",1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String ma = "B23DCCN322";
        String qCode = "YldPTXg4";
        
        Object obj = sv.requestData(ma, qCode);
        int[] a = (int[]) obj;
        int n = a.length;
        List<Integer> peaks = new ArrayList<>();
        if(n == 1){
            peaks.add(1);
        }
        else{
             if(a[0] > a[1]){
                 peaks.add(1);
             }
             for(int i = 1;i<n-1;i++){
                 if(a[i] > a[i-1] && a[i] > a[i+1]){
                     peaks.add(i+1);
                 }
             }
             if(a[n-1] > a[n-2]){
                 peaks.add(n);
             }
        }
        sv.submitData(ma, qCode, peaks);
    }
}
