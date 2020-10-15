import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private List<Student> students = new ArrayList<>();

    public Teacher(String name) {
        super(name);
    }

    public void add(Student student) {
        students.add(student);
    }
}
