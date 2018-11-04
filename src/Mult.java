public class Mult extends Expression {
    Expression left;
    Expression right;

    public Mult(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String show() {
        return "(" + left.show() + " * " + right.show() + ")";
    }

    @Override
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
