package users;

public class Exam {

    public Course course;


    public Exam(Course course) {
        this.course = course;
    }

    public Exam() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Exam{" +
                ", course=" + course +
                '}';
    }
}
