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
public class TimSoConThieu {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress iA = InetAddress.getByName("36.50.135.242");
        int iP  = 2207;
        String ma = ";B23DCCN322;oYlH7On0";
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(),ma.length(),iA,iP);
        socket.send(dpGui);
        
        byte[] buffer  = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData());
        String []tmps = s.trim().split(";");
        String rI = tmps[0].trim();
        int n = Integer.parseInt(tmps[1]);
        int [] cnt = new int[n + 1];
        String [] arr = tmps[2].trim().split(",");
        for(int i = 0;i<arr.length;i++){
            int x = Integer.parseInt(arr[i]);
            cnt[x]++;
        }
        String data = "";
        for(int i = 1;i<= n;i++){
            if(cnt[i] == 0){
                 data+= i + ",";
            }
        }
        String res = rI + ";" + data.substring(0,data.length()-1);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(),iA,iP);
        socket.send(dpGui1);
        socket.close();
        
    }
}
