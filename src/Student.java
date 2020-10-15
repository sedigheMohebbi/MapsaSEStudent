public class Student extends Person {

    private Teacher teacher;

    public Student(String name) {
        super(name);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
