package RMI;
import java.rmi.registry.*;
public class LaMaSangThapPhan {
    public static long trans(char c){
        if (c == 'I') return 1;
        else if (c=='V') return 5;
        else if (c=='X') return 10;
        else if (c=='L') return 50;
        else if (c=='C') return 100;
        else if (c=='D') return 500;
        else return 1000;
    }
    public static long solve(String s){
        long tong  = 0;
        tong += trans(s.charAt(s.length()-1));
        for(int i = s.length() - 2;i>=0;i--){
            if(trans(s.charAt(i+1)) > s.charAt(i)){
                tong -= trans(s.charAt(i));
            } else {
                tong += trans(s.charAt(i));
            }
        }
        return tong;
    }
    public static void main(String [] args) throws Exception{
        Registry r = LocateRegistry.getRegistry("localhost",1099);
        CharacterService sv = (CharacterService) r.lookup("RMICharacterService");
        String ma = "B23DCCN322";
        String qCode = "6g7J8k9L";
        String s = sv.requestCharacter(ma,qCode);
        long res = solve(s);
        sv.submitCharacter(ma,qCode,res+"");
    }
}
