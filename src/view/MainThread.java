/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StudentController;
import entity.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import model.StudentModel;

/**
 *
 * @author xuanhung
 */
public class MainThread {

    public static void main(String[] args) throws SQLException {
        generateMenu();
    }

    public static void generateMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        StudentModel model = new StudentModel();
//        StudentController studentController = new StudentController();        
        while (true) {
            System.out.println("Quản lý sinh viên");
            System.out.println("------------------");
            System.out.println("1. Thêm mới.");
            System.out.println("2. Hiển thị danh sách.");
            System.out.println("3. Sửa thông tin sinh viên.");
            System.out.println("5. Thoát.");
            System.out.println("-------------------");
            System.out.println("Vui lòng nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Thêm mới sinh viên.");
                    StudentController controller = new StudentController();
                    Student student = controller.getStudentInformation();
                    model.save(student);
                    System.out.println("Thêm mới sinh viên thành công.");
                    break;
                case 2:
                    System.out.println("Hiển thị danh sách sinh viên.");
                    ArrayList<Student> listStudent = model.query();
                    System.out.printf("%-12s %-12s %-12s \n", "ID", "Name", "Roll Number");
                    System.out.println("---------------------------------");
                    for (int i = 0; i < listStudent.size(); i++) {
                        Student stu = listStudent.get(i);
                        System.out.printf("%-12s %-12s %-12s \n", stu.getId(), stu.getName(), stu.getRollNumber());
                    }
                    break;
                case 3:
                    System.out.println("Vui lòng nhập id sinh viên: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();
                    Student existStudent = model.queryById(studentId);
                    if(existStudent == null){
                        System.err.println("Sinh viên không tồn tại hoặc đã bị xoá.");
                        break;
                    }
                    System.out.println("Tồn tại sinh viên với thông tin: ");
                    System.out.println("Tên: " + existStudent.getName());
                    System.out.println("Mã sinh viên: " + existStudent.getRollNumber());
                    System.out.println("Vui lòng nhập tên mới cho sinh viên: ");
                    String name = scanner.nextLine();
                    System.out.println("Vui lòng nhập mã sinh viên mới: ");
                    String rollNumber = scanner.nextLine();
                    
                    Student st = new Student(name, rollNumber);
                    
                    model.update(studentId, st);
                    break;
                case 5:
                    System.out.println("Bye bye.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn sai.");
                    break;
            }
        }
    }

}
