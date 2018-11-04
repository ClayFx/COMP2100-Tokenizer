import javax.swing.*;
import java.awt.*;


public class Calculator implements Runnable {

    private final int WIDTH = 300;
    private final int HEIGHT = 150;

    private JFrame main;
    private JPanel content, buttonPanel;
    private JTextField display, input;
    private JButton clear, evaluate;


    public Calculator() {
        SwingUtilities.invokeLater(this);
    }

    @Override
    public void run() {
        main = new JFrame("Calculator");
        main.setSize(WIDTH, HEIGHT);
        main.setLocationRelativeTo(null);
        main.setResizable(true);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        init();
        main.setVisible(true);
    }

    private void init() {
        Font textFont = new Font("Arial", Font.PLAIN, 24);
        Font buttonFont = new Font("Arial", Font.PLAIN, 20);
        content = new JPanel();
        content.setLayout(new BorderLayout());
        main.setContentPane(content);
        display = new JTextField();
        display.setBackground(Color.LIGHT_GRAY);
        display.setFont(textFont);
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        input = new JTextField();
        input.setFont(textFont);
        input.setHorizontalAlignment(SwingConstants.RIGHT);
        content.add(display, BorderLayout.NORTH);
        content.add(input, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        content.add(buttonPanel, BorderLayout.SOUTH);
        clear = new JButton("Clear");
        clear.setFont(buttonFont);
        evaluate = new JButton("=");
        evaluate.setFont(buttonFont);
        buttonPanel.add(clear);
        buttonPanel.add(evaluate);

        clear.addActionListener(e -> {
            display.setText("");
            input.setText("");
        });

        evaluate.addActionListener(event -> {
            String s = input.getText();
            try {
                Tokenizer tokenizer = new MathTokenizer(s);
                Expression e = Parser.parse(tokenizer);
                display.setText(String.valueOf(e.evaluate()));
            } catch (ParseException | IllegalArgumentException e1) {
                display.setText("Illegal input");
            }
        });

    }

    public static void main(String[] args) {
        new Calculator();
    }

}
