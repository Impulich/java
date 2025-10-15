package practice3;

public class Task5 {

    public static void main(String[] args) {
        printResults(5);
        printResults(10);
        printResults(0);   // помилка
        printResults(-3);  // помилка
    }

    public static double harmonicSum(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n має бути > 0, отримано n=" + n);
        }
        double sum = 0;
        for (int k = 1; k <= n; k++) {
            sum += 1.0 / k;
        }
        return sum;
    }

    static void printResults(int n) {
        System.out.print("n=" + n + " result: ");
        try {
            System.out.println(harmonicSum(n));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
