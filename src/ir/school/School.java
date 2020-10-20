package ir.school;

import ir.school.entity.Student;
import ir.school.entity.Teacher;
import ir.school.exception.NameFormatException;
import ir.school.exception.PersonNotFoundException;
import ir.school.reader.Reader;
import ir.school.validator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class School {
    List<Student> studentList;
    List<Teacher> teacherList;

    public Student findStudentByName(String name) throws PersonNotFoundException {
        for (Student studentIem : studentList) {
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
        String studentFileAddress = "./school/students.txt";
        String teacherFileAddress = "./school/teachers.txt";
        String teacherStudentFileAddress = "./school/TeachersStudentsAssigner.txt";
        Reader reader = new Reader();
        studentList = createStudentFromFile(reader.readFile(studentFileAddress));
        teacherList = createTeacherFromFile(reader.readFile(teacherFileAddress));
        assign(reader.readFile(teacherStudentFileAddress));
    }

    private void assign(ArrayList<String> teacherStudentNames) {
        for (int i = 0; i < teacherStudentNames.size() - 1; i++) {
            try {
                String[] strings = teacherStudentNames.get(i).split(" ");
                String studentName = strings[0];
                String teacherName = strings[1];
                if (NameValidator.getInstance().validateName(studentName) && NameValidator.getInstance().validateName(teacherName)) {
                    Student student = findStudentByName(studentName);
                    Teacher teacher = findTeacherByName(teacherName);
                    assignTeacherToStudent(student, teacher);
                }
            } catch (NameFormatException | PersonNotFoundException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private List<Student> createStudentFromFile(List<String> studentsName) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentsName.size() - 1; i++) {
            try {
                if (NameValidator.getInstance().validateName(studentsName.get(i))) {
                    Student student = new Student(studentsName.get(i).trim());
                    students.add(student);
                }
            } catch (NameFormatException e) {
                System.out.println(e);
            }
        }
        return students;
    }

    private List<Teacher> createTeacherFromFile(List<String> teachersName) {
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < teachersName.size() - 1; i++) {
            try {
                if (NameValidator.getInstance().validateName(teachersName.get(i))) {
                    Teacher teacher = new Teacher(teachersName.get(i).trim());
                    teachers.add(teacher);
                }
            } catch (NameFormatException e) {
                System.out.println(e);
            }
        }
        return teachers;
    }

    public static void main(String[] args) {
        School school = new School();
        school.run();
    }

}
