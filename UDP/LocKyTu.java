package UDP;

import java.net.*;

public class LocKyTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        String ma = ";B23DCCN322;6g7J8k9L";
        InetAddress sA = InetAddress.getByName("");
        int sP = 2207;
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(),ma.length(),sA,sP);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        String s = new String(dpNhan.getData());
        String[] tmp = s.trim().split(";");
        String rI = tmp[0];
        String tmps = tmp[1].trim();
        String data = "";
        int [] cnt = new int[256];
        for(char x : tmps.toCharArray()){
            if(Character.isAlphabetic(x)){
                cnt[x]++;
            }
        }
        String res = "";
        for(char x : data.toCharArray()){
            if(cnt[x] > 0){
                res += x;
                cnt[x] = 0;
            }
        }
        res = rI + ";" + res;
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
    
}
