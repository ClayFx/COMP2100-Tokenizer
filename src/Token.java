public class Token {
    int value;
    TokenType type;

    public Token(TokenType type, int value) {
        this.type = type;
        this.value = value;
    }
    public Token(TokenType type) {
        this.type = type;
        this.value = -1;
    }




    @Override
    public String toString() {
        if (type == TokenType.INTLIT) {
            return "INTLIT(" + value + ")";
        } else {
            return type.toString();
        }
    }

    public boolean equals(Token t) {
        if (this.type == TokenType.INTLIT && this.value == t.value || this.type == t.type)
            return true;
        return false;
    }
}

