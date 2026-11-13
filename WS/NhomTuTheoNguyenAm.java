/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;

import java.util.Collections;
import java.util.Comparator;
import java.util.*;
/**
 *
 * @author ASUS
 */
public class NhomTuTheoNguyenAm {
    public static int dem(String s){
        int cnt = 0;
        String nguyenam = "ueoaiUEOAI";
        for(int  i = 0;i< s.length();i++){
            if(nguyenam.indexOf(s.charAt(i)) != -1){
                cnt+= 1;
            }
        }
        return cnt;
    }
    public static void main(String [] args) throws Exception{
        CharacterService service = new CharacterService();
        SoapCharacterService p = service.getSoapCharacterServicePort();
        String ma = "B23DCCN322";
        String qCode = "XJHCLfS9";
        
        List<String> list = p.requestStringArray(ma,qCode);
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                if(dem(s1) != dem(s2)) return dem(s1) - dem(s2);
                return s1.compareTo(s2);
            }
        });
        
        List<String> ans = new ArrayList<>();
        String gr = list.get(0);
        for(int i = 1;i<list.size();i++){
            if(dem(list.get(i)) == dem(list.get(i-1))){
                gr += "," + list.get(i);
            }
            else{
                ans.add(gr);
                gr = list.get(i);
            }
        }
        ans.add(gr);
        p.submitCharacterStringArray(ma,qCode,ans);
    }
}
