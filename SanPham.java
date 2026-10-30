import java.io.*;
import java.net.*;

class Product implements Serializable{
    private static final long serialVersionUID = 20231107;
    public int id,discount;
    public String name;
    public double price;

    public Product(int id, String name, double price, int discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String toString(){
         return "Product{" + "id=" + id + ", discount=" + discount + ", price=" + price + ", name=" + name + '}';
    }

}

public class SanPham {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("",2206);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        String ma = "B16DCCN999;FF49DC02";
        out.writeObject(ma);
        out.flush();

        Product p = (Product) in.readObject();
        int newPrice = (int)p.price;

        int newDiscount =0;
        while(newPrice !=0){
            newDiscount += newPrice%10;
            newPrice /= 10;
        }
        p.discount = newDiscount;

        out.writeObject(p);
        out.flush();

        in.close();
        out.close();
        socket.close();
    }
};
