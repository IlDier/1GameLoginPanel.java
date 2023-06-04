package Game.Game;

import DataManager.PlayersData.Player;
import Game.Game.GameManger.Game;
import Game.Logic.Character;
import Game.Logic.CollisionChecker;
import Game.Logic.Heros.Mario;
import Game.Logic.Interfaces.ProgressRate;
import Game.Logic.Maps.Map;

import Game.Logic.Score.ScoreManager;
import Game.Logic.Tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class SectionPanel extends JPanel implements Runnable , ProgressRate {
    private static final int originalTileSize = 16;
    private static final int scaleSize=2;
    public static final int tileSize= originalTileSize*scaleSize;
    private final int tilesColumn=45;
    private final int tilesRow=24;
    private final int screenWidth=tileSize*tilesColumn;
    private final int screenHeight=tileSize*tilesRow;
    private final int fps=40;
    private int mapNumb ;
    private long timer ;
    public TileManager tileManager=new TileManager(this);
    private Thread gameThread;
    public CharacterKeyListener characterKeyListener = new CharacterKeyListener(this);
    private Mario mario ;
    private Player player;
    private int mainTime = 120;
    public static int floor = 635;
    private int partNumb = 1;
    private FinishChecker fc = new FinishChecker(this);
    private ScoreManager sm ;
    private Game game;
    private SectionFrame sectionFrame;
    private Map map;
    private CollisionChecker collisionChecker = new CollisionChecker(this);


    public SectionPanel(SectionFrame sectionFrame, int mapNumb, long timer, int coins, int hearts, Player player, int partNumb,Game game,int score){
        sm = new ScoreManager(score,0,this);
        this.game = game;
        this.player = player;
        this.partNumb = partNumb;
        mario = player.mainHero;
        mario.setCharacterKeyListener(characterKeyListener);
        if(mapNumb==0 && game!=null) {
            mario.setX(game.getHeroX());
            mario.setY(game.getHeroY());
        }
        mario.setSectionPanel(this);
        mario.setPlayer(player);
        mario.setCoins(coins);
        mario.setSpeedY(0);
        mario.setHeart(hearts);
        this.sectionFrame = sectionFrame;
        this.timer = timer;
        this.mapNumb = mapNumb;
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        setDoubleBuffered(true);


        addKeyListener(characterKeyListener);
        setFocusable(true);

        // Starting for calculating Score

        map = new Map(mapNumb, this,partNumb);
        characterKeyListener.init_characters();


    }
    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
       double drawInterval = 1000000000/fps;
       double delta=0;
       long lastTime = System.nanoTime();
       long currentTime ;

       int timeCounter = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            timer+=currentTime-lastTime;
            lastTime=currentTime;
            if(delta>=1) {

                update();


                repaint();
                delta--;
                timeCounter++;
            }
        }
    }
    public void update(){
    mario.setNowMapNumb(mapNumb);
    mario.setPartNumb(partNumb-1);
    mario.Update(this,sm);
    fc.updateFC();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    tileManager.draw(g2);


    for(Character character : map.characters) character.draw(g2);

    Font stringFont = new Font( "SansSerif", Font. PLAIN, 60 );
    g2.setFont(stringFont);

    mario.draw(g2);

    sm.draw(g2);


    timerTitle(g2);
    coinTitle(g2);


    g2.dispose();
    }

    private void timerTitle(Graphics2D g2){
        g2.drawString("TIME: "+timer/(1000000000)+"/"+mainTime,0,100);
    }
    private void coinTitle(Graphics2D g2){
        g2.drawString("COINS: "+ mario.getCoins(),650,100);
    }
    public void stopGameThread(){
        gameThread = null;
    }
    public int getTileSize() {
        return tileSize;
    }

    public int getTilesColumn() {
        return tilesColumn;
    }

    public int getTilesRow() {
        return tilesRow;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public SectionFrame getSectionFrame() {
        return sectionFrame;
    }

    public void setSectionFrame(SectionFrame sectionFrame) {
        this.sectionFrame = sectionFrame;
    }

    public int getOriginalTileSize() {
        return originalTileSize;
    }

    public int getScaleSize() {
        return scaleSize;
    }

    public int getFps() {
        return fps;
    }

    public int getMapNumb() {
        return mapNumb;
    }

    public void setMapNumb(int mapNumb) {
        this.mapNumb = mapNumb;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    public TileManager getTileManager() {
        return tileManager;
    }

    public void setTileManager(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    public Thread getGameThread() {
        return gameThread;
    }

    public void setGameThread(Thread gameThread) {
        this.gameThread = gameThread;
    }

    public CharacterKeyListener getCharacterKeyListener() {
        return characterKeyListener;
    }

    public void setCharacterKeyListener(CharacterKeyListener characterKeyListener) {
        this.characterKeyListener = characterKeyListener;
    }

    public Mario getMario() {
        return mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    public CollisionChecker getCollisionChecker() {
        return collisionChecker;
    }

    public void setCollisionChecker(CollisionChecker collisionChecker) {
        this.collisionChecker = collisionChecker;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ScoreManager getSm() {
        return sm;
    }

    public void setSm(ScoreManager sm) {
        this.sm = sm;
    }

    public int getMainTime() {
        return mainTime;
    }

    public int getPartNumb() {
        return partNumb;
    }

    public void setPartNumb(int partNumb) {
        this.partNumb = partNumb;
    }

    public void setMainTime(int mainTime) {
        this.mainTime = mainTime;
    }

    public FinishChecker getFc() {
        return fc;
    }

    public void setFc(FinishChecker fc) {
        this.fc = fc;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void STOP(){
        sectionFrame.dispose();
        stopGameThread();
    }

    @Override
    public int coin() {
        return mario.getCoins();
    }

    @Override
    public int distanceFromStart() {
        return (mapNumb % 4) * sectionFrame.getX() + mario.getX();
    }

    @Override
    public int distanceUntilEnd() {
        return 4 * sectionFrame.getX() - distanceFromStart();
    }

    @Override
    public int ProressRate() {
        if(distanceFromStart()/distanceUntilEnd() > 0) return distanceFromStart()/distanceUntilEnd();
        else return distanceFromStart();
    }

}
