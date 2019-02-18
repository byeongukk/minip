
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

import controller.BattleManager;
import controller.ItemManager;
import model.dao.ItemDao;
import model.vo.Ball;
import model.vo.Item;
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

	private JButton upButton = new JButton(new ImageIcon(("images/userMenuImages/upButtonBasic.PNG")));
	private JButton downButton = new JButton(new ImageIcon(("images/userMenuImages/downButtonBasic.PNG")));

	private JLabel itemInfoLabel = new JLabel(new ImageIcon(("images/userMenuImages/itemInfo.PNG")));
	//private JLabel itemListLabel = new JLabel(new ImageIcon(("images/userMenuImages/itemList.PNG")));

	public UserInvenPage(MainFrame mf,JPanel oldPage,User user, Map m) {
		this.mf = mf;
		this.ump = ump;
		this.uivp = this;
		this.user = user;
		this.m = m;
		this.oldPage = oldPage; // JPanel�� �޾� userMenuPage, BattlePage�� ������ ����
		ArrayList<Item> itemList= (ArrayList<Item>) user.getUi_list();

		String[] iNameList = new String[itemList.size()];
		for(int i=0 ; i<iNameList.length ; i++) {
			iNameList[i] = itemList.get(i).getiName();
		}
		String[] iAmount = new String[itemList.size()];
		for(int i=0 ; i<iNameList.length ; i++) {
			iAmount[i] = itemList.get(i).getiAmount()+"";
		}



		this.setLayout(null);
		this.setBackground(Color.WHITE);
		JLabel label = new JLabel();
		label.setText("���� ������");

		mf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == UserMenuPage.ESC) {
					mf.remove(uivp);
					uivp.setVisible(false);
				}
			}
		});

		itemInfoLabel.setBounds(500, 100, 300, 300);
		//itemListLabel.setBounds(100,30,400,650);
		JList itemNameList = new JList(iNameList);
		itemNameList.setFont(new Font(getName(),Font.BOLD,17));
		itemNameList.setBounds(50, 100, 320, 480);
		itemNameList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

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
				//������ �������� ������ ������������ �Ѿ
				String userItemName = null;
				userItemName = itemNameList.getSelectedValue()+""; //������ ������ ����
				System.out.println(userItemName==null);
				if(userItemName!=null) {
					uivp.setVisible(false);
					mf.remove(uivp);
				}
				ItemDao iList = new ItemDao();
				Item checkItem = null;
				checkItem = new ItemManager(user).itemReturn(userItemName);
				//������ ����Ʈ���� ���þ����� ã�� ����
			/*	for(int i=0; i<iList.getIList().size(); i++) {
					if(iList.getIList().get(i).getiName().equals(userItemName)) {
						checkItem = iList.getIList().get(i);
					}
				}*/
				//�����κ������� ���� ��� �� �� ����
				if(oldPage instanceof BattlePage) {
					if(checkItem instanceof Ball) {
						if(!(bm.catchP(user, oldPage, m, checkItem))) {
							System.out.println("���������");
							oldPage.setVisible(true);
						} else {
							System.out.println("�������");
							oldPage.setVisible(false);
							mf.remove(oldPage);
							m.setVisible(true);
							m.setCantmove(false);
						}
						//uivp.setVisible(false);
						
					}
				}else {
					if(checkItem instanceof Ball) {
						JOptionPane.showMessageDialog(null, "�������� ��Ʋ�߿��� ����� �� �ֽ��ϴ�", "����", JOptionPane.WARNING_MESSAGE);
						mf.add(uivp);
						uivp.setVisible(true);
					} else {
						for(int i=0; i<itemList.size(); i++) {
							//������ �����۰� �������� ���������� ��ȣ�� �޾� �޼ҵ� ����
							if(itemList.get(i).getiName().equals(userItemName)) {
								uivp.setVisible(false);
								mf.add(new PInfoPage(mf, uivp, user,userItemName)); //0217-01;
								/////������ ����� ������������ ���ƿ����� ȭ�� ������Ʈ ����
							}
						}
					}
				}
			}
		});
		this.add(useButton);

		upButton.setBounds(200, 20, 95, 95);
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
				//Ŭ���� �̺�Ʈ
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
				//Ŭ���� �̺�Ʈ
			}
		});
		this.add(downButton);

		label.setBounds(450, 20, 200, 40);
		backButton.setBounds(900, 610, 90, 120);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		backButton.setContentAreaFilled(false);
		//�ڷΰ��� ��ư
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
				//Ŭ���� �̺�Ʈ
				mf.remove(uivp);
				oldPage.setVisible(true);
				mf.requestFocus();
			}
		});
		this.add(backButton);
		this.add(itemInfoLabel);
		this.add(itemNameList);
		this.add(itemAmountList);

		this.add(label);
	}

}
