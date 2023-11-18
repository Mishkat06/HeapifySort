import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] originalArray = {4, 10, 3, 5, 1};

        System.out.println("Original Array: " + Arrays.toString(originalArray));

        // Create a copy of the original array for min heap and max heap
        int[] arrayForMinHeap = Arrays.copyOf(originalArray, originalArray.length);
        int[] arrayForMaxHeap = Arrays.copyOf(originalArray, originalArray.length);

        // Sort the array into a Min Heap
        heapSortMinHeap(arrayForMinHeap);
        System.out.println("Max Heap: " + Arrays.toString(arrayForMinHeap));

        // Sort the array into a Max Heap
        heapSortMaxHeap(arrayForMaxHeap);
        System.out.println("Min Heap: " + Arrays.toString(arrayForMaxHeap));
    }

    // Heap sort for min heap
    public static void heapSortMinHeap(int[] array) {
        int n = array.length;

        // Build min heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyMinHeap(array, n, i);
        }

        // Extract elements from the min heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Swap the root (minimum element) with the last element
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call min heapify on the reduced heap
            heapifyMinHeap(array, i, 0);
        }
    }

    // Heapify for min heap
    public static void heapifyMinHeap(int[] array, int n, int i) {
        int smallest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && array[leftChild] < array[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < n && array[rightChild] < array[smallest]) {
            smallest = rightChild;
        }

        if (smallest != i) {
            int swap = array[i];
            array[i] = array[smallest];
            array[smallest] = swap;

            heapifyMinHeap(array, n, smallest);
        }
    }

    // Heap sort for max heap
    public static void heapSortMaxHeap(int[] array) {
        int n = array.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyMaxHeap(array, n, i);
        }

        // Extract elements from the max heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call max heapify on the reduced heap
            heapifyMaxHeap(array, i, 0);
        }
    }

    // Heapify for max heap
    public static void heapifyMaxHeap(int[] array, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapifyMaxHeap(array, n, largest);
        }
    }
}
