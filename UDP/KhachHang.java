/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.*;
import UDP.Customer;
/**
 *
 * @author ASUS
 */
public class KhachHang {
    public static String chuanhoaName(String s){
        String [] tmps = s.trim().split("\\s++");
        String res = "";
        res += tmps[tmps.length - 1].toUpperCase() + ", ";
        for(int i = 0;i<tmps.length - 1;i++){
            res += Character.toUpperCase(tmps[i].charAt(0)) + tmps[i].substring(1,tmps[i].length()).toLowerCase() + " ";
        }
        return res.trim();
    }
    public static String chuanHoaNS(String s){
        String [] tmps = s.trim().split("-");
        String res = "";
        res = tmps[1] + "/" + tmps[0] + "/" + tmps[2];
        return res.trim();
    }
    
    public static String chuanHoaUserName(String s){
        String [] tmps = s.trim().split("\\s++");
        String res = "";
        for(int i = 0;i< tmps.length-1;i++){
            res += Character.toLowerCase(tmps[i].charAt(0));
        }
        res += tmps[tmps.length-1].toLowerCase();
        return res.trim();
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress iA = InetAddress.getByName("36.50.135.242");
        int iP = 2209;
        String ma = ";B23DCCN322;Bp8OLvCE";
        
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(), ma.length(),iA,iP);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String rI = new String(dpNhan.getData(),0,8);
        ByteArrayInputStream input = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength() - 8);
        ObjectInputStream in = new ObjectInputStream(input);
        Customer kh = (Customer) in.readObject();
        kh.userName = chuanHoaUserName(kh.name);
        kh.dayOfBirth = chuanHoaNS(kh.dayOfBirth);
        kh.name = chuanhoaName(kh.name);
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(output);
        out.writeObject(kh);
        out.flush();
        
        byte[] data = new byte[output.size() + 8];
        System.arraycopy(rI.getBytes(), 0, data, 0, 8);
        System.arraycopy(output.toByteArray(), 0, data, 8, output.size());
        DatagramPacket dpGui1 = new DatagramPacket(data,data.length,iA,iP);
        socket.send(dpGui1);
        socket.close();
    }
}
