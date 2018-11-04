public class Lit extends Expression {

    int value;

    public Lit(int value) {
        this.value = value;
    }

    @Override
    public String show(){
        if (value >= 0) {
            return "" + value;
        } else {
            return "(" + value + ")";
        }
    }; // this should show the expression as a string

    @Override
    public int evaluate(){
        return value;
    };  // this should evaluate the expression
}
