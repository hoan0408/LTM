import java.io.*;
import java.net.*;
public class TCPDataStream {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        String ma = "B23DCCN322;yFyi8ESB";
        out.writeUTF(ma);
        out.flush();

        String s = in.readUTF().trim();
        int d = in.readInt();   

        String res = "";
        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch)){
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                res += (char)(((ch - base - d + 26) % 26 )+ base);
            }
            else {
                res += ch;
            }
        }
        out.writeUTF(res);
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
}
