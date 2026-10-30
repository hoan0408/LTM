package UDP;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class SapXepTheoTuDienNguoc {
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
        String[] tmps = tmp[1].trim().split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(tmps));
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER.reversed());

        String res = rI + ";";
        for(String x : list){
            res += x + ",";
        }
        res = res.substring(0,res.length()-1);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);
        socket.close();
    }
}



