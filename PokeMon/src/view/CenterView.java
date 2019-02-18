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

public class CenterView extends JPanel{
	   private MainFrame mf;
	   private CenterView centerView;
	   private Map m;
	   private Image backButtonImage = new ImageIcon("images/maketViewImages/marketViewBack.png").getImage();
	   private JButton backButton = new JButton(new ImageIcon(backButtonImage));
	   private MCManager mc;
	   private int ans=0;
	   private Image centerBackground = new ImageIcon("images/maketViewImages/centerView.gif").getImage();
	   
	   private RecoveryView rv ;
	   private PChangeView pv;
	   
	   private User user;
	   
	   private PInfoPage pinfo;
	   
	   private RecoveryView recoveryView;
	   
	   public CenterView(MainFrame mf, JPanel oldPage, User user) {
	     mc = new MCManager(user);
	     this.mf=mf;
	      this.centerView=this;
	      this.m=(Map)oldPage;
	      this.user=user;
	      
	      this.setLayout(null);
	      this.setBounds(0,0,1024,768);
	      
	      this.setBackground(Color.BLUE);
	      
	      
	      
	      //System.out.println("����");
	      
	      JLabel recover = new JLabel("���Ϳ� ���� �� ȯ���մϴ�");
	      recover.setFont(new Font(getName(),4,30));
	      recover.setBounds(330, 200, 600, 200);
	      this.add(recover);
	      
	      JButton btnRecovery = new JButton("���ϸ� ȸ��");
	      btnRecovery.setBounds(310, 400, 200, 50);
	      btnRecovery.setFont(new Font(getName(),3,15));
	      this.add(btnRecovery);
	      
	      JButton btnPChange = new JButton("���ϸ� ��ü");
	      btnPChange.setBounds(510, 400, 200, 50);
	      btnPChange.setFont(new Font(getName(),3,15));
	      this.add(btnPChange);
	      
	      
	      btnRecovery.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mousePressed(MouseEvent e) {
	        	 System.out.println("���ϸ� ȸ�� �������� �̵�");
	            //mc.useRecovery(ans);
	            
	            rv = new RecoveryView(mf, centerView, user);
	            
	            centerView.setVisible(false);
	            mf.add(rv);
	            rv.setVisible(true);
	            
	         }
	      });
	      
	      btnPChange.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mousePressed(MouseEvent e) {
	        	 System.out.println("���ϸ� ��ü �������� �̵�");
	        	 //mc.usepChange(ans);
		            
		            pv = new PChangeView(mf, centerView, user);
		            
		            centerView.setVisible(false);
		            mf.add(pv);
		            pv.setVisible(true);
	            
	            
	         }
	      });
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
	            mf.remove(centerView);
	            
	            m.setVisible(true);
	            mf.requestFocus();
	            m.setEscCtn(0);
	         }
	      });
	      this.add(backButton);
	   }
	   public void paintComponent(Graphics g) {
	      
	         g.drawImage(centerBackground, 0, 0, 1024, 729, this);
	   }
	   public void settingButton(JButton jb) {
	         jb.setBorderPainted(false);
	         jb.setFocusPainted(false);
	         jb.setContentAreaFilled(false);
	   }
	}