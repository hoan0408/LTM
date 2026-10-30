import java.io.*;
import java.net.*;

public class HeCoSo8Va16 {
    public static void main(String [] args) throws Exception{
        Socket socket = new Socket("",2206);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String ma = "B16DCCN999;FF49DC02";
        out.writeUTF(ma);
        out.flush();

        int res = in.readInt();
        String oct = Integer.toOctalString(res);
        String hex = Integer.toHexString(res).toUpperCase();
        String hex2 = Integer.toBinaryString(res);
        String result = oct + ";" + hex + ";" + hex2;

        out.writeUTF(result);
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}


