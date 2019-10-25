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
            System.out.println("Chọn một trong các phương thức hành động sau: \n1. Thêm khách hàng HSBC \n2. Hiển thị khách hàng HSBC \n3. Thực hiện giao dịch HSBC \n4.Đọc file txt danh sách khách hàng HSBC level 1");
            System.out.println("\n5. Thêm khách hàng ShinHan \n6. Hiển thị khách hàng ShinHan \n7. Thực hiện giao dịch ShinHan \n8.Đọc file txt danh sách khách hàng Shihan level 1\n\n9. Hiển thị danh sách khách hàng của cả 2 ngân hàng");
            System.out.println("_________________________________________");
            System.out.print("Chọn: ");
            String s = scanner.nextLine();
            switch (s) {
                case "1":

                    nhhsbc.themKhachHangHSBC();
                    break;

                case "2":
                    nhhsbc.hienThiKhachHangHSBC();
                    System.out.println("Bạn có muốn lưu danh sách khách hàng có Level 1 vào file '.txt' không?\n1. Có    2.Không");
                    System.out.print("Chọn: ");
                    String temp = scanner.nextLine();
                    switch (temp) {
                        case "1":
                            System.out.println("Danh sách khách hàng Level 1: ");
                            nhhsbc.GhiDuLieuKhachHSBC();
                            break;
                        case "2":
                            break;
                        default:
                            break;
                    }
                    break;
                case "3":
                    nhhsbc.thucHienChuyenTien2();
                    break;
                case "4":
                    nhhsbc.DocDuLieuHSBC();
                    break;
                case "5":
                    nhShinHan.themKhachHangSHINHAN();
                    break;
                case "6":
                    nhShinHan.hienThiKhachHangSHINHAN();
                    System.out.println("Bạn có muốn lưu danh sách khách hàng có Level 1 vào file '.txt' không?\n1. Có    2.Không");
                    System.out.print("Chọn: ");
                    String temp2 = scanner.nextLine();
                    switch (temp2) {
                        case "1":
                            System.out.println("Danh sách khách hàng Level 1: ");
                            nhShinHan.GhiDuLieuKhachShinhan();
                            break;
                        case "2":
                            break;
                        default:
                            break;
                    }
                    break;
                case "7":
                    nhShinHan.thucHienChuyenTien2();
                    break;
                case "8":
                    nhShinHan.DocDuLieuShinhan();
                    break;
                case "9":
                    nhhsbc.hienThiKhachHangHSBC();
                    nhShinHan.hienThiKhachHangSHINHAN();
                    break;
                default:
                    break;
            }
        }
    }
}
