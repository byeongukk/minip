package model.vo;

import java.awt.Image;

public class Stone extends Item {
	
   private int stoneType;	//스톤 타입 -> 1 : 불 / 2 : 물 / 3 : 풀
   
   public Stone() {}
   
   public Stone(String iName, int iNo, int iPrice, int iType, int iAmount, int stoneType) {
      super(iName, iNo, iPrice, iType, iAmount);
      this.stoneType = stoneType;
   }

   public int getStoneType() {
	return stoneType;
   }

   public void setStoneType(int stoneType) {
	this.stoneType = stoneType;
   }
   
   

}