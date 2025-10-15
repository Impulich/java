import java.util.Scanner;

public class lab4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Меню завдань ===");
            System.out.println("1. Завдання 15 – Кількість елементів, що кратні 5");
            System.out.println("2. Завдання 45 – Кількість додатних елементів, індекс яких кратний 4");
            System.out.println("3. Завдання 61 – Формування масиву C з A і B");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    task15();
                    break;
                case 2:
                    task45();
                    break;
                case 3:
                    task61();
                    break;
                case 0:
                    System.out.println("Вихід з програми...");
                    break;
                default:
                    System.out.println("Невірний вибір! Спробуйте ще раз.");
            }
        } while (choice != 0);

        sc.close();
    }

    // --- Завдання 15 ---
    public static void task15() {
        int[] arr = {10, 3, 25, 14, 5, 40, 9, 20};
        int count = 0;

        for (int num : arr) {
            if (num % 5 == 0) {
                count++;
            }
        }

        System.out.println("Масив: ");
        printArray(arr);
        System.out.println("Кількість елементів, кратних 5: " + count);
    }

    // --- Завдання 45 ---
    public static void task45() {
        int[] arr = {-5, 2, 7, -3, 8, 10, 4, -6, 12};
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 4 == 0 && arr[i] > 0) {
                count++;
            }
        }

        System.out.println("Масив: ");
        printArray(arr);
        System.out.println("Кількість додатних елементів з індексом кратним 4: " + count);
    }

    // --- Завдання 61 ---
    public static void task61() {
        int[] A = {2, -3, 4, -5, 7, -2};
        int[] B = {5, -2, -1, -6, 8, -3};
        int[] C = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && B[i] > 0) {
                C[i] = A[i] + B[i];
            } else if (A[i] < 0 && B[i] < 0) {
                C[i] = A[i] * B[i];
            } else {
                C[i] = 0;
            }
        }

        System.out.println("Масив A: ");
        printArray(A);
        System.out.println("Масив B: ");
        printArray(B);
        System.out.println("Результуючий масив C: ");
        printArray(C);
    }

    // --- Допоміжна функція для виводу масиву ---
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
