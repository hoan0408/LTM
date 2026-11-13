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
public class XoayVongKyTu {
    public static void main(String [] args) throws Exception{
        CharacterService service = new CharacterService();
        SoapCharacterService p = service.getSoapCharacterServicePort();
        String ma = "B23DCCN322";
        String qCode = "T4n5RwHT";
        
        List<Integer> list = p.requestCharacter(ma,qCode);
        int timeRot = list.get(0) % list.size();
        Collections.rotate(list, timeRot);
        p.submitCharacterCharArray(ma,qCode,list);
    }
}
