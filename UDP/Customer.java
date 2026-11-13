/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.Serializable;
/**
 *
 * @author ASUS
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = 20151107;
    public String id,code,name,dayOfBirth,userName ;
    
    public Customer(String id, String code, String name, String dayOfBirth,String userName ){
        this.id = id;
        this.code= code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = userName;
    }
    @Override
    public String toString(){
        return  String.format("%s,%s,%s,%s", id,code,name,dayOfBirth,userName);
    }
    
}
