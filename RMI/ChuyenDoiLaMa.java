/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.util.*;
import java.rmi.registry.*;
/**
 *
 * @author ASUS
 */
public class ChuyenDoiLaMa {        
    public static void main(String[] args)throws Exception{
        Registry rg = LocateRegistry.getRegistry("36.50.135.242",1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String ma = "B23DCCN322";
        String qCode = "GAHAaOhU";
        String s = sv.requestCharacter(ma, qCode);
        
        String rm = "";
        Integer dec = Integer.parseInt(s);
        int [] tp = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] lm = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0;i<tp.length;i++){
            if(dec >= tp[i]){
                rm+= lm[i];
                dec-= tp[i];
            }
        }
        sv.submitCharacter(ma, qCode, rm);
    }
}
