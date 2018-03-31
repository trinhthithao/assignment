/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Student;
import java.util.Scanner;

/**
 *
 * @author xuanhung
 */
public class StudentController {
    
    public Student getStudentInformation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.println("Vui lòng nhập mã sinh viên: ");
        String rollNumber = scanner.nextLine();
        Student student = new Student(name, rollNumber);
        return student;
    }
    
}
