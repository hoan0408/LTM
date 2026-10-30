import java.io.*;
import java.net.*;

class Address implements Serializable{
    private static final long serialVersionUID = 20180801L;
    public int id;
    public String code,addressLine,city,postalCode ;

    public Address(int id, String code, String addressLine, String city, String postalCode) {
        this.id = id;
        this.code = code;
        this.addressLine = addressLine;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override 
    public String toString(){
        return String.format("%d,%s,%s,%s,%s",id,code,addressLine,city,postalCode);
    }
}

public class DiaChiKhachHang {
    public static String format(String s){
        String res = "";
        res += Character.toUpperCase(s.charAt(0));
        for(int i = 1;i<s.length();i++){
            res+= Character.toLowerCase(s.charAt(i));
        }
        return res;
    }
    public static String chuanhoa(String s){
        String[] arr= s.trim().toLowerCase().split("\\s+");
        for(int i = 0;i<arr.length;i++){
            String res = "";
            for(char c : arr[i].toCharArray()){
                if(Character.isLetter(c) || Character.isDigit(c)){
                    res+= c;
                }
            }
            arr[i] = format(res);
        }
        return String.join(" ",arr);
    }

    public static String chuanhoa2(String s){
        String res = "";
        s = s.trim();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c) || c == '-'){
                res+= c;
            }
        }
        return res;
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("",2206);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        String ma = "B16DCCN999;FF49DC02";
        out.writeObject(ma);
        out.flush();

        Address a = (Address) in.readObject();
        a.addressLine = chuanhoa(a.addressLine);
        a.postalCode = chuanhoa2(a.postalCode);
        out.writeObject(a);
        out.flush();
        in.close(); 
        out.close();
        socket.close();
    }   
}



