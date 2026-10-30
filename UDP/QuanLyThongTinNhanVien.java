package UDP;
import java.io.*;
import java.net.*;
public class QuanLyThongTinNhanVien {
    public static String chuanhoaName(String name){
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        String res = "";
        for(String x : tmp){
            res += Character.toUpperCase(x.charAt(0)) + x.substring(1) + " ";
        }
        return res.trim();
    }

    public static double chuanhoaSalary(double salary){
        int x = 0;
        double newSalary = salary;
        while(salary != 0){
            x += salary % 10;
            salary /= 10;
        }
        newSalary += salary * x/100;
        return newSalary;
        
    }

    public static String chuanhoaDate(String hireDate){
        String[] tmp = hireDate.trim().split("-");
        return tmp[2] + "/" + tmp[1]+ "/" + tmp[0];
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("");
        int sP = 2207;

        String ma = ";B23DCCN322;6g7J8k9L";
        DatagramPacket dpGui = new DatagramPacket(ma.getBytes(),ma.length(),sA, sP);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);

        String rI = new String(dpNhan.getData(),0,8);
        ByteArrayInputStream input = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength() - 8);
        ObjectInputStream in = new ObjectInputStream(input);
        Employee e = (Employee) in.readObject();

        e.name = chuanhoaName(e.name);
        e.salary = chuanhoaSalary(e.salary);
        e.hireDate = chuanhoaDate(e.hireDate);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(output);
        out.write(buffer);
        out.flush();

        byte[] data = new byte[8 + output.size()];
        System.arraycopy(rI.getBytes(), 0, data, 0, 8);
        System.arraycopy(output.toByteArray(), 0, data, 8, output.size());
        DatagramPacket dpGui1 = new DatagramPacket(data, data.length, sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
    
}
