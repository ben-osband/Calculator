/*
Ben Osband
6/24/2023
Calculator.java
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class Calculator extends JFrame implements ActionListener {

    private JLabel label;
    private JPanel answerField;

    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton additionButton;
    private JButton subtractionButton;
    private JButton multiplicationButton;
    private JButton clearButton;
    private JButton equalsButton;
    private JButton divisionButton;



    public Calculator() {
        
        // Setting up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(465, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setResizable(false);
        this.setTitle("Calculator");
        
        ImageIcon logo = new ImageIcon("logo1.png");
        
        this.setIconImage(logo.getImage());
        
        ////////////////////////////// Making the objects and setting up the layout ///////////////////////////////////

        //// Answer bar
        label = new JLabel();
        label.setText("");
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setFont(new Font("Helvetica", Font.BOLD, 50));
        
        answerField = new JPanel();
        answerField.setBounds(10, 10, 430, 100);
        answerField.setBackground(Color.LIGHT_GRAY);
        answerField.setLayout(new BorderLayout());
        answerField.add(label);


        //// First Row
        button1 = new JButton();
        button1.setBounds(10, 120, 100, 100);
        button1.addActionListener(this);
        button1.setText("1");
        button1.setFont(new Font("Monospaced", Font.BOLD, 50));
        button1.setFocusable(false);
        button1.setBackground(Color.GRAY);

        button2 = new JButton();
        button2.setBounds(120, 120, 100, 100);
        button2.addActionListener(this);
        button2.setText("2");
        button2.setFont(new Font("Monospaced", Font.BOLD, 50));
        button2.setFocusable(false);
        button2.setBackground(Color.GRAY);

        button3 = new JButton();
        button3.setBounds(230, 120, 100, 100);
        button3.addActionListener(this);
        button3.setText("3");
        button3.setFont(new Font("Monospaced", Font.BOLD, 50));
        button3.setFocusable(false);
        button3.setBackground(Color.GRAY);

        additionButton = new JButton();
        additionButton.setBounds(340, 120, 100, 100);
        additionButton.addActionListener(this);
        additionButton.setText("+");
        additionButton.setFont(new Font("Monospaced", Font.BOLD, 50));
        additionButton.setFocusable(false);
        additionButton.setBackground(Color.WHITE);

        //// Second Row
        button4 = new JButton();
        button4.setBounds(10, 230, 100, 100);
        button4.addActionListener(this);
        button4.setText("4");
        button4.setFont(new Font("Monospaced", Font.BOLD, 50));
        button4.setFocusable(false);
        button4.setBackground(Color.GRAY);

        button5 = new JButton();
        button5.setBounds(120, 230, 100, 100);
        button5.addActionListener(this);
        button5.setText("5");
        button5.setFont(new Font("Monospaced", Font.BOLD, 50));
        button5.setFocusable(false);
        button5.setBackground(Color.GRAY);

        button6 = new JButton();
        button6.setBounds(230, 230, 100, 100);
        button6.addActionListener(this);
        button6.setText("6");
        button6.setFont(new Font("Monospaced", Font.BOLD, 50));
        button6.setFocusable(false);
        button6.setBackground(Color.GRAY);

        subtractionButton = new JButton();
        subtractionButton.setBounds(340, 230, 100, 100);
        subtractionButton.addActionListener(this);
        subtractionButton.setText("-");
        subtractionButton.setFont(new Font("Monospaced", Font.BOLD, 50));
        subtractionButton.setFocusable(false);
        subtractionButton.setBackground(Color.WHITE);

        //// Third Row
        button7 = new JButton();
        button7.setBounds(10, 340, 100, 100);
        button7.addActionListener(this);
        button7.setText("7");
        button7.setFont(new Font("Monospaced", Font.BOLD, 50));
        button7.setFocusable(false);
        button7.setBackground(Color.GRAY);

        button8 = new JButton();
        button8.setBounds(120, 340, 100, 100);
        button8.addActionListener(this);
        button8.setText("1");
        button8.setFont(new Font("Monospaced", Font.BOLD, 50));
        button8.setFocusable(false);
        button8.setBackground(Color.GRAY);

        button9 = new JButton();
        button9.setBounds(230, 340, 100, 100);
        button9.addActionListener(this);
        button9.setText("9");
        button9.setFont(new Font("Monospaced", Font.BOLD, 50));
        button9.setFocusable(false);
        button9.setBackground(Color.GRAY);

        multiplicationButton = new JButton();
        multiplicationButton.setBounds(340, 340, 100, 100);
        multiplicationButton.addActionListener(this);
        multiplicationButton.setText("*");
        multiplicationButton.setFont(new Font("Monospaced", Font.BOLD, 50));
        multiplicationButton.setFocusable(false);
        multiplicationButton.setBackground(Color.WHITE);

        //// Fourth Row
        clearButton = new JButton();
        clearButton.setBounds(10, 450, 100, 100);
        clearButton.addActionListener(this);
        clearButton.setText("C");
        clearButton.setFont(new Font("Monospaced", Font.BOLD, 50));
        clearButton.setFocusable(false);
        clearButton.setBackground(Color.WHITE);
        
        button0 = new JButton();
        button0.setBounds(120, 450, 100, 100);
        button0.addActionListener(this);
        button0.setText("0");
        button0.setFont(new Font("Monospaced", Font.BOLD, 50));
        button0.setFocusable(false);
        button0.setBackground(Color.GRAY);

        equalsButton = new JButton();
        equalsButton.setBounds(230, 450, 100, 100);
        equalsButton.addActionListener(this);
        equalsButton.setText("=");
        equalsButton.setFont(new Font("Monospaced", Font.BOLD, 50));
        equalsButton.setFocusable(false);
        equalsButton.setBackground(Color.WHITE);

        divisionButton = new JButton();
        divisionButton.setBounds(340, 450, 100, 100);
        divisionButton.addActionListener(this);
        divisionButton.setText("/");
        divisionButton.setFont(new Font("Monospaced", Font.BOLD, 50));
        divisionButton.setFocusable(false);
        divisionButton.setBackground(Color.WHITE);

        /////////////////////////////////////// Adding objects to the frame ///////////////////////////////////////////

        this.add(answerField);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(additionButton);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(subtractionButton);
        this.add(button7);
        this.add(button8);
        this.add(button9);
        this.add(multiplicationButton);
        this.add(clearButton);
        this.add(button0);
        this.add(equalsButton);
        this.add(divisionButton);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Makes the frame visible
        this.setVisible(true);

    }

    @Override
    // Event handler
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action");
    }

    public static void main(String[] args) {
        new Calculator();
    }

}