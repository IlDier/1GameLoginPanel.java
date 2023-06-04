package Game.Logic.Tile;

import Game.Game.SectionPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    protected SectionPanel sectionPanel;
    protected Tile[] tiles=new Tile[15];
    public Tile[][] mapTile= new Tile[24][45];
    public TileManager(SectionPanel sectionPanel){
        this.sectionPanel=sectionPanel;
    getImage();
    }
    private void getImage(){
        try{
            tiles[0] = new Tile(0);
            File Soil = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Tile/Soil.png");
            tiles[0].image = ImageIO.read(Soil);
            tiles[0].collision=true;
            tiles[1]= new Tile(1);
            File Sky = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Tile/Sky.png");
            tiles[1].image = ImageIO.read(Sky);
            tiles[2] = new Tile(2);
            File Pipe = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Tile/Pipe.png");
            tiles[2].image = ImageIO.read(Pipe);
            tiles[2].collision = true;
            tiles[3] = new Tile(3);
            File Air = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Tile/air.png");
            tiles[3].image = ImageIO.read(Air);
            tiles[4] = new Tile(4);
            File Question = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Tile/QuestionMarkBlock.png");
            tiles[4].image = ImageIO.read(Question);
            tiles[4].collision = true;
            tiles[5] = new Tile(5);
            File finalBossBlocks = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Tile/FinalBossBlocks.png");
            tiles[5].image = ImageIO.read(finalBossBlocks);
            tiles[5].collision = true;
            tiles[6] = new Tile(6);
            File simpleBlock = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Tile/SimpleBlock.png");
            tiles[6].image = ImageIO.read(simpleBlock);
            tiles[6].collision=true;
            tiles[7] = new Tile(7);
            File filledBlock = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Tile/FilledBlock.png");
            tiles[7].image = ImageIO.read(filledBlock);
            tiles[7].collision=true;
            tiles[8] = new Tile(8);
            File blockWithOneCoin = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Tile/SimpleBlock.png");
            tiles[8].image = ImageIO.read(blockWithOneCoin);
            tiles[8].collision=true;
            tiles[9] = new Tile(9);
            File blockWithManyCoins = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Tile/SimpleBlock.png");
            tiles[9].image = ImageIO.read(blockWithManyCoins);
            tiles[9].collision=true;
            tiles[10] = new Tile(10);
            File slimeBlock  = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Tile/Slime.png");
            
        } catch (IOException o) {
        }
    }
    public void loadMap(File Map){
        try {
            BufferedReader bf=new BufferedReader(new FileReader(Map));
            String line= bf.readLine();
           for(int i=0 ; line!=null ; i++){
                String[] x = line.split(" ");
                for(int j=0; j<45;j++){
                    mapTile[i][j] = tiles[Integer.parseInt(x[j])];
                }
                line= bf.readLine();
            }
        } catch (Exception o) {}


    }
    private void buildMap(Graphics2D g2){
   for(int i=0;i<sectionPanel.getTilesRow();i++){
       for(int j=0;j<sectionPanel.getTilesColumn();j++){
          g2.drawImage(mapTile[i][j].image,j*SectionPanel.tileSize,i*SectionPanel.tileSize,sectionPanel.getTileSize(),sectionPanel.getTileSize(),null);
       }

   }
    }
    public void draw(Graphics2D g2){

        buildMap(g2);
    }
}
