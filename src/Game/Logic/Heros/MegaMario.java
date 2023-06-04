package Game.Logic.Heros;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Interfaces.Shooting;

import javax.imageio.ImageIO;
import java.io.File;

public class MegaMario extends Mario  {
    public MegaMario(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
//        blockDestroyer = true;
    }

    @Override
    protected void getImage() {
        try {
            File megaMario =new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/MegaMario.png");
            main = ImageIO.read(megaMario);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }


}
