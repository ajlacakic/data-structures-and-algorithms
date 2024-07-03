package homework3;

import java.util.ArrayList;

public class Node {
    String key;
    ArrayList<Entry> values;
    Node left, right;
    boolean color; // true for red, false for black

    public Node(String key, Entry entry, boolean color) {
        this.key = key;
        this.values = new ArrayList<>();
        this.values.add(entry);
        this.color = color;
    }
}
