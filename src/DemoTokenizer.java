public class DemoTokenizer {
    final static String exp1 = "(12 + 3)";
    final static String exp2 = "(  2 *-3)";
    final static String exp3 = "(3- 2)";


    public static void main(String[] args) {
        show(exp1);
        System.out.println("");
        show(exp2);
        System.out.println("");
        show(exp3);
    }

    public static void show(String exp){
        Tokenizer tz = new MathTokenizer(exp);
        while (tz.hasNext()){
            System.out.println(tz.current().toString());
            tz.next();
        }
    }
}
