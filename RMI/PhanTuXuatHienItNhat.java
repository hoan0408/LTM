/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.util.*;
import java.net.*;
import java.rmi.registry.*;
import RMI.ByteService;
/**
 *
 * @author ASUS
 */
public class PhanTuXuatHienItNhat {
    public static void main(String[] args)throws Exception {
    Registry rg = LocateRegistry.getRegistry("36.50.135.242",1099);
    ByteService sv = (ByteService) rg.lookup("RMIByteService");
    String ma = "B23DCCN322";
    String qCode = "0vNC8VJj";
    
    byte[] a = sv.requestData(ma, qCode);
    int [] cnt = new int[1024];
    for(byte x : a) cnt[x]++;
    byte ptuMin =  a[0];
    int slMin = cnt[a[0]];
    for(byte x : a)
    {
        if(cnt[x] < slMin)
            {
            slMin = cnt[x];
            ptuMin = x;
            }
    }
    byte[] res = {ptuMin, (byte)slMin};
    sv.submitData(ma,qCode,res);
    } 
}
