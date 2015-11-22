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
import javax.swing.SwingConstants;

/**
 *
 * @author Zhjjosh
 */
public class GameView extends JFrame {

    private JLabel imgLabel;
    private ImageIcon creatureImg, roomImg;
    private JTextArea infoTextArea;
    private JButton room1Button, room2Button, room3Button;
    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem exitMenuItem, pauseMenuItem;

    public GameView() {

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

        room1Button = new JButton();
        room1Button.setFont(new Font("Arial", 1, 18));
        roomImg = new ImageIcon(getClass().getResource(GameImage.DOOR));
        room1Button.setIcon(roomImg);
        room1Button.setText("ROOM 1");
        room1Button.setForeground(Color.WHITE);
        getContentPane().add(room1Button);
        room1Button.setBounds(100, 200, 160, 200);
        room1Button.setHorizontalTextPosition(SwingConstants.CENTER);

        room2Button = new JButton();
        room2Button.setFont(new Font("Arial", 1, 18));
        room2Button.setIcon(roomImg);
        room2Button.setText("ROOM 2");
        room2Button.setForeground(Color.WHITE);
        getContentPane().add(room2Button);
        room2Button.setBounds(295, 200, 160, 200);
        room2Button.setHorizontalTextPosition(SwingConstants.CENTER);

        room3Button = new JButton();
        room3Button.setFont(new Font("Arial", 1, 18));
        room3Button.setIcon(roomImg);
        room3Button.setText("ROOM 3");
        room3Button.setForeground(Color.WHITE);
        getContentPane().add(room3Button);
        room3Button.setBounds(490, 200, 160, 200);
        room3Button.setHorizontalTextPosition(SwingConstants.CENTER);

        pack();
    }

    /**
     * @return the imgLabel
     */
    public JLabel getImgLabel() {
        return imgLabel;
    }

    /**
     * @param imgLabel the imgLabel to set
     */
    public void setImgLabel(JLabel imgLabel) {
        this.imgLabel = imgLabel;
    }

    /**
     * @return the creatureImg
     */
    public ImageIcon getCreatureImg() {
        return creatureImg;
    }

    /**
     * @param creatureImg the creatureImg to set
     */
    public void setCreatureImg(ImageIcon creatureImg) {
        this.creatureImg = creatureImg;
    }

    /**
     * @return the roomImg
     */
    public ImageIcon getRoomImg() {
        return roomImg;
    }

    /**
     * @param roomImg the roomImg to set
     */
    public void setRoomImg(ImageIcon roomImg) {
        this.roomImg = roomImg;
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
     * @return the room1Button
     */
    public JButton getRoom1Button() {
        return room1Button;
    }

    /**
     * @param room1Button the room1Button to set
     */
    public void setRoom1Button(JButton room1Button) {
        this.room1Button = room1Button;
    }

    /**
     * @return the room2Button
     */
    public JButton getRoom2Button() {
        return room2Button;
    }

    /**
     * @param room2Button the room2Button to set
     */
    public void setRoom2Button(JButton room2Button) {
        this.room2Button = room2Button;
    }

    /**
     * @return the room3Button
     */
    public JButton getRoom3Button() {
        return room3Button;
    }

    /**
     * @param room3Button the room3Button to set
     */
    public void setRoom3Button(JButton room3Button) {
        this.room3Button = room3Button;
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
}
