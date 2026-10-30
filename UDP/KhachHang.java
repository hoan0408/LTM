package UDP;
import java.io.*;
import java.net.*;
public class KhachHang {

    public static String chuanhoaName(String s){
        String [] parts = s.trim().split("\\s++");
        int len = parts.length;
        String res = "";
        res += parts[len-1].toUpperCase()+ ", ";
        for(int i = 0;i<len - 1;i++){
            res += Character.toUpperCase(parts[i].charAt(0)) + parts[i].substring(1,parts[i].length()).toLowerCase() + " ";
        }
        return res.trim();
    }

    public static String chuanhoaNS(String s){
        String [] parts = s.trim().split("-");
        String res = "";
        res += parts[1] + "/" + parts[0] + "/" + parts[2];
        return res;
    }

    public static String taikhoanKH(String s){
        String [] parts = s.trim().toLowerCase().split("\\s++");
        String res = "";
        for(int i = 0;i<parts.length - 1;i++){
            res += parts[i].charAt(0);
        }
        res += parts[parts.length - 1];
        return res;
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA =  InetAddress.getByName("36.50.135.242");
        int sP = 2209;

        String ma = ";B23DCCN322;Bp8OLvCE";
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(), ma.length(),sA,sP);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String rI = new String(dpNhan.getData(),0,8);
        ByteArrayInputStream input = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream in = new ObjectInputStream(input);
        Customer kh = (Customer) in.readObject();
        kh.userName = taikhoanKH(kh.name);
        kh.name = chuanhoaName(kh.name);
        kh.dayOfBirth = chuanhoaNS(kh.dayOfBirth);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(output);
        out.writeObject(kh);
        out.flush();

        byte[] data = new byte[8 + output.size()]; 
        System.arraycopy(rI.getBytes(), 0, data, 0, 8);
        System.arraycopy(output.toByteArray(), 0, data, 8, output.size());
        DatagramPacket dpGui1 = new DatagramPacket(data, data.length, sA, sP);
        socket.send(dpGui1);
        socket.close();

    }
}
