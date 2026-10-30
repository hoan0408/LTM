package UDP;

import java.net.*;
import java.util.*;
public class PhanTuLonNhatCuaDayCon {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress SA = InetAddress.getByName("");
        int sP = 2207;

        String ma = ";B23DCCN322;6g7J8k9L";
        DatagramPacket dpGui = new DatagramPacket (ma.getBytes(),ma.length(),SA,sP);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData());
        String[] tmp = s.trim().split(";");
        String rI = tmp[0];
        int n = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);
        String[] tmps = tmp[3].trim().split(",");
        int [] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(tmps[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int idx1 = 0;
        int idx2 = k;
        while(idx2 <= n){
            int max =Integer.MIN_VALUE;
            for(int i = idx1;i<idx2;i++){
                if(arr[i] > max){
                    max = arr[i];
                }
            }
            list.add(max);
            idx1++;
            idx2++;
        }

        String res = rI + ";";
        for(int x : list){
            res += x + ",";
        }
        res = res.substring(0,res.length()-1);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),SA,sP);
        socket.send(dpGui1);
        socket.close();
    }
    
}
