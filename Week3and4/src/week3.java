import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ":" + riskScore + " (Bal:" + accountBalance + ")";
    }
}

public class week3 {

    // 🔵 Bubble Sort (Ascending by riskScore)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {

                    // swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;

                    // 🔍 visualize swaps
                    System.out.println("Swap: " + arr[j].name + " <-> " + arr[j + 1].name);
                }
            }

            if (!swapped) break; // optimization
        }

        System.out.println("Total Swaps: " + swaps);
    }

    // 🟢 Insertion Sort (Descending riskScore + accountBalance)
    public static void insertionSort(Client[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // ⚖ Comparator (DESC riskScore, then DESC balance)
    public static int compare(Client c1, Client c2) {
        if (c1.riskScore != c2.riskScore) {
            return Integer.compare(c2.riskScore, c1.riskScore); // DESC
        }
        return Double.compare(c2.accountBalance, c1.accountBalance); // DESC
    }

    // 🔴 Top 10 highest risk clients
    public static void printTopRisks(Client[] arr) {
        System.out.println("\nTop High-Risk Clients:");

        int limit = Math.min(10, arr.length);

        for (int i = 0; i < limit; i++) {
            System.out.println(arr[i].name + " (" + arr[i].riskScore + ")");
        }
    }

    // 🚀 Main
    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 10000),
                new Client("clientB", 50, 7000)
        };

        // 🔵 Bubble Sort (Ascending)
        System.out.println("Bubble Sort (Ascending by riskScore):");
        bubbleSort(clients);

        System.out.println("Result:");
        for (Client c : clients) {
            System.out.println(c);
        }

        // 🟢 Insertion Sort (Descending)
        insertionSort(clients);

        System.out.println("\nInsertion Sort (Descending by riskScore + balance):");
        for (Client c : clients) {
            System.out.println(c);
        }

        // 🔴 Top risks
        printTopRisks(clients);
    }
}
