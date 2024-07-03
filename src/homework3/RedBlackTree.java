package homework3;

import java.util.ArrayList;

public class RedBlackTree {
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private Node put(Node h, String key, Entry entry) {
        if (h == null) return new Node(key, entry, RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, entry);
        else if (cmp > 0) h.right = put(h.right, key, entry);
        else h.values.add(entry);

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }

    public void put(String key, Entry entry) {
        root = put(root, key, entry);
        root.color = BLACK;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    public ArrayList<Entry> get(String searchableName) {
        ArrayList<Entry> result = new ArrayList<>();
        Node x = root;
        int redEdges = 0;
        int blackEdges = 0;

        while (x != null) {// searched or leaf
            int cmp = searchableName.compareTo(x.key);
            if (cmp < 0) {
                if (x.left != null && !isRed(x.left)) blackEdges++;
                else if (x.left != null) redEdges++;
                x = x.left;//move to left child
            } else if (cmp > 0) {
                if (x.right != null && !isRed(x.right)) blackEdges++;
                else if (x.right != null) redEdges++;
                x = x.right;
            } else {
                result = new ArrayList<>(x.values);
                break;
            }
        }

        if (!result.isEmpty()) {
            System.out.println(result.size() + " entries found.");
            System.out.println("Red edges: " + redEdges + ", Black edges: " + blackEdges);
        } else {
            System.out.println("No entries found.");
        }

        return result;
    }


    public int[] countRedAndBlackEdges() {
        int[] count = {0, 0}; // index 0 for black, 1 for red
        countEdges(root, count);
        return count;
    }

    private void countEdges(Node x, int[] count) {
        if (x == null) return;
        if (x.color == RED) count[1]++;
        else count[0]++;

        countEdges(x.left, count);
        countEdges(x.right, count);
    }
}
