package homework3;
import java.io.*;
import java.util.*;

public class FileUtils {
    public static RedBlackTree readFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        RedBlackTree rbt = new RedBlackTree();
        scanner.nextLine(); // Skip the header line

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(";");
            if (data.length < 6) continue;

            String[] names = data[0].split(", ");
            String surname = names.length > 1 ? names[0] : "";
            String name = names.length > 1 ? names[1] : names[0];

            Entry entry = new Entry(surname, name, data[1], data[2], data[3], data[4], data[5]);
            rbt.put(surname + ", " + name, entry);
        }
        scanner.close();
        return rbt;
    }
}
