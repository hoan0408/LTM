/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author ASUS
 */
public class MinMax {
    public static void main(String [] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress iA = InetAddress.getByName("36.50.135.242");
        int iP = 2207;
        String ma = ";B23DCCN322;ND3xhZ7D";
        
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(), ma.length(),iA,iP);
        socket.send(dpGui);
        
        byte[] buffer = new byte [1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        String [] tmps = s.trim().split(";");
        String rI = tmps[0].trim();
        String []data = tmps[1].trim().split(",");
        int [] arr = new int[1024];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < data.length;i++){
            int x = Integer.parseInt(data[i]);
            if(x > max){
                max = x;
            }
            if(x < min){
                min = x;
            }
        }
        String res = rI + ";" + max + "," + min ;
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(),iA,iP);
        socket.send(dpGui1);
        socket.close();
        
    }
}
