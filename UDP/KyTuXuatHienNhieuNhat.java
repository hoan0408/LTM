package UDP;
import java.net.*;
public class KyTuXuatHienNhieuNhat {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA =  InetAddress.getByName("36.50.135.242");
        int sP = 2208;

        String ma = ";B23DCCN322;JOoOd56B";
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(), ma.length(),sA,sP);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        String s1 = new String(dpNhan.getData());
        String[] tmp = s1.trim().split(";");
        String rI = tmp[0];
        String s = tmp[1].trim();
        int [] arr = new int[256];
        int max = Integer.MIN_VALUE;
        for(char c : s.toCharArray()){
            arr[c]++;
            if(arr[c] > max){
                max = arr[c];
            }
        }
        char resC = ' ';
        for(char x : s.toCharArray()){
            if(arr[x] == max){
                resC = x;
                break;
            }
        }
        s1= "";
        s1 += resC + ":";
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == resC){
                s1 += (i + 1) + ",";
            }
        }
        System.out.println(s1);
        String res = rI + ";" + s1;
        System.out.println(res);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);
        socket.close();
    }
}
