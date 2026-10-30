import java.io.*;
import java.net.Socket;
import java.util.Arrays;
public class TCPByteStream {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("36.50.135.242",2206 );
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        out.write("B23DCCN322;dCgRRXph".getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytes = in.read(buffer); // len dữ liệu server trả
        String data = new String(buffer, 0, bytes).trim();
        String[] parts = data.split(",");
        int []a = new int[parts.length];
        for(int i = 0;i<parts.length;i++){
            a[i] = Integer.parseInt(parts[i]);
        }
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        int st1 = 0;
        int st2 = 0;
        for(int i = 0;i<a.length - 1;i++){
            if(a[i+1]- a[i] <= min){
                min = a[i+1]- a[i];
                st1 = a[i];
                st2 = a[i+1];
            }
        }
        System.out.println(String.format("%d,%d,%d", min, st1, st2));
        out.write(String.format("%d,%d,%d", min, st1, st2).getBytes());
        out.flush();
        socket.close();
    }
}   
