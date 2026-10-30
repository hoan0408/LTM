import java.io.*;
import java.net.*;

public class ViTriCanBangTong {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("",2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        String ma = "B16DCCN999;FF49DC02";
        out.write(ma.getBytes());
        out.flush();

        byte[] buffer = new byte[1024];
        int len = in.read(buffer);
        String s = new String(buffer,0,len).trim();
        String[] parts = s.split(",");
        int[] a = new int[parts.length];
        int tong = 0;
        for(int i = 0;i<parts.length;i++){
            a[i] = Integer.parseInt(parts[i]);
            tong+= a[i];
        }
        int tong1 = 0;
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for(int i = 0;i< a.length;i++){
            tong1+= a[i];
            if(Math.abs(2*tong1 - tong) < min){
                min = Math.abs(2*tong1 - tong);
                pos = i + 1;
            }
        }
        String res = pos + "," + tong1 + "," + (tong - tong1) + "," + min;
        out.write(res.getBytes());
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
