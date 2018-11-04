public class MathTokenizer extends Tokenizer {

    String str;
    int pos;  // points at the next token in the string to return
    Token current;

    public MathTokenizer(String str) {
        this.str = str;
        pos = 0;
        current = null;
        next();
    }

    @Override
    boolean hasNext() {
        return current != null;
    }

    @Override
    Token current() {
        return current;
    }

    @Override
    void next() {
        // consume the white space

        while (pos < str.length() && Character.isWhitespace(str.charAt(pos)) ) {
            pos++;
        }

        if (pos < str.length()) {
            char c = str.charAt(pos);
            if (c == '(') {
                pos++;
                current = new Token(TokenType.LBRA);
            } else if (c == ')') {
                pos++;
                current = new Token(TokenType.RBRA);
            } else if (c == '+') {
                pos++;
                current = new Token(TokenType.PLUS);
            } else if (c == '-') {
                pos++;
                current = new Token(TokenType.MINUS);
            } else if (c == '*') {
                pos++;
                current = new Token(TokenType.MULT);
            }  else if (c == '/') {
                pos++;
                current = new Token(TokenType.DIV);

            } else if (Character.isDigit(c)) {
                String number = "";
                number += c;
                pos++;
                while (pos < str.length() && Character.isDigit(c = str.charAt(pos)) ) {
                    number += c;
                    pos++;
                }
                current = new Token(TokenType.INTLIT, Integer.parseInt(number));
//				pos++;
            }
        } else {
            current = null;
        }
    }
}