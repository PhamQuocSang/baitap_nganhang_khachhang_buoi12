package Buoi12_BTNganHangVaKhachHang2;

import Bank.Bank;
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
    static ArrayList<NHHSBC> listBank = new ArrayList<NHHSBC>();
    static ArrayList<NHShinHan> listBank2 = new ArrayList<NHShinHan>();

    public static void main(String[] args) {
        KhachHangController cc = new KhachHangController();
        while (true) {
            NHShinHan nhShinHan = new NHShinHan();
            NHHSBC nhhsbc = new NHHSBC();
            System.out.println("_________________________________________");
            System.out.println("Chọn một trong các phương thức hành động sau: \n1. Thêm khách hàng HSBC \n2. Hiển thị khách hàng HSBC \n3. Thực hiện giao dịch HSBC");
            System.out.println("\n4. Thêm khách hàng ShinHan \n5. Hiển thị khách hàng ShinHan \n6. Thực hiện giao dịch ShinHan \n\n7. Hiển thị danh sách khách hàng của cả 2 ngân hàng");
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
                case "4":
                    nhShinHan.themKhachHangSHINHAN();
                    break;
                case "5":
                    nhShinHan.hienThiKhachHangSHINHAN();
                    break;
                case "6":
                    nhShinHan.thucHienChuyenTien2();
                    break;
                case "7":
                    nhhsbc.hienThiKhachHangHSBC();
                    nhShinHan.hienThiKhachHangSHINHAN();
                    break;
                default:
                    break;
            }
        }
    }
}
