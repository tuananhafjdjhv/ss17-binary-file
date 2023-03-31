package thuc_hanh.bai2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        String PATH_FILE = "C:\\Users\\Thu Nguyen\\Desktop\\full\\ss17_binary_file_serialization\\src\\thuc_hanh\\bai2\\file.txt";
        students.add(new Student(1, "Trịnh Đức Toàn", "Hà Nội"));
        students.add(new Student(2, "Lê Việt Dũng", "Phú Thọ"));
        students.add(new Student(3, "Phùng Trung Dũng", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Đồng Chính", "Hải Dương"));
        writeToFile(PATH_FILE,students);
        List<Student> studentDataFromFile = readDataFromFile("text.txt");
        for (Student student:studentDataFromFile) {
            System.out.println(student);
        }

    }

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream oos = new ObjectInputStream(fis);
            students = (List<Student>) oos.readObject();
            oos.close();
            fis.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

}
