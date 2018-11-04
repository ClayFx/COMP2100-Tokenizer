public class Parser {

    static Expression parse(Tokenizer t) throws ParseException{
        Token token = t.current();
        if (token.type == TokenType.INTLIT) {
            int v = token.value;
            t.next();
            return new Lit(v);
        } else if (token.type == TokenType.LBRA) {
            t.next();
            Expression e1 = parse(t);
            Token operator = t.current();
            if (operator.type == TokenType.PLUS) {
                t.next();
                Expression e2 = parse(t);
                t.parse(new Token(TokenType.RBRA));
                return new Add(e1, e2);
            } else if (operator.type == TokenType.MINUS) {
                t.next();
                Expression e2 = parse(t);
                t.parse(new Token(TokenType.RBRA));
                return new Sub(e1, e2);
            } else if (operator.type == TokenType.MULT) {
                t.next();
                Expression e2 = parse(t);
                t.parse(new Token(TokenType.RBRA));
                return new Mult(e1, e2);
            } else if (operator.type == TokenType.DIV) {
                t.next();
                Expression e2 = parse(t);
                t.parse(new Token(TokenType.RBRA));
                return new Div(e1, e2);
            } else {
                throw new ParseException();
            }
        } else if (token.type == TokenType.MINUS) {
            t.next();
            Expression e = parse(t);
            return new Minus(e);
        } else {
            throw new ParseException();
        }
    }
}
