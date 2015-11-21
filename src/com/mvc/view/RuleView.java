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
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author Zhjjosh
 */
public class RuleView extends JFrame {

    private JLabel titleLabel;
    private JScrollPane ruleScrollPane;
    private JList ruleList;
    private JButton continueButton;

    @SuppressWarnings("unchecked")
    public RuleView() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(750, 500));
        getContentPane().setLayout(null);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource(GameImage.BACKGROUND_IMAGE))));

        titleLabel = new JLabel();
        titleLabel.setFont(new Font("Arial", 1, 36));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setText("Rule");
        getContentPane().add(titleLabel);
        titleLabel.setBounds(350, 5, 160, 120);

        ruleList = new JList();
        ruleList.setModel(new AbstractListModel() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });

        ruleScrollPane = new JScrollPane();
        ruleScrollPane.setViewportView(ruleList);
        getContentPane().add(ruleScrollPane);
        ruleScrollPane.setBounds(120, 110, 560, 200);

        continueButton = new JButton();
        continueButton.setFont(new Font("Arial", 0, 36)); // NOI18N
        continueButton.setText("Continue");
        getContentPane().add(continueButton);
        continueButton.setBounds(200, 350, 350, 75);

        pack();
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
     * @return the ruleScrollPane
     */
    public JScrollPane getRuleScrollPane() {
        return ruleScrollPane;
    }

    /**
     * @param ruleScrollPane the ruleScrollPane to set
     */
    public void setRuleScrollPane(JScrollPane ruleScrollPane) {
        this.ruleScrollPane = ruleScrollPane;
    }

    /**
     * @return the ruleList
     */
    public JList getRuleList() {
        return ruleList;
    }

    /**
     * @param ruleList the ruleList to set
     */
    public void setRuleList(JList ruleList) {
        this.ruleList = ruleList;
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
}
