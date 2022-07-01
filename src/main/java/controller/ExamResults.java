package controller;

import users.Course;
import users.Exam;
import users.Student;

import javax.swing.*;
import java.util.ArrayList;

public class ExamResults {

    public Editor editor;
    private ArrayList<Exam> exams = new ArrayList<>();

    public ExamResults(Editor editor, ArrayList<Exam> exams) {
        this.editor = editor;
        this.exams = exams;
    }

    public ExamResults(Editor editor) {
        this.editor = editor;
    }

    public ExamResults() {
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    public void createExam(){
        Course examCourse = (Course) JOptionPane.showInputDialog(
                null,
                "Select course",
                "Exam on ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                editor.courses.toArray(),
                editor.courses.toArray()[0]
        );
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
            Student updateStudent = (Student) JOptionPane.showInputDialog(
                    null,
                    "Select student",
                    "Change grade ",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    currentStudentList.toArray(),
                    currentStudentList.toArray()[0]
            );
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
