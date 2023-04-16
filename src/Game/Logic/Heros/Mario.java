package Game.Logic.Heros;

import DataManager.PlayersData.Player;
import Game.Game.CharacterKeyListener;
import Game.Game.GameManger.Game;
import Game.Game.SectionFrame;
import Game.Game.SectionPanel;
import Game.Logic.Character;
import Game.Logic.Coin.Coin;
import Game.Logic.Enemy.Planet;
import Game.Logic.Flag;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Mario extends Character {
    private int Heart = 3;
    private final int grovicty = 1;
    protected int code = 0;
    protected int coins = 0;
    private final int xCo = x;
    private final int yCo = y;
    private Player player;

    public Mario(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        direction = "right";
        this.getImage();
    }


    @Override
    public void Update(SectionPanel sectionPanel) {

        sectionPanel.collisionChecker.checkTile(this);
        for (Character character : sectionPanel.map.characters) {
            touchWithEnemy(character);
            touchCoin(character);
            touchFlag(character);
        }
        upDynamic();
        deadJumping(sectionPanel);
        if (characterKeyListener.up) {
            speedY = -10;
            direction = "up";
        } else if (characterKeyListener.down) {
            this.setY(this.getY() + this.getSpeedY());
            direction = "down";
        } else if (characterKeyListener.right) {
            this.setX(this.getX() + this.getSpeedX());
            direction = "right";
        } else if (characterKeyListener.left) {
            this.setX(this.getX() - this.getSpeedX());
            direction = "left";
        }

    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.drawImage(main, x, y, SectionPanel.tileSize, SectionPanel.tileSize, null);
        g2.drawString("HEART :" + Heart, 350, 100);
    }

    @Override
    protected void getImage() {
        try {
            File Mario = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/Mario.png");
            main = ImageIO.read(Mario);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }

    protected Character touchCoin(Character character) {
        Character character1 = null;
        if (character instanceof Coin && this.isTouch(character,0)) {
            coins++;
            character.setVisible(false);
            character1 = character;
        }
        return character1;
    }

    protected void touchWithEnemy(Character character) {
        touchPlant(character);
    }

    protected void touchPlant(Character character) {
        if (character instanceof Planet && this.isTouch(character,0)) {
            Heart--;
            x = xCo;
            y = yCo;
        }
    }

    protected void deadJumping(SectionPanel sectionPanel) {
        if (y > 720) {
            Heart--;
            x = xCo;
            y = yCo - 16;
        }
    }

    protected void touchFlag(Character character) {
        if (character instanceof Flag && character.isTouch(this,0)) {

            boolean Break = false;
            x = 0;
            y = SectionPanel.floor;
            sectionPanel.STOP();
            if (sectionPanel.getPartNumb() == 2 && sectionPanel.getMapNumb() == 3){
                sectionPanel.getFc().setWin(true);
                sectionPanel.getFc().setFinish(true);
                Break = true;

            }
            if(!Break) {
                if (sectionPanel.getMapNumb() == 3) {
                    sectionPanel.setMapNumb(0);


                    sectionPanel.setPartNumb(sectionPanel.getPartNumb() + 1);
                    new SectionFrame(0, sectionPanel.getTimer(), coins, Heart, player, sectionPanel.getPartNumb(), sectionPanel.getGame());
                } else {
                    new SectionFrame(sectionPanel.getMapNumb() + 1, sectionPanel.getTimer(), coins, Heart, player, sectionPanel.getPartNumb(), sectionPanel.getGame());
                }
            }
        }


    }
    public void upDynamic(){
        y -= speedY;


       if(y<300) speedY = -3;
       if(y>SectionPanel.floor) speedY = 0;


    }
    public int getHeart() {
        return Heart;
    }

    public void setHeart(int heart) {
        Heart = heart;
    }

    public double getGrovicty() {
        return grovicty;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getxCo() {
        return xCo;
    }

    public int getyCo() {
        return yCo;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
