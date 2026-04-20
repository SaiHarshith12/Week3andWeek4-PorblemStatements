import java.util.*;

public class week3 {

    // 🔵 Linear Search (unsorted)
    public static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: Found at index " + i +
                        " (Comparisons: " + comparisons + ")");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: Not found (Comparisons: " + comparisons + ")");
        }
    }

    // 🟢 Lower Bound (first index >= target)
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        int comparisons = 0;

        while (low < high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println("Binary (lower_bound) comparisons: " + comparisons);
        return low;
    }

    // 🟢 Upper Bound (first index > target)
    public static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // 🔻 Floor (largest ≤ target)
    public static Integer floorValue(int[] arr, int target) {
        int idx = lowerBound(arr, target);

        if (idx < arr.length && arr[idx] == target) {
            return arr[idx];
        } else if (idx > 0) {
            return arr[idx - 1];
        }
        return null;
    }

    // 🔺 Ceiling (smallest ≥ target)
    public static Integer ceilingValue(int[] arr, int target) {
        int idx = lowerBound(arr, target);

        if (idx < arr.length) {
            return arr[idx];
        }
        return null;
    }

    // 🚀 Main
    public static void main(String[] args) {

        int[] unsorted = {50, 10, 100, 25};
        int[] sorted = {10, 25, 50, 100};

        int target = 30;

        System.out.println("Unsorted: " + Arrays.toString(unsorted));
        linearSearch(unsorted, target);

        System.out.println("\nSorted: " + Arrays.toString(sorted));

        Integer floor = floorValue(sorted, target);
        Integer ceil = ceilingValue(sorted, target);

        System.out.println("Floor(" + target + "): " +
                (floor != null ? floor : "None"));

        System.out.println("Ceiling(" + target + "): " +
                (ceil != null ? ceil : "None"));

        int insertPos = lowerBound(sorted, target);
        System.out.println("Insertion index for " + target + ": " + insertPos);
    }
}
