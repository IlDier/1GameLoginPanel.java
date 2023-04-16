package Login.Loging;


import DataManager.PlayersData.Player;
import Login.GameLogin.GameLoginFrame;
import Login.SignUp.SignUpFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class LoginPanel extends JPanel {
    private Image PanelImage= Toolkit.getDefaultToolkit().createImage("D:/JavaProjects/ApProjectSpring2023/src/Data/LoginPanelBackground.jpg");
    private JTextField Username=new JTextField("");
    private JLabel UsernameLabel =new JLabel("Enter Your Username :");
    private JLabel PasswordLabel=new JLabel("Enter Your Password");
    private JLabel SignUpLabel=new JLabel("Don't have an account? Sing Up Free! Just Click question mark!!!");
    private JPasswordField passwordField=new JPasswordField("");
    private JButton LOGIN_BUTTON =new JButton("Login");
    private JButton SIGN_UP_BUTTON =new JButton();
    private LoginFrame loginFrame;
    private File UsernameandPasswords=new File("D:/JavaProjects/ApProjectSpring2023/src/Data/UsernamesAndPasswords.txt");

    public LoginPanel(LoginFrame loginFrame){
        this.loginFrame=loginFrame;
        setLayout(null);
        setSize(500,500);
        setUsername();
        setPasswordField();
        setLOGIN_BUTTON();
        setSignUpLabel();
        setSIGN_UP_BUTTON();

     repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(PanelImage,0,0,this);

    }

    private void setUsername(){
        Username.setLocation(225,200);
        Username.setSize(150,50);
        Username.setBackground(null);
        UsernameLabel.setBounds(75,200,150,50);
        UsernameLabel.setForeground(Color.CYAN);
        add(UsernameLabel);
        add(Username);
    }
    private void setPasswordField(){
        passwordField.setLocation(225,250);
        passwordField.setSize(150,50);
        passwordField.setBackground(null);
        PasswordLabel.setBounds(75,250,150,50);
        PasswordLabel.setForeground(Color.CYAN);
        add(PasswordLabel);
        add(passwordField);
    }
    private void setLOGIN_BUTTON(){
        LOGIN_BUTTON.setBounds(225,300,150,50);
        LOGIN_BUTTON.setVisible(true);
        add(LOGIN_BUTTON);
        LOGIN_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    String user ="null";
                    boolean check=true;
                    Scanner reader=new Scanner(UsernameandPasswords);
                    while(reader.hasNextLine()&&check){
                        String UP=reader.nextLine();
                        UP=UP.replaceAll("\\s+"," ");
                        String[] s= UP.split(" ");
                        String pas=String.valueOf(passwordField.getPassword());
                        if(s[1].equals(Username.getText().trim())&&s[3].equals(pas)) {
                            JOptionPane.showMessageDialog(loginFrame,"Login Succesfully!");
                            loginFrame.dispose();
                            check=false;
                            user = s[1];
                            break;
                        }
                    }
                    if(!check){
                        Player player = new Player(user);

                        new GameLoginFrame(player);
                    }
                    else {
                        JOptionPane.showMessageDialog(loginFrame, "Please Enter Your password or username correctly!",
                                "ERROR 1402", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception o){}
            }
        });
    }
    private void setSignUpLabel(){
        SignUpLabel.setBounds(100,350,400,100);
        SignUpLabel.setForeground(Color.CYAN);
        SignUpLabel.setFont(Font.getFont(Font.MONOSPACED));
        add(SignUpLabel);
    }
    private void setSIGN_UP_BUTTON(){
        SIGN_UP_BUTTON.setBounds(42,74,110,90);
        SIGN_UP_BUTTON.setOpaque(false);
        SIGN_UP_BUTTON.setContentAreaFilled(false);
        SIGN_UP_BUTTON.setBorderPainted(false);
        SIGN_UP_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                loginFrame.setVisible(false);
                new SignUpFrame();
            }
        });
        add(SIGN_UP_BUTTON);
    }


}
