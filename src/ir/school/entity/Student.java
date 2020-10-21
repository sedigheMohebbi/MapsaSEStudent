package ir.school.entity;

public class Student extends Person {
    private boolean passed;

    private Teacher teacher;

    public Student(String name) {
        super(name);
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
public String toString(){
        return super.toString()+" "+ isPassed();
}
    public Teacher getTeacher() {
        return teacher;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
