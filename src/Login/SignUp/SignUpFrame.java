package Login.SignUp;

import javax.swing.*;
import java.awt.*;

public class SignUpFrame extends JFrame {
    private Point Location=new Point(100,100);
    private Dimension FrameSize=new Dimension(450,300);
    private SignUpPanel SignUpPanel;
    public SignUpFrame(){
        setSize(FrameSize);
        setLayout(null);
        setLocation(Location);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(SignUpPanel=new SignUpPanel(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpFrame();
    }
}
