import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeacherReader {
    public List<Teacher> readTeachersFile() {
        File file = new File("./school/teachers.txt");
        String nextLine;
        ArrayList<Teacher> teachers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            nextLine = reader.readLine();
            while (nextLine != null) {
                try {
                    if (NameValidator.getInstance().validateName(nextLine)) {
                        Teacher teacher = new Teacher(nextLine.trim());
                        teachers.add(teacher);
                    }
                } catch (NameFormatException e) {
                    System.out.println(e);
                }
                nextLine = reader.readLine();
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return teachers;
    }
}
