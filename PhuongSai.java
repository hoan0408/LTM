import java.io.*;
import java.net.*;

public class PhuongSai {
    public static void main(String[] args) throws Exception{
       Socket socket = new Socket("",2207);
       DataInputStream in = new DataInputStream(socket.getInputStream());
       DataOutputStream out = new DataOutputStream(socket.getOutputStream());

       String ma = "B16DCCN999;FF49DC02";
       out.writeUTF(ma);
        out.flush();
        int n = in.readInt();
        int []arr= new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = in.readInt();
        }
        int tong = 0;
        float tb =0;
        float ps = 0;
        for(int i = 0;i<n;i++){
            tong += arr[i];
        }
        tb = (float)tong/n;
        for(int i = 0;i<n;i++){
            ps += (arr[i] - tb)*(arr[i] - tb);
        }
        ps = ps/n;
        out.writeInt(tong); out.flush();
        out.writeFloat(tb); out.flush();
        out.writeFloat(ps); out.flush();

        in.close();
        out.close();
        socket.close();

    }
}
