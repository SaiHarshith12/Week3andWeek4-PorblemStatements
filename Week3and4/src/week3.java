import java.util.*;

public class week3 {

    // 🔵 Linear Search (First Occurrence)
    public static int linearFirst(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Index: " + i +
                        " (Comparisons: " + comparisons + ")");
                return i;
            }
        }

        System.out.println("Not found (Comparisons: " + comparisons + ")");
        return -1;
    }

    // 🔵 Linear Search (Last Occurrence)
    public static int linearLast(String[] arr, String target) {
        int comparisons = 0;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                index = i;
            }
        }

        System.out.println("Linear Last Index: " + index +
                " (Comparisons: " + comparisons + ")");
        return index;
    }

    // 🟢 Binary Search (Find any occurrence)
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary Found at Index: " + mid +
                        " (Comparisons: " + comparisons + ")");
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Not found (Comparisons: " + comparisons + ")");
        return -1;
    }

    // 🟢 Count Occurrences using Binary Search
    public static int countOccurrences(String[] arr, String target) {
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);

        if (first == -1) return 0;

        return last - first + 1;
    }

    // Find first occurrence (Binary)
    public static int firstOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                high = mid - 1; // move left
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // Find last occurrence (Binary)
    public static int lastOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                low = mid + 1; // move right
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // 🚀 Main
    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        System.out.println("Original Logs:");
        System.out.println(Arrays.toString(logs));

        // 🔵 Linear Search
        linearFirst(logs, "accB");
        linearLast(logs, "accB");

        // 🟢 Sort for Binary Search
        Arrays.sort(logs);

        System.out.println("\nSorted Logs:");
        System.out.println(Arrays.toString(logs));

        // 🟢 Binary Search
        binarySearch(logs, "accB");

        int count = countOccurrences(logs, "accB");
        System.out.println("Total Occurrences of accB: " + count);
    }
}
