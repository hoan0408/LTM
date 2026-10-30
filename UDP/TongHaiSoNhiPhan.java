package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TongHaiSoNhiPhan {
    public static int binaryToDecimal(String binary){
        int decimal = 0;
        int idx = 0;
        for(int i = binary.length() - 1;i>=0;i--){
            decimal += (binary.charAt(i)- '0') * Math.pow(2,idx);
            idx++;
        }
        return decimal;
    }
   public static void main(String[] args) throws Exception{
    DatagramSocket socket = new DatagramSocket();
    InetAddress sA = InetAddress.getByName("");
    int sP = 2207;

    String ma = ";B23DCCN322;6g7J8k9L";
    DatagramPacket dpGui = new DatagramPacket(ma.getBytes(),ma.length(),sA, sP);
    socket.send(dpGui);

    byte[] buffer = new byte[1024];
    DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
    socket.receive(dpNhan);

    String s = new String(dpNhan.getData());
    String[] tmp = s.trim().split(";");
    String rI = tmp[0];
    String [] tmps = tmp[1].trim().split(",");
    String so1 = tmps[0].trim();
    String so2 = tmps[1].trim();
    int decimal1 = Integer.parseInt(so1,2);
    int decimal2 = Integer.parseInt(so2,2);
    int sum = decimal1 + decimal2;
    String res = rI + ";" + sum;

    DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
    socket.send(dpGui1);
    socket.close();
   } 
}



