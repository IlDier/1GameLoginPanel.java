package Game.Logic.Items;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Score.ScoreManager;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.io.File;

public class MagicalStar extends Item{
    public MagicalStar(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        getImage();
        speedX = 5;
        score = 40;
    }

    @Override
    protected void getImage() {
        try {
            File Coin=new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/Star.png");
            main = ImageIO.read(Coin);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }

    @Override
    public void Update(@NotNull SectionPanel sectionPanel, ScoreManager scoreManager) {
        x += speedX;
    }
}
