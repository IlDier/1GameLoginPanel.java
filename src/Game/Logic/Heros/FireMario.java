package Game.Logic.Heros;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Interfaces.Shooting;

public class FireMario extends MegaMario implements Shooting {
    public FireMario(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
    }

    @Override
    public void shoot() {

    }
}
