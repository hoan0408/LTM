import java.io.*;
import java.net.*;
import java.util.*;
public class SoLonThuHai {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        String ma = "B23DCCN322;QheKhlJd";
        out.write(ma.getBytes());
        out.flush();

        byte[] buffer = new byte[1024];
        int bytes = in.read(buffer);
        String data = new String(buffer,0,bytes).trim();
        String[] parts = data.split(",");
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0;i<parts.length;i++){
            a.add(Integer.parseInt(parts[i]));
        }
        int min = Integer.MIN_VALUE;
        int min2 = Integer.MIN_VALUE;
        for(int i = 0;i<a.size();i++){
            if(a.get(i) > min){
                min2 = min;
                min = a.get(i);
            }
            else if(a.get(i) > min2 && a.get(i) < min){
                min2 = a.get(i);
            }
        }
        out.write(String.format("%d,%d",min2,a.indexOf(min2)).getBytes());
    }
}