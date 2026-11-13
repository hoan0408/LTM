/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;
/**
 *
 * @author ASUS
 */
public class ChuanHoaChuoi {
    public static void main(String [] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress iA = InetAddress.getByName("36.50.135.242");
        int iP = 2208;
        String ma = ";B23DCCN322;sz2J5MN8";
        
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(), ma.length(),iA,iP);
        socket.send(dpGui);
        
        byte[] buffer = new byte [1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        String [] tmps = s.trim().split(";");
        String rI = tmps[0].trim();
        String []data = tmps[1].trim().split(" ");
        String res = rI + ";";
        for(String x : data){
            res += Character.toUpperCase(x.charAt(0)) + x.toLowerCase().substring(1,x.length()) + " ";
        }
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(),iA,iP);
        socket.send(dpGui1);
        socket.close();
        
    }
}
