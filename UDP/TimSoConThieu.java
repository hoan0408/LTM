package UDP;

import java.net.*;
import java.util.*;
public class TimSoConThieu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("");
        int sP = 2207;

        String ma = ";B23DCCN322;6g7J8k9L";
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(), ma.length(),sA, sP);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData());
        String[] tmp = s.trim().split(";");
        String rI = tmp[0];
        int n = Integer.parseInt(tmp[1].trim());
        String []tmps = tmp[2].trim().split(",");

        int [] cnt = new int[n+1];
        for(String x :tmps){
            int  num = Integer.parseInt(x);
            cnt[num]++;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1;i<= n;i++){
            if(cnt[i] == 0){
                arr.add(i);
            }
        }
        String res = rI + ";";
        for(int i = 0;i< arr.size();i++){
            res += arr.get(i) + ',';
        }
        res = res.substring(0, res.length() - 1);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);
        socket.close();
    }
    
}
