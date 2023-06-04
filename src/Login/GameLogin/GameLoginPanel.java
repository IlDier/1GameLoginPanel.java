package Login.GameLogin;

import DataManager.IndexChecker.IndexChecker;
import DataManager.PlayersData.Player;
import Game.Game.GameManger.Game;
import Game.Game.SectionFrame;
import Login.GameList.ListFrame;
import Profile.ProfileFrame;
import Store.StoreFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLoginPanel extends JPanel {
    private Image GamePanelImage= Toolkit.getDefaultToolkit().createImage("D:/JavaProjects/ApProjectSpring2023/src/Data/GameLoginBackground.jpg");

    private JButton NEW_GAME=new JButton("New Game");
    private JButton PREVIOUS_GAME=new JButton("Previous Game");
    private JButton HIGHEST_SCORE=new JButton("Highest Score");
    private JButton COINS=new JButton("COINS");
    private JButton QUIT=new JButton("Quit");
    private JButton STORE=new JButton("STORE");
    private JButton INDEX_CODE = new JButton("Index: "+ IndexChecker.getIndex());
    private ImageIcon profile=new ImageIcon("D:/JavaProjects/ApProjectSpring2023/src/Data/Profile.jpg");
    private JButton PROFILE=new JButton(profile);
    private GameLoginFrame gameLoginFrame;
    private Player player ;
    public GameLoginPanel(GameLoginFrame gameLoginFrame, Player player){
        this.player = player;

        this.gameLoginFrame= gameLoginFrame;
        setLayout(null);
        setButtons();
    repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(GamePanelImage,0,0,this);
    }
    private void setButtons(){
        setNEW_GAME();
        setPREVIOUS_GAME();
        setHIGHEST_SCORE();
        setCOINS();
        setSTORE();
        setQUIT();
        setPROFILE();
        setIndexCode();
    }

    private void setNEW_GAME() {
        NEW_GAME.setBounds(250,50,140,86);
        NEW_GAME.setBackground(Color.GREEN);
        NEW_GAME.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                 if( NEW_GAME.getModel().isRollover()) NEW_GAME.setBackground(Color.CYAN);
                else NEW_GAME.setBackground(Color.GREEN);
            }
        });
        NEW_GAME.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListFrame(player);
                gameLoginFrame.dispose();
            }
        });
        add(NEW_GAME);
        NEW_GAME.setVisible(true);
    }

    private void setPREVIOUS_GAME() {
        PREVIOUS_GAME.setBounds(250,136,140,86);
        PREVIOUS_GAME.setBackground(Color.BLUE);
        PREVIOUS_GAME.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(PREVIOUS_GAME.getModel().isRollover()) PREVIOUS_GAME.setBackground(Color.CYAN);
                else PREVIOUS_GAME.setBackground(Color.BLUE);
            }
        });
        PREVIOUS_GAME.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Game game = new Game(player);
                 game.getPer_Code();
                 gameLoginFrame.dispose();
                if(!game.perSave()) game.NEWGAME();
                 new SectionFrame(game.getMapNumb(),game.getTime(),game.getCoins(),game.getHeart(),player,game.getPartNumb(),game,game.getScore());
            }
        });
        PREVIOUS_GAME.setVisible(true);
        add(PREVIOUS_GAME);
    }

    private void setHIGHEST_SCORE() {
        HIGHEST_SCORE.setBounds(250,222,140,86);
        HIGHEST_SCORE.setBackground(Color.YELLOW);
        HIGHEST_SCORE.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(HIGHEST_SCORE.getModel().isRollover()) HIGHEST_SCORE.setBackground(Color.CYAN);
                else HIGHEST_SCORE.setBackground(Color.YELLOW);
            }
        });
        HIGHEST_SCORE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(gameLoginFrame,"Your Highest Score is :"+player.getHighestscore());
            }
        });
        HIGHEST_SCORE.setVisible(true);
        add(HIGHEST_SCORE);
    }

    private void setCOINS() {
        COINS.setBounds(250,308,140,86);
        COINS.setBackground(Color.WHITE);
        COINS.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(COINS.getModel().isRollover()) COINS.setBackground(Color.CYAN);
                else COINS.setBackground(Color.WHITE);
            }
        });
        COINS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(gameLoginFrame,"Your coins Score is :"+player.getCoins());
            }
        });
        COINS.setVisible(true);
        add(COINS);
    }

    private void setSTORE() {
        STORE.setBounds(250,394,140,86);
        STORE.setBackground(Color.MAGENTA);
        STORE.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(STORE.getModel().isRollover()) STORE.setBackground(Color.CYAN);
                else STORE.setBackground(Color.MAGENTA);
            }
        });
        STORE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLoginFrame.dispose();
                new StoreFrame(player);
            }
        });
        STORE.setVisible(true);
        add(STORE);
    }
    private void setQUIT(){
        QUIT.setBounds(250,480,140,86);
        QUIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLoginFrame.dispose();
            }
        });
        QUIT.setBackground(Color.RED);
        QUIT.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(QUIT.getModel().isRollover()) QUIT.setBackground(Color.CYAN);
                else QUIT.setBackground(Color.RED);
            }
        });
        QUIT.setVisible(true);
        add(QUIT);
    }
    private void setPROFILE(){
        PROFILE.setBounds(0,0,100,100);
        PROFILE.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          gameLoginFrame.dispose();
                                          new ProfileFrame(player);
                                      }
                                  });
                add(PROFILE);
    }
    private void setIndexCode(){
        INDEX_CODE.setBounds(250,562,140,86);
        add(INDEX_CODE);
        INDEX_CODE.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(INDEX_CODE.getModel().isRollover()) INDEX_CODE.setBackground(Color.CYAN);
                else INDEX_CODE.setBackground(Color.MAGENTA);
            }
        });
    }
//    private void CHANGE_SHAPE(JButton jButton){
//        jButton.setContentAreaFilled(false);
//        jButton.setFocusPainted(false);
//        jButton.setBorderPainted(false);
//    }
}
