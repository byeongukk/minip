package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.BattleManager;
import controller.ItemManager;
import model.dao.ItemDao;
import model.vo.Ball;
import model.vo.Item;
import model.vo.Pokemon;
import model.vo.User;

public class UserInvenPage extends JPanel {
	//0217-01
	private JPanel uivp;
	private MainFrame mf;
	private BattlePage bp;
	private UserMenuPage ump;
	private User user;
	private JPanel oldPage;
	private Map m;
	private BattleManager bm = new BattleManager();

	private JButton backButton = new JButton(new ImageIcon(("images/userMenuImages/backButtonBasic.PNG")));
	private JButton useButton = new JButton(new ImageIcon(("images/userMenuImages/useButton.PNG")));

	//private JButton upButton = new JButton(new ImageIcon(("images/userMenuImages/upButtonBasic.PNG")));
	//private JButton downButton = new JButton(new ImageIcon(("images/userMenuImages/downButtonBasic.PNG")));

	private JLabel itemInfoLabel = new JLabel();
	//private JLabel itemListLabel = new JLabel(new ImageIcon(("images/userMenuImages/itemList.PNG")));

	private ItemDao id = new ItemDao();

	public UserInvenPage(MainFrame mf,JPanel oldPage,User user,Map m) {
		this.mf = mf;
		this.ump = ump;
		this.uivp = this;
		this.user = user;
		this.oldPage = oldPage; // JPanel로 받아 userMenuPage, BattlePage를 받을수 있음
		ArrayList<Item> itemList= (ArrayList<Item>) user.getUi_list();
		ArrayList<Item> imgList= (ArrayList<Item>) user.getUi_list();
		ArrayList<Item> iInfo= (ArrayList<Item>) user.getUi_list();

		String[] iNameList = new String[itemList.size()];
		for(int i=0 ; i<iNameList.length ; i++) {
			iNameList[i] = itemList.get(i).getiName();
		}
		String[] iAmount = new String[itemList.size()];
		for(int i=0 ; i<iNameList.length ; i++) {
			iAmount[i] = itemList.get(i).getiAmount()+"";
		}
		//아이템정보에 이미지 띄우기---sm

		ImageIcon[] iImgList = new ImageIcon[imgList.size()];
		int num = 0;
		for(int i=0 ; i<iImgList.length ; i++) {
			iImgList[i] = new ImageIcon("images/itemImages/i00" + itemList.get(i).getiNo() + ".png");
			num++;
		}

		JList itemName = new JList(iNameList);
		itemName.setFont(new Font(getName(),Font.BOLD,17));
		itemName.setBounds(50, 100, 320, 480);
		itemName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		itemInfoLabel.setBounds(500, 100, 300, 300);
		itemInfoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		JLabel itemImg = new JLabel();
		itemImg.setBounds(630, 130, 50, 50);

		String[] jta = new String[itemList.size()];
		JTextField jtaText = new JTextField(290);

		JLabel jl = new JLabel(/*"ㅈ같다 ㅅㅂ"*/);
		jl.setBounds(505, 200, 290, 150);

		Item searchItem = null;

		String grade;
		int x=100;
		int y=100;

		for(int i=0; i<itemList.size(); i++) {
			searchItem = itemList.get(i);
			//jta[i] = new JTextArea();
			int iNum = searchItem.getiNo();
			if(searchItem.getiType() == 0) {

			}
			jta[i]=itemList.get(i).getiName() + ".\n"
					+itemList.get(i).getiInfo() + "\n";
			//jta[i].setEditable(false);
			//jta[i].setBounds(520, 200, 250, 150);
			//this.add(jta[i]);
			//jtaText.add(jta[i]);
			jl = new JLabel(jta[i]);
		}

		//jl.add(jtaText);

		itemName.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				itemImg.setIcon(iImgList[itemName.getSelectedIndex()]);
				/*jl.add(jta[itemName.getSelectedIndex()]);
	            jtaText.setText(jta[itemName.getSelectedIndex()]+"");
	            jtaText.setBounds(520, 200, 250, 150);
	            jtaText.setEditable(false);
	            jtaText.setHorizontalAlignment(JTextField.CENTER);
	            jl.add(jtaText);*/
			}
		});
		itemName.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				jtaText.setText(jta[itemName.getSelectedIndex()]+"");
				jtaText.setBounds(505, 200, 290, 150);
				jtaText.setEditable(false);
				jtaText.setHorizontalAlignment(JTextField.CENTER);
			}
		});
		this.add(jtaText);	    
		this.add(jl);
		this.add(itemImg);

		this.setLayout(null);
		this.setBackground(Color.WHITE);
		JLabel label = new JLabel();
		label.setText("가방 페이지");

		mf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == UserMenuPage.ESC) {
					mf.remove(uivp);
					uivp.setVisible(false);
				}
			}
		});


		JList itemAmountList = new JList(iAmount);
		itemAmountList.setFont(new Font(getName(),Font.BOLD,17));
		itemAmountList.setBounds(380, 100,50,480);
		itemAmountList.setEnabled(false);
		itemAmountList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));



		useButton.setBounds(500, 450, 300, 150);
		useButton.setBorderPainted(false);
		useButton.setFocusPainted(false);
		useButton.setContentAreaFilled(false);
		useButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				useButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				useButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				//선택한 아이템이 있을때 다음페이지로 넘어감
				String userItemName = null;
				userItemName = itemName.getSelectedValue()+""; //선택한 아이템 리셋
				System.out.println(userItemName==null);
				if(userItemName!=null) {
					uivp.setVisible(false);
					mf.remove(uivp);
				}
				ItemDao iList = new ItemDao();
				Item checkItem = null;
				checkItem = new ItemManager(user).itemReturn(userItemName);



				//유저인벤에서는 볼을 사용 할 수 없음
				if(oldPage instanceof BattlePage) {
					if(checkItem instanceof Ball) {
						if(!(bm.catchP(user, oldPage, m, checkItem))) {
							System.out.println("못잡았을때");
							oldPage.setVisible(true);
						} else {
							System.out.println("잡았을때");
							oldPage.setVisible(false);
							mf.remove(oldPage);
							m.setVisible(true);
							m.setCantmove(false);
						}
						//uivp.setVisible(false);
					}
				}else {
					if(checkItem instanceof Ball) {
						JOptionPane.showMessageDialog(null, "볼종류는 배틀중에만 사용할 수 있습니다", "에러", JOptionPane.WARNING_MESSAGE);
						mf.add(uivp);
						uivp.setVisible(true);
					} else {
						for(int i=0; i<itemList.size(); i++) {
							//선택한 아이템과 소지중인 아이템으로 번호를 받아 메소드 실행
							if(itemList.get(i).getiName().equals(userItemName)) {
								uivp.setVisible(false);
								mf.add(new PInfoPage(mf, uivp, user,userItemName)); //0217-01;
								/////아이템 사용후 이전페이지로 돌아왔을때 화면 업데이트 문제
							}
						}
					}
				}
			}
		});
		this.add(useButton);

		/*upButton.setBounds(200, 20, 95, 95);
		upButton.setBorderPainted(false);
		upButton.setFocusPainted(false);
		upButton.setContentAreaFilled(false);
		upButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				upButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				upButton.setIcon(new ImageIcon("images/userMenuImages/upButtonEntered.PNG"));
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				upButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				upButton.setIcon(new ImageIcon("images/userMenuImages/upButtonBasic.PNG"));
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				//클릭시 이벤트
			}
		});
		this.add(upButton);

		downButton.setBounds(200, 600, 95, 95);
		downButton.setBorderPainted(false);
		downButton.setFocusPainted(false);
		downButton.setContentAreaFilled(false);
		downButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				downButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				downButton.setIcon(new ImageIcon("images/userMenuImages/downButtonEntered.PNG"));
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				downButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				downButton.setIcon(new ImageIcon("images/userMenuImages/downButtonBasic.PNG"));
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				//클릭시 이벤트
			}
		});
		this.add(downButton);*/

		label.setBounds(450, 20, 200, 40);
		backButton.setBounds(900, 610, 90, 120);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		backButton.setContentAreaFilled(false);
		//뒤로가기 버튼
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
			public void mousePressed(java.awt.event.MouseEvent e) {
				//클릭시 이벤트
				mf.remove(uivp);
				oldPage.setVisible(true);
				mf.requestFocus();
			}
		});
		this.add(backButton);
		this.add(itemInfoLabel);
		this.add(itemName);
		this.add(itemAmountList);

		this.add(label);
	}



}
