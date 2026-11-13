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
public class SapXepTheoMuc {
    public static int getPriority(String s){
        if(s.startsWith("ERROR")) return 1;
        if(s.startsWith("WARN")) return 2;
        if(s.startsWith("INFO")) return 3;
        return 4;
    }
    public static void main(String[] args) throws Exception{
        CharacterService service = new CharacterService();
        SoapCharacterService p = service.getSoapCharacterServicePort();
        String ma = "B23DCCN322";
        String qCode = "lzsn7zjI";
        List<String> list = p.requestStringArray(ma,qCode);
        List<String> res = new ArrayList<>();
        for(String line: list){
            String masked = line.replaceAll("email=\\S+", "email=[EMAIL]").replaceAll("phone=\\S+", "phone=[PHONE]").replaceAll("token=\\S+", "token=[TOKEN]");
            res.add(masked);
        }
        Collections.sort(res, new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                return getPriority(s1) - getPriority(s2);
            }
        });  
        p.submitStringArray(ma,qCode,res);
    }
}
