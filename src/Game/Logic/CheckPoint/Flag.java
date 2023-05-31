package Game.Logic.CheckPoint;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Flag extends CheckPoint {
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


}
