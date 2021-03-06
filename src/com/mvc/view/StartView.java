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

/**
 *
 * @author Zhjjosh
 */
public class StartView extends JFrame {

    private JLabel titleLabel;
    private JButton startButton, exitButton;
    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem exitMenuItem;

    public StartView() {

        menubar = new JMenuBar();
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);

        exitMenuItem = new JMenuItem("Exit");

        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit the game");

        menu.add(exitMenuItem);
        menubar.add(menu);
        setJMenuBar(menubar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(750, 500));
        setTitle("Hunt The Wumpus");
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - 750) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 500) / 2);
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
}
