import java.io.*;
import java.net.*;
import java.util.*;

public class SapXepChuoi {
    public static void main(String[] args) throws Exception{
        Socket socket =new Socket("",2206);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String ma = "B16DCCN999;FF49DC02";
        out.write(ma);
        out.newLine();
        out.flush();

        String s = in.readLine().trim();
        String[] arr = s.split(",");
        String res = "";
        ArrayList<String> arrList = new ArrayList<>();
        for(String x : arr) {
            arrList.add(x);
        }
        Collections.sort(arrList);
        for(int i = 0;i<arrList.size()-1;i++){
            res = res + arrList.get(i) + " ";
        }
        res = res + arrList.get(arrList.size()-1);
        out.write(res);
        out.newLine();
        out.flush();

        in.close();
        out.close();
        socket.close();

    }
}
