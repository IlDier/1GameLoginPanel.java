package Login.GameList;

import DataManager.PlayersData.Player;

import javax.swing.*;
import java.awt.*;

public class ListFrame extends JFrame {
    private Dimension FrameSize=new Dimension(700,250);
    private Point Location=new Point(0,0);
    public ListFrame(Player player){
        setSize(FrameSize);
        setLocation(Location);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new ListPanel(this,player));
        setVisible(true);
    }

    public static void main(String[] args) {
        new ListFrame(null);
    }
}
