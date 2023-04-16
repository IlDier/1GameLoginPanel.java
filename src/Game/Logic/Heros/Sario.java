package Game.Logic.Heros;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;

import javax.imageio.ImageIO;
import java.io.File;

public class Sario extends Mario{
    public Sario(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);

        code = 1;
    }

    @Override
    protected void getImage() {
        try {
            File Mario=new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/Sario.png");
            main = ImageIO.read(Mario);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }
}
