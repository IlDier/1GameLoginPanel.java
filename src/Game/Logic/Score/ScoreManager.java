package Game.Logic.Score;

import Game.Game.SectionPanel;

import java.awt.*;

public class ScoreManager {
    int coins ;
    int heart ;
    int enemy ;
    int secRemain ;
    public int score = 0;
    public ScoreManager(int coins , int heart , int enemy , int secRemain){
        this.coins = coins;
        this.heart = heart;
        this.enemy = enemy;
        this.secRemain = secRemain;
    }
    public void scoreResult(){

        score = 0;
        score += coins* 10;
        score += heart* 20;

    }
    public void update(SectionPanel sectionPanel){
        coins = sectionPanel.getMario().getCoins();
        heart = sectionPanel.getMario().getHeart();

        scoreResult();
    }
    public void finalScore(int secRemain){
        scoreResult();
        score+= secRemain;
    }
    public void draw(Graphics2D g2){
        g2.drawString("SCORE "+score,1000,100);
    }
}
