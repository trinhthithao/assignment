/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author xuanhung
 */
public class Student {

    private int id;
    private String name;
    private String rollNumber;

    public Student(int id, String name, String rollNumber) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public Student() {

    }

    public static Student getStudentInstance() {
        Student st = new Student();
        return st;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", rollNumber=" + rollNumber + '}';
    }

}
