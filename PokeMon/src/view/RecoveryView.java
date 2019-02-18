package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MCManager;
import model.vo.Pokemon;
import model.vo.User;

public class RecoveryView extends JPanel{
	
   private MainFrame mf;
   private RecoveryView recoveryView;
   private Map m;
   private Image backButtonImage = new ImageIcon("images/maketViewImages/marketViewBack.png").getImage();
   private JButton backButton = new JButton(new ImageIcon(backButtonImage));
   private MCManager mc;
   private int ans=0;
   private Image recoveryBackground = new ImageIcon("images/maketViewImages/centerView.gif").getImage();
   
   private User user;
   
   private PInfoPage pinfo;
   
   private JButton resultYes = new JButton("모두 회복 되었습니다.");
   private Dialog yes = new Dialog(mf); 
   
   private CenterView centerView;
   
   public RecoveryView(MainFrame mf, JPanel oldPage, User user) {
     mc = new MCManager(user);
     this.mf=mf;
      this.recoveryView=this;
      this.centerView = (CenterView)oldPage;
      
      this.setLayout(null);
      this.setBounds(0,0,1024,768);
      
      this.setBackground(Color.BLUE);
      
      JLabel recover = new JLabel("포켓몬을 회복하시겠습니까?");
      recover.setFont(new Font(getName(),4,30));
      recover.setBounds(250, 130, 500, 200);
      this.add(recover);
      
      JButton btnYes = new JButton("예");
      btnYes.setBounds(400, 600, 100, 50);
      btnYes.setFont(new Font(getName(),3,15));
      this.add(btnYes);
      
      JButton btnNo = new JButton("아니오");
      btnNo.setBounds(500, 600, 100, 50);
      btnNo.setFont(new Font(getName(),3,15));
      this.add(btnNo);
      
      
      Pokemon searchPoke = null;
      int pokeImgNo = 0;
      ImageIcon[] pImgList = new ImageIcon[4];
      JLabel[] userPoke = new JLabel[pImgList.length];
      int x=215;
      int y=300;
      int num=1;
      for(int i=0 ; i<4 ; i++) {
         if(user.getUp_list().size()==0) {
            System.out.println("포켓몬이 없음");
         }
         else {
            
            //i 로 해놓으면 널포인트 익셉션 뜸....
            //일단 임의로 0으로 무한 반복 돌림
            /*System.out.println(user.getUp_list().get(0));
            searchPoke = user.getUp_list().get(0);
            System.out.println(user.getUp_list().get(0).getpNo());
            pokeImgNo = user.getUp_list().get(0).getpNo();*/
            searchPoke = user.getUp_list().get(i);
            pokeImgNo = user.getUp_list().get(i).getpNo();
            pImgList[i] = new ImageIcon("images/poke/"+pokeImgNo+"F.gif");
            userPoke[i] = new JLabel(pImgList[i]);
             userPoke[i].setBounds(x, y, 175, 300);
             x+=148;
             num++;
             System.out.println("x : "+x);
             System.out.println("num : "+num);
             this.add(userPoke[i]);
            
         }
      }
      
      yes.setBounds(700, 450, 200, 100);
      btnYes.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            ans=1;
            mc.useRecovery(ans);
            
            yes.add(resultYes);         
            yes.setVisible(true);
            
            ans=0;
            
         }
      });
      settingButton(resultYes);
      resultYes.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            //mf.remove(yes);
            //yes.setVisible(false);
            yes.dispose();
              
              mf.remove(recoveryView);
              
              centerView.setVisible(true);
              centerView.requestFocus();
              //m.setEscCtn(0);
              ans=0;
         }
      });
      this.add(resultYes);
      
      btnNo.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            ans=2;
            mc.useRecovery(ans);
            
            
            mf.remove(recoveryView);
            
            centerView.setVisible(true);
            centerView.requestFocus();
            //((Map)m).start();
            //m.setEscCtn(0);
            
            ans=0;
         }
      });
      
      
      /*
      m.setVisible(true);
      mf.requestFocus();
      m.setEscCtn(0);
      mf.remove(centerView);*/
      
      backButton.setBounds(904, 660, 90, 59);
      settingButton(backButton);
      backButton.setBorderPainted(false);
      backButton.setFocusPainted(false);
      backButton.setContentAreaFilled(false);
      
      backButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) { }
         @Override
         public void mouseExited(MouseEvent e) {}
         @Override
         public void mousePressed(MouseEvent e) {
            mf.remove(recoveryView);
            
            centerView.setVisible(true);
            centerView.requestFocus();
            //((Map)m).start();
            m.setEscCtn(0);
         }
      });
      this.add(backButton);
   }
   
   public void paintComponent(Graphics g) {
      
         g.drawImage(recoveryBackground, 0, 0, 1024, 729, this);
   }
   public void settingButton(JButton jb) {
         jb.setBorderPainted(false);
         jb.setFocusPainted(false);
         jb.setContentAreaFilled(false);
   }
   
}