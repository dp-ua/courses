package com.epam.swing.ch1;

import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Getter
public class AddAndPrint extends JFrame {
    private JPanel mainPanel;
    private JLabel labelInfo;
    private JButton printButton;
    private JButton clearButton;
    private JButton addButton;
    private JTextField textAdd;
    private JTextArea textArea;


    public AddAndPrint() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTextToTextPlan(textAdd.getText());
            }
        });
        textAdd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                keyPressedOperate(e);
            }
        });
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printArea();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearArea();
            }
        });
    }

    private void clearArea() {
        textArea.setText("");
    }

    private void printArea() {
        System.out.println(textArea.getText());
    }


    private void clearTextAdd() {
        textAdd.setText("");
    }


    private void keyPressedOperate(KeyEvent event) {
        switch (event.getKeyCode()) {
            case 27: clearTextAdd();
                break;
            default:
        }
    }

    private void showError(String textError) {
        labelInfo.setText(textError);
    }

    private void addTextToTextPlan(String text) {
        if (text.trim().length() == 0) {
            showError("Can't add blank string");
            return;
        }
        textArea.append(text + "\n");
        textAdd.setText((""));
        showError("");

    }

}
