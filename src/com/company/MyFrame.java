package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{
    JLabel label1, label2;
    JButton button;
    JTextArea area;
    JEditorPane pane;
    Font font = new Font("Arial", Font.PLAIN, 20);

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("IBAN Validator");
        this.setSize(875,500);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(Color.lightGray);

        area = new JTextArea();
        area.setBounds(50,50,350,300);
        area.setLineWrap(true);
        area.setFont(font);

        button = new JButton("Validate");
        button.setBounds(350,375,150,50);
        button.addActionListener(this);
        button.setFont(font);

        pane = new JEditorPane();
        pane.setBounds(450, 50, 350,300);
        pane.setFont(font);
        pane.setEditable(false);

        label1 = new JLabel("IBAN");
        label1.setFont(font);

        label2 = new JLabel("Validation result");
        label2.setFont(font);

        this.add(area);
        this.add(button);
        this.add(pane);
        this.add(label1);
        this.add(label2);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pane.setText("");
        String text = area.getText();
        String[] words = text.split(",");
        for(String word : words){
            if(word.isBlank())
                continue;

            pane.setText(pane.getText() + word.trim() + IBAN_Validator.iban_Validator(word));
        }
    }
}
