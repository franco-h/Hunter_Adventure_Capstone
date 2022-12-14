package com.huntersadventure.swing;


import com.huntersadventure.game.Combat;
import com.huntersadventure.game.GameController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePage {

    public  JFrame window;
    JPanel topPanel, inventoryPanel, dialogPanel, mapPanel, textPanel;
    JScrollPane scrollPane;
    JLabel map;
    ImageIcon mapSrc, mapImg;
    Image resizeMap, resizedMap;
    Container container;

    // work with dialogue and text panel
    public String text = "";
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 24);
    public JTextArea mainText;
    JTextField test = new JTextField(20);

    public GamePage(){
        window = new JFrame("A Hunter's Adventure");
        window.setSize(1200, 900);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setLocationRelativeTo(null);

        container = window.getContentPane();

        //top panel
        topPanel = new JPanel();
        topPanel.setBounds(10, 10, 1175, 55);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
        topPanel.setBackground(Color.black);
        container.add(topPanel);

        //inventory panel
        inventoryPanel = new JPanel(new GridLayout(2,0));
        inventoryPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        inventoryPanel.setBounds(10, 70, 100, 100);
        inventoryPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setPreferredSize(new Dimension(600, 500));
        scrollPane = new JScrollPane(inventoryPanel);
        scrollPane.setAlignmentY(Component.CENTER_ALIGNMENT);
        scrollPane.setBounds(10, 70, 577, 350);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        container.add(scrollPane);

        //map image src
        mapSrc = new ImageIcon("src/main/resources/GameText/map.png");
        resizeMap = mapSrc.getImage();
        resizedMap = resizeMap.getScaledInstance(550,330, Image.SCALE_SMOOTH);
        mapImg = new ImageIcon(resizedMap);
        map = new JLabel(mapImg);

        //map
        mapPanel = new JPanel();
        mapPanel.setBounds(590, 70, 595, 350);
        mapPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        mapPanel.setBackground(Color.black);
        mapPanel.add(map);
        container.add(mapPanel);

        //dialog
        dialogPanel = new JPanel();
        dialogPanel.setBounds(10, 425, 1175, 350);
        dialogPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        dialogPanel.setBackground(Color.black);
        container.add(dialogPanel);

        mainText = new JTextArea("Welcome to the Hunter's Adventure!\n" +
                "Would you like to hear the back story? (y/n)");
        mainText.setBounds(20, 500, 1000, 250);
        mainText.setBackground(Color.black);
        mainText.setForeground(Color.white);
        mainText.setFont(normalFont);
        mainText.setLineWrap(true);
        mainText.setWrapStyleWord(true);
        mainText.setEditable(false);

        dialogPanel.add(mainText);

        //text panel
        textPanel = new JPanel();
        textPanel.setBounds(10, 780, 1175, 65);
        textPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
        textPanel.setBackground(Color.black);
        window.setVisible(true);
        container.add(textPanel);

        textPanel.add(test, "left");

        // action listener and threading for player input
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = test.getText();
                test.setText("");

                synchronized (GameController.class) {
                    GameController.class.notifyAll();
                }

                synchronized (Combat.class) {
                    Combat.class.notifyAll();
                }
            }
        });
    }

//    public static void main(String[] args) {
//        new GamePage();
//    }
}