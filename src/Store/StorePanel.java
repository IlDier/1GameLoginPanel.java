package Store;

import DataManager.PlayersData.Player;
import Login.GameLogin.GameLoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StorePanel extends JPanel {
    private JButton JARIO = new JButton("Buy JARIO ");  // Jario who can jump better than mario
    private JButton SARIO = new JButton("By sario"); // sario who can faster than mario
    private JButton KARIO = new JButton("By kario"); // absorb coins
    private JButton LARIO = new JButton("By lario"); // better Thrower !!
    private JButton BACK = new JButton("Back") ;
    private JLabel coins = new JLabel("Your Coins is :");
    private StoreFrame storeFrame;
    private Player player;
    public StorePanel(StoreFrame storeFrame,Player player){
        this.storeFrame = storeFrame;
        this.player = player;


        setButtons();

        setButtonsActions();


        setLabels();
    }
    private void updateCoin(){
        coins.setText("Your Coin is : "+player.getCoins());

    }
    private void setLabels(){
        setCoinLabel();
    }
    private  void setButtons(){
        setLayout(null);

        setJARIO();
        setSario();
        setKario();
        setLario();
        setBACK();

    }

    private void setBACK() {
        BACK.setBounds(500,500,160,100);
        add(BACK);
    }
    private void setBACKAction(){
        BACK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.dispose();
                new GameLoginFrame(player);
            }
        });
    }

    private void setJARIO() {
        JARIO.setLocation(100,100);
        JARIO.setSize(160,100);
        add(JARIO);
    }

    private void setSario() {
        SARIO.setLocation(100,250);
        SARIO.setSize(160,100);
        add(SARIO);
    }

    private void setKario() {
        KARIO.setLocation(100,400);
        KARIO.setSize(160,100);
        add(KARIO);
    }

    private void setLario() {
        LARIO.setLocation(100,550);
        LARIO.setSize(160,100);
        add(LARIO);
    }
    private void setButtonsActions(){
        setSaroioAction();
        setKarioAction();
        setLarioAction();
        setJarioAction();
        setBACKAction();

    }
    private void setSaroioAction(){
        SARIO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.getStoreCode().charAt(1) != '1') {
                    if (player.getCoins() > 15) {

                        player.setCoins(player.getCoins() - 15);
                        player.setHeroCode(1);
                        changeStoreCode(1);
                        updateCoin();
                    } else JOptionPane.showMessageDialog(storeFrame, "You Don't have enough coins! It needs 15 coins at least.",
                            "Error 11402", JOptionPane.ERROR_MESSAGE);
                }
                else JOptionPane.showMessageDialog(storeFrame, "It has been bought!!!!!!",
                        "Error 114055", JOptionPane.ERROR_MESSAGE);
            }
        });

    }
    private void setKarioAction(){
        KARIO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.getStoreCode().charAt(2) != '1') {
                    if (player.getCoins() > 20) {
                        player.setCoins(player.getCoins() - 20);
                        player.setHeroCode(2);
                        changeStoreCode(2);
                        updateCoin();
                    } else JOptionPane.showMessageDialog(storeFrame, "You Don't have enough coins! It needs 20 coins at least.",
                            "Error 11402", JOptionPane.ERROR_MESSAGE);
                }
                else JOptionPane.showMessageDialog(storeFrame, "It has been bought!!!!!!",
                        "Error 114055", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    private void setLarioAction(){
        LARIO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(player.getStoreCode().charAt(3) != '1') {
                    if (player.getCoins() > 25) {
                        player.setCoins(player.getCoins() - 25);
                        player.setHeroCode(3);
                        changeStoreCode(3);
                        updateCoin();
                    } else JOptionPane.showMessageDialog(storeFrame, "You Don't have enough coins! It needs 25 coins at least.",
                            "Error 11402", JOptionPane.ERROR_MESSAGE);
                }
                else JOptionPane.showMessageDialog(storeFrame, "It has been bought!!!!!!",
                        "Error 114055", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    private void setJarioAction(){
        JARIO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(player.getStoreCode().charAt(4) != '1') {
                    if (player.getCoins() > 45) {
                        player.setCoins(player.getCoins() - 45);
                        player.setHeroCode(4);
                        changeStoreCode(4);
                        updateCoin();
                    } else JOptionPane.showMessageDialog(storeFrame, "You Don't have enough coins! It needs 45 coins at least.",
                            "Error 11402", JOptionPane.ERROR_MESSAGE);
                }
                else JOptionPane.showMessageDialog(storeFrame, "It has been bought!!!!!!",
                        "Error 114055", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    private void setCoinLabel(){
        updateCoin();
        coins.setLocation(0,-65);
        coins.setSize(1000,200);
        coins.setFont(new Font( "SansSerif", Font. PLAIN, 60 ));
        add(coins);


    }
    private void changeStoreCode(int index){
        String code =player.getStoreCode();
        String[] k = code.split("");
        k[index] = "1";
        StringBuilder NEW = new StringBuilder();
        for (int i = 0 ; i<k.length ; i++) NEW.append(k[i]);
        player.setStoreCode(NEW.toString());
    }
}

