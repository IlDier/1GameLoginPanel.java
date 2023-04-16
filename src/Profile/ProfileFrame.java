package Profile;

import DataManager.PlayersData.Player;

import javax.swing.*;
import java.awt.*;

public class ProfileFrame extends JFrame {
    private Point Location =new Point(330,0);
    private Dimension FrameSize=new Dimension(600,800);
    private JLabel passwordLabel ;
    private JLabel usernameLabel ;
    private JLabel highestscoreLabel ;
    private JComboBox<String> heros ;
    private String[] Heros = {"dario","sario","kario","lario"};
    public ProfileFrame(Player player){
        setTitle("PROFILE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(FrameSize);
        setLocation(Location);
        setContentPane(new ProfilePanel(this,player));
        setVisible(true);


    }

    public static void main(String[] args) {
        Player kokomba = new Player("Kokomba");
        new ProfileFrame(kokomba);
    }
}
