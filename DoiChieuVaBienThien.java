import java.io.*;
import java.net.*;

public class DoiChieuVaBienThien {
    public static void main(String [] args) throws Exception{
        Socket socket = new Socket("",807);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String ma = "B16DCCN999;FF49DC02";
        out.writeUTF(ma);
        out.flush();

        String s = in.readUTF().trim();
        s = s.replaceAll(",", " ");
        String[] parts = s.split("\\s++");
        int doichieu = 0;
        int dobienthien = 0;
        int [] arr = new int[parts.length];
        for(int i = 0;i< parts.length;i++){
            arr[i] = Integer.parseInt(parts[i]);
        }
        for(int i = 0;i<arr.length - 2;i++){
            if((arr[i] < arr[i+1] && arr[i+1] > arr[i+2]) || (arr[i] > arr[i+1] && arr[i + 1] < arr[i+2])){
                doichieu+=1;
            }
        }
        for(int i = 0;i< arr.length - 1;i++){
            dobienthien+= Math.abs((arr[i+1]- arr[i]));
        }
        out.writeInt(doichieu);
        out.flush();
        out.writeInt(dobienthien);
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}


