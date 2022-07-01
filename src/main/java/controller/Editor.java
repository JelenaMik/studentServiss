package controller;

import users.Course;
import users.Student;
import users.Teacher;

import javax.swing.*;
import java.util.ArrayList;

public class Editor {

    public Editor() {
    }

    private ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Teacher> teachers = new ArrayList<>();
    public ArrayList<Course> courses = new ArrayList<>();

    public void addStudent(){
        String name = JOptionPane.showInputDialog(null, "Enter student name!");
        String id = JOptionPane.showInputDialog(null, "Enter student id!");
        Student student  = new Student(name, id);
        students.add(student);
    }

    public void seeAllStudents(){
        for(Student x: students){
            System.out.println(x);
        }
    }

    public void editStudent(){
        Student editStudent= selectStudent();
        String newName = JOptionPane.showInputDialog(null, "Enter student new Name");
        String newId= JOptionPane.showInputDialog(null, "Enter student new Id");
        editStudent.setId(newId);
        editStudent.setName(newName);
        JOptionPane.showMessageDialog(null,"Student data was edited!" );
    }

    public void removeStudent() {
        Student removeStudent= selectStudent();
        this.students.remove(removeStudent);
    }

    public void addTeacher(){
        String name = JOptionPane.showInputDialog(null, "Enter teacher name!");
        String id = JOptionPane.showInputDialog(null, "Enter teacher id!");
        Teacher teacher  = new Teacher(name, id);
        teachers.add(teacher);
    }

    public void seeAllTeachers(){
        for(Teacher x: teachers){
            System.out.println(x);
        }
    }

    public void editTeacher(){
        Teacher editTeacher= selectTeacher();
        String newName = JOptionPane.showInputDialog(null, "Enter teacher's new Name");
        String newId= JOptionPane.showInputDialog(null, "Enter teacher's new Id");
        editTeacher.setId(newId);
        editTeacher.setName(newName);
        JOptionPane.showMessageDialog(null,"Teacher data was edited!" );
    }

    public void removeTeacher() throws Exception{
        Teacher removeTeacher= selectTeacher();
        this.teachers.remove(removeTeacher);
    }

    public void addCourse() throws Exception {
        Course course = new Course();
        String name = JOptionPane.showInputDialog(null, "Enter course name!");
        course.setName(name);
        Teacher courseTeacher= selectTeacher();
        course.setTeacher(courseTeacher);

        int input = 5;
        do{
            Student courseStudent= selectStudent();
            course.getStudentsList().add(courseStudent);
            input = JOptionPane.showConfirmDialog(null, "Do you want to add another student?");
        }while(input==0);
        courses.add(course);
    }

    public void removeCourse() {
        Course courseToRemove= selectCourse();
        this.courses.remove(courseToRemove);
    }

    public void editCourse() throws Exception {
        Course editCourse = selectCourse();
        String name = JOptionPane.showInputDialog(null, "Enter new course name!");
        editCourse.setName(name);
        Teacher newCourseTeacher= selectTeacher();
        editCourse.setTeacher(newCourseTeacher);
    }

    public void seeCourse(){
        Course seeCourse = selectCourse();
        System.out.println(
                "Course{" + "name='" + seeCourse.getName() + '\'' +
                        ", teacher=" + seeCourse.getTeacher() +  '}'
        );
        System.out.println("Course student list: ");
        for (Student student: seeCourse.getStudentsList()){
            System.out.println(student);
        }
    }

    public Course selectCourse(){
        Course course = (Course) JOptionPane.showInputDialog(
                null, "Course", "Select course: ",
                JOptionPane.QUESTION_MESSAGE,null,
                this.courses.toArray(),  this.courses.toArray()[0]
        );
        return course;
    }


    public Student selectStudent(){
        Student student= (Student) JOptionPane.showInputDialog(
                null,"Student ",
                "Select student: ", JOptionPane.QUESTION_MESSAGE,  null,
                this.students.toArray(), this.students.toArray()[0]
        );
        return student;
    }

    public Teacher selectTeacher(){
        Teacher teacher= (Teacher) JOptionPane.showInputDialog(
                null,"Teacher: ","Select teacher: ",
                JOptionPane.QUESTION_MESSAGE,null,
                this.teachers.toArray(), this.teachers.toArray()[0]
        );
        return teacher;
    }
}
