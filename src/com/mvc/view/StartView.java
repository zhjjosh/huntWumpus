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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Zhjjosh
 */
public class StartView extends JFrame {
    
    private JLabel titleLabel;
    private JButton startButton, exitButton;
    
    public StartView(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(750, 500));
        getContentPane().setLayout(null);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource(GameImage.BACKGROUND_IMAGE))));

        titleLabel = new JLabel();
        titleLabel.setFont(new Font("Arial", 1, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setText("Hunt the Wumpus"); 
        getContentPane().add(titleLabel);
        titleLabel.setBounds(200, 20, 350, 150);
        
        startButton = new JButton();
        startButton.setFont(new Font("Arial", 0, 36)); // NOI18N
        startButton.setText("START GAME");
        getContentPane().add(startButton);
        startButton.setBounds(200, 200, 350, 75);

        exitButton = new JButton();
        exitButton.setFont(new Font("Arial", 0, 36)); // NOI18N
        exitButton.setText("Exit");
        getContentPane().add(exitButton);
        exitButton.setBounds(200, 300, 350, 75);

        pack();
        setVisible(true);
    }

    /**
     * @return the titleLabel
     */
    public JLabel getTitleLabel() {
        return titleLabel;
    }

    /**
     * @param titleLabel the titleLabel to set
     */
    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    /**
     * @return the startButton
     */
    public JButton getStartButton() {
        return startButton;
    }

    /**
     * @param startButton the startButton to set
     */
    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    /**
     * @return the exitButton
     */
    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * @param exitButton the exitButton to set
     */
    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }
}
