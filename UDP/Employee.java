package UDP;

public class Employee implements java.io.Serializable {
    private static final long serialVersionUID = 20261107L;
    public String id,name,hireDate;
    public double salary;

    public Employee(String id, String name, double salary, String hireDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    @Override 
    public String toString() {
        return String.format("%s,%s,%s,%s", id, name, salary, hireDate);
    }
}
