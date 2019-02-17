package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MCManager;
import model.vo.User;

public class CenterView extends JPanel{
   private MainFrame mf;
   private CenterView centerView;
   private Map m;
   private Image backButtonImage = new ImageIcon("images/back.png").getImage();
   private JButton backButton = new JButton(new ImageIcon(backButtonImage));
   private MCManager mc;
   private int ans=0;
   
   public CenterView(MainFrame mf, JPanel oldPage, User user) {
	  mc = new MCManager(user);
	  this.mf=mf;
      this.centerView=this;
      this.m=(Map)oldPage;
      
      this.setLayout(null);
      this.setBounds(0,0,1024,768);
      
      this.setBackground(Color.BLUE);
      
      
      //System.out.println("센터");
      
      JLabel recover = new JLabel("회복하시겠습니까?");
      recover.setFont(new Font(getName(),4,30));
      recover.setBounds(380, 200, 500, 200);
      this.add(recover);
      
      JButton btnYes = new JButton("예");
      btnYes.setBounds(400, 400, 100, 50);
      btnYes.setFont(new Font(getName(),3,15));
      this.add(btnYes);
      
      JButton btnNo = new JButton("아니오");
      btnNo.setBounds(500, 400, 100, 50);
      btnNo.setFont(new Font(getName(),3,15));
      this.add(btnNo);
      
      btnYes.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            ans=1;
            mc.useCenter(ans);
            
            mf.remove(centerView);
            
            m.setVisible(true);
            mf.requestFocus();
            m.setEscCtn(0);
            ans=0;
         }
      });
      btnNo.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            ans=2;
            mc.useCenter(ans);
            
            m.setVisible(true);
            mf.requestFocus();
            m.setEscCtn(0);
            ans=0;
            
            
         }
      });
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      backButton.setBounds(920, 600, 70, 50);
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
            mf.remove(centerView);
            
            m.setVisible(true);
            mf.requestFocus();
            //((Map)m).start();
            m.setEscCtn(0);
            
         }
      });
      this.add(backButton);
      
      
      
      
      
      
      
      
      
      
   }
   public void settingButton(JButton jb) {
         jb.setBorderPainted(false);
         jb.setFocusPainted(false);
         jb.setContentAreaFilled(false);
   }
   
}