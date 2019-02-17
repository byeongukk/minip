package controller;

import model.dao.ItemDao;
import model.dao.PokemonDao;
import model.vo.Pokemon;
import model.vo.User;

public class MCManager {
	
	private String resultNo;
    private User user;
    private ItemDao id = new ItemDao();
    private PokemonDao pd = new PokemonDao();
    
    public MCManager(User user) {
    	this.user = user;
    }
   
   public void useMarket(String iName, int iAmount) {
      int check = 0;//구매 하고 싶은 아이템의 총 가격
      
      ItemManager im = new ItemManager(user);
      resultNo=null;
      
      for(int i=0 ; i<id.getIList().size() ; i++) {
         //아이템 고른 것을 비교하여 아이템리스트의 몇번째 인덱스에 있는 지 확인
         if(id.getIList().get(i).getiName().equals(iName)) {
            //구매 하고 싶은 아이템의 총 금액
            check = (id.getIList().get(i).getiPrice()) * iAmount;
            if(iAmount > 100) {
               //구매 불가
               resultNo="최대 구매 수량은 100개 입니다.";
            }else if(iAmount < 1){
               resultNo="최소 구매 수량은 1개 입니다.";
            }else if(user.getuGold() < check){
               resultNo="골드가 부족합니다.";
            }else {
            	//구매 가능
            	//decreaseGold = 유저골드차감
            	im.decreaseGold(check);
            	//addInven = 유저인벤에 아이템 추가
            	im.addInven(i, iAmount);
            }
         }
      }
   }
   
   public String getResultNo() {
      return resultNo;
   }
   
   public void setResultNo(String resultNo) {
      this.resultNo = resultNo;
   }
   
   public void useCenter(int ans) {
	   //1 = yes / 2 = no
       //회복 시켜주기
	   
	   Pokemon p = new Pokemon();
	   p = pd.getpList().get(0);
	   
	   user.getUp_list().set(0, p);
	      
	   for(int i = 0; i < user.getUp_list().size(); i++) {
	    	  if(user.getUp_list().get(i) == null) {
	    		  System.out.print(i + " : 빈칸 | ");
	    	  }else {
	    		  System.out.print(" " + i + " : " + user.getUp_list().get(i).getpName() + " / "
	    				  + user.getUp_list().get(i).getpHp() + " |");
	    		  }
	   }
	      
	   System.out.println("--회복시작--");
	   
	   int addHp = 200;
	   
	   if(ans == 2) {
		   System.out.println("센터 나감");
	   }else {
		   for(int i = 0; i < user.getUp_list().size(); i++) {
			   if(user.getUp_list().get(i) != null) {
				   user.getUp_list().get(i).setpHp(addHp);
				   System.out.println("회복 끝");
			   }
		   }
	   }
	   
	   for(int i = 0; i < user.getUp_list().size(); i++) {
	    	  if(user.getUp_list().get(i) == null) {
	    		  System.out.print(i + " : 빈칸 | ");
	    	  }else {
	    		  System.out.print(" " + i + " : " + user.getUp_list().get(i).getpName() + " / "
	    				  + user.getUp_list().get(i).getpHp() + " |");
	    	  }
	   }
   }

}