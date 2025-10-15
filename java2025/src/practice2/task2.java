class task2 {
    static void main(String[] args) {
        if (args != null && args.length > 0) {
        }

        double p1 = 2.54, q1 = 1.23, r1 = -2.14, s1 = -0.23;
        double res5 = calc5(p1, q1, r1, s1);
        System.out.printf("Завдання 5: y = %.12f%n", res5);



        double p2 = 1.25, q2 = 3.09, r2 = 4.25, s2 = 0.56;
        double res15 = calc15(p2, q2, r2, s2);
        System.out.printf("Завдання 15: y = %.12f%n", res15);



        double p3 = 2.98, q3 = 5.55, r3 = 0.045, s3 = 0.129;
        double res25 = calc25(p3, q3, r3, s3);
        System.out.printf("Завдання 25: y = %.12f%n", res25);
    }

    static double calc5(double a, double b, double c, double d) {
        double numerator = Math.sqrt(Math.pow(Math.cos(a), 2) + Math.pow(Math.sin(b), 2));
        double denominator = Math.abs(c - d) + Math.log(1 + Math.pow(a, 2));
        return numerator / denominator;
    }


    static double calc15(double a, double b, double c, double d) {
        double numerator = Math.exp(a) + Math.tan(b);
        double denominator = Math.sqrt(Math.abs(c) + Math.asin(d));
        return numerator / denominator;
    }


    static double calc25(double a, double b, double c, double d) {
        double numerator = Math.log(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));
        double denominator = 1 + Math.cos(c * d);
        return numerator / denominator;
    }
}