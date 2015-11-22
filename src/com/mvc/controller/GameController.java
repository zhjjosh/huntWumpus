/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import com.mvc.model.GameModel;
import com.mvc.view.GameView;
import com.mvc.view.PauseView;
import com.mvc.view.RuleView;
import com.mvc.view.StartView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author itmanager
 */
public class GameController implements ActionListener {

    private StartView startView;
    private RuleView ruleView;
    private GameView gameView;
    private PauseView pauseView;
    private GameModel gameModel;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameController game = new GameController();
                game.initView();
            }
        });
    }

    public void initView() {
        this.startView = new StartView();
        this.ruleView = new RuleView();
        this.gameView = new GameView();
        this.pauseView = new PauseView();
        this.startView.getStartButton().addActionListener(this);
        this.startView.getExitButton().addActionListener(this);
        this.startView.getExitMenuItem().addActionListener(this);
        this.ruleView.getContinueButton().addActionListener(this);
        this.ruleView.getExitMenuItem().addActionListener(this);
        this.gameView.getRoom1Button().addActionListener(this);
        this.gameView.getRoom2Button().addActionListener(this);
        this.gameView.getRoom3Button().addActionListener(this);
        this.gameView.getPauseMenuItem().addActionListener(this);
        this.gameView.getExitMenuItem().addActionListener(this);
        this.pauseView.getResumeButton().addActionListener(this);
        this.pauseView.getExitMenuItem().addActionListener(this);
    }

    public GameController() {
        gameModel = new GameModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.startView.getStartButton()) {
            ruleView.setVisible(true);
            startView.setVisible(false);
        } else if (e.getSource() == this.startView.getExitButton()
                ||e.getSource() == this.startView.getExitMenuItem()
                ||e.getSource() == this.ruleView.getExitMenuItem()
                ||e.getSource() == this.gameView.getExitMenuItem()
                ||e.getSource() == this.pauseView.getExitMenuItem()) {
            System.exit(0);
        } else if (e.getSource() == this.ruleView.getContinueButton()) {
            ruleView.setVisible(false);
            gameView.setVisible(true);
        }else if (e.getSource() == this.gameView.getRoom1Button()) {

        }else if (e.getSource() == this.gameView.getRoom2Button()) {

        }else if (e.getSource() == this.gameView.getRoom3Button()) {

        }else if (e.getSource() == this.gameView.getPauseMenuItem()) {
            pauseView.setVisible(true);
            gameView.setVisible(false);
        }else if (e.getSource() == this.pauseView.getResumeButton()) {
            pauseView.setVisible(false);
            gameView.setVisible(true);
        }
    }

}
