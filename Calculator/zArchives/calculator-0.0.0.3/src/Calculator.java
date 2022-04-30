/*
 * Jhonatan Nagasako
 * 30-APR-2022
 * (Major version).(Minor version).(Revision number).(Build number)
 *
 * Help/inspiration:
 * https://www.youtube.com/watch?v=dfhmTyRTCSQ&ab_channel=BroCode
 *
 * */

// version: 0.0.0.0 = able to create frame
// version: 0.0.0.1 = debugging forloops function and number buttons... missing the "decButton", it was a forloop mistmatch
// version: 0.0.0.2 = adding functionality to buttons of caluclator
// version: 0.0.0.3 = adding negButton, need to improve the GUI for next steps

import javax.swing.*;       // enables development of inputs methods that can run on any Java runtime environment
import java.awt.*;          // original GUI interface, this package predates Java Swing (above)
import java.awt.event.*;    // Used for event classes and listener interface

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield; // holds all the numbers and the result
    JButton[] numberButtons = new JButton[10]; // these will be the digits of calculator
    JButton[] functionButtons = new JButton[9]; // this will be the +-*/ etc.
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    // declare a font, only one font used
    Font myFont = new Font("Calibri", Font.BOLD,30);

    double num1 = 0.0, num2 = 0.0, result = 0.0; // initialize
    char operator; // holds +-*/

    // constructor
    Calculator(){
        frame = new JFrame("Calculator"); // name of the calculator
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows to close out of program, ends Java program
        frame.setSize(420, 550);

        // test run to check if the frame is being created correctly
        frame.setLayout(null);

        textfield = new JTextField(); // instantiation because "null" is used for the setLayout, we need to set the width & height
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont); // declared earlier in code (top)
        textfield.setEditable(false); // will be editable once you click on a button

        // create buttons, then add to array called functionButtons made earlier
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        // set buttons above to functionButtons array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // use a forloop - to set the action lisenter, change font, etc. for function buttons
        // cannot use enhance array because of the javax.swing
        for(int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this); // waiting for user action
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false); // remove outline when button is pressed, helps with esthetics
        }

        // these are anonymous
        // use a forloop - to set the action lisenter, change font, etc. for function buttons
        // cannot use enhance array because of the javax.swing
        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this); // waiting for user action
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false); // remove outline when button is pressed, helps with esthetics
        }

        // delete and clear button is on a different frame
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);


        panel = new JPanel();
        panel.setBounds(50,100,300,300);// bounds for panel
        panel.setLayout(new GridLayout(4,4,10,10)); // button spacing and locations
        // panel.setBackground(Color.GRAY); // debugger to check the location of the button grid

        // reference array, add buttons, created in panel.SetLayout(new GridLayout(etc.));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // always test run to check calculator
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield); // user input
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // adds functions for buttons in calculator

        // check if someone clicks a numberButton, display number
        for (int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        // decimal button
        if(e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat(".")); // but will add extra decimals... // fix?
        }

        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText()); // clear calculator display after function selected
            operator = '+';
            textfield.setText("");
        }

        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText()); // clear calculator display after function selected
            operator = '-';
            textfield.setText("");
        }

        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText()); // clear calculator display after function selected
            operator = '*';
            textfield.setText("");
        }

        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText()); // clear calculator display after function selected
            operator = '/';
            textfield.setText("");
        }

        // equal button is a little different
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());
            switch(operator) { // determine which mathematical operations user wants
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == clrButton) {
            textfield.setText("");
        }

        if(e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }

        if(e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1; // flip the sign
            textfield.setText(String.valueOf(temp));
        }

    } // overide last curly bracket
}
