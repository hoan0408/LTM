import java.io.*;
import java.net.*;

public class TongCacSoNguyenTo {

    public static boolean isPrime(int n){
        if(n < 2 ) return false;
        for(int i = 1;i< Math.sqrt(n);i++){
            if(n%i == 0) return false;
        }
        return true;
    }
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
        for(int i = 0;i<parts.length;i++){
            a[i] = Integer.parseInt(parts[i]);
        }
        int tong = 0;
        for(int i = 0;i<a.length;i++){
            if(isPrime(a[i])){
                tong+= a[i];
            }
        }
        String res = String.valueOf(tong);
        out.write(res.getBytes());
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
