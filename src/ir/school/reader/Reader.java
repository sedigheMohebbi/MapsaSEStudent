package ir.school.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    public ArrayList<String> readFile(String address) {
        File file = new File(address);
        String nextLine;
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            nextLine = reader.readLine();
            while (nextLine != null) {
                list.add(nextLine);
                nextLine = reader.readLine();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return list;
    }
}
