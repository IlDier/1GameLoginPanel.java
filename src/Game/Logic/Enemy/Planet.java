package Game.Logic.Enemy;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Character;
import Game.Logic.Score.ScoreManager;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Planet extends Enemy{
    private int updown;

    public Planet(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        updown = y;
        getImage();
    }


    @Override
    protected void getImage() {
        try {
            File Planet=new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/Planet.png");
            main = ImageIO.read(Planet);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }


    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.drawImage(main,x,updown,120,120,null);

    }

    @Override
    public boolean isTouch(Character character,int appro) {
        double radius1 = Math.sqrt(Width*Width+Height*Height)/2;
        int center1X = x+Width/2;
        int center1Y = y+Height/2;
        double radius2 = Math.sqrt(character.getWidth()*character.getWidth()+character.getHeight()*character.getHeight())/2;
        int center2X = character.getX()+character.getWidth()/2;
        int center2Y = character.getY()+character.getHeight()/2;
        if(((center1X-center2X)*(center1X-center2X)+(center2Y-center1Y)*(center2Y-center1Y))<=(radius2+radius1+32)*(radius2+radius1+32)) return true;
        else return false;
    }
}
