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
      int check = 0;//���� �ϰ� ���� �������� �� ����
      
      ItemManager im = new ItemManager(user);
      resultNo=null;
      
      for(int i=0 ; i<id.getIList().size() ; i++) {
         //������ �� ���� ���Ͽ� �����۸���Ʈ�� ���° �ε����� �ִ� �� Ȯ��
         if(id.getIList().get(i).getiName().equals(iName)) {
            //���� �ϰ� ���� �������� �� �ݾ�
            check = (id.getIList().get(i).getiPrice()) * iAmount;
            if(iAmount > 100) {
               //���� �Ұ�
               resultNo="�ִ� ���� ������ 100�� �Դϴ�.";
            }else if(iAmount < 1){
               resultNo="�ּ� ���� ������ 1�� �Դϴ�.";
            }else if(user.getuGold() < check){
               resultNo="��尡 �����մϴ�.";
            }else {
               //���� ����
               //decreaseGold = �����������
               im.decreaseGold(check);
               //addInven = �����κ��� ������ �߰�
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
   
   public void useRecovery(int ans) {
      //1 = yes / 2 = no
       //ȸ�� �����ֱ�      
         
      System.out.println("--ȸ������--");
      
      int addHp = 200;
      
      if(ans == 2) {
         System.out.println("���� ����");
      }else {
         for(int i = 0; i < user.getUp_list().size(); i++) {
            if(user.getUp_list().get(i) != null) {
               System.out.println(user.getUp_list().get(i).getpHp());
               //user.getUp_list().get(i).setpMaxHp(400);
               user.getUp_list().get(i).setpHp(user.getUp_list().get(i).getpMaxHp());
               System.out.println(user.getUp_list().get(i).getpHp());
               System.out.println("ȸ�� ��");
               
            }
         }
      }
      
      
   }

}