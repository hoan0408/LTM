package TCP;
import java.io.*;
public class Laptop implements Serializable{
    private static final long serialVersionUID = 20150711L;
    public int id;
    public String code,name;
    public int quantity;

    public Laptop(int id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }
    @Override
    public String toString(){
        return String.format("%d,%s,%s,%d", id, code, name, quantity);
    }
}
