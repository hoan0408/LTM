package UDP;
import java.net.*;
public class MaHoaCaesar{
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
        String [] tmp = s.trim().split(";");
        String rI = tmp[0];
        String tmps = tmp[1].trim();
        int cnt = Integer.parseInt(tmp[2].trim());
        String res = rI + ";";
        for(int i = 0;i<tmps.length();i++){
            char x = tmps.charAt(i);
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            res += (char)(x-base + cnt) % 26 + base;
        }

        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);
        socket.close();
    }
}