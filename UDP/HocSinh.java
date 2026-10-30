package UDP;
import java.io.*;
import java.net.*;
public class HocSinh {
    public static String chuanhoa(String s){
        String[] parts = s.trim().split("\\s++");
        int len = parts.length;
        String res = "";
        for(int i = 0;i<len;i++){
            res += Character.toUpperCase(parts[i].charAt(0)) + parts[i].substring(1, parts[i].length()).toLowerCase() + " ";
        }
        return res.trim();
    }

    public static String chuanhoaEmail(String s){
        String[] parts = s.trim().split("\\s++");
        int len = parts.length;
        String res = "";
        res += parts[len-1].toLowerCase();
        for(int i = 0;i<len-1;i++){
            res+= Character.toLowerCase(parts[i].charAt(0));
        }
        return res;
    }
    public static void main(String[] args)throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("36.50.135.242");
        int sP = 2209;

        String ma = ";B23DCCN322;8pUzVHx6";
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(),ma.length(),sA,sP);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);
        String rI = new String(dpNhan.getData(),0,8);
        
        ByteArrayInputStream input = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength()-8);
        ObjectInputStream in = new ObjectInputStream(input);
        Student sv = (Student) in.readObject();
        System.out.println(sv.id + " " + sv.code + " " + sv.name + " " + sv.email);
        sv.name = chuanhoa(sv.name);
         sv.email = chuanhoaEmail(sv.name) + "@ptit.edu.vn";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(output);
        out.writeObject(sv);
        out.flush();
        System.out.println(sv.id + " " + sv.code + " " + sv.name + " " + sv.email);
        byte[] data = new byte[8 + output.size()];
        System.arraycopy(rI.getBytes(), 0, data, 0, 8);
        System.arraycopy(output.toByteArray(), 0, data, 8, output.size());
        DatagramPacket dpGui1 = new DatagramPacket(data, data.length, sA, sP);
        socket.send(dpGui1);
        socket.close();

    }
}
