package TCP;
import java.io.*;
import java.net.*;
public class SanPham {
    public static String chuanhoa(String s){
        String [] parts = s.trim().split("\\s++");
        int len = parts.length;
        String res = "";
        String firstName = parts[0];
        String lastName = parts[len-1];
        res += lastName + " ";
        for(int i = 1;i<len-1;i++){
            res += parts[i] + " ";
        }
        res += firstName;
        return res;
    }

    public static int tinhSoLuong(int n){
        int res = 0;
        while(n!=0){
           res = res * 10 + n%10;
            n /= 10;
        }
        return res;
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("36.50.135.242",2209);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        String ma = "B23DCCN322;rUkrX2mv";
        out.writeObject(ma);
        out.flush();

        Laptop L = (Laptop) in.readObject();
        L.name = chuanhoa(L.name);
        L.quantity  = tinhSoLuong(L.quantity);

        System.out.println(L);
        out.writeObject(L);
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
