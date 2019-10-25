package Bank;

import KhachHang.KhachHang;
import KhachHang.KhachHangController;


import java.util.ArrayList;
import java.util.Scanner;

public class NHShinHan extends Bank implements IBankController {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<KhachHang> listKhachHangSHINHAN = new ArrayList<KhachHang>();
    KhachHangController khachHangController = new KhachHangController();

    public NHShinHan() {
        setMaNH("NHShinHan");
        setTenNH("Ngân hàng ShinHan");
        setLaiSuat(0.8f);
    }

    public void themKhachHangSHINHAN() {
        System.out.println("DANH SÁCH KHÁCH HÀNG NGÂN HÀNG SHINHAN: ");
        khachHangController = new KhachHangController();
        khachHangController.themKhachHang(listKhachHangSHINHAN);
    }

    public void hienThiKhachHangSHINHAN() {
        System.out.println("DANH SÁCH KHÁCH HÀNG NGÂN HÀNG SHINHAN: ");
        KhachHangController khachHangController = new KhachHangController();
        khachHangController.hienThiKhachHang(listKhachHangSHINHAN);
    }

    @Override
    public double tinhPhi(double soTienCanChuyen) {
        double phi = 4000 + getLaiSuat() * soTienCanChuyen;

        return phi;
    }

    @Override
    public void thucHienChuyenTien2() {
        boolean timThay = false;
        System.out.print("Nhập id khách: ");
        String s = scanner.nextLine();
        /*
         * KKiểm tra khách hàng giao dịch có tồn tại hay không
         * */
        for (KhachHang khachHang : listKhachHangSHINHAN) {
            if (s.equals(khachHang.getMaKH())) {
                timThay = true;
                System.out.println("─────── ĐANG TIẾN HÀNH GIAO DỊCH ───────");
                System.out.println("Mã khách hàng: " + khachHang.getMaKH() + "\nTên khách hàng: " + khachHang.getTenKH() + "\nLevel: " + khachHang.getLevel());
                System.out.print("Mời nhập số tiền cần chuyển: ");
                double tienChuyen = scanner.nextDouble();
                scanner.nextLine();
                //Kiểm tra số tiền chuyển, nếu lớn hơn số dư thì không dc chuyển, báo lỗi KHÔNG ĐỦ TIỀN ĐỀ CHUYỂN
                if (khachHang.getSoDuTaiKhoan() >= tienChuyen) {

                    /*chú thích
                     * Cập nhật số dư =  [Số dư tài khoản hiện tại trước khi chuyển] TRỪ cho [Tổng phí chuyển của mỗi ngân hàng và số tiền cần chuyển]
                     */
                    double capNhatSoDuTaiKhoanCuaKhach = khachHang.getSoDuTaiKhoan() - (tinhPhi(tienChuyen) + tienChuyen);

                    //Sau khi kiềm tra số tiền chuyển có hợp lí hay không, tiếp đến là kiểm tra phí giao dịch coi có đủ để giao dịch hay không
                    //Nếu không đủ tiền trả phí giao dịch của HSBC thì báo lỗi KHÔNG ĐỦ TIỀN ĐỂ TRẢ PH1I GIAO DỊCH + thông báo chi tiết thiếu bao nhiêu)
                    if (khachHang.getSoDuTaiKhoan() >= (tinhPhi(tienChuyen) + tienChuyen)) {
                        System.out.print("Mã id khách hàng nhận tiền giao dịch: ");
                        String a = scanner.nextLine();
                        boolean timThay2 = false;
                        //kiểm tra khách hàng nhận có tồn tại hay không
                        for (KhachHang khachHang2 : listKhachHangSHINHAN) {
                            if (a.equals(khachHang2.getMaKH())) {
                                timThay2 = true;
                                System.out.println("─────── KHÁCH HÀNG NHẬN TỒN TẠI ───────");
                                System.out.println("Mã khách hàng nhận tiền: " + khachHang2.getMaKH() + "\nTên khách hàng nhận tiền: " + khachHang2.getTenKH());
                                double temp = 0;
                                System.out.println("GIAO DỊCH THÀNH CÔNG!");
                                System.out.println("Số tiền trước giao dịch: " + khachHang.getSoDuTaiKhoan());
                                System.out.println("Số tiền cần giao dịch là: " + tienChuyen);
                                System.out.println("Phí giao dịch của HSBC: " + tinhPhi(tienChuyen));
//
                                //điều kiện level:
                                //Level 1: hoàn trả 0% phí giao dịch
                                //Level 2: hoàn trả 20% phí gao dịch
                                //Level 3: hoàn trả 50% phí giao dịch
                                if (khachHang.getLevel() == 2) {
                                    temp = (tinhPhi(tienChuyen) * 0.2d);
                                    System.out.println("Hoàn trả: " + temp + " (Vì khách hàng có mã " + khachHang.getMaKH() + " đạt Level 2: HSBC xin hoàn trả 20% phí giao dịch)");
                                }
                                if (khachHang.getLevel() == 3) {
                                    System.out.println("( Vì khách hàng có mã " + khachHang.getMaKH() + " đạt Level 3: HSBC xin hoàn trả 50% phí giao dịch )");
                                    temp = (tinhPhi(tienChuyen) * 0.5d);
                                    System.out.println("Hoàn trả: " + temp);
                                }
                                System.out.println("[ Số tiền còn lại trong tài khoản sau giao dịch: " + (capNhatSoDuTaiKhoanCuaKhach + temp) + " ]");

                                //cập nhật lại số tiền dư của khách hàng
                                khachHang2.setSoDuTaiKhoan(tienChuyen + khachHang2.getSoDuTaiKhoan());
                                khachHang.setSoDuTaiKhoan(capNhatSoDuTaiKhoanCuaKhach + temp);
                            }
                        }
                    }
                    /*
                     * Số tiền trong tài khoản của khách hàng chuyển không đủ để thực hiện giao dịch hoặc k đủ trả phú giao dịch
                     * */
                    else {
                        System.out.println("────        THÔNG BÁO       ────");
                        System.out.println("Số tiền trong tài khoản khách hàng không đủ để trả tổng chi phí giao dịch của ngân hàng");
                        System.out.println("────    Thông tin chi tiết  ────: ");
                        System.out.println("Số tiền trong tài khoản: " + khachHang.getSoDuTaiKhoan());
                        System.out.println("Số tiền cần chuyển là: " + tienChuyen);
                        System.out.println("Chi phí để chuyển tiền là: " + (tinhPhi(tienChuyen) + tienChuyen));
                        /*
                         * TÍNH TIỀN THIẾU
                         * nhân thêm -1 để số tiền thiếu không bị âm ( vì tiền thiếu = tiền trong tài khoản - tiền giao dịch chắc chắn âm)
                         * */
                        System.out.println("Thiếu: " + (-1 * (khachHang.getSoDuTaiKhoan() - (tinhPhi(tienChuyen) + tienChuyen))));
                    }
                } else {
                    System.out.println("Số dư trong tài khoản của khách hàng không đủ để thực hiện tiền");
                }
            }
        }
        // Khách hàng giao dịch tiền không tồn tại

        if (timThay == false) {
            System.out.println("Không tìm thấy mã id của khách hàng!");
        }
    }
}

