package homework1;

import java.util.Arrays;

public class MergeSort {
    public static void sort(Entry[] entries) {
        if (entries.length < 2) return;
        int mid = entries.length / 2;
        Entry[] left = Arrays.copyOfRange(entries, 0, mid);
        Entry[] right = Arrays.copyOfRange(entries, mid, entries.length);
        sort(left);
        sort(right);
        merge(entries, left, right);
    }

    private static void merge(Entry[] entries, Entry[] left, Entry[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                entries[k++] = left[i++];
            } else {
                entries[k++] = right[j++];
            }
        }
        while (i < left.length) {// remaining elements
            entries[k++] = left[i++];
        }
        while (j < right.length) {
            entries[k++] = right[j++];
        }
    }
}

