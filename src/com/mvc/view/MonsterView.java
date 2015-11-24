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
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 *
 * @author Zhjjosh
 */
public class MonsterView extends JFrame {

    private JLabel titleLabel,img1Label,img2Label;
    private JButton continueButton, exitButton;
    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem exitMenuItem, pauseMenuItem;
    private JTextArea infoTextArea;
    private ImageIcon creature1Img, creature2Img;

    public MonsterView() {

       menubar = new JMenuBar();
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        pauseMenuItem = new JMenuItem("Pause");
        exitMenuItem = new JMenuItem("Exit");

        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit the game");

        pauseMenuItem.setMnemonic(KeyEvent.VK_E);
        pauseMenuItem.setToolTipText("Pasue the game");

        menu.add(pauseMenuItem);
        menu.add(exitMenuItem);
        menubar.add(menu);
        setJMenuBar(menubar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(750, 500));
        setTitle("Hunt The Wumpus");
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - 750) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 500) / 2);
        getContentPane().setLayout(null);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource(GameImage.BACKGROUND_IMAGE))));

        infoTextArea = new JTextArea();
        infoTextArea.setFont(new Font("Arial", 1, 18));
        infoTextArea.setText("You are in room 1. \nThere no creature in the room.");
        getContentPane().add(infoTextArea);
        infoTextArea.setBounds(100, 20, 550, 60);
        infoTextArea.setEditable(false);

        img1Label = new JLabel();
        creature1Img = new ImageIcon(getClass().getResource(GameImage.FLYING_BIRD));
        img1Label.setIcon(creature1Img);
        getContentPane().add(img1Label);
        img1Label.setBounds(200, 100, 160, 120);
        
        img2Label = new JLabel();
        creature2Img = new ImageIcon(getClass().getResource(GameImage.FLYING_BIRD));
        img2Label.setIcon(creature2Img);
        getContentPane().add(img2Label);
        img2Label.setBounds(400, 100, 160, 120);
        
        continueButton = new JButton();
        continueButton.setFont(new Font("Arial", 0, 36)); // NOI18N
        continueButton.setText("Continue");
        getContentPane().add(continueButton);
        continueButton.setBounds(200, 250, 350, 50);

        exitButton = new JButton();
        exitButton.setFont(new Font("Arial", 0, 36)); // NOI18N
        exitButton.setText("Exit");
        getContentPane().add(exitButton);
        exitButton.setBounds(200, 350, 350, 50);

        pack();
        //setVisible(true);
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
     * @return the img1Label
     */
    public JLabel getImg1Label() {
        return img1Label;
    }

    /**
     * @param img1Label the img1Label to set
     */
    public void setImg1Label(JLabel img1Label) {
        this.img1Label = img1Label;
    }

    /**
     * @return the img2Label
     */
    public JLabel getImg2Label() {
        return img2Label;
    }

    /**
     * @param img2Label the img2Label to set
     */
    public void setImg2Label(JLabel img2Label) {
        this.img2Label = img2Label;
    }

    /**
     * @return the continueButton
     */
    public JButton getContinueButton() {
        return continueButton;
    }

    /**
     * @param continueButton the continueButton to set
     */
    public void setContinueButton(JButton continueButton) {
        this.continueButton = continueButton;
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

    /**
     * @return the menubar
     */
    public JMenuBar getMenubar() {
        return menubar;
    }

    /**
     * @param menubar the menubar to set
     */
    public void setMenubar(JMenuBar menubar) {
        this.menubar = menubar;
    }

    /**
     * @return the menu
     */
    public JMenu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(JMenu menu) {
        this.menu = menu;
    }

    /**
     * @return the exitMenuItem
     */
    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    /**
     * @param exitMenuItem the exitMenuItem to set
     */
    public void setExitMenuItem(JMenuItem exitMenuItem) {
        this.exitMenuItem = exitMenuItem;
    }

    /**
     * @return the pauseMenuItem
     */
    public JMenuItem getPauseMenuItem() {
        return pauseMenuItem;
    }

    /**
     * @param pauseMenuItem the pauseMenuItem to set
     */
    public void setPauseMenuItem(JMenuItem pauseMenuItem) {
        this.pauseMenuItem = pauseMenuItem;
    }

    /**
     * @return the infoTextArea
     */
    public JTextArea getInfoTextArea() {
        return infoTextArea;
    }

    /**
     * @param infoTextArea the infoTextArea to set
     */
    public void setInfoTextArea(JTextArea infoTextArea) {
        this.infoTextArea = infoTextArea;
    }

    /**
     * @return the creature1Img
     */
    public ImageIcon getCreature1Img() {
        return creature1Img;
    }

    /**
     * @param creature1Img the creature1Img to set
     */
    public void setCreature1Img(ImageIcon creature1Img) {
        this.creature1Img = creature1Img;
    }

    /**
     * @return the creature2Img
     */
    public ImageIcon getCreature2Img() {
        return creature2Img;
    }

    /**
     * @param creature2Img the creature2Img to set
     */
    public void setCreature2Img(ImageIcon creature2Img) {
        this.creature2Img = creature2Img;
    }
    
    public void updateCreatureImg(String s1,String s2) {
        java.net.URL imgUrl1 = getClass().getResource(s1);
        java.net.URL imgUrl2 = getClass().getResource(s2);
        ImageIcon icon1 = new ImageIcon(imgUrl1);
        ImageIcon icon2 = new ImageIcon(imgUrl2);
        img1Label.setIcon(icon1);
        img2Label.setIcon(icon2);
    }
}
