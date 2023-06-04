package Game.Game;

import DataManager.IndexChecker.IndexChecker;
import DataManager.PlayersData.Player;
import Game.Game.GameManger.Game;
import Game.Logic.Character;
import Game.Logic.CheckPoint.GrayFlag;
import Game.Logic.Heros.Mario;
import Login.GameLogin.GameLoginFrame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class CharacterKeyListener implements KeyListener {
    public boolean up , down , right , left ;
    private SectionPanel sectionPanel;
    private ArrayList<Character> characters;
    public CharacterKeyListener(SectionPanel sectionPanel){
        this.sectionPanel = sectionPanel;
    }
    public void init_characters(){
        characters = sectionPanel.getMap().characters;
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        if(keyCode == KeyEvent.VK_W){
            if(sectionPanel.getMario().getY()>300) up=true;
        }  else if(keyCode == KeyEvent.VK_A){
       left=true;
        }  else if(keyCode == KeyEvent.VK_D){
       right=true;
        }  else if(keyCode == KeyEvent.VK_S){
       down=true;
        }else if (keyCode == KeyEvent.VK_ESCAPE) {
            int res = JOptionPane.showConfirmDialog(sectionPanel, "Are you sure to Exit ?");
            if (res == 0) {
                int res1 = JOptionPane.showConfirmDialog(sectionPanel, "Do you want to save this game ?!");
                Game game = new Game(sectionPanel, sectionPanel.getPlayer());
                game.setPerCode();
                if (res1 == 0) {


                    game.setSCD();
                    sectionPanel.getPlayer().setIndex(IndexChecker.getIndex());
                }
                sectionPanel.STOP();
                new GameLoginFrame(sectionPanel.getPlayer());
            }
        } else if (keyCode == KeyEvent.VK_I && sectionPanel.getMario().isCheckPoint()) {
                int res = JOptionPane.showConfirmDialog(sectionPanel, "Do you want to save your game here ?!");
                if (res == 0) {
                    Mario mario = sectionPanel.getPlayer().getMainHero();
                    Game game  = new Game(sectionPanel,sectionPanel.getPlayer());
                    for(Character character : characters){
                        if(character instanceof GrayFlag && mario.getNowMapNumb() == character.getNowMapNumb()){
                           if(mario.getPartNumb() == character.getPartNumb()) {
                               game.setHeroX(character.getX());
                               break;
                           }
                        }
                    }
                    game.setPerCode();
                    game.setSCD();
                    sectionPanel.getPlayer().setIndex(IndexChecker.getIndex());
                }

            }
        else if(keyCode == KeyEvent.VK_O){
            sectionPanel.getMario().activateSword();

        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode=e.getKeyCode();
        if(keyCode == KeyEvent.VK_W){
            sectionPanel.getMario().setSpeedY(0);
            up=false;
        }  else if(keyCode == KeyEvent.VK_A){
            left=false;
        }  else if(keyCode == KeyEvent.VK_D){
            right=false;
        }  else if(keyCode == KeyEvent.VK_S){
            down=false;
        }
    }
}
