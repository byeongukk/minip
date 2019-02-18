package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.w3c.dom.views.AbstractView;

import controller.MCManager;
import model.vo.User;

public class LabPage extends JPanel {
	
	private MainFrame mf;
	private LabPage lp;
	private JPanel oldPage;
	private Map m;
	private Image labBackground = new ImageIcon().getImage();
	   
	private User user;
	private int count = 1;
	
	
	public LabPage(MainFrame mf, JPanel oldPage, User user) {
		this.lp = this;
		this.mf = mf;
		this.oldPage = oldPage;
		this.user = user;
		
		String[] talkList = new String[3];
		talkList[0] = "안녕! " + user.getuName() + ". 환영하네.";
		talkList[1] = "밖은 위험하니까 포켓몬 한 마리를 데려가도록 하게.";
		talkList[2] = "포켓몬은 총 세마리일세. 좋은 친구와 즐거운 모험을 떠나게.";
		
		
		JLabel presentGold = new JLabel();
	      presentGold.setBounds(50, 500, 100, 50);
	      presentGold.setFont(new Font(getName(),4,12));
	      
	      JTextField userGold = new JTextField(40);
	      userGold.setText(talkList[0]);
	      userGold.setBounds(150, 50, 700, 300);
	      userGold.setEditable(false);
	      userGold.setHorizontalAlignment(JTextField.CENTER);
	      presentGold.add(userGold);
	      
	      
	      
	      userGold.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(count < talkList.length) {
					userGold.setText(talkList[count]);
					count++;
				}
			}
		});
		
		
		JButton back = new JButton("뒤로");
		
		back.setBounds(900, 610, 90, 120);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		//뒤로가기 버튼
		back.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				//클릭시 이벤트
				mf.remove(lp);
				oldPage.setVisible(true);
				mf.requestFocus();
			}
		});
		
		this.add(back);
		this.add(userGold);
		this.add(presentGold);
				
		this.setBackground(Color.blue);
		this.setVisible(true);
		this.setLayout(null);
		this.setBounds(0, 0, 1024, 768);
		mf.add(this);
	}

}
