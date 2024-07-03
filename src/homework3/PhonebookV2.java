package homework3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) throws FileNotFoundException {
        RedBlackTree phonebook = FileUtils.readFile("raw_phonebook_data.csv"); // Adjust the file path accordingly
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Enter 'Surname, Name' to search or '-1' to exit:");
            input = scanner.nextLine();
            if (input.equals("-1")) break;

            ArrayList<Entry> results = phonebook.get(input);
            if (results != null) {
                System.out.println(results.size() + " entries found:");
                for (Entry entry : results) {
                    System.out.println(entry);
                }
            } else {
                System.out.println("No entries found.");
            }
        }
        scanner.close();
    }
}
