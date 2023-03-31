package bai_tap.bai2;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        try {
            // Yêu cầu người dùng cung cấp tên tệp nguồn và tên tệp đích
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nhập tên tệp nguồn: ");
            String sourceFileName = reader.readLine();
            System.out.println("Nhập tên tệp đích: ");
            String targetFileName = reader.readLine();

            // Mở các luồng đầu vào và đầu ra
            InputStream inputStream = new FileInputStream(sourceFileName);
            OutputStream outputStream = new FileOutputStream(targetFileName);

            // Sao chép dữ liệu từ tệp nguồn đến tệp đích
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Đóng các luồng
            inputStream.close();
            outputStream.close();

            // Hiển thị thông báo thành công và số byte trong tệp đích
            File targetFile = new File(targetFileName);
            System.out.println("Đã sao chép tệp " + sourceFileName + " sang " + targetFileName);
            System.out.println("Kích thước của tệp " + targetFileName + " là " + targetFile.length() + " byte.");
        } catch (FileNotFoundException e) {
            System.out.println("Tệp nguồn không tồn tại.");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi sao chép tệp.");
        }
    }
}

