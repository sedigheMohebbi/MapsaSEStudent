package ir.school;

import ir.school.entity.Student;
import ir.school.entity.Teacher;
import ir.school.exception.PersonNotFoundException;
import ir.school.reader.StudentReader;
import ir.school.reader.StudentTeacherAssigner;
import ir.school.reader.TeacherReader;

import java.util.List;

public class School {
    List<Student> studentLis;
    List<Teacher> teacherList;

    public Student findStudentByName(String name) throws PersonNotFoundException {
        for (Student studentIem : studentLis) {
            if (studentIem.getName().equals(name)) {
                return studentIem;
            }
        }
        throw new PersonNotFoundException("ir.school.entity.Student \"" + name + "\" not found");

    }

    public Teacher findTeacherByName(String name) throws PersonNotFoundException {
        for (Teacher teacherIem : teacherList) {
            if (teacherIem.getName().equals(name)) {
                return teacherIem;
            }
        }
        throw new PersonNotFoundException("ir.school.entity.Teacher \"" + name + "\" not found");
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
