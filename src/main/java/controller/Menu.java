package controller;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class Menu {

    private ExamResults results = new ExamResults();

    public Menu(){
        this.results.setEditor(new Editor());
    }

    public Menu(Editor editor){
        this.results.setEditor(editor);
    }

    public void start() throws Exception {
        try{
                String input = JOptionPane.showInputDialog(null, """
                Write the corresponding number
                
                1. Add student
                2. See all students 
                3. Update student data
                4. Remove student
                5. Add teacher
                6. See all teachers 
                7. Update teacher data
                8. Remove teacher
                9. Add course
                10. See course
                11. Update course
                12. Remove course
                13. Create exam
                14. Enter exam grades
                15. Upgrade Exam grades
                16. See exam results
                17. Close/Exit
                """);


            switch (input){
                case "1":
                    results.getEditor().addStudent();
                    break;
                case "2":
                    results.getEditor().seeAllStudents();
                    break;
                case "3":
                    results.getEditor().editStudent();
                    break;
                case "4":
                    results.getEditor().removeStudent();
                    break;
                case "5":
                    results.getEditor().addTeacher();
                    break;
                case "6":
                    results.getEditor().seeAllTeachers();
                    break;
                case "7":
                    results.getEditor().editTeacher();
                    break;
                case "8":
                    results.getEditor().removeTeacher();
                    break;
                case "9":
                    results.getEditor().addCourse();
                    break;
                case "10":
                    results.getEditor().seeCourse(); //add to see studentList
                    break;
                case "11":
                    results.getEditor().editCourse();
                    break;
                case "12":
                    results.getEditor().removeCourse();
                    break;
                case "13":
                    results.createExam();
                    break;
                case "14":
                    results.enterGrades();
                    break;
                case "15":
                    results.updateGrades();
                    break;
                case "16":
                    results.seeExamResults();
                    break;
                case "17":
                    System.exit(0);


                default:
                    JOptionPane.showMessageDialog(null, "Please select valid entry");
                    break;

            }

        }catch (Exception e){
            System.out.println(e);
        }


        start();

    }



}

