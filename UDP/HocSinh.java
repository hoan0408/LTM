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
import UDP.Student;
/**
 *
 * @author ASUS
 */
public class HocSinh {
    public static String chuanhoaName(String s){
        String [] tmp = s.trim().split(" ");
        String data = "";
        for(String x : tmp){
            data += Character.toUpperCase(x.charAt(0)) + x.substring(1,x.length()).toLowerCase() + " ";
        }
        return data.trim();
    }
    
    public static String chuanhoaEmail(String s){
        String[] parts = s.trim().toLowerCase().split(" ");
        String res = "";
        res += parts[parts.length - 1];
        for(int i = 0;i< parts.length - 1;i++){
            res += parts[i].charAt(0);
        }
        return res;
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress iA = InetAddress.getByName("36.50.135.242");
        int iP = 2209;
        String ma = ";B23DCCN322;8pUzVHx6";
        
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(), ma.length(),iA,iP);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);
        String rI = new String(dpNhan.getData(),0,8);
        
        
        ByteArrayInputStream input = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength()-8);
        ObjectInputStream in = new ObjectInputStream(input);
        Student sv = (Student) in.readObject();
        sv.name = chuanhoaName(sv.name);
        sv.email = chuanhoaEmail(sv.name) + "@ptit.edu.vn";
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(output);
        out.writeObject(sv);
        out.flush();
        
        
        byte[]data = new byte[8 + output.size()];
        System.arraycopy(rI.getBytes(),0, data, 0, 8);
        System.arraycopy(output.toByteArray(), 0, data, 8, output.size());
        DatagramPacket dpGui1 = new DatagramPacket(data, data.length, iA,iP);
        socket.send(dpGui1);
        socket.close();
        
    }
}
