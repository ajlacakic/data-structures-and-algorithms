package homework1;

import java.util.Scanner;
import java.io.IOException;

public class PhonebookV1 {
    public static void main(String[] args) {
        String inputFile = "raw_phonebook_data.csv";
        String outputFile = "output1.csv";

        try {
            Entry[] entries = FileUtils.readFile(inputFile);
            MergeSort.sort(entries);
            FileUtils.writeToFile(entries, outputFile);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter a 'Surname, Name' to search, or -1 to exit:");
                String input = scanner.nextLine();

                if (input.equals("-1")) {
                    break;
                }
                int[] result = BinarySearch.search(entries, input);
                if (result.length == 0) {
                    System.out.println("No entries found.");
                } else {
                    //result[0] and result[1] are the start and end indices of entries matching the search
                    int start = result[0];
                    int end = result[1];
                    System.out.println("Entries found: " + (end - start + 1));
                    for (int i = start; i <= end; i++) {
                        System.out.println(entries[i]);
                    }
                }
            }
            scanner.close();
            System.out.println("Program terminated.");

        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
