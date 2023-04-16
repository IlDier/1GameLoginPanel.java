package Store;

import DataManager.PlayersData.Player;

import javax.swing.*;
import java.awt.*;

public class StoreFrame extends JFrame {
    private Point Location =new Point(300,0);
    private Dimension FrameSize=new Dimension(660,800);
    private StorePanel storePanel;

    public StoreFrame(Player player) {
        setTitle("Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FrameSize);
        setLocation(Location);
        setLayout(null);
        setContentPane(new StorePanel(this,player));
        setVisible(true);

    }

}
