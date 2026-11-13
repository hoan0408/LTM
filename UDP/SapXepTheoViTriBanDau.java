/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.net.*;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class SapXepTheoViTriBanDau {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress iA = InetAddress.getByName("");
        int iP = 2207;
        
        String ma = ";B15DCCN009;F3E8B2D4";
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(),ma.length(),iA,iP);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData());
        String []tmps = s.trim().split(";");
        String rI = tmps[0];
        String []data = tmps[1].trim().split(",");
        TreeMap<Integer,String> tr = new TreeMap<>();
       
        for(String x : data){
            String [] tmp1 = x.trim().split(":");
            tr.put(Integer.parseInt(tmp1[1]), tmp1[0]);
        }
        String res = rI + ";";
        for(String x : tr.values()){
            res += x + " ";
        }
        res = res.substring(0,res.length() - 1);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(),iA,iP);
        socket.send(dpGui1);
        socket.close();
        
    }
}
