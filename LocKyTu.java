import java.io.*;
import java.net.*;

public class LocKyTu {
    public static void main(String [] args) throws Exception{
        Socket socket = new Socket("",2207);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


        String ma = "B23DCCN322;A1B2C3D4";
        out.write(ma);
        out.newLine();
        out.flush();

        String s = in.readLine().trim();
        String res1 = "", res2 = "";
        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch) || Character.isDigit(ch)){
                res1 += ch;
            }
            else {
                res2 += ch;
            }
        }
        System.out.println("Result 1: " + res1);
        System.out.println("Result 2: " + res2);

        out.write(res1);
        out.newLine();
        out.flush();
        out.write(res2);
        out.newLine();
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}

