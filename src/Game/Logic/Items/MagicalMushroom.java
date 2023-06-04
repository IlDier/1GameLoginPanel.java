package Game.Logic.Items;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;

import javax.imageio.ImageIO;
import java.io.File;

public class MagicalMushroom extends Item{
    public MagicalMushroom(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        getImage();
        speedX = 3;
        score = 30;
    }

    @Override
    protected void getImage() {
        try {
            File Coin=new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/Mushroom.png");
            main = ImageIO.read(Coin);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }

    @Override
    public void Update(SectionPanel sectionPanel) {
        x += speedX;
    }
}
