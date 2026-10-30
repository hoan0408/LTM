import java.io.*;
import java.net.*;
import java.util.*;

public class SapXepTheoDoDai{
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("",2207);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String ma = "B16DCCN999;FF49DC02";
        out.write(ma);
        out.newLine();
        out.flush();

        String data = in.readLine().trim();
        String[] parts = data.split(",");
        ArrayList<String> res = new ArrayList<>();
        for(String part: parts){
            res.add(part);
        }
        int n = res.size();
        Collections.sort(res, new Comparator<String>(){
            @Override 
            public int compare(String s1,String s2){
                return s1.length() - s2.length();
            }
        });

        String result = String.join(", ",res);
        out.write(result);
        out.newLine();
        out.flush();
        in.close();
        out.close();
        socket.close();

    }
}