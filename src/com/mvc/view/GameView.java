/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.view;

import com.mvc.huntwumpus.GameImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Zhjjosh
 */
public class GameView extends JFrame {

    private JLabel imgLabel, room1Label, room2Label, room3Label, roomNo1Label, roomNo2Label, roomNo3Label;
    private ImageIcon creatureImg, roomImg;
    private JTextArea infoTextArea;

    public GameView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(750, 500));
        getContentPane().setLayout(null);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource(GameImage.BACKGROUND_IMAGE))));

        imgLabel = new JLabel();
        creatureImg = new ImageIcon(getClass().getResource(GameImage.FLYING_BIRD));
        imgLabel.setIcon(creatureImg);
        getContentPane().add(imgLabel);
        imgLabel.setBounds(100, 20, 160, 120);

        infoTextArea = new JTextArea();
        infoTextArea.setFont(new Font("Arial", 1, 18));
        infoTextArea.setText("You are in room 1. \nThere no creature in the room.");
        getContentPane().add(infoTextArea);
        infoTextArea.setBounds(300, 20, 350, 120);
        infoTextArea.setEditable(false);

        room1Label = new JLabel();
        roomNo1Label = new JLabel();
        roomNo1Label.setFont(new Font("Arial", 1, 18));
        roomImg = new ImageIcon(getClass().getResource(GameImage.DOOR));
        room1Label.setIcon(roomImg);
        roomNo1Label.setText("ROOM 1");
        roomNo1Label.setForeground(Color.WHITE);
        getContentPane().add(roomNo1Label);
        getContentPane().add(room1Label);
        room1Label.setBounds(100, 200, 160, 200);
        roomNo1Label.setBounds(150, 210, 160, 200);

        room2Label = new JLabel();
        roomNo2Label = new JLabel();
        roomNo2Label.setFont(new Font("Arial", 1, 18));
        roomImg = new ImageIcon(getClass().getResource(GameImage.DOOR));
        room2Label.setIcon(roomImg);
        roomNo2Label.setText("ROOM 2");
        roomNo2Label.setForeground(Color.WHITE);
        getContentPane().add(roomNo2Label);
        getContentPane().add(room2Label);
        room2Label.setBounds(295, 200, 160, 200);
        roomNo2Label.setBounds(345, 210, 160, 200);
        
        room3Label = new JLabel();
        roomNo3Label = new JLabel();
        roomNo3Label.setFont(new Font("Arial", 1, 18));
        roomImg = new ImageIcon(getClass().getResource(GameImage.DOOR));
        room3Label.setIcon(roomImg);
        roomNo3Label.setText("ROOM 3");
        roomNo3Label.setForeground(Color.WHITE);
        getContentPane().add(roomNo3Label);
        getContentPane().add(room3Label);
        room3Label.setBounds(490, 200, 160, 200);
        roomNo3Label.setBounds(540, 210, 160, 200);
        
        pack();
    }
}
