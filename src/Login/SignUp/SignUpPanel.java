package Login.SignUp;

import Game.Game.SectionPanel;
import Login.Loging.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SignUpPanel extends JPanel {
    private JTextField Username=new JTextField("");
    private JTextField password=new JTextField("");
    private JLabel UsernameLabel=new JLabel("EnterYourUsername(at least 4 character) :");
    private JLabel passwordLabel=new JLabel("EnterYourPassword(at least 4 character) :");
    private JButton OK=new JButton("Sign Up!");
    private JButton BACK_BUTTON=new JButton("BACK");
    private SignUpFrame signUpFrame;
    private File UsernameandPasswords=new File("D:/JavaProjects/ApProjectSpring2023/src/Data/UsernamesAndPasswords.txt");
    private Image background= Toolkit.getDefaultToolkit().createImage("D:/JavaProjects/ApProjectSpring2023/src/Data/SignUpBackGround.png");
    public SignUpPanel(SignUpFrame signUpFrame){
        this.signUpFrame=signUpFrame;
        setLayout(null);
         setButtons();
         setTexes();
         setLabels();
         setActionButtons();
         repaint();
    }
    //Set Buttons Here
    private void setButtons(){
        setOK();
        setBACK_BUTTON();
    }
    private void setOK(){
        OK.setSize(125,75);
        OK.setLocation(100,200);
        OK.setVisible(true);
        OK.setForeground(Color.BLACK);
        add(OK);
    }
    private void setBACK_BUTTON(){
        BACK_BUTTON.setSize(125,75);
        BACK_BUTTON.setLocation(225,200);
        BACK_BUTTON.setVisible(true);
        BACK_BUTTON.setForeground(Color.BLACK);
        add(BACK_BUTTON);
    }
    // Set Texes Here
    private void setTexes(){
        setUsername();
        setPassword();
    }

    private void setUsername(){
        Username.setSize(100,50);
        Username.setLocation(250,50);
        Username.setVisible(true);
        add(Username);
    }
    private void setPassword(){
        password.setSize(100,50);
        password.setLocation(250,105);
        password.setVisible(true);
        add(password);
    }
    // Set Labels Here
    private void setLabels(){
        setPasswordLabel();
        setUsernameLabel();
    }
    private void setPasswordLabel(){
        passwordLabel.setBounds(0,50,250,50);
        passwordLabel.setForeground(Color.BLACK);
        add(passwordLabel);
    }
    private void setUsernameLabel(){
        UsernameLabel.setBounds(0,100,250,50);
        UsernameLabel.setForeground(Color.BLACK);
        add(UsernameLabel);
    }
    // SetActionButtons here
    private void setActionButtons(){
        setBACK_BUTTONAction();
        setOKAction();
    }
    private void setBACK_BUTTONAction(){
        BACK_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpFrame.dispose();
                new LoginFrame();
            }
        });
    }
    private void setOKAction(){
         OK.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                  if(Username.getText().length()>3&&password.getText().length()>3){
                      JOptionPane.showMessageDialog(null,"Sign Up Successfully!");
                  try {
                      FileWriter fr=new FileWriter(UsernameandPasswords,true);
                      BufferedWriter br=new BufferedWriter(fr);
                      br.write("Username: "+Username.getText()+" Password: "+password.getText());
                      File file = new File("D:/JavaProjects/ApProjectSpring2023/src/DataManager/PlayersData/Players.txt");
                      FileWriter fr1=new FileWriter(file,true);
                      BufferedWriter br1=new BufferedWriter(fr1);
                      int floor = SectionPanel.floor;
                      br1.write("Username: "+Username.getText()+" Password: "+password.getText()+" coins: 0 Highestscore: 0 Herocode: 0 StoreCode: 00000 secretCode1: 0:0:0:3:0:0:0:"+ floor+":1:0:1 secretCode2: 0:0:0:3:0:0:0:"+floor+":1:0:2 secretddCode3: 0:0:0:3:0:0:0:"+floor+":1:0:3 Index: 0 perCode: 0:0:0:3:0:0:0:"+floor+":1:0:0");

                      br1.newLine();
                      br.newLine();
                      br.close();
                      fr.close();
                      br1.close();;
                      fr1.close();

                  } catch (Exception o){}
                      signUpFrame.dispose();
                      new LoginFrame();
                  }
                  else JOptionPane.showMessageDialog(signUpFrame, "Please Enter Your password or username correctly!",
                          "ERROR 1401", JOptionPane.ERROR_MESSAGE);
             }
         });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background,0,0,this);

    }
}
