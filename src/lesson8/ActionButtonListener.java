package lesson8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Character.isDigit;

public class ActionButtonListener implements ActionListener {

    private JTextField outField;
    private StringBuilder sb;
    private boolean flagIsDigit = false;

    public ActionButtonListener(JTextField outField) {
        this.outField = outField;
        this.sb = new StringBuilder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();

        if (jButton.getText().equals("C")) {
            outField.setText("0");
            return;
        }

        if (jButton.getText().equals("Submit")) {
            if (outField.getText().equals("") || outField.getText().equals("0") || !this.flagIsDigit) {
                return;
            }

            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
            try {
                Object expResult1 = scriptEngine.eval(outField.getText());
                outField.setText(expResult1.toString());
            } catch (ScriptException scriptException) {
                scriptException.printStackTrace();
            }

            return;
        }

        if (outField.getText().equals("0")) {
            outField.setText("");
        }

        sb.append(outField.getText());

        if (!this.flagIsDigit && !isDigit(jButton.getText().charAt(0))) {
            sb.append("0");
        }

        this.flagIsDigit = isDigit(jButton.getText().charAt(0));

        String val = sb.append(jButton.getText()).toString();
        outField.setText(val);
        sb.setLength(0);
    }
}
