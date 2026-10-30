import java.io.*;
import java.net.*;
import java.util.*;

public class DaoNguocDoanDaiK {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("",2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String ma = "B16DCCN999;FF49DC02";
        out.writeUTF(ma);
        out.flush();

        int k = in.readInt();
        String s = in.readUTF().trim();
        String[] parts = s.split(",");
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0;i < parts.length;i+=k){
            int j = Math.min(i+k-1,parts.length-1);
            for(int o = j;o >=i ;o--){
                res.add(parts[o]);
            }
        }
        String result = String.join(",",res);
        out.writeUTF(result);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}


