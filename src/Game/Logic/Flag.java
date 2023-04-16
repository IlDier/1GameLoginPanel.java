package Game.Logic;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Flag extends Character {
    public Flag(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        getImage();
    }

    @Override
    protected void getImage() {
        try {
            File Flag=new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/Flag.png");
            main = ImageIO.read(Flag);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(main,x,y,Width,Height,null);
    }

    @Override
    public boolean isTouch(Character character,int appro) {
        if(character.getX() > x) return true;
        else return false;
    }
}
