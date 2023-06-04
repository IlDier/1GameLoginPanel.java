package Game.Logic.Score;

import Game.Game.SectionPanel;
import Game.Logic.Character;
import Game.Logic.Items.Coin;
import Game.Logic.Items.MagicFlower;

import java.awt.*;
import java.util.ArrayList;

public class ScoreManager{
    private ArrayList<Character> gainedScore = new ArrayList<>();
    int secRemain ;

    public int score;
    private SectionPanel sectionPanel;
    public ScoreManager(int score,int secRemain,SectionPanel sectionPanel){

        this.score = score;
        this.sectionPanel = sectionPanel;
        this.secRemain = secRemain;
    }

    public void finalScore(int secRemain){
        score += sectionPanel.getMario().getHeart() * 20;
        score+= secRemain;
    }
    public void draw(Graphics2D g2){
        g2.drawString("SCORE "+score,1000,100);
    }


    public ArrayList<Character> getGainedScore() {
        return gainedScore;
    }

    public void setGainedScore(ArrayList<Character> gainedScore) {
        this.gainedScore = gainedScore;
    }
}
