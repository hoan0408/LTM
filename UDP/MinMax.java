package UDP;

import java.net.*;
public class MinMax {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("");
        int sP = 2207;

        String ma = ";B23DCCN322;6g7J8k9L"; 
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(), ma.length(),sA,sP);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData());
        String []tmp = s.trim().split(";");
        String rI = tmp[0];
        String [] tmps = tmp[1].trim().split(",");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String x : tmps){
            int num = Integer.parseInt(x);
            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }
        String res = rI + ";" + min + "," + max;
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);
        socket.close();
    }
}
