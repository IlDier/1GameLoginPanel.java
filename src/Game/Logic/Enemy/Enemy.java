package Game.Logic.Enemy;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public abstract class Enemy extends Character {


    protected int Health = 3;
    public Enemy(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }
}
