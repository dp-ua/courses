package com.epam.swing;

import com.epam.swing.ch1.AddAndPrint;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test list");
        AddAndPrint addAndPrint = new AddAndPrint();
        frame.setContentPane(addAndPrint.getMainPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getRootPane().setDefaultButton(addAndPrint.getAddButton());
    }

}
