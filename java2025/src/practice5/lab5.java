public class lab5 {
    // Метод сортування вставкою (Insertion Sort)
    public static void insertionSort(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            double key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Метод сортування бульбашкою (Bubble Sort)
    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // якщо не було обмінів — масив уже відсортований
        }
    }

    // Вивід масиву
    public static void printArray(double[] arr) {
        for (double num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double[] array1 = {3.4, 1.2, 7.8, 5.5, 2.1, 4.0};
        double[] array2 = array1.clone();

        System.out.println("Початковий масив:");
        printArray(array1);

        insertionSort(array1);
        System.out.println("\nПісля сортування вставкою (Insertion Sort):");
        printArray(array1);

        bubbleSort(array2);
        System.out.println("\nПісля сортування бульбашкою (Bubble Sort):");
        printArray(array2);
    }
}
