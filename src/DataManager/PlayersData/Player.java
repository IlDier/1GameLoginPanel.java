package DataManager.PlayersData;

import Game.Game.CharacterKeyListener;
import Game.Game.SectionPanel;
import Game.Logic.Heros.*;

import java.io.*;
import java.util.Scanner;

public class Player {

    protected File file = new File("D:/JavaProjects/ApProjectSpring2023/src/DataManager/PlayersData/Players.txt");
    protected String username ;
    protected String password ;
    protected int coins ;
    protected int highestscore ;
    protected int heroCode ;
    private int index =0;

    protected String storeCode ;
    private String secretCode1 ;
    private String secretCode2 ;
    private String secretCode3 ;
    protected String perCode ;
    public Mario mainHero ;
    private int size ;
    private int row =-1;
        public Player(String username){

        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){

                row++;
                String line = reader.nextLine();
                String[] x = line.split(" ");
                if(x[1].trim().equals(username.trim())){
                    this.username = username;
                    password = x[3];
                    coins = Integer.parseInt(x[5]);
                    highestscore = Integer.parseInt(x[7]);
                    heroCode = Integer.parseInt(x[9]);
                    storeCode = x[11];
                    secretCode1 = x[13];
                    secretCode2 = x[15];
                    secretCode3 = x[17];
                    perCode = x[19];
                    index = Integer.parseInt(x[19]);
                    break;
                }
            }


        } catch (Exception e) {}
            updateHero();
            size = getFileSizeRow();
    }

    protected int getFileSizeRow(){
            int size = 0;
        try {
            int i ;
            Scanner reader = new Scanner(file);
            for( i=0 ;reader.hasNextLine() ;i++) reader.nextLine();

            size = i;
            reader.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
       return size;
    }

    public String[] getText(int size) {
            String[] s = new String[size];
        try {
            int i ;
            Scanner reader = new Scanner(file);
            String line = reader.nextLine();
            for(i=0 ;reader.hasNextLine() ;i++){
                s[i] = line ;
                line = reader.nextLine();
            }
            s[i] = line;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return s;
    }
    private void appendText(String text , int column){
            String[] r = getText(size);
        String[] f = r[row].split(" ");
        f[column] = text;
        StringBuilder v = new StringBuilder();
        for(int i = 0 ; i<f.length;i++) v.append(f[i]+" ");
        r[row] = v.toString();
        try {
            FileWriter fw = new FileWriter(file,false);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0 ;i<r.length;i++) {
                bw.write(r[i]);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception o) {}

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

            appendText(username,1);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
            appendText(password,3);
        this.password = password;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
            appendText(Integer.toString(coins),5);
        this.coins = coins;
    }

    public int getHighestscore() {
        return highestscore;
    }

    public void setHighestscore(int highestscore) {
            appendText(Integer.toString(highestscore),7);
        this.highestscore = highestscore;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
            appendText(storeCode,11);
        this.storeCode = storeCode;
    }

    public int getHeroCode() {
        return heroCode;
    }

    public void setHeroCode(int heroCode) {
            appendText(Integer.toString(heroCode),9);
        this.heroCode = heroCode;
    }

    public String getSecretCode1() {
        return secretCode1;
    }

    public void setSecretCode1(String secretCode1) {
        appendText(secretCode1,13);
        this.secretCode1 = secretCode1;
    }

    public String getSecretCode2() {
        return secretCode2;
    }

    public void setSecretCode2(String secretCode2) {
        appendText(secretCode1,15);
        this.secretCode2 = secretCode2;
    }

    public String getPerCode() {
        return perCode;
    }

    public void setPerCode(String perCode) {
            appendText(perCode,19);
        this.perCode = perCode;
    }

    public String getSecretCode3() {
        return secretCode3;
    }

    public void setSecretCode3(String secretCode3) {
        appendText(secretCode1,17);
        this.secretCode3 = secretCode3;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
            appendText(Integer.toString(index),19);
        this.index = index;
    }

    public void updateHero(){
            getHero();
    }
    private void getHero(){
            if(heroCode == 0){
                mainHero = new Mario(0,SectionPanel.floor, SectionPanel.tileSize,SectionPanel.tileSize,null,new CharacterKeyListener(null));
            }
            else if(heroCode == 1){

                mainHero = new Sario(0,SectionPanel.floor, SectionPanel.tileSize,SectionPanel.tileSize,null,new CharacterKeyListener(null));
            }
            else if(heroCode == 2){
                mainHero = new Kario(0,SectionPanel.floor, SectionPanel.tileSize,SectionPanel.tileSize,null,new CharacterKeyListener(null));

            }
            else if(heroCode == 3){
                mainHero = new Lario(0,SectionPanel.floor, SectionPanel.tileSize,SectionPanel.tileSize,null,new CharacterKeyListener(null));

            }
            else {
                mainHero = new Jario(0,SectionPanel.floor, SectionPanel.tileSize,SectionPanel.tileSize,null,new CharacterKeyListener(null));

            }
    }
    public void setSection(){
            mainHero.setX(0);
            mainHero.setY(638);
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Mario getMainHero() {
        return mainHero;
    }

    public void setMainHero(Mario mainHero) {
        this.mainHero = mainHero;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
