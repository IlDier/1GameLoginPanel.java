package Login.Loging;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private Point Location =new Point(300,0);
    private Dimension FrameSize=new Dimension(660,800);
    private LoginPanel LoginPanel;
    private ImageIcon Mario=new ImageIcon("D:/JavaProjects/ApProjectSpring2023/src/Data/Mario.png");

    public LoginFrame() {
        setTitle("MainMenu");
        setIconImage(Mario.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(FrameSize);
        setLocation(Location);
        setLayout(null);
        setContentPane(LoginPanel=new LoginPanel(this));
        setVisible(true);
    }


    public static void main(String[] args) {
        new LoginFrame();
    }
}
