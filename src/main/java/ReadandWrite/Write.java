package ReadandWrite;

import KhachHang.KhachHang;

import java.io.*;
import java.util.ArrayList;

public class Write {


//    ArrayList<KhachHang> list = new ArrayList<KhachHang>();
    public void GhiDuLieuKhach(String path, ArrayList<KhachHang> list ) {
        int count = 0;
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (KhachHang nh: list
        ) {
            if(nh.getLevel()==1)
            {
                count++;
                try {
                    fw.write(String.valueOf(nh) +"\n");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ghi thành công, có " + count + " khách hàng lv1");


    }

    public void DocDuLieuKhach(String path){

        try {
            FileReader f = new FileReader(path);
            //đọc dc từng dòng trong file của mình, nhưng k lưu dc dòng đó.
            BufferedReader bufferedReader = new BufferedReader(f);//
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null)
            {
                sb.append(line);
                sb.append("\n");
            }
            System.out.println(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println("Đường dẫn sai");
        } catch (IOException e) {
            System.out.println("Không đọc dc dữ liệu");
        }
    }
}
