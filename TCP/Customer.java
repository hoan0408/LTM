package TCP;
import java.io.*;
public class Customer implements Serializable{
    private static final long serialVersionUID = 20170711L;
    public int id;
    public String code, name,dayOfBirth,userName;

    public Customer(int id, String code, String name, String dayOfBirth, String userName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }

    @Override 
    public String toString() {
        return String.format("%d,%s,%s,%s,%s", id, code, name, dayOfBirth, userName);
    }
}
