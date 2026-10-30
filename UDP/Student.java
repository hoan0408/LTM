package UDP;
import java.io.Serializable;
public class Student implements Serializable {
    public String id,code, name, email;
    private static final long serialVersionUID = 20171107;
    public Student(String id,String code, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.code = code;
    }

    public Student(String code){
        this.code = code;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", id, code, name, email);
    }
}

