package Login.GameLogin;


import DataManager.PlayersData.Player;

import javax.swing.*;
import java.awt.*;

public class GameLoginFrame extends JFrame {
    private Point Location=new Point(50,50);
    private Dimension FrameSize=new Dimension(700,800);
    private ImageIcon Mario=new ImageIcon("D:/JavaProjects/ApProjectSpring2023/src/Data/Mario.png");


//    private JButton PROFILE=new JButton();
    public GameLoginFrame(Player player){
        setTitle("Game Menu");
        setIconImage(Mario.getImage());
      setLocation(Location);
      setSize(FrameSize);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(null);
      setContentPane( new GameLoginPanel(this,player));
      setVisible(true);
    }

    public static void main(String[] args) {
     Player player = new Player("Kokomba");
     new GameLoginFrame(player);
    }

}
