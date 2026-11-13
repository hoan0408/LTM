/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class DaoNguocChuoi {
    public static void main(String[] args) throws Exception{
        CharacterService service = new CharacterService();
        SoapCharacterService p = service.getSoapCharacterServicePort();
        String ma = "B23DCCN322";
        String qCode = "giJuW172";
        
        String s = p.requestString(ma,qCode);
        String res = new StringBuilder(s).reverse().toString();
        p.submitString(ma,qCode,res);
    }
}
