import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentReader {
    public List<Student> readStudentsFile() {
        File file = new File("./school/students.txt");
        String nextLine;
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            nextLine = reader.readLine();
            while (nextLine != null) {
                try {
                    if (NameValidator.getInstance().validateName(nextLine)) {
                        Student student = new Student(nextLine.trim());
                        students.add(student);
                    }
                } catch (NameFormatException e) {
                    System.out.println(e);
                }
                nextLine = reader.readLine();
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return students;
    }
}
