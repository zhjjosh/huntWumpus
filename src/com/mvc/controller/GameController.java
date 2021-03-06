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
    private String pauseViewStatus;

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
        this.pauseViewStatus = "0";
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
        this.gameView.getShoot1Button().addActionListener(this);
        this.gameView.getShoot2Button().addActionListener(this);
        this.gameView.getShoot3Button().addActionListener(this);
        this.pauseView.getResumeButton().addActionListener(this);
        this.pauseView.getExitMenuItem().addActionListener(this);
        this.monsterView.getPauseMenuItem().addActionListener(this);
        this.monsterView.getExitMenuItem().addActionListener(this);
        this.monsterView.getContinueButton().addActionListener(this);
        this.monsterView.getExitButton().addActionListener(this);

    }

    public GameController() {
        gameModel = new GameModel();
    }

    public void updateGameView(String s) {
        this.world.enterRoom(s);
        String status = this.world.MonsterCheck(true);
        switch (status) {
            case "1":
                this.gameView.setVisible(false);
                this.monsterView.getInfoTextArea().setText(this.world.getFlyingBirdText(s));
                this.monsterView.updateCreatureImg(GameImage.FLYING_BIRD, GameImage.BOOK);
                this.monsterView.getExitButton().setVisible(false);
                this.monsterView.setVisible(true);
                break;
            case "2":
                this.gameView.setVisible(false);
                this.monsterView.getInfoTextArea().setText(this.world.getSleepMonsterText(s));
                this.monsterView.updateCreatureImg(GameImage.OPEN, GameImage.SLEEP);
                this.monsterView.getExitButton().setVisible(false);
                this.monsterView.setVisible(true);
                break;
            case "3":
                this.gameView.setVisible(false);
                this.monsterView.getInfoTextArea().setText(this.world.getHappyMonsterText(s));
                this.monsterView.updateCreatureImg(GameImage.CLOSE, GameImage.HAPPY);
                this.monsterView.getExitButton().setVisible(false);
                this.monsterView.setVisible(true);
                break;
            case "4":
                this.gameView.setVisible(false);
                this.monsterView.getInfoTextArea().setText(this.world.getAngryMonsterText(s));
                this.monsterView.updateCreatureImg(GameImage.CLOSE, GameImage.ANGRY);
                this.monsterView.getExitButton().setVisible(false);
                this.monsterView.setVisible(true);
                break;
            case "5":
                this.gameView.setVisible(false);
                this.monsterView.getInfoTextArea().setText(this.world.getWumpusText(s));
                this.monsterView.updateCreatureImg(GameImage.WUMPUS, GameImage.KILLED);
                this.monsterView.getExitButton().setVisible(true);
                this.monsterView.setVisible(true);
                break;
            default:
                this.gameView.getRoom1Button().setText("Room " + this.world.getRooms()[0]);
                this.gameView.getRoom2Button().setText("Room " + this.world.getRooms()[1]);
                this.gameView.getRoom3Button().setText("Room " + this.world.getRooms()[2]);
                this.gameView.getShoot1Button().setText("Shoot Room " + this.world.getRooms()[0]);
                this.gameView.getShoot2Button().setText("Shoot Room " + this.world.getRooms()[1]);
                this.gameView.getShoot3Button().setText("Shoot Room " + this.world.getRooms()[2]);
                this.gameView.getInfoTextArea().setText(this.world.describe());
                break;
        }

    }

    public void winOrLose(String s) {
        if (this.world.getWumpus().getLabel().equals(s)) {
            this.gameView.setVisible(false);
            this.monsterView.getInfoTextArea().setText(this.world.getVictoryText());
            this.monsterView.updateCreatureImg(GameImage.KILLED_WUPMUS, GameImage.VICTORY);
            this.monsterView.getExitButton().setVisible(true);
            this.monsterView.setVisible(true);
        } else {
            this.gameView.setVisible(false);
            this.monsterView.getInfoTextArea().setText(this.world.getShootFailedText());
            this.monsterView.updateCreatureImg(GameImage.WUMPUS, GameImage.KILLED);
            this.monsterView.getExitButton().setVisible(true);
            this.monsterView.setVisible(true);
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
                || e.getSource() == this.pauseView.getExitMenuItem()
                || e.getSource() == this.monsterView.getExitMenuItem()
                || e.getSource() == this.monsterView.getExitButton()) {
            System.exit(0);
        } else if (e.getSource() == this.ruleView.getContinueButton()) {
            ruleView.setVisible(false);
            gameView.setVisible(true);
        } else if (e.getSource() == this.gameView.getRoom1Button()) {
            updateGameView(gameView.getRoom1Button().getText().substring(5));
            this.world.setFlyingBird();
        } else if (e.getSource() == this.gameView.getRoom2Button()) {
            updateGameView(gameView.getRoom2Button().getText().substring(5));
            this.world.setFlyingBird();
        } else if (e.getSource() == this.gameView.getRoom3Button()) {
            updateGameView(gameView.getRoom3Button().getText().substring(5));
            this.world.setFlyingBird();
        } else if (e.getSource() == this.gameView.getShoot1Button()) {
            winOrLose(gameView.getShoot1Button().getText().substring(11));
        } else if (e.getSource() == this.gameView.getShoot2Button()) {
            winOrLose(gameView.getShoot2Button().getText().substring(11));
        } else if (e.getSource() == this.gameView.getShoot3Button()) {
            winOrLose(gameView.getShoot3Button().getText().substring(11));
        } else if (e.getSource() == this.gameView.getPauseMenuItem()) {
            pauseView.setVisible(true);
            gameView.setVisible(false);
            this.pauseViewStatus = "0";
        } else if (e.getSource() == this.monsterView.getPauseMenuItem()) {
            pauseView.setVisible(true);
            monsterView.setVisible(false);
            this.pauseViewStatus = "1";
        } else if (e.getSource() == this.pauseView.getResumeButton()) {
            pauseView.setVisible(false);
            if ("0".equals(pauseViewStatus)) {
                gameView.setVisible(true);
            } else {
                monsterView.setVisible(true);
            }
        } else if (e.getSource() == this.monsterView.getContinueButton()) {
            if (this.monsterView.getExitButton().isVisible()) {
                this.monsterView.setVisible(false);
                layout = new Layout();
                world = new World(layout);
                updateGameView(this.world.getLocation().getLabel());
                this.gameView.setVisible(true);
            } else {

                String status = this.world.MonsterCheck(false);
                switch (status) {
                    case "1":
                        this.monsterView.setVisible(false);
                        this.updateGameView(this.world.getLocation().getLabel());
                        this.gameView.setVisible(true);
                        break;
                    case "2":
                        this.monsterView.setVisible(false);
                        this.updateGameView(this.world.getWumpusRoom());
                        this.gameView.setVisible(true);
                        break;
                    case "3":
                        this.monsterView.setVisible(false);
                        this.gameView.setVisible(true);
                        break;
                    case "4":
                        this.monsterView.setVisible(false);
                        this.updateGameView(this.world.getRandomRoom());
                        this.gameView.setVisible(true);
                        break;
                    case "5":
                        this.monsterView.setVisible(false);
                        layout = new Layout();
                        world = new World(layout);
                        updateGameView(this.world.getLocation().getLabel());
                        this.gameView.setVisible(true);
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
