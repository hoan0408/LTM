import java.util.*;

class SinhVien{
    private String ma,ten,sdt;
    private int index;
    public SinhVien(String ma,String ten,String sdt,int index){
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.index = index;
    }
    @Override 
    public String toString(){
        return ma + " " + ten + " " + sdt;
    }
    public int getIndex(){
        return index;
    }
}

public class songuyentotrongfile{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<SinhVien> ds = new ArrayList<>();
        for(int i = 0;i<n;i++){
            sc.nextLine();
            ds.add(new SinhVien(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextInt()));
        }
        sc.nextLine();
        String [] th = new String[m + 1];
        for(int i = 1;i<=m;i++){
            th[i] = sc.nextLine();
        }
        
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            int cnt = sc.nextInt();
            System.out.println("DANH SACH NHOM " + cnt + " ");
            for(SinhVien x : ds){
                if(x.getIndex() == cnt){
                    System.out.println(x);
                }
            }
            System.out.println("Bai tap dang ky: " + th[cnt]);
        }
    }
}