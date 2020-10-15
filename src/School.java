import java.util.List;
import java.util.Optional;

public class School {
    List<Student> studentLis;
    List<Teacher> teacherList;

    public List<Student> getStudentLis() {
        return studentLis;
    }

    public void setStudentLis(List<Student> studentLis) {
        this.studentLis = studentLis;
    }

    public List<Teacher> getTeachers() {
        return teacherList;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teacherList = teachers;
    }

    public Student findStudentByName(String name) throws PersonNotFoundException {
        for (Student studentIem : studentLis) {
            if (studentIem.getName().equals(name)) {
                return studentIem;
            }
        }
        throw new PersonNotFoundException("Student \"" + name + "\" not found");

    }

    public Teacher findTeacherByName(String name) throws PersonNotFoundException {
        for (Teacher teacherIem : teacherList) {
            if (teacherIem.getName().equals(name)) {
                return teacherIem;
            }
        }
        throw new PersonNotFoundException("Teacher \"" + name + "\" not found");
    }

    public void assignTeacherToStudent(Student student, Teacher teacher) {
        teacher.add(student);
        student.setTeacher(teacher);
    }

    public void run() {
        StudentReader studentReader = new StudentReader();
        TeacherReader teacherReader = new TeacherReader();
        StudentTeacherAssigner studentTeacherAssigner = new StudentTeacherAssigner();
        studentLis = studentReader.readStudentsFile();
        teacherList = teacherReader.readTeachersFile();
        studentTeacherAssigner.assign(this);
    }

    public static void main(String[] args) {
        School school = new School();
        school.run();
    }
}
