package Game.Logic.Maps;

import Game.Game.SectionPanel;
import Game.Logic.Character;
import Game.Logic.CheckPoint.GrayFlag;
import Game.Logic.Enemy.Planet;
import Game.Logic.CheckPoint.Flag;
import Game.Logic.Items.Coin;
import Game.Logic.Items.MagicFlower;
import Game.Logic.Items.MagicalMushroom;
import Game.Logic.Items.MagicalStar;
import Game.Logic.Weapon.Weapon;

import java.io.File;
import java.util.ArrayList;

public  class Map {
    public ArrayList<Character> characters = new ArrayList<>();
    private File P1_1;
    private File P1_2;
    private File P1_3;
    private File P1_4;
    private File P2_1;
    private File P2_2;
    private File P2_3;
    private File P2_4;

    public Map(int mapNumb, SectionPanel sectionPanel,int partNumb){

        if(partNumb == 1) {
            if (mapNumb == 0) P1_1(sectionPanel);
            else if (mapNumb == 1) P1_2(sectionPanel);
            else if (mapNumb == 2) P1_3(sectionPanel);
            else P1_4(sectionPanel);
        }
        else if(partNumb == 2){
            if (mapNumb == 0) P2_1(sectionPanel);
            else if (mapNumb == 1) P2_2(sectionPanel);
            else if (mapNumb == 2) P2_3(sectionPanel);
            else P2_4(sectionPanel);
        }
    }
    private void P1_1(SectionPanel sectionPanel){
        P1_1 = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Maps/1_PART/1.txt");
        characters.add(new Weapon(140,500,32,32,sectionPanel,null));
        characters.add(new Coin(150,640,32,32,sectionPanel,null));
        characters.add(new MagicFlower(200,300,56,49,sectionPanel,null));
        characters.add(new Coin(200,640,32,32,sectionPanel,null));
        characters.add(new Coin(250,640,32,32,sectionPanel,null));
        characters.add(new MagicalMushroom(300,500,32,32,sectionPanel,null));
        characters.add(new MagicalStar(250,500,62,43,sectionPanel,null));
        characters.add(new Coin(300,640,32,32,sectionPanel,null));
        characters.add(new Coin(34*32,16*32,32,32,sectionPanel,null));
        characters.add(new Coin(33*32,16*32,32,32,sectionPanel,null));
        characters.add(new Flag(1200,205,200,478,sectionPanel,null));
        characters.add(new GrayFlag(800,200,72,88,sectionPanel,null));
        sectionPanel.tileManager.loadMap(P1_1);
    }
    private void P1_2(SectionPanel sectionPanel){
        P1_2 = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Maps/1_PART/2.txt");
        characters.add(new Coin(70,500,32,32,sectionPanel,null));
        characters.add(new Coin(102,300,32,32,sectionPanel,null));
        characters.add(new Coin(134,300,32,32,sectionPanel,null));
        characters.add(new Coin(166,300,32,32,sectionPanel,null));
        characters.add(new Flag(1200,205,200,478,sectionPanel,null));
        sectionPanel.tileManager.loadMap(P1_2);
    }
    private void P1_3(SectionPanel sectionPanel){
        P1_3 = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Maps/1_PART/3.txt");
        characters.add(new Coin(200,640,32,32,sectionPanel,null));
        characters.add(new Coin(250,640,32,32,sectionPanel,null));
        characters.add(new Coin(350,640,32,32,sectionPanel,null));
        characters.add(new Coin(400,640,32,32,sectionPanel,null));
        characters.add(new Planet(635,390,49,50,sectionPanel,null));
        characters.add(new Flag(1200,205,200,478,sectionPanel,null));
        sectionPanel.tileManager.loadMap(P1_3);
    }
    private void P1_4(SectionPanel sectionPanel){
        P1_4 = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Maps/1_PART/4.txt");
        characters.add(new Flag(1200,205,200,478,sectionPanel,null));
        sectionPanel.tileManager.loadMap(P1_4);
    }
    private void P2_1(SectionPanel sectionPanel){
        P2_1 = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Maps/2_PART/1.txt");
        characters.add(new Flag(1200,205,200,478,sectionPanel,null));
        sectionPanel.tileManager.loadMap(P2_1);
    }
    private void P2_2(SectionPanel sectionPanel){
        P2_2 = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Maps/2_PART/2.txt");
        characters.add(new Flag(1200,205,200,478,sectionPanel,null));
        sectionPanel.tileManager.loadMap(P2_2);
    }
    private void P2_3(SectionPanel sectionPanel){
        P2_3 = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Maps/2_PART/3.txt");
        characters.add(new Flag(1200,205,200,478,sectionPanel,null));
        sectionPanel.tileManager.loadMap(P2_3);
    }
    private void P2_4(SectionPanel sectionPanel){
        P2_4 = new File("D:/JavaProjects/ApProjectSpring2023/src/Game/Logic/Maps/2_PART/4.txt");
        characters.add(new Flag(1200,205,200,478,sectionPanel,null));
        sectionPanel.tileManager.loadMap(P2_4);
    }
}
