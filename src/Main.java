import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String TestText1 = "<div>\n" +
                "<p>Символи <> круглих дужок <code>'('</code> та <code>')'</code>. <br />Ці символи\n" +
                "дозволяють отримати з рядка додаткову інформацію.\n" +
                "<br/>Зазвичай, якщо парсер регулярних виразів шукає в тексті інформацію\n" +
                "за заданим виразом і знаходить її - він просто повертає\n" +
                "знайдений рядок.</p>\n" +
                "<p align=\"right\">А ось тут <a href=\"google.com\">посилання</a>, щоб життя медом не здавалося.</p>\n" +
                "</div>";
        String TestText2 = "(+380)50-333-33-33";
        String TestText3 = "+1-237-49-63";
        String TestText4 = "Я хочу    бути     програмістом";

        Pattern numberPattern = Pattern.compile("\\(\\+380\\)\\d{2}-\\d{3}-\\d{2}-\\d{2}");
        numberValidator(numberPattern, TestText2);
        numberValidator(numberPattern, TestText3);

        String whitespacePattern = "\\s{2,}";
        String cleanSpace = TestText4.replaceAll(whitespacePattern, " ");
        System.out.println("\nText without whitespace: " + cleanSpace);

        String htmlPattern = "(<[^>]+>|<+>)";
        String cleanHTML = TestText1.replaceAll(htmlPattern, "");
        System.out.println("\nText without html: " + cleanHTML);
    }
    public static void numberValidator(Pattern pattern, String text) {
        String message = pattern.matcher(text).matches() ?
                "Number " + text + " valid" :
                "Number " + text + " invalid";
        System.out.println(message);
    }

}