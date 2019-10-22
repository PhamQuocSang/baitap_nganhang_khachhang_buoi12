package Bank;

import KhachHang.KhachHang;
import KhachHang.KhachHangController;


import java.util.ArrayList;
import java.util.Scanner;

public class NHShinHan extends Bank{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<KhachHang> listKhachHangSHINHAN = new ArrayList<KhachHang>();
    KhachHangController khachHangController = new KhachHangController();
    public NHShinHan() {
        setMaNH("NHShinHan");
        setTenNH("Ngân hàng ShinHan");
        setLaiSuat(0.8f);
    }

    public void themKhachHangSHINHAN() {
        khachHangController = new KhachHangController();
        khachHangController.themKhachHang(listKhachHangSHINHAN);
    }

    public void hienThiKhachHangSHINHAN() {
        for (KhachHang nh : listKhachHangSHINHAN
        ) {
            System.out.println(nh.toString());
        }
    }
}
