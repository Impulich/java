package practice3;

public class task7 {

    public static void main(String[] args) {
        printResults(0);
        printResults(Math.PI / 2);
        printResults(Math.PI);
        printResults(Double.NaN); // помилка
    }


    public static double function(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new IllegalArgumentException("Некоректний аргумент x=" + x);
        }
        return Math.sin(x) + Math.cos(x);
    }

    static void printResults(double x) {
        System.out.print("x=" + x + " result: ");
        try {
            System.out.println(function(x));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
