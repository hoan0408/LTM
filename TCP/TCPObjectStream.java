package TCP;
import java.io.*;
import java.net.*;
public class TCPObjectStream {
    public static String chuanhoa(String s){
        String [] parts = s.trim().split("\\s+");
        int len = parts.length;
        String lastName = parts[len-1].toUpperCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<len-1;i++){
           String word = parts[i].toLowerCase();
           String newWord = Character.toUpperCase(word.charAt(0)) + word.substring(1);
           sb.append(newWord).append(" ");
        }
        String newName = lastName + ", " + sb.toString().trim();
        return newName;
    }

    public static String chuanhoa2(String s){
        String [] parts = s.trim().toLowerCase().split("\\s+");
        int len = parts.length;
        StringBuilder sb = new StringBuilder();
        String lastName = parts[len-1];
        for(int i = 0;i<len - 1;i++){
         sb.append(parts[i].charAt(0));
        }
        String userName = sb.toString() + lastName;
        return userName;
    }
    public static String chuanhoangay(String s){
        String []parts = s.trim().split("-");
        String newDate = parts[1] + "/" + parts[0] + "/" + parts[2];
        return newDate;
    }
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        String ma = "B23DCCN322;TrtdkHic";
        out.writeObject(ma);
        out.flush();

        Customer customer = (Customer) in.readObject();
        customer.userName = chuanhoa2(customer.name);
        customer.name = chuanhoa(customer.name);
        customer.dayOfBirth = chuanhoangay(customer.dayOfBirth);

        System.out.println(customer);
        out.writeObject(customer);
        out.flush();
    }

}
