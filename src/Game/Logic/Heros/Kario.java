package Game.Logic.Heros;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;

import javax.imageio.ImageIO;
import java.io.File;

public class Kario extends Mario{
    public Kario(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        speedX = 30;
        code = 2;
    }
    @Override
    protected void getImage() {
        try {
            File Mario=new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/Kario.png");
            main = ImageIO.read(Mario);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }
}
