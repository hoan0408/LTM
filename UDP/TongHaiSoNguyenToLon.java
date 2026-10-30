package UDP;
import java.math.BigInteger;
import java.net.*;

public class TongHaiSoNguyenToLon  {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("");
        int sP = 2207;
        String ma = ";B23DCCN322;6g7J8k9L";
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(),ma.length(),sA,sP);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        String data = new String(dpNhan.getData());
        String[] tmp = data.trim().split(";");
        String rI = tmp[0];
        BigInteger so1 = new BigInteger(tmp[1].trim());
        BigInteger so2 = new BigInteger(tmp[2].trim());

        BigInteger sum = so1.add(so2);
        BigInteger difference = so1.subtract(so2);

        String res = rI + ";" + sum.toString() + "," + difference.toString();
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);

        socket.close();

    }
}


