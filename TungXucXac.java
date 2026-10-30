import java.io.*;
import java.net.*;
import java.util.*;


public class TungXucXac {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("",2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String ma = "B16DCCN999;FF49DC02";
        out.writeUTF(ma);
        out.flush();

        int n = in.readInt();
        int [] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = in.readInt();
        }

        int [] cnt = new int[1000];
        for(int i = 0;i<n;i++){
            cnt[arr[i]]++;
        }
        ArrayList<String> res = new ArrayList<>();
        for(int i = 1;i<= 6;i++){
            float x = (float)cnt[i]/n;
           out.writeFloat(x);
        }
       in.close();
       out.close();
        socket.close();
    }    
}


