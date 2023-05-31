package Game.Logic.Weapon;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Character;
import Game.Logic.Enemy.Enemy;

public class Weapon extends Character {
    protected int damage = 3;
    public Weapon(int x, int y, int Width, int Height, SectionPanel sectionPanel, CharacterKeyListener characterKeyListener) {
        super(x, y, Width, Height, sectionPanel, characterKeyListener);
    }

    @Override
    protected void getImage() {
        super.getImage();
    }
    public void attacked(Character character){
        if(character instanceof Enemy){
            Enemy enemy = (Enemy) character;
            if(enemy.getHealth() < 3) enemy.remove();
            else enemy.setHealth(enemy.getHealth()-damage);
        }
    }

}
