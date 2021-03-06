package view;

import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.BattleManager;
import model.dao.PokemonDao;
import model.vo.User;


public class BattlePage extends JPanel {
	//0217-01
	//0217-01  private JPanel bp;
	private BattlePage bp;
   private MainFrame mf;
   private Map m;
   private BattleSkillPage bsp;
   private PInfoPage pip;
   //0217-01 private JPanel uivp;
   private UserInvenPage uivp;
   private User user;
   private BattleManager bm = new BattleManager();
	private PokemonDao pd = new PokemonDao();

	private JLabel enPLabel;
	private JLabel myPLabel;
	private ImageIcon myPIcon;
	private ImageIcon enPIcon;
	private JLabel myHP = new JLabel();
	private JLabel enHP = new JLabel();

   //버튼 이미지 올리기
   private Image fightButtonImage = new ImageIcon("images/싸운다버튼.png").getImage();
   private Image changeButtonImage = new ImageIcon("images/포켓몬버튼.png").getImage();
   private Image invenButtonImage = new ImageIcon("images/가방버튼.png").getImage();
   private Image runButtonImage = new ImageIcon("images/도망간다버튼.png").getImage();
   private JButton mes = new JButton("도망칠 수 없다.  싸워라.");
   private Dialog blockrun = new Dialog(mf);



   //삭제할 백버튼
   private Image backButtonImage = new ImageIcon("images/back.png").getImage();
   private JButton backButton = new JButton(new ImageIcon(backButtonImage));

   //이미지 버튼화
   private JButton fightButton = new JButton(new ImageIcon(fightButtonImage));
   private JButton changeButton = new JButton(new ImageIcon(changeButtonImage));
   private JButton invenButton = new JButton(new ImageIcon(invenButtonImage));
   private JButton runButton = new JButton(new ImageIcon(runButtonImage));

   private int mpnum;
   private int epnum;




public Map getM() {
	return m;
}


public void setM(Map m) {
	this.m = m;
}


//Graphics
   //전투 배경 이미지
   Image background = Toolkit.getDefaultToolkit().getImage("images/battleViewImg/battleview.png");
   Image mground = Toolkit.getDefaultToolkit().getImage("images/battleViewImg/풀필드1.png");
   Image eground = Toolkit.getDefaultToolkit().getImage("images/battleViewImg/풀필드2.png");
  

   public BattlePage(MainFrame mf, JPanel panel, User user) {
	
	   this.setSize(1024,768);
	   this.bp = this;
      this.mf = mf;
      this.m = (Map)panel;
      //0217-01 this.pip = new PInfoPage(mf,this,user);
      //0217-01 this.bsp = new BattleSkillPage(mf, this,user);
      this.user = user;
      
      //버튼을 맘대로 배치하기 위해
      bp.setLayout(null);
      //this.pip = new PInfoPage(mf, this);


      fightButton.setBounds(180, 500, 300, 80);
      this.add(fightButton);
      settingButton(fightButton);
      fightButton.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
        	 //0217-03 싸우기 버튼 클릭시 배틀스킬페이지 생성후 넘김
        	 if(user.getUp_list().get(0).getpHp() <= 0) {
         		JPanel panel = bm.changeBP(mf, bp, pip, user);
         		panel.setVisible(true);
         		mf.add(panel);
         		
         	}else if(user.getUp_list().get(0).getpHp() >0){
         		
         		bsp = new BattleSkillPage(mf, bp,user);
         		mf.add(bsp);
         		bm.showS(bsp,user);
         		bp.setVisible(false);
         	}
         	
         	
         	bp.setVisible(false);
            
         }
      });
      this.add(fightButton);


      changeButton.setBounds(550, 500, 300, 80);
      settingButton(changeButton);
      changeButton.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
        	 bp.setVisible(false);
          //0217-01 mf.add(pip);
            mf.add(new PInfoPage(mf,bp,user)); //0217-01
         }
      });
      this.add(changeButton);



      invenButton.setBounds(180, 600, 300, 80);
      settingButton(invenButton);
      invenButton.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
            bp.setVisible(false);
          //0217-01 uivp.setVisible(true);   
          //0217-01 mf.add(uivp);
            mf.add(new UserInvenPage(mf, bp, user,m)); //0217-01
            
         }
      });
      this.add(invenButton);


      //m.setNum(4);
      if(m.getNum() == 4) {
         runButton.setBounds(550, 600, 300, 80);
         settingButton(runButton);
         runButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
               blockrun.setBounds(600, 300, 200, 100 );
               blockrun.add(mes);

               blockrun.setVisible(true);

            }
         });
         this.add(runButton);      

         //다이얼로그 메세지 클릭시 이벤트
         settingButton(mes);
         mes.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
               blockrun.dispose();

            }
         });
         this.add(mes);      
      }else {
         runButton.setBounds(550, 600, 300, 80);
         settingButton(runButton);
         runButton.setBorderPainted(false);
         runButton.setFocusPainted(false);
         runButton.setContentAreaFilled(false);
         runButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
               mf.remove(bp);
               m.setVisible(true);
               mf.requestFocus();
               m.setCantMove(false);
               //((Map) m).start();
            }
         });
         this.add(runButton);
      }
      //삭제할 이벤트
      backButton.setBounds(780, 650, 300, 80);
      settingButton(backButton);
      backButton.setBorderPainted(false);
      backButton.setFocusPainted(false);
      backButton.setContentAreaFilled(false);
      backButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
         }
         @Override
         public void mouseExited(MouseEvent e) {
         }
         @Override
         public void mousePressed(MouseEvent e) {
            mf.remove(bp);
            m.setVisible(true);
            mf.requestFocus();
            m.setCantMove(false);
            //((Map) m).start();
         }
      });
      this.add(backButton);   
   }


   //라벨 대신 배경, 포켓몬 불러오는 그래픽스
   public void paintComponent(Graphics g) {
      g.drawImage(background, 0, 0, 1012, 729, this);
      g.drawImage(mground, 150, 321, 280, 100, this);
      g.drawImage(eground, 670, 90, 250, 100, this);
      if(this.isVisible()) {
    	  mpnum = user.getUp_list().get(0).getpNo();
    	  Image mypokemon = Toolkit.getDefaultToolkit().getImage("images/poke/"+mpnum+"B.gif");
    	  g.drawImage(mypokemon, 235, 321, 90, 90, this);
    	  epnum = user.getEp_list().get(0).getpNo();
    	  Image enpokemon = Toolkit.getDefaultToolkit().getImage("images/poke/"+epnum+"F.gif");
          g.drawImage(enpokemon, 740, 60, 100, 100, this);
      }
      
   }


   public void settingButton(JButton jb) {
      jb.setBorderPainted(false);
      jb.setFocusPainted(false);
      jb.setContentAreaFilled(false);
   }
   
   

}
