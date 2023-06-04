package Game.Logic.Weapon;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Character;
import Game.Logic.Enemy.Enemy;
import Game.Logic.Score.ScoreManager;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Weapon extends Character {

    public Weapon(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        getImage();
    }

    @Override
    protected void getImage() {
        try {
            File Mario=new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/PipeSword.png");
            main = ImageIO.read(Mario);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }


    public void attacked(Character character){
        if(character instanceof Enemy){
//            Enemy enemy = (Enemy) character;
//            if(enemy.getHealth() < 3) enemy.remove();
//            else enemy.setHealth(enemy.getHealth()-damage);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(main,x,y,Width,Height,null);
    }
}
