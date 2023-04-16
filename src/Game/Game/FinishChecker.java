package Game.Game;

import Game.Game.GameManger.Game;
import Login.GameList.ListFrame;

import javax.swing.*;

public class FinishChecker {
    private SectionPanel sectionPanel;
    boolean Finish = false;
    boolean win = false;

    public FinishChecker(SectionPanel sectionPanel) {
        this.sectionPanel = sectionPanel;
    }

    public boolean isFinish() {
        return Finish;
    }

    public void setFinish(boolean finish) {
        Finish = finish;
    }

    public SectionPanel getSectionPanel() {
        return sectionPanel;
    }

    public void setSectionPanel(SectionPanel sectionPanel) {
        this.sectionPanel = sectionPanel;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    private void check(){
        if(sectionPanel.getTimer()/1000000000 > sectionPanel.getMainTime()) Finish = true;
        else if(sectionPanel.getMario().getHeart() == 0 ) Finish = true;
    }
    public void updateFC(){
        check();
        if(Finish){
            int score = 0;
           Game game1 = sectionPanel.getGame();
           if(game1!= null) {
               if (game1.isPrevious()) {
                   game1.NEWGAME();
                   game1.setPerCode();
               }
           }


            sectionPanel.getPlayer().setCoins(sectionPanel.getPlayer().getCoins()sectionPanel.getMario().getCoins());
            if(win) {

                sectionPanel.getSm().finalScore((int) (sectionPanel.getMainTime()-sectionPanel.getTimer()/1000000000));
                score = sectionPanel.getSm().score;
                JOptionPane.showMessageDialog(sectionPanel.getSectionFrame(),"You Won! with score: " +score);
            }
            else {
                sectionPanel.getSm().scoreResult();
                score = sectionPanel.getSm().score;
                JOptionPane.showMessageDialog(sectionPanel.getSectionFrame(),"You Lost! with score: " +score);
            }
            if(sectionPanel.getPlayer().getHighestscore()<score) sectionPanel.getPlayer().setHighestscore(score);
            sectionPanel.STOP();
            Game game = sectionPanel.getGame();
            if(game != null){
                game.NEWGAME();
                game.setSCD();
            }

            new ListFrame(sectionPanel.getPlayer());
        }
    }
}
