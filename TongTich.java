import java.io.*;
import java.net.*;


public class TongTich {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242",2207 );
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String ma = "B23DCCN322;AQAZ85PI";
        out.writeUTF(ma);
        out.flush();

        int so1 = in.readInt();
        int so2 = in.readInt();

        int tong = so1 + so2;
        int tich = so1 * so2;

        out.writeInt(tong);
        out.writeInt(tich);
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
