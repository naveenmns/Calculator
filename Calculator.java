package sample;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {
    JLabel displaylabel;
    JButton sevenbtn, eigbtn, ninebtn, forebtn, fivebtn, sixbtn, onebtn, twobtn, threebtn, dotbtn, divbtn, mulbtn, subbtn, addbtn, equalbtn, clrbtn, zerobtn;
    boolean isoperatorclick = false, mul = false, sub = false, add = false, div = false;
    String oldvalue;

    public Calculator() {
        JFrame jf = new JFrame("Calculator");
        jf.setLayout(null);
        jf.setSize(550, 600);
        jf.setLocation(50, 100);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displaylabel = new JLabel();
        displaylabel.setBounds(30, 50, 380, 40);
        displaylabel.setBackground(Color.GRAY);
        displaylabel.setOpaque(true);
        displaylabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displaylabel.setForeground(Color.white);
        jf.add(displaylabel);

        sevenbtn = new JButton("7");
        sevenbtn.setBounds(30, 130, 80, 80);
        sevenbtn.addActionListener(this);
        jf.add(sevenbtn);

        eigbtn = new JButton("8");
        eigbtn.setBounds(130, 130, 80, 80);
        eigbtn.addActionListener(this);
        jf.add(eigbtn);

        ninebtn = new JButton("9");
        ninebtn.setBounds(230, 130, 80, 80);
        ninebtn.addActionListener(this);
        jf.add(ninebtn);

        forebtn = new JButton("4");
        forebtn.setBounds(30, 230, 80, 80);
        forebtn.addActionListener(this);
        jf.add(forebtn);

        fivebtn = new JButton("5");
        fivebtn.setBounds(130, 230, 80, 80);
        fivebtn.addActionListener(this);
        jf.add(fivebtn);

        sixbtn = new JButton("6");
        sixbtn.setBounds(230, 230, 80, 80);
        sixbtn.addActionListener(this);
        jf.add(sixbtn);

        onebtn = new JButton("1");
        onebtn.setBounds(30, 330, 80, 80);
        onebtn.addActionListener(this);
        jf.add(onebtn);

        twobtn = new JButton("2");
        twobtn.setBounds(130, 330, 80, 80);
        twobtn.addActionListener(this);
        jf.add(twobtn);

        threebtn = new JButton("3");
        threebtn.setBounds(230, 330, 80, 80);
        threebtn.addActionListener(this);
        jf.add(threebtn);

        dotbtn = new JButton(".");
        dotbtn.setBounds(30, 430, 80, 80);
        dotbtn.addActionListener(this);
        jf.add(dotbtn);

        zerobtn = new JButton("0");
        zerobtn.setBounds(130, 430, 80, 80);
        zerobtn.addActionListener(this);
        jf.add(zerobtn);

        equalbtn = new JButton("=");
        equalbtn.setBounds(230, 430, 80, 80);
        equalbtn.addActionListener(this);
        jf.add(equalbtn);

        divbtn = new JButton("/");
        divbtn.setBounds(330, 130, 80, 80);
        divbtn.addActionListener(this);
        jf.add(divbtn);

        mulbtn = new JButton("*");
        mulbtn.setBounds(330, 230, 80, 80);
        mulbtn.addActionListener(this);
        jf.add(mulbtn);

        subbtn = new JButton("-");
        subbtn.setBounds(330, 330, 80, 80);
        subbtn.addActionListener(this);
        jf.add(subbtn);

        addbtn = new JButton("+");
        addbtn.setBounds(330, 430, 80, 80);
        addbtn.addActionListener(this);
        jf.add(addbtn);

        clrbtn = new JButton("C");
        clrbtn.setBounds(430, 430, 80, 80);
        clrbtn.addActionListener(this);
        jf.add(clrbtn);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        // Numbers
        if (src == sevenbtn) appendNumber("7");
        else if (src == eigbtn) appendNumber("8");
        else if (src == ninebtn) appendNumber("9");
        else if (src == forebtn) appendNumber("4");
        else if (src == fivebtn) appendNumber("5");
        else if (src == sixbtn) appendNumber("6");
        else if (src == onebtn) appendNumber("1");
        else if (src == twobtn) appendNumber("2");
        else if (src == threebtn) appendNumber("3");
        else if (src == zerobtn) appendNumber("0");
        else if (src == dotbtn) {
            if (!displaylabel.getText().contains(".")) {
                displaylabel.setText(displaylabel.getText() + ".");
            }
        }

        // Operators
        else if (src == addbtn) setOperator("add");
        else if (src == subbtn) setOperator("sub");
        else if (src == mulbtn) setOperator("mul");
        else if (src == divbtn) setOperator("div");

        // Equal
        else if (src == equalbtn) {
            String newvalue = displaylabel.getText();
            float oldval = Float.parseFloat(oldvalue);
            float newval = Float.parseFloat(newvalue);
            float result = 0;

            if (add) result = oldval + newval;
            else if (sub) result = oldval - newval;
            else if (mul) result = oldval * newval;
            else if (div) result = oldval / newval;

            displaylabel.setText(String.valueOf(result));
            resetOperators();
        }

        // Clear
        else if (src == clrbtn) {
            displaylabel.setText("");
            resetOperators();
        }
    }

    private void appendNumber(String num) {
        if (isoperatorclick) {
            displaylabel.setText(num);
            isoperatorclick = false;
        } else {
            displaylabel.setText(displaylabel.getText() + num);
        }
    }

    private void setOperator(String op) {
        resetOperators();
        isoperatorclick = true;
        oldvalue = displaylabel.getText();
        switch (op) {
            case "add": add = true; break;
            case "sub": sub = true; break;
            case "mul": mul = true; break;
            case "div": div = true; break;
        }
    }

    private void resetOperators() {
        add = sub = mul = div = false;
    }
}
