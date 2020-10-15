public class Student extends Person {

    private Teacher teacher;

    public Student(String name) {
        super(name);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


}
