/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.util.*;
import java.net.*;
import java.rmi.registry.*;
/**
 *
 * @author ASUS
 */
public class GiaTriTBDoLechChuanPhanVi95 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("36.50.135.242",1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String ma = "B23DCCN322";
        String qCode = "qhjHaYXl";
        Object obj = sv.requestData(ma, qCode);
        String csvData = (String ) obj;
        String[] tokens = csvData.split(",");
        List<Double> s = new ArrayList<>();
        for (String token : tokens) {
            double val = Double.parseDouble(token.trim());
            s.add(val); 
        }  
        int n = s.size();
        double tb = 0;
        double dolechchuan = 0;
        double tong = 0;
        for(double x : s) {
            tong+= x;
        }
        tb = tong/n;
        double phuongsai = 0;
        for(double x : s){
            phuongsai+= (x - tb) * (x-tb);
        }
        phuongsai /= n;
        dolechchuan = Math.sqrt(phuongsai);
        Collections.sort(s);
        int p95Index = (int) Math.ceil(n * 0.95) - 1;
        double p95 = s.get(p95Index);
        
        String ans = String.format(Locale.US, "average=%.2f;stddev=%.2f;p95=%.2f", tb, dolechchuan, p95);
        sv.submitData(ma, qCode, ans);
    }
}
