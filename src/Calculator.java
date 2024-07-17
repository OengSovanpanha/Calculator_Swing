import javax.swing.*;
import java.awt.event.ActionEvent;

public class Calculator {
    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textFieldResult;
    private JButton btnAdd;
    private JButton btnSubtract;
    private JButton btnMultiply;
    private JButton btnDivide;
    private JButton btnModulus;
    private JButton btnClear;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340, 330);
        frame.setLayout(null);

        JLabel label1 = new JLabel("First Number:");
        label1.setBounds(10, 10, 100, 30);
        frame.add(label1);

        textField1 = new JTextField();
        textField1.setBounds(150, 10, 165, 30);
        frame.add(textField1);

        JLabel label2 = new JLabel("Second Number:");
        label2.setBounds(10, 50, 120, 30);
        frame.add(label2);

        textField2 = new JTextField();
        textField2.setBounds(150, 50, 165, 30);
        frame.add(textField2);

        JLabel labelResult = new JLabel("Result:");
        labelResult.setBounds(10, 90, 100, 30);
        frame.add(labelResult);

        textFieldResult = new JTextField();
        textFieldResult.setBounds(150, 90, 165, 30);
        textFieldResult.setEditable(false);
        frame.add(textFieldResult);

        btnAdd = new JButton("+");
        btnAdd.setBounds(10, 140, 150, 40);
        frame.add(btnAdd);

        btnSubtract = new JButton("-");
        btnSubtract.setBounds(165, 140, 150, 40);
        frame.add(btnSubtract);

        btnMultiply = new JButton("*");
        btnMultiply.setBounds(10, 190, 150, 40);
        frame.add(btnMultiply);

        btnDivide = new JButton("/");
        btnDivide.setBounds(165, 190, 150, 40);
        frame.add(btnDivide);

        btnModulus = new JButton("%");
        btnModulus.setBounds(10, 240, 150, 40);
        frame.add(btnModulus);

        btnClear = new JButton("Clear");
        btnClear.setBounds(165, 240, 150, 40);
        frame.add(btnClear);

        // Add action listeners for buttons
        btnAdd.addActionListener(e -> performOperation(e));
        btnSubtract.addActionListener(e -> performOperation(e));
        btnMultiply.addActionListener(e -> performOperation(e));
        btnDivide.addActionListener(e -> performOperation(e));
        btnModulus.addActionListener(e -> performOperation(e));
        btnClear.addActionListener(e -> clearFields());

        frame.setVisible(true);
    }

    private void performOperation(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(textField1.getText());
            double num2 = Double.parseDouble(textField2.getText());
            double result = 0;

            if (e.getSource() == btnAdd) {
                result = num1 + num2;
            } else if (e.getSource() == btnSubtract) {
                result = num1 - num2;
            } else if (e.getSource() == btnMultiply) {
                result = num1 * num2;
            } else if (e.getSource() == btnDivide) {
                result = num1 / num2;
            } else if (e.getSource() == btnModulus) {
                result = num1 % num2;
            }

            textFieldResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textFieldResult.setText("");
    }
}
