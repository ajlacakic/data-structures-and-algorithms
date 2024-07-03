package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int low = 0, high = entries.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (entries[mid].getName().compareTo(searchableName) < 0) {
                low = mid + 1;
            } else if (entries[mid].getName().compareTo(searchableName) > 0) {
                high = mid - 1;
            } else {//match
                int start = mid, end = mid;
                while (start > low && entries[start - 1].getName().equals(searchableName)) start--;
                while (end < high && entries[end + 1].getName().equals(searchableName)) end++;
                return new int[]{start, end};
            }
        }
        return new int[]{};
    }
}

