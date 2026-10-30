import java.io.*;
import java.net.*;
public class TimTuDaiNhat {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("",2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String ma = "B23DCCN322;A1B2C3D4";
        out.write(ma);
        out.newLine();
        out.flush();

        String data = in.readLine().trim();
        String [] parts = data.split("\\s++");
        String res = "";
        int maxLen = 0;
        int pos = 0;
        for(int i = 0;i<parts.length;i++){
            if(parts[i].length() > maxLen){
                maxLen = parts[i].length();
                res = parts[i];
                pos = data.indexOf(res);
            }
        }
        System.out.println(String.format("%s,%d",res,pos));
        out.write(res);
        out.newLine();
        out.flush();
        out.write(pos);
        out.newLine();
        out.flush();

        in.close();
        out.close();
        socket.close();
   
    }
}
