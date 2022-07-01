package users;

import controller.Editor;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Course{

    Editor editor = new Editor();


    public String name;
    public Teacher teacher;
    private ArrayList<Student> studentsList = new ArrayList<>();

    public Course(String name, Teacher teacher, ArrayList<Student> studentsList) {
        this.name = name;
        this.teacher = teacher;
        this.studentsList = studentsList;
    }



    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }


}
