package Game.Logic.CheckPoint;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;

import javax.imageio.ImageIO;
import java.io.File;

public class GrayFlag extends CheckPoint{
    private boolean visit = false;
    public GrayFlag(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        getImage();
    }

    @Override
    protected void getImage() {
        try {
            File Flag=new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/GrayFlag.png");
            main = ImageIO.read(Flag);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }

    public boolean isVisit() {
        return visit;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }
}
