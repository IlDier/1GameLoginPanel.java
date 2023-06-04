package Game.Logic.Heros;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Character;
import Game.Logic.Items.Coin;

import javax.imageio.ImageIO;
import java.io.File;

public class Lario extends Mario{
    public Lario(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
        code = 3;
    }
    @Override
    protected void getImage() {
        try {
            File Mario=new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Characters/Lario.png");
            main = ImageIO.read(Mario);
        } catch (Exception o) {
            System.out.println("NO");
        }
    }

    @Override
    protected void touchCoin(Character character) {
        if (character instanceof Coin && this.isTouch(character,10000)) {
            coins++;
            character.setVisible(false);
        }

    }
}
