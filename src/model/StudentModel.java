/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.ResultSetImpl;
import entity.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author xuanhung
 */
public class StudentModel {

    public void save(Student student) throws SQLException {
        Connection cnn
                = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata_demo?useUnicode=true&characterEncoding=utf-8", "root", "");
        Statement stt = cnn.createStatement();
        stt.execute("INSERT INTO students (name, rollNumber) VALUES ('"
                + student.getName() + "', '"
                + student.getRollNumber() + "');");
    }

    public ArrayList<Student> query() throws SQLException {
        ArrayList<Student> listStudent = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata_demo?useUnicode=true&characterEncoding=utf-8", "root", "");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("Select * from students");
        while (resultset.next()) {
            int id = resultset.getInt("id");            
            String name = resultset.getString("name");            
            String rollNumber = resultset.getString("rollNumber");            
            Student student = new Student(id, name, rollNumber);
            listStudent.add(student);
        }
        return listStudent;
    }
    
    public Student queryById(int id) throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata_demo?useUnicode=true&characterEncoding=utf-8", "root", "");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("select * from students where id = " + id);
        if(resultset.next()){
            int studentId = resultset.getInt("id");            
            String name = resultset.getString("name");            
            String rollNumber = resultset.getString("rollNumber");            
            Student student = new Student(studentId, name, rollNumber);
            return student;
        }
        return null;
    }

    public void update(int id, Student student) throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata_demo?useUnicode=true&characterEncoding=utf-8", "root", "");
        Statement statement = connection.createStatement();
        statement.execute("update students set name = '" 
                + student.getName() + "', rollNumber = '" + student.getRollNumber() + "' WHERE id = " + id);
    }
    
    
    public void delete(){
    
    }
        
}
