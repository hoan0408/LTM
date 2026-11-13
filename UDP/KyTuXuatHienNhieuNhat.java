package UDP;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class KyTuXuatHienNhieuNhat {
    public static void main(String [] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress iA = InetAddress.getByName("36.50.135.242");
        int iP = 2208;
        String ma = ";B23DCCN322;JOoOd56B";
        
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(), ma.length(),iA,iP);
        socket.send(dpGui);
        
        byte[] buffer = new byte [1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        String [] tmps = s.trim().split(";");
        String rI = tmps[0].trim();
        String data = tmps[1].trim();
        int [] cnt = new int[256];
        int max = Integer.MIN_VALUE;
        char kytu = ' ';
        for(char x : data.toCharArray()){
            cnt[x]++;
            if(cnt[x] > max){
                max = cnt[x];
                kytu = x;
            }
        }
        String res = rI + ";" + kytu + ":" ;
        for(int i = 0;i<data.length();i++){
            if(data.charAt(i) == kytu){
                res += (i+1) + ",";
            }
        }
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(),iA,iP);
        socket.send(dpGui1);
        socket.close();
        
    }
}
