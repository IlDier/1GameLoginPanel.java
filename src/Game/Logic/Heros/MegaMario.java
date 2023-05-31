package Game.Logic.Heros;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Interfaces.Shooting;

public class MegaMario extends Mario  {
    public MegaMario(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        blockDestroyer = true;
    }

    @Override
    protected void getImage() {
        super.getImage();
    }


}
