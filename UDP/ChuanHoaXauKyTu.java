package UDP;

import java.net.*;
public class ChuanHoaXauKyTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA =  InetAddress.getByName("36.50.135.242");
        int sP = 2208;

        String ma = ";B23DCCN322;sz2J5MN8";
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(),ma.length(),sA,sP);
        socket.send(dpGui);
        
        byte[]buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);

        String s1 = new String(dpNhan.getData());
        String[] tmp = s1.trim().split(";");

        String rI = tmp[0];
        String s = tmp[1];
        String [] tmps = s.trim().split("\\s++");

        s = "";
        for(String x :tmps){
            s += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        String res = rI + ";" + s;

        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);
        socket.close();
    }
}
