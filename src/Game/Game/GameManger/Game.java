package Game.Game.GameManger;

import DataManager.IndexChecker.IndexChecker;
import DataManager.PlayersData.Player;
import Game.Game.SectionFrame;
import Game.Game.SectionPanel;
import Game.Logic.Heros.Mario;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private SectionPanel sectionPanel;
    private int coins =0;
    private long time =0;
    private int mapNumb =0;
    private int heart =0;
    private int score =0;
    private int heroCode =0;
    private int heroX =0;
    private int heroY =0;
    private int partNumb = 1;
    private int index;
    private boolean save = false;
    private String perCode ;
    private Player player;
    private String secretCode1;
    private String secretCode2;
    private String secretCode3;
    private boolean previous = false;
    // coins/time/mapNumb/heart/score/herocode/herox/heroy/partNumb/save/Index
    public Game(Player player){
        this.player = player;


    }
    public Game(SectionPanel sectionPanel,Player player){
        this.player = player;
        this.sectionPanel = sectionPanel;
        coins = player.getMainHero().getCoins();
        time = sectionPanel.getTimer();
        mapNumb = sectionPanel.getMapNumb();
        heart = player.getMainHero().getHeart();
        sectionPanel.getSm().update(sectionPanel);
        score = sectionPanel.getSm().score;
        heroCode = player.getHeroCode();
        heroX = player.getMainHero().getX();
        heroY = player.getMainHero().getY();
        partNumb = sectionPanel.getPartNumb();
        save = true;
        index = IndexChecker.getIndex();

    }
    public void setPerCode(){
        String Scoin  = Integer.toString(coins);
        String stime = Long.toString(time);
        String smapNumb = Integer.toString(mapNumb);
        String sheart = Integer.toString(heart);
        String sscore = Integer.toString(score);
        String sherocode = Integer.toString(heroCode);
        String sherox = Integer.toString(heroX);
        String sheroy = Integer.toString(heroY);
        String spartNumb = Integer.toString(partNumb);
        String ssave ;
        if(save ) ssave = "1";
        else ssave = "0";
        String sindex = Integer.toString(index);
        player.setPerCode(Scoin+":"+stime+":"+smapNumb+":"+sheart+":"+sscore+":"+sherocode+":"+sherox+":"+sheroy+":"+spartNumb+":"+ssave+":"+sindex);
    }
    public void getPer_Code(){
        String perCode = player.getPerCode();
        String[] s = perCode.split(":");
        coins = Integer.parseInt(s[0]);
        time = Long.parseLong(s[1]);
        mapNumb = Integer.parseInt(s[2]);
        heart = Integer.parseInt(s[3]);
        score = Integer.parseInt(s[4]);
        heroCode = Integer.parseInt(s[5]);
        heroX = Integer.parseInt(s[6]);
        heroY = Integer.parseInt(s[7]);
        partNumb = Integer.parseInt(s[8]);
        save = getBool(s[9]);
        index = Integer.parseInt(s[10]);
        setPerCode();

    }
    public void getFirst_SCD(){
        String secretCode = player.getSecretCode1();
        String[] s = secretCode.split(":");
        coins = Integer.parseInt(s[0]);
        time = Long.parseLong(s[1]);
        mapNumb = Integer.parseInt(s[2]);
        heart = Integer.parseInt(s[3]);
        score = Integer.parseInt(s[4]);
        heroCode = Integer.parseInt(s[5]);
        heroX = Integer.parseInt(s[6]);
        heroY = Integer.parseInt(s[7]);
        partNumb = Integer.parseInt(s[8]);
        save = getBool(s[9]);
        index = Integer.parseInt(s[10]);
        setSCD();
    }
    public void setSCD(){
        if(index % 3 == 0) setFirst_SCD();
        else if ( index % 3 == 1) setSecond_SCD();
        else setThird_SCD();
    }
    public boolean perSave(){
        getPer_Code();
        return save;
    }
    public void setFirst_SCD(){


        String Scoin  = Integer.toString(coins);
        String stime = Long.toString(time);
        String smapNumb = Integer.toString(mapNumb);
        String sheart = Integer.toString(heart);
        String sscore = Integer.toString(score);
        String sherocode = Integer.toString(heroCode);
        String sherox = Integer.toString(heroX);
        String sheroy = Integer.toString(heroY);
        String spartNumb = Integer.toString(partNumb);
        String ssave ;
        if(save ) ssave = "1";
        else ssave = "0";
        String sindex = Integer.toString(index);
        player.setSecretCode1(Scoin+":"+stime+":"+smapNumb+":"+sheart+":"+sscore+":"+sherocode+":"+sherox+":"+sheroy+":"+spartNumb+":"+ssave+":"+sindex);
    }
    public void setSecond_SCD(){
        String Scoin  = Integer.toString(coins);
        String stime = Long.toString(time);
        String smapNumb = Integer.toString(mapNumb);
        String sheart = Integer.toString(heart);
        String sscore = Integer.toString(score);
        String sherocode = Integer.toString(heroCode);
        String sherox = Integer.toString(heroX);
        String sheroy = Integer.toString(heroY);
        String spartNumb = Integer.toString(partNumb);
        String ssave ;
        if(save ) ssave = "1";
        else ssave = "0";
        String sindex = Integer.toString(index);
        player.setSecretCode2(Scoin+":"+stime+":"+smapNumb+":"+sheart+":"+sscore+":"+sherocode+":"+sherox+":"+sheroy+":"+spartNumb+":"+ssave+":"+sindex);
    }
    public void setThird_SCD(){
        String sscoin  = Integer.toString(coins);
        String stime = Long.toString(time);
        String smapNumb = Integer.toString(mapNumb);
        String sheart = Integer.toString(heart);
        String sscore = Integer.toString(score);
        String sherocode = Integer.toString(heroCode);
        String sherox = Integer.toString(heroX);
        String sheroy = Integer.toString(heroY);
        String spartNumb = Integer.toString(partNumb);
        String ssave ;
        if(save ) ssave = "1";
        else ssave = "0";
        String sindex = Integer.toString(index);
        player.setSecretCode3(sscoin+":"+stime+":"+smapNumb+":"+sheart+":"+sscore+":"+sherocode+":"+sherox+":"+sheroy+":"+spartNumb+":"+ssave+":"+sindex);
    }
    public void getSecond_SCD(){
        String secretCode = player.getSecretCode2();
        String[] s = secretCode.split(":");
        coins = Integer.parseInt(s[0]);
        time = Long.parseLong(s[1]);
        mapNumb = Integer.parseInt(s[2]);
        heart = Integer.parseInt(s[3]);
        score = Integer.parseInt(s[4]);
        heroCode = Integer.parseInt(s[5]);
        heroX = Integer.parseInt(s[6]);
        heroY = Integer.parseInt(s[7]);
        partNumb = Integer.parseInt(s[8]);
        save = getBool(s[9]);
        index = Integer.parseInt(s[10]);
    }
    public void getThird_SCD(){
        String secretCode = player.getSecretCode3();
        String[] s = secretCode.split(":");
        coins = Integer.parseInt(s[0]);
        time = Long.parseLong(s[1]);
        mapNumb = Integer.parseInt(s[2]);
        heart = Integer.parseInt(s[3]);
        score = Integer.parseInt(s[4]);
        heroCode = Integer.parseInt(s[5]);
        heroX = Integer.parseInt(s[6]);
        heroY = Integer.parseInt(s[7]);
        partNumb = Integer.parseInt(s[8]);
        save = getBool(s[9]);
        index = Integer.parseInt(s[10]);
    }
    public boolean issaveD(){
        int index = IndexChecker.getIndex();
        if(index == 0 ){
            getFirst_SCD();
        }
        else if (index == 1){
            getSecond_SCD();
        }
        else {
            getThird_SCD();
        }
        return save;
    }
    public void NEWGAME(){        // coins/time/mapNumb/heart/score/herocode/herox/heroy/partNumb/save/Index

        coins = 0;
        time = 0;
        mapNumb = 0;
        heart = 3;
        score = 0 ;
        heroCode = player.getHeroCode();
        heroY = SectionPanel.floor;
        heroX = 0;
        partNumb = 1;
        save = false;

        index = IndexChecker.getIndex();

    }
    private boolean  getBool(String s){
        if(s=="0") return false;
        else return true;
    }
    public void getSCDGame(){
        if(index == 0 ) getFirst_SCD();
        else if (index == 1) getSecond_SCD();
        else getThird_SCD();
    }

    public SectionPanel getSectionPanel() {
        return sectionPanel;
    }

    public int getCoins() {
        return coins;
    }

    public long getTime() {
        return time;
    }

    public int getMapNumb() {
        return mapNumb;
    }

    public int getHeart() {
        return heart;
    }

    public int getScore() {
        return score;
    }

    public int getHeroCode() {
        return heroCode;
    }

    public int getHeroX() {
        return heroX;
    }

    public int getHeroY() {
        return heroY;
    }

    public int getPartNumb() {
        return partNumb;
    }

    public int getIndex() {
        return index;
    }

    public boolean isSave() {
        return save;
    }

    public Player getPlayer() {
        return player;
    }

    public String getSecretCode1() {
        return secretCode1;
    }

    public String getSecretCode2() {
        return secretCode2;
    }

    public String getSecretCode3() {
        return secretCode3;
    }

    public String getPerCode() {
        return perCode;
    }

    public boolean isPrevious() {
        return previous;
    }

    public void setPrevious(boolean previous) {
        this.previous = previous;
    }

    public static void main(String[] args) {
        Player player = new Player("Kokomba");
        Game game = new Game(player);
        game.getFirst_SCD();
        game.setSecond_SCD();
    }


}
