/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import com.mvc.huntwumpus.GameImage;
import com.mvc.model.GameModel;
import com.mvc.model.Layout;
import com.mvc.model.World;
import com.mvc.view.GameView;
import com.mvc.view.MonsterView;
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
    private MonsterView monsterView;
    private GameModel gameModel;
    private Layout layout;
    private World world;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameController gameController = new GameController();
                gameController.initView();
            }
        });
    }

    public void initView() {
        this.startView = new StartView();
        this.ruleView = new RuleView();
        this.gameView = new GameView();
        this.monsterView = new MonsterView();
        layout = new Layout();
        world = new World(layout);
        updateGameView(this.world.getLocation().getLabel());
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

    public void updateGameView(String s) {
        this.world.enterRoom(s);
        String status = this.world.MonsterCheck();
        switch (status) {
            case "1":
                this.gameView.setVisible(false);
                this.monsterView.getInfoTextArea().setText(this.world.getFlyingBirdText(s));
                this.monsterView.updateCreatureImg(GameImage.FLYING_BIRD, GameImage.ANGRY);
                this.monsterView.setVisible(true);
                break;
            case "2":
                
                break;
            case "3":
               
                break;
            case "4":
                
                break;
            case "5":
                
                break;
            default:
                this.gameView.getRoom1Button().setText("Room " + this.world.getRooms()[0]);
                this.gameView.getRoom2Button().setText("Room " + this.world.getRooms()[1]);
                this.gameView.getRoom3Button().setText("Room " + this.world.getRooms()[2]);
                this.gameView.getInfoTextArea().setText(this.world.describe());
                break;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.startView.getStartButton()) {
            ruleView.setVisible(true);
            startView.setVisible(false);
        } else if (e.getSource() == this.startView.getExitButton()
                || e.getSource() == this.startView.getExitMenuItem()
                || e.getSource() == this.ruleView.getExitMenuItem()
                || e.getSource() == this.gameView.getExitMenuItem()
                || e.getSource() == this.pauseView.getExitMenuItem()) {
            System.exit(0);
        } else if (e.getSource() == this.ruleView.getContinueButton()) {
            ruleView.setVisible(false);
            gameView.setVisible(true);
        } else if (e.getSource() == this.gameView.getRoom1Button()) {
            updateGameView(gameView.getRoom1Button().getText().substring(5));
        } else if (e.getSource() == this.gameView.getRoom2Button()) {
            updateGameView(gameView.getRoom2Button().getText().substring(5));
        } else if (e.getSource() == this.gameView.getRoom3Button()) {
            updateGameView(gameView.getRoom3Button().getText().substring(5));
        } else if (e.getSource() == this.gameView.getPauseMenuItem()) {
            pauseView.setVisible(true);
            gameView.setVisible(false);
        } else if (e.getSource() == this.pauseView.getResumeButton()) {
            pauseView.setVisible(false);
            gameView.setVisible(true);
        }
    }

}
