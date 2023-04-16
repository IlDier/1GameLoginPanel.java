package Game.Logic.Tile;

import Game.Logic.Character;

import java.awt.image.BufferedImage;

public class Tile {
    protected BufferedImage image;
    protected boolean collision=false;
    private int tileNumb;
    public Tile(int tileNumb){
        this.tileNumb= tileNumb;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public int getTileNumb() {
        return tileNumb;
    }

    public void setTileNumb(int tileNumb) {
        this.tileNumb = tileNumb;
    }
}
