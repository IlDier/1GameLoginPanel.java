package Game.Game;




import DataManager.PlayersData.Player;
import Game.Game.GameManger.Game;

import javax.swing.*;
import java.awt.*;

public class SectionFrame extends JFrame {
    private Point Location = new Point(0,0);
    private int SectionNumber = 1;
    private long timer ;
    private SectionPanel sectionPanel;
    public SectionFrame(int mapNumb, long timer, int coins, int Hearts, Player player, int partNumb,Game game,int score){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(Location);
        setTitle("MARIO MARIO MARIO!");
        setResizable(false);
        sectionPanel = new SectionPanel(this,mapNumb,timer,coins , Hearts,player,partNumb,game,score);
        add(sectionPanel);
        pack();

        sectionPanel.startGame();

        setVisible(true);
    }



    @Override
    public Point getLocation() {
        return Location;
    }

    @Override
    public void setLocation(Point location) {
        Location = location;
    }

    public int getSectionNumber() {
        return SectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        SectionNumber = sectionNumber;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    public SectionPanel getSectionPanel() {
        return sectionPanel;
    }

    public void setSectionPanel(SectionPanel sectionPanel) {
        this.sectionPanel = sectionPanel;
    }


}
