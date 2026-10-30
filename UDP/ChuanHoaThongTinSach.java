package UDP;
import java.io.*;
import java.net.*;
public class ChuanHoaThongTinSach {
    public static String chuanhoaTitle(String s){
        String [] parts = s.trim().split("\\s++");
        int len = parts.length;
        String res = "";
        for(int i = 0;i<len;i++){
            res += Character.toUpperCase(parts[i].charAt(0)) + parts[i].substring(1,parts[i].length()).toLowerCase() + " ";
        }
        return res.trim();
    }
    
    public static String chuanhoaAuthor(String s){
        String [] parts = s.trim().split("\\s++");
        int len = parts.length;
        String res = "";
        res += parts[0].toUpperCase() + " ";
        for(int i = 1;i<len;i++){
            res += Character.toUpperCase(parts[i].charAt(0)) + parts[i].substring(1,parts[i].length()).toLowerCase() + " ";
        }
        return res.trim();
    }

    public static String chuanhoaISBN(String s){
        String res = "";
        res += s.substring(0,3) + "-" + s.substring(3,4) + "-" + s.substring(4,6) + "-" + s.substring(6,s.length()-1) + "-" + s.substring(s.length()-1,s.length());
        return res;
    }
    public static String chuanhoaPublishDate(String s){
        String [] parts = s.trim().split("-");
        String res = "";
        res += parts[1]+"/" + parts[0];
        return res;
    }
    public static void main(String [] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("");
        int sP = 2207;

        String ma = ";B23DCCN322;6g7J8k9L";
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(),ma.length(),sA, sP);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);
        String rI = new String(dpNhan.getData(),0,8);
        ByteArrayInputStream input = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength() - 8);
        ObjectInputStream in = new ObjectInputStream(input);
        Book b = (Book) in.readObject();

        b.title = chuanhoaTitle(b.title);
        b.author = chuanhoaAuthor(b.author);
        b.isbn = chuanhoaISBN(b.isbn);
        b.publishDate = chuanhoaPublishDate(b.publishDate);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(output);
        out.writeObject(b);
        out.flush();

        byte[] data = new byte[8 + output.size()];
        System.arraycopy(rI.getBytes(), 0, data, 0 , 8);
        System.arraycopy(output.toByteArray(), 0, data, 8, output.size());
        DatagramPacket dpGui1 = new DatagramPacket(data, data.length, sA, sP);
        socket.send(dpGui1);

    }
}


