package KhachHang;

import Bank.Bank;

import java.util.ArrayList;
import java.util.Scanner;

public class KhachHangController extends KhachHang implements IKhachHangController {
    static ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
    static Scanner scanner = new Scanner(System.in);
    public static Double s = 0d;


    @Override
    public ArrayList<KhachHang> themKhachHang(ArrayList<KhachHang> listKhachHang) {
//        while (true) {
//            System.out.println("Mời bạn chọn một trong các phương thức sau: \n1.Thêm    2.Thoát");
//            System.out.println("Chọn: ");
//            String temp = scanner.nextLine();
//            if (temp.equals("1")) {
                boolean checkLevel = true;
                KhachHang khachHang = new KhachHang();
                System.out.print("Nhập mã khách hàng: ");
                khachHang.setMaKH(scanner.nextLine());
                System.out.print("Nhập tên khách hàng: ");
                khachHang.setTenKH(scanner.nextLine());



                System.out.print("Nhập level: ");
                khachHang.setLevel(checkNhapSo());


                System.out.print("Nhập số tiền trong tài khoản (số dư): ");
                khachHang.setSoDuTaiKhoan(scanner.nextDouble());
                scanner.nextLine();

                listKhachHang.add(khachHang);
                 s = khachHang.getSoDuTaiKhoan();
//                break;
//
//            }
//        }
        return listKhachHang;
    }

    public int checkNhapSo() {
        int n;
        while (true) {
            String s = scanner.nextLine();
            if (s.trim().equals("")) {
                System.out.println("");
                System.out.println("WARNING: Không được phép nhập chuỗi rỗng!");
                continue;
            } else {
                try {
                    n = Integer.parseInt(s);
                    break;
                } catch (Exception e) {
                    System.out.println("WARNING: Chỉ được phép nhập số!");
                    continue;
                }
            }
        }
        return n;
    }

    @Override
    public ArrayList<KhachHang> hienThiKhachHang(ArrayList<KhachHang> listKhachHang) {

        if (listKhachHang.size() == 0) {
            System.out.println("Hiện không có tồn tại khách hàng nào trong danh sách!");
        } else {
            System.out.println("DANH SÁCH KHÁCH HÀNG: ");
            for (KhachHang khachHang : listKhachHang
            ) {
                System.out.println(khachHang.toString());
            }
        }
        return listKhachHang;
    }

//    public boolean checkTaiKhoan(double soTienChuyen)
//    {
//        KhachHangController khachHangController = new KhachHangController();
//        KhachHang khachHang = new KhachHang();
//        if(soTienChuyen >= khachHangController.s)
//        {
//            return false;
//        }
//        return true;
//    }
//
//    public void checkChuyenTien()
//    {
//        Bank bank = new Bank();
//        KhachHang khachHang = new KhachHang();
//
//        System.out.print("Mời nhập số tiền cần chuyển: ");
//        bank.setSoTienChuyen(scanner.nextDouble());
//        if(checkTaiKhoan(bank.getSoTienChuyen())==true)
//        {
//            System.out.print("Thành cmn công");
//        }
//        else
//        {
//            System.out.print("cc");
//        }
//
//    }
}
