package Login.GameList;

import DataManager.IndexChecker.IndexChecker;
import DataManager.PlayersData.Player;
import Game.Game.GameManger.Game;
import Game.Game.SectionFrame;
import Game.Game.SectionPanel;
import Login.GameLogin.GameLoginFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListPanel extends JPanel {
    private Player player;
    private JButton GO = new JButton("GO!");
    private JButton BACK = new JButton("Back");
    private JButton NEW_GAME = new JButton("New Game");
    private JButton SET = new JButton("SET");
    private String[] gameCode = {"FirstGame","SecondGame","ThirdGame"};
    private JComboBox jc;
    private ListFrame listFrame;
    public ListPanel(ListFrame listFrame, Player player){
        this.listFrame = listFrame;
        this.player = player;
        jc = new JComboBox(gameCode);


        setLayout(null);
        setButtons();
        setActions();
        setJComboBoxes();

    }
    private void setJComboBoxes(){
        setJc();
    }
    private void setJc(){
        jc.setBounds(150,50,120,25);
        add(jc);
    }
    private void setActions(){
        setBACKAction();
        setGOAction();
        setNEW_GAMEAction();
        setSETAction();
    }
    private void setButtons(){
        setNEW_GAME();
        setGO();
        setBACK();
        setSET();
    }
    private void setSET(){
        SET.setBounds(200,100,100,60);
        add(SET);
    }
    private void setSETAction(){
        SET.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IndexChecker.setIndex(jc.getSelectedIndex());
            }
        });
    }
    private void setNEW_GAME(){

        NEW_GAME.setBounds(40,20,100,66);
        add(NEW_GAME);
    }
    private void setNEW_GAMEAction(){
        NEW_GAME.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listFrame.dispose();
                player.updateHero();
                new SectionFrame(0,0,0,3,player,1,null,0);
            }
        });
    }
    private void setGO(){
        GO.setBounds(40,86,100,66);
        add(GO);

    }
    private void setGOAction(){
        GO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listFrame.dispose();
                Game game = new Game(player);
                game.setPrevious(true);
                if(!game.issaveD()) game.NEWGAME();
                new SectionFrame(game.getMapNumb(),game.getTime(),game.getCoins(),game.getHeart(),player,game.getPartNumb(),game,game.getScore());
            }
        });
    }
    private void setBACK(){
        BACK.setBounds(40,152,100,66);
        add(BACK);

    }
    private void setBACKAction(){
        BACK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listFrame.dispose();
                new GameLoginFrame(player);
            }
        });
    }



}
