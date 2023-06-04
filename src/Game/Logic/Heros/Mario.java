package Game.Logic.Heros;

import DataManager.PlayersData.Player;
import Game.Game.CharacterKeyListener;
import Game.Game.SectionFrame;
import Game.Game.SectionPanel;
import Game.Logic.Character;
import Game.Logic.CheckPoint.GrayFlag;
import Game.Logic.Enemy.Planet;
import Game.Logic.CheckPoint.Flag;
import Game.Logic.Items.Coin;
import Game.Logic.Items.MagicFlower;
import Game.Logic.Items.MagicalMushroom;
import Game.Logic.Items.MagicalStar;
import Game.Logic.Score.ScoreManager;
import Game.Logic.Weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Mario extends Character {
    private int Heart = 3;
    private final int grovicty = 1;
    protected int code = 0;

    protected int coins = 0;
    private int respawnX = x;
    private int respawnY = y;
    private int type = -1;
    private boolean checkPoint = false;
    protected boolean blockDestroyer = false;
    private Player player;
    private int swordActivate = -1;
    protected ScoreManager scoreManager;
    private Weapon weapon;
    private File simpleMario = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/Mario.png");
    private File megaMario = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/MegaMario.png");
    private File fireMario = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/FireMario.png");

    private int plusType(int type){
        if(type == 1) return 1;
        else {
            Heart++;
            return type+1;
        }
    }
    private int minusType(int type){
        if(type == -1) return -1;
        else{
            Heart--;
            return type-1;
        }
    }
    public Mario(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        direction = "right";
        getImage();
        weapon =  new Weapon(-1000,-1000,SectionPanel.tileSize,54,sectionPanel,characterKeyListener);
    }


    @Override
    public void Update(@NotNull SectionPanel sectionPanel, ScoreManager scoreManager) {

        this.scoreManager = scoreManager;
       if(swordActivate == 1) updateSword();
       sectionPanel.getCollisionChecker().checkTile(this);
        for (Character character : sectionPanel.getMap().characters) {
            character.Update(sectionPanel);
            touchWithEnemy(character);
            touchCoin(character);
            touchFlag(character);
            touchCheckPoint(character);
            touchItems(character);
//            if(!character.isVisible()) sectionPanel.getMap().characters.remove(character);
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
        getImage();
        g2.setColor(Color.WHITE);
        g2.drawImage(main, x, y, Width, Height, null);
        g2.drawString("HEART :" + Heart, 350, 100);
    }

    @Override
    protected void getImage() {
        try {
            File mario;
            if(type == -1){
                mario = simpleMario;

                Height = SectionPanel.tileSize;
            }
            else if(type == 0){
                mario = megaMario;
                Height = 2*SectionPanel.tileSize;
            }
            else{
                mario = fireMario;
                Height = 2*SectionPanel.tileSize;
            }
            main = ImageIO.read(mario);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }
    private void updateSword(){
//          weapon.setX(x+100);
//          weapon.setY(y-100);
//        System.out.println("x :"+x+" y :"+ y+" WeaponX: "+weapon.getX()+" WeaponY: "+weapon.getY());

    }

    protected void touchCoin(Character character) {
        if (character instanceof Coin && this.isTouch(character,0)) {
            coins++;
            scoreManager.score += 10;
            sectionPanel.getSm().getGainedScore().add(character);
            character.setVisible(false);
        }
    }

    protected void touchWithEnemy(Character character) {
        touchPlant(character);
    }

    protected void touchPlant(Character character) {
        if (character instanceof Planet && this.isTouch(character,0)) {
            Heart--;
            type = minusType(type);
            x = respawnX;
            y = respawnY;
        }
    }
    private int negativeOrZero(int x,int y){
        if(x> y) return x-y;
        else return 0;
    }

    protected void deadJumping(SectionPanel sectionPanel) {
        if (y > 720) {
            sectionPanel.getSm().score  = negativeOrZero(sectionPanel.getSm().score,30);
            Heart--;
            type = minusType(type);
            x = respawnX;
            y = respawnY;
        }
    }
    protected void touchCheckPoint(Character character){
        if(character instanceof GrayFlag && character.isTouch(this,0)){
            checkPoint = true;
        }
        else checkPoint = false;
    }
    protected void touchItems(Character character){
        touchMagicFlower(character);
        touchMushroom(character);
        touchStar(character);
    }
    protected void touchStar(Character character){
        if(character instanceof MagicalStar && character.isTouch(this,0)){
            MagicalStar magicalStar = (MagicalStar) character;
            type = plusType(type);
            scoreManager.score += MagicalStar.score;
            sectionPanel.getSm().getGainedScore().add(magicalStar);
            magicalStar.setVisible(false);

        }
    }
    protected void touchMushroom(Character character){
        if(character instanceof MagicalMushroom && character.isTouch(this,0)){
            MagicalMushroom magicalMushroom = (MagicalMushroom) character;
            type = plusType(type);
            scoreManager.score += MagicalMushroom.score;
            sectionPanel.getSm().getGainedScore().add(magicalMushroom);
            magicalMushroom.setVisible(false);
        }
    }
    protected void touchMagicFlower(Character character){
        if(character instanceof MagicFlower && isTouch(character,0)){
            MagicFlower magicFlower = (MagicFlower) character;
            type = plusType(type);
            scoreManager.score += MagicFlower.score;
            sectionPanel.getSm().getGainedScore().add(magicFlower);
            magicFlower.setVisible(false);
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
                    new SectionFrame(0, sectionPanel.getTimer(), coins, Heart, player, sectionPanel.getPartNumb(), sectionPanel.getGame(),sectionPanel.getSm().score);
                } else {
                    new SectionFrame(sectionPanel.getMapNumb() + 1, sectionPanel.getTimer(), coins, Heart, player, sectionPanel.getPartNumb(), sectionPanel.getGame(),sectionPanel.getSm().score);
                }
            }
        }


    }
    public void activateSword(){
        swordActivate = 1;
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



    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(boolean checkPoint) {
        this.checkPoint = checkPoint;
    }

    public boolean isBlockDestroyer() {
        return blockDestroyer;
    }

    public void setBlockDestroyer(boolean blockDestroyer) {
        this.blockDestroyer = blockDestroyer;
    }

}
