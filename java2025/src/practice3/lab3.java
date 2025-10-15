package practice3;

public class lab3 {

    public static void main(String[] args) {
        System.out.println("=== Завдання 5 ===");
        testTask5();

        System.out.println("\n=== Завдання 7 ===");
        testTask7();

        System.out.println("\n=== Завдання 14 ===");
        testTask14();
    }

    // ================= ЗАВДАННЯ 5 =================
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

    static void testTask5() {
        int[] tests = {5, 10, 0, -3};
        for (int n : tests) {
            System.out.print("n=" + n + " result: ");
            try {
                System.out.println(harmonicSum(n));
            } catch (IllegalArgumentException e) {
                System.out.println("EXCEPTION! " + e.getMessage());
            }
        }
    }

    // ================= ЗАВДАННЯ 7 =================

    public static double function(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new IllegalArgumentException("Некоректний аргумент x=" + x);
        }
        return Math.sin(x) + Math.cos(x);
    }

    static void testTask7() {
        double[] tests = {0, Math.PI / 2, Math.PI, Double.NaN};
        for (double x : tests) {
            System.out.print("x=" + x + " result: ");
            try {
                System.out.println(function(x));
            } catch (IllegalArgumentException e) {
                System.out.println("EXCEPTION! " + e.getMessage());
            }
        }
    }

    // ================= ЗАВДАННЯ 14 =================

    public static double infiniteSum(double eps) {
        if (eps <= 0) {
            throw new IllegalArgumentException("eps має бути > 0, отримано eps=" + eps);
        }

        double sum = 0;
        int k = 1;
        while (true) {
            double term = Math.pow(-1, k + 1) * (1.0 / k);
            if (Math.abs(term) < eps) break;
            sum += term;
            k++;
        }
        return sum;
    }

    static void testTask14() {
        double[] tests = {0.1, 0.01, 0.0001, -0.5};
        for (double eps : tests) {
            System.out.print("eps=" + eps + " result: ");
            try {
                System.out.println(infiniteSum(eps));
            } catch (IllegalArgumentException e) {
                System.out.println("EXCEPTION! " + e.getMessage());
            }
        }
    }
}
