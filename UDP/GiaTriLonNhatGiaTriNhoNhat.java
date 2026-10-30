package UDP;
import java.net.*;
public class GiaTriLonNhatGiaTriNhoNhat {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("36.50.135.242");
        int sP = 2207;
        String ma = ";B23DCCN322;ND3xhZ7D";

        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(),ma.length(),sA,sP);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);

        String s = new String(dpNhan.getData());
        String[] tmp = s.trim().split(";");
        String rI = tmp[0];
        String[] tmps = tmp[1].trim().split(",");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String x :tmps){
            int i = Integer.parseInt(x);
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }
        String res = rI + ";" + max + "," + min;
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);
        socket.close();
    }
}
