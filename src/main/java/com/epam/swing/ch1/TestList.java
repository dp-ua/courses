package com.epam.swing.ch1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestList extends JFrame implements ActionListener {
    private JList list;
    private JPanel panel;
    private JButton buttonAddRndNumber;


    public TestList() {
//        list.addComponentListener((ComponentListener) this);
        buttonAddRndNumber.addActionListener(this);

        buttonAddRndNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel) list.getModel();
                model.addElement(Math.round(Math.random() * 1000));
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listMouseClick(e);
            }
        });
    }

    private void listMouseClick(MouseEvent e) {
        if (e.getClickCount() > 1) {
            int index = list.getSelectedIndex();
            DefaultListModel model = (DefaultListModel) list.getModel();
            if (index > -1) model.remove(index);
        }
    }


    private void initList() {
        DefaultListModel model = new DefaultListModel();
        model.addElement("Test 1");
        model.addElement("Mars");
        model.addElement("Yupiter");
        list.setModel(model);
        list.setVisibleRowCount(20);
        list.setAutoscrolls(true);
    }

    public static void main(String[] args) {

    }

    private int rnd() {
        return (int) Math.round(Math.random()*255);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == buttonAddRndNumber) {

            buttonAddRndNumber.setBackground(new Color(rnd(),rnd(),rnd()));
            list.setBackground(new Color(rnd(),rnd(),rnd()));
            this.setBackground(new Color(rnd(),rnd(),rnd()));
        }
    }
}
