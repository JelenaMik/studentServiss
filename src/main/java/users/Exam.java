package users;

public class Exam {

    public Course course;


    public Exam(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Exam{" +
                ", course=" + course +
                '}';
    }
}
