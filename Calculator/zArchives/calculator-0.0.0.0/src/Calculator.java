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
// version: 0.0.0.1 = debugging forloops function and number buttons...

import javax.swing.*;       // enables development of inputs methods that can run on any Java runtime environment
import java.awt.*;          // original GUI interface, this package predates Java Swing (above)
import java.awt.event.*;    // Used for event classes and listener interface

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield; // holds all the numbers and the result
    JButton[] numberButtons = new JButton[10]; // these will be the digits of calculator
    JButton[] functionButtons = new JButton[8]; // this will be the +-*/ etc.
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    // declare a font
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

        textfield = new JTextField(); // because "null" is used for the setLayout, we need to set the width & height
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont); // declared earlier in code (top)
        textfield.setEditable(false); // will be editable once you click on a button

        // create buttons, then add to array called functionButtons made earlier
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        // set buttons above to functionButtons array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equButton;
        functionButtons[5] = delButton;
        functionButtons[6] = clrButton;
/**
        // use a forloop - to set the action lisenter, change font, etc. for function buttons
        // cannot use enhance array because of the javax.swing
        for(int i = 0; i < 8; i++) {
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
**/
        // delete and clear button is on a different frame
        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

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

    }
}
