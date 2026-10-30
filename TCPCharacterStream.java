import java.io.*;
import java.net.*;

public class TCPCharacterStream {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String ma = "B23DCCN322;x8MiI3GJ";
        out.write(ma);
        out.newLine();
        out.flush();

        String s = in.readLine().trim();
        int cnt[] = new int[256];
        for(char ch : s.toCharArray()){
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
                cnt[ch]++;
            }
        }
        String res = "";
        for(char x : s.toCharArray()){
            if(cnt[x] > 1){
                res = res + x + ":" + cnt[x]+ ",";
                cnt[x] = 0;
            }
        }
        out.write(res);
        out.newLine();
        out.flush();

        in.close();
        out.close();
        socket.close();

    }
}
