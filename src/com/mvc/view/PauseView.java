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
public class PauseView extends JFrame{
    private JLabel titleLabel1, titleLabel2;
    private JButton resumeButton;
    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem exitMenuItem;

    public PauseView() {

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

        titleLabel1 = new JLabel();
        titleLabel1.setFont(new Font("Arial", 1, 18));
        titleLabel1.setForeground(Color.WHITE);
        titleLabel1.setText("Your game has been pasue.");
        getContentPane().add(titleLabel1);
        titleLabel1.setBounds(200, 20, 350, 150);
        
        titleLabel2 = new JLabel();
        titleLabel2.setFont(new Font("Arial", 1, 18));
        titleLabel2.setForeground(Color.WHITE);
        titleLabel2.setText("Please click resume to resume the game.");
        getContentPane().add(titleLabel2);
        titleLabel2.setBounds(200, 40, 400, 150);

        resumeButton = new JButton();
        resumeButton.setFont(new Font("Arial", 0, 36)); // NOI18N
        resumeButton.setText("Resume");
        getContentPane().add(resumeButton);
        resumeButton.setBounds(200, 200, 350, 75);

        pack();
    }

    /**
     * @return the titleLabel1
     */
    public JLabel getTitleLabel1() {
        return titleLabel1;
    }

    /**
     * @param titleLabel1 the titleLabel1 to set
     */
    public void setTitleLabel1(JLabel titleLabel1) {
        this.titleLabel1 = titleLabel1;
    }

    /**
     * @return the titleLabel2
     */
    public JLabel getTitleLabel2() {
        return titleLabel2;
    }

    /**
     * @param titleLabel2 the titleLabel2 to set
     */
    public void setTitleLabel2(JLabel titleLabel2) {
        this.titleLabel2 = titleLabel2;
    }

    /**
     * @return the resumeButton
     */
    public JButton getResumeButton() {
        return resumeButton;
    }

    /**
     * @param resumeButton the resumeButton to set
     */
    public void setResumeButton(JButton resumeButton) {
        this.resumeButton = resumeButton;
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
