package Game.Logic;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Score.ScoreManager;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Character {
    protected int x= 50;
    protected int y=50;
    protected int nowMapNumb;
    protected int partNumb;
    protected int speedX=15;
    protected int speedY=10;
    protected int Width ;
    protected int Height ;
    protected SectionPanel sectionPanel;
    protected CharacterKeyListener characterKeyListener;
    protected BufferedImage main;
    protected Rectangle solidArea;
    protected String direction ;
    protected boolean visible = true ;


    public Character(int x, int y,int Width,int Height ,SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        this.Height = Height;
        this.Width = Width;
        this.x = x;
        this.y = y;
        this.sectionPanel = sectionPanel;
        this.characterKeyListener = characterKeyListener;


    }
    protected void getImage(){}
    public void Update(SectionPanel sectionPanel){}

    public void Update(@NotNull SectionPanel sectionPanel, ScoreManager scoreManager) {
    }

    public  void draw(Graphics2D g2){}
    public boolean isTouch(Character character,int appro){
        double radius1 = Math.sqrt(Width*Width+Height*Height)/2;
        int center1X = x+Width/2;
        int center1Y = y+Height/2;
        double radius2 = Math.sqrt(character.Width*character.Width+character.Height*character.Height)/2;
        int center2X = character.x+character.Width/2;
        int center2Y = character.y+character.Height/2;
        if(((center1X-center2X)*(center1X-center2X)+(center2Y-center1Y)*(center2Y-center1Y))<=((radius2+radius1)*(radius2+radius1)+appro)) return true;
        else return false;
    }
    public void remove(){
        x = -1000;
        y = -1000;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
        if(!visible) {
            x = -1000;
            y = -1000;
        }
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public SectionPanel getSectionPanel() {
        return sectionPanel;
    }

    public void setSectionPanel(SectionPanel sectionPanel) {
        this.sectionPanel = sectionPanel;
    }

    public CharacterKeyListener getCharacterKeyListener() {
        return characterKeyListener;
    }

    public void setCharacterKeyListener(CharacterKeyListener characterKeyListener) {
        this.characterKeyListener = characterKeyListener;
    }

    public BufferedImage getMain() {
        return main;
    }

    public void setMain(BufferedImage main) {
        this.main = main;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getNowMapNumb() {
        return nowMapNumb;
    }

    public void setNowMapNumb(int nowMapNumb) {
        this.nowMapNumb = nowMapNumb;
    }



    public void setPartNumb(int partNumb) {
        this.partNumb = partNumb;
    }
    public int getPartNumb(){ return partNumb; }
}
