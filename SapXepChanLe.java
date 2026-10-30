import java.io.*;
import java.net.*;
import java.util.*;

public class SapXepChanLe {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("",2207);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        String ma = "B16DCCN999;FF49DC02";
        out.write(ma.getBytes());
        out.flush();

        byte[] buffer = new byte[1024];
        int bytes = in.read(buffer);
        String data = new String(buffer,0,bytes).trim();
        String[] parts = data.split(",");
        ArrayList<Integer> chan = new ArrayList<>();
        ArrayList<Integer> le = new ArrayList<>();

        for(int i = 0;i<parts.length;i++){
            int x = Integer.parseInt(parts[i]);
            if(x%2==0){
                chan.add(x);
            }
            else{
                le.add(x);
            }
        }
        Collections.sort(chan);
        Collections.sort(le);
        String res = "[";
        for(int i = 0;i<chan.size() - 1;i++){
            res = res + chan.get(i) + ", ";
        }
        res += chan.get(chan.size() - 1) + "];[" ;
        for(int i = 0;i<le.size() - 1;i++){
            res = res + le.get(i) + ", ";
        }
        res += le.get(le.size() - 1) + "]";
        out.write(res.getBytes());
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}

