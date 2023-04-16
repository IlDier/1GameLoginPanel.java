package Game.Logic;

import Game.Game.SectionPanel;

public class CollisionChecker {
    private SectionPanel sectionPanel;
    public CollisionChecker(SectionPanel sectionPanel){
        this.sectionPanel=sectionPanel;
    }
    public void checkTile(Character character){
              int LeftX = character.x;
              int RightX = character.x + sectionPanel.getTileSize();
              int TopY = character.y;
              int BottomY = character.y + sectionPanel.getTileSize();

              int LeftCol = LeftX/sectionPanel.getTileSize();
              int RightCol = RightX/sectionPanel.getTileSize() ;
              int TopRow = TopY/sectionPanel.getTileSize() ;
              int BottomRow = BottomY/sectionPanel.getTileSize();



              switch (character.direction){
                  case "up":
                      int characterTopRow = (TopY-character.speedY)/sectionPanel.getTileSize();
                      if(sectionPanel.tileManager.mapTile[characterTopRow][LeftCol].isCollision() || sectionPanel.tileManager.mapTile[characterTopRow][RightCol].isCollision()) character.setSpeedY(0);
                      else character.setSpeedY(3);

                      break;
                  case "down":
                      int characterBottomRow = (BottomY)/sectionPanel.getTileSize() ;
                      if(sectionPanel.tileManager.mapTile[characterBottomRow][LeftCol].isCollision() || sectionPanel.tileManager.mapTile[characterBottomRow][RightCol].isCollision()) character.setSpeedY(0);
                      else character.setSpeedY(-3);
                  break;
                  case "right":
                      int characterRightColumn = (RightX)/sectionPanel.getTileSize();
                      if(sectionPanel.tileManager.mapTile[TopRow][characterRightColumn].isCollision() || sectionPanel.tileManager.mapTile[BottomRow][characterRightColumn].isCollision()) character.setSpeedX(0);
                      else character.setSpeedX(10);
                      break;
                  case "left":
                      int characterLeftColumn = (LeftX - character.speedX)/sectionPanel.getTileSize();
                      if(sectionPanel.tileManager.mapTile[TopRow][characterLeftColumn].isCollision() || sectionPanel.tileManager.mapTile[BottomRow][characterLeftColumn].isCollision()) character.setSpeedX(0);
                      else character.setSpeedX(10);
                      break;
              }
    }
}
