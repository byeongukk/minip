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
		talkList[0] = "�ȳ�! " + user.getuName() + ". ȯ���ϳ�.";
		talkList[1] = "���� �����ϴϱ� ���ϸ� �� ������ ���������� �ϰ�.";
		talkList[2] = "���ϸ��� �� �������ϼ�. ���� ģ���� ��ſ� ������ ������.";
		
		
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
		
		
		JButton back = new JButton("�ڷ�");
		
		back.setBounds(900, 610, 90, 120);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		//�ڷΰ��� ��ư
		back.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				//Ŭ���� �̺�Ʈ
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
