import java.io.*;
import java.net.*;

class Student implements Serializable{
    private static final long serialVersionUID = 20151107;
    public int id;
    public String code;
    public float gpa;
    public String qpaLetter;
    
    public Student(int id, String code, float gpa, String qpaLetter) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
        this.qpaLetter = qpaLetter;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", code=" + code + ", gpa=" + gpa + ", qpaLetter=" + qpaLetter + '}';
    }
        
}

public class SinhVien {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("",2206);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        String ma = "B16DCCN999;FF49DC02";
        out.writeObject(ma);
        out.flush();

        Student s = (Student) in.readObject();
        if(s.gpa >= 3.7 && s.gpa <= 4.0){
            s.qpaLetter = "A";
        }
        else if(s.gpa >= 3.0 && s.gpa < 3.7){
            s.qpaLetter = "B";
        }
        else if(s.gpa >= 2.0 && s.gpa < 3.0){
            s.qpaLetter = "C";
        }
        else if(s.gpa >= 1.0 && s.gpa < 2.0){
            s.qpaLetter = "D";
        }
        else{
            s.qpaLetter = "F";
        }

        out.writeObject(s);
        out.flush();
        in.close(); 
        out.close();
        socket.close();
    }
}
