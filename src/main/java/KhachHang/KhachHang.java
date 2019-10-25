package KhachHang;

public class KhachHang {
    private String maKH, tenKH;
    private int level;
    private double soDuTaiKhoan;
    private double soTienChuyen;

    public double getSoTienChuyen() {
        return soTienChuyen;
    }

    public void setSoTienChuyen(double soTienChuyen) {
        this.soTienChuyen = soTienChuyen;
    }



    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getSoDuTaiKhoan() {
        return soDuTaiKhoan;
    }

    public void setSoDuTaiKhoan(double soDuTaiKhoan) {
        this.soDuTaiKhoan = soDuTaiKhoan;
    }



    @Override
    public String toString() {
        return "Khách Hàng {" +
                "Mã ID: " + maKH +
                ", Họ tên: " + tenKH +
                ", Level = " + level +
                ", Số dư tài khoản: " + soDuTaiKhoan +
                '}';
    }
}
