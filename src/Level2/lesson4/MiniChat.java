package Level2.lesson4;

import Level1.lesson8.ActionButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniChat extends JFrame {

    public MiniChat() {

        setTitle("MiniChat");
        setBounds(100, 100, 350, 550);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        JTextArea  outField = new JTextArea();
        outField.setEditable(false);
        outField.setTabSize(4);
        outField.setLineWrap(true);
        outField.setWrapStyleWord(true);
        JScrollPane jsp = new JScrollPane(outField);
        add(jsp, BorderLayout.CENTER);

        JPanel jp = new JPanel();
        add(jp, BorderLayout.SOUTH);
        jp.setLayout(new BorderLayout());

        JTextField inField = new JTextField();
        jp.add(inField, BorderLayout.CENTER);
        JButton sendBtn = new JButton("SEND");
        jp.add(sendBtn, BorderLayout.EAST);

        sendBtn.addActionListener(listenField(inField, outField));
        inField.addActionListener(listenField(inField, outField));

        setVisible(true);
    }

    private ActionListener listenField(JTextField inField, JTextArea outField){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = inField.getText() + "\r\n";
                outField.append(message);
                inField.setText("");
            }
        };
    }

}
