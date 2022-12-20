import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] smallSet = new int[1000];
        int[] mediumSet = new int[10000];
        int[] largeSet = new int[100000];
        Random r = new Random();

        for (int i = 0; i < smallSet.length; i++) {
            smallSet[i] = r.nextInt(0, 10001);
        }
        for (int i = 0; i < mediumSet.length; i++) {
            mediumSet[i] = r.nextInt(0, 10001);
        }
        for (int i = 0; i < largeSet.length; i++) {
            largeSet[i] = r.nextInt(0, 10001);
        }

        long startTime = System.currentTimeMillis();
        bubbleSort( smallSet );
        long endTime = System.currentTimeMillis();
        System.out.println("Small set bubble sort: " +
                (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        bubbleSort( mediumSet );
        endTime = System.currentTimeMillis();
        System.out.println("Medium set bubble sort: " +
                (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        bubbleSort( largeSet );
        endTime = System.currentTimeMillis();
        System.out.println("Large set bubble sort: " +
                (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        mergeSort( smallSet, 0, smallSet.length - 1 );
        endTime = System.currentTimeMillis();
        System.out.println("Small set merge sort: " +
                (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        mergeSort( mediumSet, 0, mediumSet.length - 1 );
        endTime = System.currentTimeMillis();
        System.out.println("Medium set merge sort: " +
                (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        mergeSort( largeSet, 0, largeSet.length - 1 );
        endTime = System.currentTimeMillis();
        System.out.println("Large set merge sort: " +
                (endTime - startTime) + " ms");
    }

    // taken from GeeksForGeeks.org
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Also taken from GeeksForGeeks.org

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

}


