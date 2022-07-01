package controller;

import users.Course;
import users.Exam;
import users.Student;

import javax.swing.*;
import java.util.ArrayList;

public class ExamResults {

    public Editor editor;
    private ArrayList<Exam> exams = new ArrayList<>();

    public ExamResults() {
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public void createExam(){
        Course examCourse = getEditor().selectCourse();
        Exam exam = new Exam(examCourse);
        exams.add(exam);
    }

    public ArrayList<Student> getStudentList(){
        Exam examGrade = selectExam();
        return examGrade.course.getStudentsList();
    }

public void enterGrades() {
    ArrayList<Student> currentStudentList = getStudentList();
    for (Student student: currentStudentList){
        String studentGrade = JOptionPane.showInputDialog(null, "Enter " + student.name + " grade!" );
        student.setGrade(studentGrade);
    }
    }

    public void updateGrades(){
        ArrayList<Student> currentStudentList = getStudentList();
        int input = 5;
        do{
            Student updateStudent = getEditor().selectStudent();
            updateStudent.setGrade(JOptionPane.showInputDialog(null, "Enter new grade"));
            input = JOptionPane.showConfirmDialog(null, "Do you want to update another student grade?");
        }while(input==0);
    }

    public void seeExamResults(){
        Exam seeExam = selectExam();
        System.out.println("Exam on course " + seeExam.getCourse());
        System.out.println("Exam results: ");
        for (Student student: seeExam.getCourse().getStudentsList()){
            System.out.println("Student name: " + student.name + "; student id: " + student.getId() + "; Grade: " + student.getGrade() );
        }
    }

    public Exam selectExam(){
        Exam exam = (Exam) JOptionPane.showInputDialog(
                null,
                "Select exam to grade",
                "Exam on ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                this.exams.toArray(),
                this.exams.toArray()[0]
        );
        return exam;
    }

}
