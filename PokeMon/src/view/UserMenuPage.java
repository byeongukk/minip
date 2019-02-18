package view;


import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.vo.User;


public class UserMenuPage extends JPanel {
	public final static int ESC = 27;
	//0217-01
	private UserMenuPage ump;
	private MainFrame mf;
	private Map m;
	private PInfoPage pip;
	private UserInfoPage uip;
	private SavePage sp;
	private UserInvenPage uivp;
	private PBookPage pb;
	
	private JButton saveButton = new JButton(new ImageIcon("images/userMenuImages/savePageButtonBasic.PNG"));
	private JButton pBookButton = new JButton(new ImageIcon("images/userMenuImages/pBookButtonBasic.PNG"));
	private JButton pokemonInfoButton = new JButton(new ImageIcon("images/userMenuImages/pokemonInfoButtonBasic.PNG"));
	private JButton userInfoButton = new JButton(new ImageIcon("images/userMenuImages/userInfoButtonBasic.PNG"));
	private JButton userInvenButton = new JButton(new ImageIcon("images/userMenuImages/userInvenButtonBasic.PNG"));
	private JButton backButton = new JButton(new ImageIcon("images/userMenuImages/backButtonBasic.png"));

	


	//0217-01public UserMenuPage(MainFrame mf, JPanel panel, User user) {
		public UserMenuPage(MainFrame mf, Map m, User user) {
		this.ump = this;
		this.mf = mf;
		this.m = m;
		//this.uip = new UserInfoPage(mf, this,user);
		//0217-01this.pip = new PInfoPage(mf, this,user);
		//0217-01this.sp = new SavePage(mf, this);
		//0217-01this.uivp = new UserInvenPage(mf,this);
		//0217-01this.pb = new PBookPage(mf,this);
		
		settingButton(saveButton);
		this.setLayout(null);
		saveButton.setBounds(200, 30, 600, 120);
		pBookButton.setBounds(200,170,600, 120);
		pokemonInfoButton.setBounds(200,310,600, 120);
		userInfoButton.setBounds(200,450,600, 120);
		userInvenButton.setBounds(200,590,600, 120);
		backButton.setBounds(900, 610, 90, 120);
		
		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				saveButton.setIcon(new ImageIcon("images/userMenuImages/savePageButtonEntered.PNG"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				saveButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				saveButton.setIcon(new ImageIcon("images/userMenuImages/savePageButtonBasic.PNG"));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ump.setVisible(false);
				//0217-01 sp.setVisible(true);
				//0217-01 mf.add(sp);
				mf.add(new SavePage(mf, ump,user));
			}
		});

		this.add(saveButton);

		settingButton(pBookButton);
		pBookButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pBookButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				pBookButton.setIcon(new ImageIcon("images/userMenuImages/pBookButtonEntered.PNG"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pBookButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				pBookButton.setIcon(new ImageIcon("images/userMenuImages/pBookButtonBasic.PNG"));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ump.setVisible(false);
				//0217-01 pb.setVisible(true);
				//0217-01 mf.add(pb);
				mf.add(new PBookPage(mf,ump));
			}
		});
		this.add(pBookButton);

		settingButton(pokemonInfoButton);
		pokemonInfoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pokemonInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				pokemonInfoButton.setIcon(new ImageIcon("images/userMenuImages/pokemonInfoButtonEntered.PNG"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pokemonInfoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				pokemonInfoButton.setIcon(new ImageIcon("images/userMenuImages/pokemonInfoButtonBasic.PNG"));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ump.setVisible(false);
				//0217-01 pip.setVisible(true);
				//0217-01 mf.add(pip);
				mf.add(new PInfoPage(mf, ump,user));
			}
		});
		this.add(pokemonInfoButton);

		settingButton(userInfoButton);
		userInfoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				userInfoButton.setIcon(new ImageIcon("images/userMenuImages/userInfoButtonEntered.PNG"));
				userInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				userInfoButton.setIcon(new ImageIcon("images/userMenuImages/userInfoButtonBasic.PNG"));
				userInfoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ump.setVisible(false);
				mf.add(new UserInfoPage(mf,ump,user));
			}
		});
		this.add(userInfoButton);

		settingButton(userInvenButton);

		userInvenButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				userInvenButton.setIcon(new ImageIcon("images/userMenuImages/userInvenButtonEntered.PNG"));
				userInvenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				userInvenButton.setIcon(new ImageIcon("images/userMenuImages/userInvenButtonBasic.PNG"));
				userInvenButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ump.setVisible(false);
				//0217-01 uivp.setVisible(true);
				//0217-01 mf.add(uivp);
				mf.add(new UserInvenPage(mf, ump, user,m)); //0217-01;
			}
		});
		this.add(userInvenButton);
		
		
		settingButton(backButton);
		backButton.setName("backButton");
		backButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(new ImageIcon("images/userMenuImages/backButtonEntered.PNG"));
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(new ImageIcon("images/userMenuImages/backButtonBasic.PNG"));
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				mf.remove(ump);
				m.setVisible(true);
				mf.requestFocus();
			}
		});
		this.add(backButton);
		
		// `키 눌렀을때 이전 메뉴로 돌아감
		mf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 192) {
					mf.remove(ump);
					m.setVisible(true);
					mf.requestFocus();
				}
			}
		});
	}
	//버튼들 기본 세팅
	public void settingButton(JButton jb) {
		jb.setBorderPainted(false);
		jb.setFocusPainted(false);
		jb.setContentAreaFilled(false);
	}





}
