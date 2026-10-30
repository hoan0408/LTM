import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class TenMien {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String ma = "B23DCCN322;2yz3mPKz";
        out.write(ma);
        out.newLine();
        out.flush();

        String[] s = in.readLine().trim().split(",");
        List<String> eduMain = new ArrayList<>();
        for(String index : s){
            index = index.trim();
            if(index.contains(".edu") || index.endsWith(".edu")){
                eduMain.add(index);
            }
        }
        String res = String.join(", ", eduMain);
        out.write(res);
        out.newLine(); 
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}


