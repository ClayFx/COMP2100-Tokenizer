import java.util.Arrays;
import java.util.List;


public class DemoParser {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("7", "( 2 +   3 ) ", "(6/ 2)", " - 9", "(3 * (5 - 3) )");
        list.forEach(s -> {
            Tokenizer tokenizer = new MathTokenizer(s);
            try {
                Expression e = Parser.parse(tokenizer);
                System.out.println(e.show() + " evaluates to " + e.evaluate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }
}
