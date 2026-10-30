import java.io.*;
import java.net.*;


public class UCLNBCNN {
    public static int UCLN(int a,int b){
        if(b==0) return a;
        return UCLN(b,a%b);
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("",2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String ma = "B16DCCN999;FF49DC02";
        out.writeUTF(ma);
        out.flush();

        int a = in.readInt();
        int b = in.readInt();
        int tong = a + b, tich = a * b,ucln = UCLN(a,b),bcnn = (a*b)/UCLN(a,b);

        out.writeInt(tong);
        out.writeInt(tich);
        out.writeInt(ucln);
        out.writeInt(bcnn);
        
        in.close();
        out.close();
        socket.close();
    }   
}
