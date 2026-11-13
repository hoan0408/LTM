/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.rmi.registry.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author ASUS
 */
public class PhanTuXuatHienNhieuNhat {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("36.50.135.242",1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        String ma = "B23DCCN322";
        String qCode = "QeyT6amy";
        
        byte[] a = sv.requestData(ma, qCode);
        int [] cnt = new int[1024];
        for(byte x : a) cnt[x]++;
        byte ptMax = a[0];
        int slMax = cnt[a[0]];
        for(byte x : a){
            if(cnt[x] > slMax){
                slMax  = cnt[x];
                ptMax = x;
            }
        }
        byte[] res = {ptMax, (byte)slMax};
        sv.submitData(ma, qCode, res);
        
    }
}
