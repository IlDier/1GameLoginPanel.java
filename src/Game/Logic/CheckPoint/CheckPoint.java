package Game.Logic.CheckPoint;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Character;
import Game.Logic.Score.ScoreManager;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class CheckPoint extends Character {
    public CheckPoint(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
    }

    @Override
    protected void getImage() {
        super.getImage();
    }

    @Override
    public boolean isTouch(Character character,int appro) {
        if(character.getX() > x) return true;
        else return false;
    }
    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(main,x,y,Width,Height,null);
    }
    public void setRespawnPoints(int respawnX,int respawnY){
        respawnX = x;
        respawnY = y;
    }
}
