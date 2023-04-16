package Profile;

import DataManager.PlayersData.Player;
import Login.GameLogin.GameLoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ProfilePanel extends JPanel {
    private JLabel usernameLabel = new JLabel();
    private JLabel passwordLabel = new JLabel();
    private JLabel coinsLabel = new JLabel();
    private JLabel highestscoreLabel = new JLabel();
    private JLabel selectionLabel = new JLabel();
    private JButton BACK_BUTTON = new JButton("BACK");
    private JButton SET = new JButton("Set");
    private String[] Heros = {"mario","sario","kario","lario","jario"};
    private JComboBox heros = new JComboBox(Heros);
    private ProfileFrame profileFrame;
    private BufferedImage mainHero ;
    private Player player;
    public ProfilePanel(ProfileFrame profileFrame,Player player){
        this.player = player ;
        this.profileFrame = profileFrame ;
        setLayout(null);

        setLabels();
        setButtons();
        setComboBoxes();

    }
    private void setButtons(){
        setBACKBUTTON();
        setSETBUTTON();
    }
    private void setSETBUTTON(){
        SET.setBounds(350,50,80,50);
        SET.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(heros.getSelectedIndex() == 0) player.setHeroCode(0);
                else if (heros.getSelectedIndex() == 1) player.setHeroCode(1);
                else if (heros.getSelectedIndex() == 2) player.setHeroCode(2);
                else if (heros.getSelectedIndex() == 3) player.setHeroCode(3);
                else if (heros.getSelectedIndex() == 4) player.setHeroCode(4);
            }
        });
        add(SET);
    }
    private void setBACKBUTTON(){
        BACK_BUTTON.setSize(160,100);
        BACK_BUTTON.setLocation(250,500);
        BACK_BUTTON.setBackground(Color.yellow);
        BACK_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileFrame.dispose();
                new GameLoginFrame(player);
            }
        });
        add(BACK_BUTTON);
    }
    private void setLabels(){
        setUsernameLabel();
        setHighestscoreLabel();
        setCoinsLabel();
        setPasswordLabel();
        setSelectionLabel();
    }

    private void setUsernameLabel() {
        usernameLabel.setText("Your username is : "+player.getUsername());
        usernameLabel.setBounds(100,100,500,100);
        usernameLabel.setFont(new Font( "SansSerif", Font. PLAIN, 30 ));
        usernameLabel.setForeground(Color.red);
        add(usernameLabel);
    }

    private void setPasswordLabel() {
        passwordLabel.setText("Your password is : "+player.getPassword());
        passwordLabel.setBounds(100,200,500,100);
        passwordLabel.setFont(new Font( "SansSerif", Font. PLAIN, 30 ));
        add(passwordLabel);

    }

    private void setCoinsLabel() {
        coinsLabel.setText("Your Coins is : "+player.getCoins());
        coinsLabel.setBounds(100,300,500,100);
        coinsLabel.setFont(new Font( "SansSerif", Font. PLAIN, 30 ));
        coinsLabel.setForeground(Color.yellow);
        add(coinsLabel);

    }

    private void setHighestscoreLabel() {
        highestscoreLabel.setText("Your Highest score is : "+player.getHighestscore());
        highestscoreLabel.setBounds(100,400,500,100);
        highestscoreLabel.setFont(new Font( "SansSerif", Font. PLAIN, 30 ));
        highestscoreLabel.setForeground(Color.blue);
        add(highestscoreLabel);
    }
    private void setSelectionLabel(){
        selectionLabel.setText("Select Your Hero : ");
        selectionLabel.setBounds(45,30,300,100);
        selectionLabel.setFont(new Font( "SansSerif", Font. PLAIN, 20 ));
        selectionLabel.setForeground(Color.green);
        add(selectionLabel);

    }
    private void setComboBoxes(){
        setHerosCombobox();
    }
    private void setHerosCombobox(){
        heros.setBounds(200,50,100,50);
        add(heros);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g ;
//        g2.drawImage(mainHero,100,0,100,100,null);
    }
}
