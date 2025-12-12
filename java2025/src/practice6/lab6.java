public class lab6 {

    // Завдання 1: перетворення int → octal
    public static String intToOctString(int i) {
        if (i < 0) throw new IllegalArgumentException("Від’ємне число");
        return Integer.toOctalString(i).toUpperCase();
    }

    // Завдання 2: слова → lower-case
    public static String toLowerWords(String s) {
        if (s == null) throw new NullPointerException("null рядок");

        String[] arr = s.split(" ");
        StringBuilder out = new StringBuilder();

        for (String w : arr) {
            // якщо тільки букви — робимо lowercase
            if (w.chars().allMatch(Character::isLetter)) {
                out.append(w.toLowerCase());
            } else {
                out.append(w);
            }
            out.append(" ");
        }

        return out.toString().trim();
    }

    public static void main(String[] args) {

        System.out.println("===== Завдання 1 =====");
        System.out.println("8  → " + intToOctString(8));
        System.out.println("511 → " + intToOctString(511));
        System.out.println("0  → " + intToOctString(0));

        System.out.println("Висновок: числа успішно переведено у вісімкову систему.\n");

        System.out.println("===== Завдання 2 =====");
        String text = "The USER with the nickname koala757 wrote 3 COMMENTS Month AGO";
        System.out.println("Вхідний текст: " + text);
        System.out.println("Результат:     " + toLowerWords(text));

        System.out.println("Висновок: усі слова, що складаються лише з літер, перетворені у нижній регістр.");
    }
}
