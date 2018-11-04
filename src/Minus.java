public class Minus extends Expression {
    Expression value;

    public Minus(Expression value) {
        this.value = value;
    }

    @Override
    public String show() {
        return "(-" + value.show() + ")";
    }

    @Override
    public int evaluate() {
        return -value.evaluate();
    }
}
