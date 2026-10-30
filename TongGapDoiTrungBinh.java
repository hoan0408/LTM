import java.io.*;
import java.net.*;

public class TongGapDoiTrungBinh {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("",2207);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        String ma = "B16DCCN999;FF49DC02";
        out.write(ma.getBytes());
        out.flush();

        byte[] data = new byte[1024];
        int len = in.read(data);
        String s = new String(data,0,len).trim();
        String[] parts = s.split(",");
        int[] a = new int[parts.length];
        for(int i = 0;i<parts.length;i++){
            a[i] = Integer.parseInt(parts[i]);
        }
        int tong = 0;
        int so1= 0;
        int so2 = 0;
        for(int i = 0;i<a.length;i++){
            tong+= a[i];
        }
        float tb = (float)tong/a.length;
        float min = Float.MAX_VALUE;
        for(int i = 0;i< a.length - 1;i++){
            for(int j = i+1;j< a.length;j++){
                if(Math.abs(a[i] + a[j] - 2*tb) < min){
                    min = Math.abs(a[i] + a[j] - 2*tb);
                    so1 = a[i];
                    so2 = a[j];
                }
            }
        }
        String res = so1 + "," + so2;
        out.write(res.getBytes());
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}



