/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.rmi.registry.*;
import java.util.*;
import java.net.*;
/**
 *
 * @author ASUS
 */
public class MaHoaURL {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("36.50.135.242",1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String ma = "B23DCCN322";
        String qCode = "NNZGuPGZ";
        String s = sv.requestCharacter(ma, qCode);
        
        URI uri = new URI(null,null,s,null);
        String ans = uri.toASCIIString();
        sv.submitCharacter(ma, qCode, ans);
    }
}
