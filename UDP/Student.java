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
public class Student implements Serializable{
    private static final long serialVersionUID = 20171107;
    public String id,code,name,email;
    
    public Student(String id, String code, String name, String email ){
        this.id = id;
        this.code= code;
        this.name = name;
        this.email = email;
    }
    public Student(String code){
        this.code = code;
    }
    
    @Override
    public String toString(){
        return  String.format("%s,%s,%s,%s", id,code,name,email);
    }
}
