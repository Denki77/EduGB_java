package Level1.lesson8;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    private JFrame mainFrame;

    public Calculator() {
        mainFrame = new JFrame();

        mainFrame.setTitle("Calculator");
        mainFrame.setBounds(100, 100, 350, 550);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        top.setLayout(new GridLayout(1, 4, 10, 5));
        top.setFont(Font.getFont("Arial"));

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(4, 3));

        JPanel right = new JPanel();
        right.setLayout(new GridLayout(4, 1));

        mainFrame.add(top, BorderLayout.NORTH);
        mainFrame.add(right, BorderLayout.EAST);
        mainFrame.add(bottom, BorderLayout.CENTER);

        JTextField outField = new JTextField();
        outField.setEditable(false);
        top.add(outField, BorderLayout.CENTER);

        ActionButtonListener abListener = new ActionButtonListener(outField);
        for (int i = 1; i <= 9; i++) {
            JButton digitBtn = new JButton(String.valueOf(i));
            bottom.add(digitBtn);
            digitBtn.addActionListener(abListener);
        }

        JButton digitBtn = new JButton("0");
        bottom.add(digitBtn);
        digitBtn.addActionListener(abListener);

        JButton plusBtn = new JButton("+");
        right.add(plusBtn);
        plusBtn.addActionListener(abListener);

        JButton minusBtn = new JButton("-");
        right.add(minusBtn);
        minusBtn.addActionListener(abListener);

        JButton multiBtn = new JButton("*");
        right.add(multiBtn);
        multiBtn.addActionListener(abListener);

        JButton divBtn = new JButton("/");
        right.add(divBtn);
        divBtn.addActionListener(abListener);

        JButton cancelBtn = new JButton("C");
        bottom.add(cancelBtn);
        cancelBtn.addActionListener(abListener);

        JButton submitBtn = new JButton("Submit");
        bottom.add(submitBtn);
        submitBtn.addActionListener(abListener);


        mainFrame.setVisible(true);
    }
}
