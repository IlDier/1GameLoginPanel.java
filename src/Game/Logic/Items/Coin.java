package Game.Logic.Items;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Character;
import Game.Logic.Score.ScoreManager;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Coin extends Item {
    public Coin(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        getImage();
    }

    @Override
    protected void getImage() {
        try {
            File Coin=new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/coin.png");
            main = ImageIO.read(Coin);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }


    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(main,x,y,Width,Height,null);
    }
}
