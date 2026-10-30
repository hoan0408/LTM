import java.io.*;
import java.net.*;
import java.util.*;
public class NenRLE {
    public static String xauDao(String s){
        String res = "";
        for(int i = s.length() - 1;i>=0;i--){
            res+= s.charAt(i);
        }
        return res;
    }

    public static String nenRLE(String s){
        String res = "";
        int cnt = 1;
        for(int i = 0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                cnt++;
            }
            else{
                res+= s.charAt(i);
                if(cnt >= 2){
                    res+= cnt;
                }
                cnt = 1;
            }
        }
        res += s.charAt(s.length() - 1);
        if(cnt >= 2){
            res+= cnt;
        }
        return res;
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("",2206);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        String ma = "B16DCCN999;FF49DC02";
        out.write(ma);
        out.newLine();
        out.flush();

        String s = in.readLine().trim();
        String[] arr = s.split("\\s++");
        ArrayList<String> arrList = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            String xauDao = xauDao(arr[i]);
            String nenRLE = nenRLE(xauDao);
            arrList.add(nenRLE);
        }
        String result = String.join(" ",arrList);
        out.write(result);
        out.newLine();
        out.flush();

        in.close();
        out.close();
        socket.close();

    }    
}
