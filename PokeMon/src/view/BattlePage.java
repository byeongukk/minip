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

   //��ư �̹��� �ø���
   private Image fightButtonImage = new ImageIcon("images/�ο�ٹ�ư.png").getImage();
   private Image changeButtonImage = new ImageIcon("images/���ϸ��ư.png").getImage();
   private Image invenButtonImage = new ImageIcon("images/�����ư.png").getImage();
   private Image runButtonImage = new ImageIcon("images/�������ٹ�ư.png").getImage();
   private JButton mes = new JButton("����ĥ �� ����.  �ο���.");
   private Dialog blockrun = new Dialog(mf);



   //������ ���ư
   private Image backButtonImage = new ImageIcon("images/back.png").getImage();
   private JButton backButton = new JButton(new ImageIcon(backButtonImage));

   //�̹��� ��ưȭ
   private JButton fightButton = new JButton(new ImageIcon(fightButtonImage));
   private JButton changeButton = new JButton(new ImageIcon(changeButtonImage));
   private JButton invenButton = new JButton(new ImageIcon(invenButtonImage));
   private JButton runButton = new JButton(new ImageIcon(runButtonImage));

   //Graphics
   //���� ��� �̹���
   Image background = Toolkit.getDefaultToolkit().getImage("images/background1.PNG");
   //�� ���ϸ� �̹���
   Image mypokemon = Toolkit.getDefaultToolkit().getImage("images/pikachu.PNG");
   //�� ���ϸ� �̹���
   Image enpokemon =  Toolkit.getDefaultToolkit().getImage("images/kkobugi.PNG");


   public BattlePage(MainFrame mf, JPanel panel, User user) {
	  this.bp = this;
      this.mf = mf;
      this.m = (Map)panel;
      //0217-01 this.pip = new PInfoPage(mf,this,user);
      //0217-01 this.bsp = new BattleSkillPage(mf, this,user);
      this.user = user;
      
      //��ư�� ����� ��ġ�ϱ� ����
      bp.setLayout(null);
      //this.pip = new PInfoPage(mf, this);


      fightButton.setBounds(180, 500, 300, 80);
      this.add(fightButton);
      settingButton(fightButton);
      fightButton.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
        	 //0217-03 �ο�� ��ư Ŭ���� ��Ʋ��ų������ ������ �ѱ�
        	BattleSkillPage bsp = new BattleSkillPage(mf, bp,user);
        	bm.showS(bsp,user);
            bp.setVisible(false);
          //0217-01  bsp.setVisible(true);
          //0217-01  mf.add(bsp);
            mf.add(bsp); //0217-01
            
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
            mf.add(new UserInvenPage(mf, bp, user)); //0217-01
            
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

         //���̾�α� �޼��� Ŭ���� �̺�Ʈ
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
      //������ �̺�Ʈ
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


   //�� ��� ���, ���ϸ� �ҷ����� �׷��Ƚ�
   public void paintComponent(Graphics g) {
      g.drawImage(background, 0, 0, 1024, 768, this);
      g.drawImage(mypokemon, 210, 150, 250, 250, this);
      g.drawImage(enpokemon, 570, 150, 250, 250, this);
   }


   public void settingButton(JButton jb) {
      jb.setBorderPainted(false);
      jb.setFocusPainted(false);
      jb.setContentAreaFilled(false);
   }
	public void viewMyPoke() {
		int mNum = user.getUp_list().get(0).getpNo();
		System.out.println("�����ϸ� �̹��� ����");
		myPIcon = new ImageIcon(("images/userMenuImages/pBook/"+mNum+".png"));
		myPLabel = new JLabel(myPIcon);
		myPLabel.setBounds(190, 150, 300, 300);
		myHP.setBounds(190, 500, 300, 80);
		this.add(myPLabel);
		this.add(myHP);
	}
	public void viewEPoke() {
		int eNum = user.getEp_list().get(0).getpNo();
		System.out.println("�����ϸ� �̹��� ����");
		enPIcon = new ImageIcon(("images/userMenuImages/pBook/"+eNum+".png"));
		enPLabel = new JLabel(enPIcon);
		enPLabel.setBounds(550, 150, 300, 300);
		enHP.setBounds(550, 500, 300, 80);
		this.add(enPLabel);
		this.add(enHP);

	}

}
