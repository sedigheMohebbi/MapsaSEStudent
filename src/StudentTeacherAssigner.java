import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StudentTeacherAssigner {
    public void assign(School school) {
        File file = new File("./school/TeachersStudentsAssigner.txt");
        String nextLine;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            nextLine = reader.readLine();
            while (nextLine != null) {
                try {
                    String[] strings = nextLine.split(" ");
                    String studentName = strings[0];
                    String teacherName = strings[1];
                    if (NameValidator.getInstance().validateName(studentName) && NameValidator.getInstance().validateName(teacherName)) {
                        Student student = school.findStudentByName(studentName);
                        Teacher teacher = school.findTeacherByName(teacherName);
                        school.assignTeacherToStudent(student, teacher);
                    }
                } catch (NameFormatException | PersonNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                nextLine = reader.readLine();
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
