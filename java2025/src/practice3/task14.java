package practice3;

public class task14 {

    public static void main(String[] args) {
        printResults(0.1);
        printResults(0.01);
        printResults(0.0001);
        printResults(-0.5);  // помилка
    }


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

    static void printResults(double eps) {
        System.out.print("eps=" + eps + " result: ");
        try {
            System.out.println(infiniteSum(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
