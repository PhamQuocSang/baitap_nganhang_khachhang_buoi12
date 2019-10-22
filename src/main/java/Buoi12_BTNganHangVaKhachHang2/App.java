package Buoi12_BTNganHangVaKhachHang2;

import Bank.NHHSBC;
import Bank.NHShinHan;
import KhachHang.KhachHang;
import KhachHang.KhachHangController;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();

    public static void main(String[] args) {
        KhachHangController cc = new KhachHangController();
        while (true) {
            NHShinHan nhShinHan = new NHShinHan();
            NHHSBC nhhsbc = new NHHSBC();
            System.out.println("_________________________________________");
            System.out.println("Chọn một trong các phương thức hành động sau: \n1. Thêm khách hàng HSBC \n2. Hiển thị khách hàng HSBC \n3. Thực hiện giao dịch");
            System.out.println("_________________________________________");
            System.out.print("Chọn: ");
            String s = scanner.nextLine();
            switch (s) {
                case "1":

                    nhhsbc.themKhachHangHSBC();
                    break;

                case "2":
                    nhhsbc.hienThiKhachHangHSBC();
                    break;

                case "3":
//                    nhhsbc.thucHienChuyenTien();
                    nhhsbc.thucHienChuyenTien2();
                    break;

                default:
                    break;
            }
        }
    }
}
