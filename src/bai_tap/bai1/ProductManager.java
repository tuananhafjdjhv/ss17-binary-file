package bai_tap.bai1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProductManager {
    // Đường dẫn tới file lưu trữ thông tin sản phẩm
    private static final String FILE_PATH = "C:\\Users\\Thu Nguyen\\Desktop\\full\\ss17_binary_file_serialization\\src\\bai_tap\\bai1\\products.txt";

    // Hàm thêm thông tin sản phẩm vào file
    public static void addProduct() {
        try {
            FileWriter writer = new FileWriter(FILE_PATH, true);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Mã sản phẩm: ");
            String code = scanner.nextLine();
            System.out.print("Tên sản phẩm: ");
            String name = scanner.nextLine();
            System.out.print("Hãng sản xuất: ");
            String brand = scanner.nextLine();
            System.out.print("Giá: ");
            double price = scanner.nextDouble();

            writer.write(code + "," + name + "," + brand + "," + price + "\n");
            writer.close();

            System.out.println("Đã thêm sản phẩm thành công");
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // Hàm hiển thị danh sách sản phẩm
    public static void showProducts() {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                System.out.println("Mã sản phẩm: " + tokens[0]);
                System.out.println("Tên sản phẩm: " + tokens[1]);
                System.out.println("Hãng sản xuất: " + tokens[2]);
                System.out.println("Giá: " + tokens[3]);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    // Hàm tìm kiếm sản phẩm theo mã
    public static void searchProduct() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập mã sản phẩm: ");
            String code = scanner.nextLine();

            File file = new File(FILE_PATH);
            Scanner fileScanner = new Scanner(file);
            boolean found = false;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] tokens = line.split(",");
                if (tokens[0].equals(code)) {
                    System.out.println("Mã sản phẩm: " + tokens[0]);
                    System.out.println("Tên sản phẩm: " + tokens[1]);
                    System.out.println("Hãng sản xuất: " + tokens[2]);
                    System.out.println("Giá: " + tokens[3]);
                    System.out.println();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Không tìm thấy sản phẩm");
            }
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    // Hàm chính để chạy chương trình
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm theo mã");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Kết thúc chương trình");
                    return;
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProducts();
                    break;
                case 3:
                    searchProduct();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }
    }
}
