import java.util.*;
public class J06009 {
    static class KhachHang{
        String makh,tenkh,gioitinh,ngaysinh,diachi;
        static int cnt = 1;
        public KhachHang(String tenkh,String gioitinh,String ngaysinh,String diachi){
            this.makh = String.format("KH%03d",cnt++);
            this.tenkh = tenkh;
            this.gioitinh = gioitinh;
            this.ngaysinh = ngaysinh;
            this.diachi = diachi;
        }
    }
    
    static class MatHang{
        String mamh,tenmh,donvitinh;
        int giamua,giaban;
        static int cnt = 1;
        public MatHang(String tenmh,String donvitinh,int giamua,int giaban){
            this.mamh = String.format("MH%03d",cnt++);
            this.tenmh = tenmh;
            this.donvitinh = donvitinh;
            this.giamua = giamua;
            this.giaban = giaban;
        }
    }
    static class HoaDon {
        String mahd;
        KhachHang khachhang;
        MatHang mathang;
        int soluong;
        long thanhtien,loinhuan;
        static int cnt = 1;
        public HoaDon(KhachHang khachhang,MatHang mathang,int soluong){
            this.mahd = String.format("HD%03d",cnt++);
            this.khachhang = khachhang;
            this.mathang = mathang;
            this.soluong = soluong;
            this.thanhtien = (long) soluong * mathang.giaban;
            this.loinhuan = (long) soluong * (mathang.giaban - mathang.giamua);
        }
        @Override
        public String toString(){
            return mahd + " " + khachhang.tenkh + " " + khachhang.diachi + " " +
               mathang.tenmh + " " + soluong + " " + thanhtien + " " + loinhuan;
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        HashMap<String,KhachHang> mapKH = new HashMap<>();
        for(int i = 0;i<t;i++){
            KhachHang x = new KhachHang(sc.nextLine(),sc.nextLine(), sc.nextLine(), sc.nextLine());
            mapKH.put(x.makh,x);
        }
        int m = Integer.parseInt(sc.nextLine());
        HashMap<String,MatHang> mapMH = new HashMap<>();
        for(int i = 0;i<m;i++){
            MatHang x = new MatHang(sc.nextLine(),sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
            mapMH.put(x.mamh,x);
        }
        int n = Integer.parseInt(sc.nextLine());
        List<HoaDon> dsHD = new ArrayList<>();
        for(int i = 0;i<n;i++){
            String line = sc.nextLine();
            String [] parts = line.split("\\s+");
            String maKH = parts[0];
            String maMH = parts[1];
            int soLuong = Integer.parseInt(parts[2]);
            
            HoaDon hd = new HoaDon(mapKH.get(maKH),mapMH.get(maMH),soLuong);
            dsHD.add(hd);
        }
        Collections.sort(dsHD,new Comparator<HoaDon>(){
            @Override
            public int compare(HoaDon h1, HoaDon h2){
                if(h2.loinhuan != h1.loinhuan){
                    return  Long.compare(h2.loinhuan,h1.loinhuan);
                }
                return h1.mahd.compareTo(h2.mahd);
            }
        });
        for (HoaDon hd : dsHD) {
            System.out.println(hd);
        }
    }
}
