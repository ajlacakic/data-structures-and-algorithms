package homework1;

import java.io.*;
import java.util.*;

public class FileUtils {
    public static Entry[] readFile(String filePath) throws IOException {
        List<Entry> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();//skip header
            while ((line = reader.readLine()) != null) {
                entries.add(new Entry(line));
            }
        }
        return entries.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Surname, Name;Street Address;City;Postcode;Country;Phone Number\n");
            for (Entry entry : entries) {
                writer.write(entry.toString() + "\n");
            }
        }
    }
}

