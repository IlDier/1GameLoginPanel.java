package Game.Logic.Items;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Score.ScoreManager;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.io.File;

public class MagicFlower extends Item{
    public MagicFlower(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        score = 30;
        getImage();
    }

    @Override
    protected void getImage() {
        try {
            File Coin=new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/Floweritem.png");
            main = ImageIO.read(Coin);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }

}
