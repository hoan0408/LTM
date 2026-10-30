package UDP;
import java.net.*;
public class SoConThieu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("36.50.135.242");
        int sP = 2208;

        String ma = ";B23DCCN322;oYlH7On0";
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(), ma.length(),sA,sP);
        socket.send(dpGui);

        byte [] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);

        String s = new String(dpNhan.getData());
        String[] tmp = s.trim().split(";");
        String rI = tmp[0];
        int n = Integer.parseInt(tmp[1]);
        System.out.println("So con thieu: " + n);
        String []tmps = tmp[2].trim().split(",");
        int [] arr = new int[n];

        for(String x : tmps){
            int i = Integer.parseInt(x);
            arr[i-1] = 1;
        }
        s = "";
        for(int i = 1;i<= n;i++){
            if(arr[i-1] == 0){
                s += i + ",";
            }
        }
        String res = rI + ";" + s.substring(0,s.length()-1);
        System.out.println("So con thieu: " + s.substring(0,s.length()-1));
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);
        socket.close();
    }
}
