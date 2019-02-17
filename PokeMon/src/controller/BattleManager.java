package controller;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import model.dao.PokemonDao;
import model.dao.SkillDao;
import model.vo.Pokemon;
import model.vo.User;
import view.BattlePage;
import view.BattleSkillPage;
import view.PInfoPage;

public class BattleManager {

	//0217-02 
	//0217-03
	private PInfoPage pip;
	private BattlePage bp;
	private PokemonDao pd = new PokemonDao();
	private SkillDao sd = new SkillDao();
	private Pokemon poke;     //���� ���ϸ�
	private Pokemon mypoke;   //�� ���ϸ�
	private int num;
	private int damage;
	private BattleSkillPage bsp;



	//���� ���ϸ� �����ִ� �κ�
	public void showP(PInfoPage pip, User user) {
		JTextArea[] jta = new JTextArea[4];
		JLabel[] jl = new JLabel[4];

		this.pip = pip;
		ArrayList<Pokemon> up_list = (ArrayList<Pokemon>) user.getUp_list(); //0217-02
		//0217-02 �⺻���� ���ϸ� �̹��� 4�� ����
		for(int i=0; i<4; i++) {

			jl[i] = new JLabel();
			jta[i] = new JTextArea();
			jta[i].setText("\t���ϸ� �̸� : "+ " " + "\n"
					+"\t��    �� : " + " " + "\n"
					+"\t��    �� : " + " " + "\n"
					+"\t�� �� �� : " + " " + "\n"
					+"\t�ִ�ü�� : " + " " + "\n"
					+"\tü    ��  : " +" " + "\n"
					+"\t�ִ����ġ : " + " " + "\n"
					+"\t�������ġ : " + " " + "\n");

			jta[i].setEditable(false);
			jl[i].setIcon(new ImageIcon("images/userMenuImages/pInfo4.png"));

		}

		Pokemon searchPoke = null;
		for(int i=0; i<up_list.size(); i++) {
			searchPoke = up_list.get(i);
			jl[i] = new JLabel();
			jta[i] = new JTextArea();
			int pNum = searchPoke.getpNo();
			jl[i].setIcon(new ImageIcon("images/userMenuImages/pBook/"+pNum+".png"));

			//�̹��� Ŭ���� ���ϸ� �̸��� �����ϵ��� ��
			jl[i].setName(up_list.get(i).getpName());
			jta[i].setText("\t���ϸ� �̸� : "+ up_list.get(i).getpName() + "\n"
					+"\t��    �� : " + up_list.get(i).getpLevel() + "\n"
					+"\t��    �� : " + up_list.get(i).getGrade() + "\n"
					+"\t�� �� �� : " + up_list.get(i).getpSpeed() + "\n"
					+"\t�ִ�ü�� : " + up_list.get(i).getpMaxHp() + "\n"
					+"\tü    ��  : " +up_list.get(i).getpHp() + "\n"
					+"\t�ִ����ġ : " + up_list.get(i).getpMaxExp()+ "\n"
					+"\t�������ġ : " + up_list.get(i).getExp() + "\n");
			jta[i].setEditable(false);
		}

		//0217-02
		/*for(int i=0; i<4; i++) {

    	  if(user.getUp_list().get(i) == null) {
    		  jl[i] = new JLabel();
        	  jta[i] = new JTextArea();
    		  jta[i].setText("\t���ϸ� �̸� : "+ " " + "\n"
   	               +"\t��    �� : " + " " + "\n"
   	               +"\t��    �� : " + " " + "\n"
   	               +"\t�� �� �� : " + " " + "\n"
   	               +"\tü    ��  : " +" " + "\n");
   	         jta[i].setEditable(false);
    		  jl[i].setIcon(new ImageIcon("images/userMenuImages/pInfo4.png"));
    	  }else {
    		  jl[i] = new JLabel();
        	  jta[i] = new JTextArea();

    	         num = user.getUp_list().get(i).getpNo();
    	         jl[i].setIcon(new ImageIcon("images/userMenuImages/pBook/"+num+".png"));


    	         jta[i].setText("\t���ϸ� �̸� : "+ user.getUp_list().get(i).getpName() + "\n"
    	               +"\t��    �� : " + user.getUp_list().get(i).getpLevel() + "\n"
    	               +"\t��    �� : " + user.getUp_list().get(i).getGrade() + "\n"
    	               +"\t�� �� �� : " + user.getUp_list().get(i).getpSpeed() + "\n"
    	               +"\tü    ��  : " +user.getUp_list().get(i).getpHp() + "\n");
    	         jta[i].setEditable(false);
    	  }

      }*/

		pip.setpInfoText(jta);
		pip.setpInfo(jl);

	}
	public void showB(BattlePage bp) {
		this.bp = bp;

	}


	public void showS(BattleSkillPage bsp, User user) {
		this.bsp = bsp;
		/*//0217-03
		user.getUp_list().get(0).getpSkill().add(sd.getsList().get(0));
		user.getUp_list().get(0).getpSkill().add(sd.getsList().get(1));
		user.getUp_list().get(0).getpSkill().add(sd.getsList().get(2));
		user.getUp_list().get(0).getpSkill().add(sd.getsList().get(3));*/

		for(int i=0; i<user.getUp_list().get(0).getpSkill().size(); i++) {
			if(i == 0) {
				bsp.getSkill1b().setText(user.getUp_list().get(0).getpSkill().get(0).getsName());
			}
			if(i == 1 ) {
				bsp.getSkill2b().setText(user.getUp_list().get(0).getpSkill().get(1).getsName());
			}
			if(i == 2) {
				bsp.getSkill3b().setText(user.getUp_list().get(0).getpSkill().get(2).getsName());
			}
			if(i == 3) {
				bsp.getSkill4b().setText(user.getUp_list().get(0).getpSkill().get(3).getsName());
			}
		}
		/*		bsp.getSkill1b().setText(user.getUp_list().get(0).getpSkill().get(0).getsName());
		bsp.getSkill2b().setText(user.getUp_list().get(0).getpSkill().get(1).getsName());
		bsp.getSkill3b().setText(user.getUp_list().get(0).getpSkill().get(2).getsName());
		bsp.getSkill4b().setText(user.getUp_list().get(0).getpSkill().get(3).getsName());*/

	}


	//���ϸ� ���� ���
	//0217-02
	//0217-03
	public void randomP(User user) {
		//System.out.println(user.getuName());

		int randomIndex = new Random().nextInt(10);
		int randomLevel = new Random().nextInt(10)+1;
		//0217-02 user.getEp_list().set(0, pd.getpList().get(randomIndex));
		//�� ���ϸ󸮽�Ʈ �ʱ�ȭ
		user.getEp_list().clear();
		//���ο� �� ���ϸ� ����
		user.getEp_list().add(pd.getpList().get(randomIndex)); //0217-02

		//���ϸ� �Ӽ� ����
		user.getEp_list().get(0).setpLevel(randomLevel);
		user.getEp_list().get(0).setExp(randomLevel);
		user.getEp_list().get(0).setpHp(randomLevel);
		user.getEp_list().get(0).setpSpeed(randomLevel);
		user.getEp_list().get(0).setExp(randomLevel);



		//���ϸ� ��ų ����
		for(int i=0; i<4; i++) {
			int random = new Random().nextInt(18);
			int ctn = new Random().nextInt(2);
			if(  user.getEp_list().get(0).getpType() == 0 && sd.getsList().get(random).getsType()==0) {
				user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
			}
			if( user.getEp_list().get(0).getpType() == 1 && (sd.getsList().get(random).getsType()==0 || sd.getsList().get(random).getsType()==1)) {
				if(ctn == 0) {
					user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
				}else {
					user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
				}
			}
			if( user.getEp_list().get(0).getpType() == 2 && (sd.getsList().get(random).getsType()==0 || sd.getsList().get(random).getsType()==2)) {
				if(ctn == 0) {
					user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
				}else {
					user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
				}
			}
			if( user.getEp_list().get(0).getpType() == 3 && (sd.getsList().get(random).getsType()==0 || sd.getsList().get(random).getsType()==3)) {
				if(ctn == 0) {
					user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
				}else {
					user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
				}
			}
		}
		System.out.println(user.getEp_list().get(0).getpName());
	}

	public void battle(User user, String selK) {
		System.out.println("��Ʋ");
		System.out.println("�� HP : " + user.getEp_list().get(0).getpHp());
		System.out.println("�� HP : " + user.getUp_list().get(0).getpHp());


		for(int i=0; i<sd.getsList().size(); i++) {
			if( sd.getsList().get(i).getsName().equals(selK)) {
				damage = sd.getsList().get(i).getsAtt() + user.getUp_list().get(0).getpLevel()*3;
			}
		}

		if(user.getUp_list().get(0).getpSpeed()>user.getEp_list().get(0).getpSpeed()) {
			atkMP(user,damage);
			atkEP(user);
		}else {
			atkEP(user);
			atkMP(user,damage);
		}



	}


	//�� ���ϸ��� ����
	public void atkMP(User user, int damage) {
		System.out.println(damage);
		System.out.println(user.getUp_list().get(0).getpName());
		int ep_hp = user.getEp_list().get(0).getpHp();
		System.out.println("�޼ҵ�ȣ��");


		//�� ���ϸ��� �ϹݼӼ�
		if(user.getUp_list().get(0).getpType() == 0 || (user.getUp_list().get(0).getpType() == user.getEp_list().get(0).getpType())) {
			user.getEp_list().get(0).setpHp(ep_hp - damage);
			System.out.println("��hp : " + user.getEp_list().get(0).getpHp());
		} 
		//�� ���ϸ��� �ҼӼ�
		else if(user.getUp_list().get(0).getpType() == 1) {
			//��밡 �븻
			if(user.getEp_list().get(0).getpType() == 0) {
				user.getEp_list().get(0).setpHp(ep_hp - damage);
				System.out.println("��hp : " + user.getEp_list().get(0).getpHp());
			}
			//��밡 ���� ��
			if(user.getEp_list().get(0).getpType() == 2) {
				user.getEp_list().get(0).setpHp(ep_hp - (damage)/2);
				System.out.println("��hp : " + user.getEp_list().get(0).getpHp());
			}
			//��밡 Ǯ�� ��
			if(user.getEp_list().get(0).getpType() == 3) {
				user.getEp_list().get(0).setpHp(ep_hp - (damage)*2);
				System.out.println("��hp : " + user.getEp_list().get(0).getpHp());
			}
		}
		//�� ���ϸ��� ���Ӽ�
		else if(user.getUp_list().get(0).getpType() == 2) {
			//��밡 �븻
			if(user.getEp_list().get(0).getpType() == 0) {
				user.getEp_list().get(0).setpHp(ep_hp - damage);
				System.out.println("��hp : " + user.getEp_list().get(0).getpHp());
			}
			//��밡 ���� ��
			if(user.getEp_list().get(0).getpType() == 1) {
				user.getEp_list().get(0).setpHp(ep_hp- (damage)*2);
				System.out.println("��hp : " + user.getEp_list().get(0).getpHp());
			}
			//��밡 Ǯ�� ��
			if(user.getEp_list().get(0).getpType() == 3) {
				user.getEp_list().get(0).setpHp(ep_hp- (damage)/2);
				System.out.println("��hp : " + user.getEp_list().get(0).getpHp());
			}
		}
		//�� ���ϸ��� Ǯ�Ӽ�
		else if(user.getUp_list().get(0).getpType() == 3) {
			//��밡 �븻
			if(user.getEp_list().get(0).getpType() == 0) {
				user.getEp_list().get(0).setpHp(ep_hp - damage);
				System.out.println("��hp : " + user.getEp_list().get(0).getpHp());
			}
			//��밡 ���� ��
			if(user.getEp_list().get(0).getpType() == 1) {
				user.getEp_list().get(0).setpHp(ep_hp - (damage)/2);
				System.out.println("��hp : " + user.getEp_list().get(0).getpHp());
			}
			//��밡 Ǯ�� ��
			if(user.getEp_list().get(0).getpType() == 3) {
				user.getEp_list().get(0).setpHp(ep_hp - (damage)*2);
				System.out.println("��hp : " + user.getEp_list().get(0).getpHp());
			}
		}      


	}

	//��� ���ϸ��� ����
	public void atkEP(User user) {

		int random = new Random().nextInt(4);
		int up_hp = user.getUp_list().get(0).getpHp();
		int damage = user.getEp_list().get(0).getpSkill().get(random).getsAtt()+ user.getEp_list().get(0).getpLevel()*3;


		//���� ���ϸ��� �븻
		if(user.getEp_list().get(0).getpType() == 0 || (user.getEp_list().get(0).getpType() == user.getUp_list().get(0).getpType())) {
			user.getUp_list().get(0).setpHp(up_hp - damage);
			System.out.println("��hp : " + user.getUp_list().get(0).getpHp());
		}

		//���� ���ϸ��� �ҼӼ�
		else if(user.getEp_list().get(0).getpType() == 1) {
			//���� �븻
			if(user.getUp_list().get(0).getpType() == 0) {
				user.getUp_list().get(0).setpHp(up_hp - damage);
				System.out.println("��hp : " + user.getUp_list().get(0).getpHp());
			}
			//���� ���� ��
			if(user.getUp_list().get(0).getpType() == 2) {
				user.getUp_list().get(0).setpHp(up_hp - (damage)/2);
				System.out.println("��hp : " + user.getUp_list().get(0).getpHp());
			}
			//���� Ǯ�� ��
			if(user.getUp_list().get(0).getpType() == 3) {
				user.getUp_list().get(0).setpHp(up_hp - (damage)*2);
				System.out.println("��hp : " + user.getUp_list().get(0).getpHp());
			}
		}
		//���� ���ϸ��� ���Ӽ�
		else if(user.getEp_list().get(0).getpType() == 2) {
			//���� �븻
			if(user.getUp_list().get(0).getpType() == 0) {
				user.getUp_list().get(0).setpHp(up_hp - damage);
				System.out.println("��hp : " + user.getUp_list().get(0).getpHp());
			}
			//���� ���� ��
			if(user.getUp_list().get(0).getpType() == 1) {
				user.getUp_list().get(0).setpHp(up_hp- (damage)*2);
				System.out.println("��hp : " + user.getUp_list().get(0).getpHp());
			}
			//���� Ǯ�� ��
			if(user.getUp_list().get(0).getpType() == 3) {
				user.getUp_list().get(0).setpHp(up_hp- (damage)/2);
				System.out.println("��hp : " + user.getUp_list().get(0).getpHp());
			}
		}
		//���� ���ϸ��� Ǯ�Ӽ�
		else if(user.getEp_list().get(0).getpType() == 3) {
			//���� �븻
			if(user.getUp_list().get(0).getpType() == 0) {
				user.getUp_list().get(0).setpHp(up_hp - damage);
				System.out.println("��hp : " + user.getUp_list().get(0).getpHp());
			}
			//���� ���� ��
			if(user.getUp_list().get(0).getpType() == 1) {
				user.getUp_list().get(0).setpHp(up_hp - (damage)/2);
				System.out.println("��hp : " + user.getUp_list().get(0).getpHp());
			}
			//���� Ǯ�� ��
			if(user.getUp_list().get(0).getpType() == 3) {
				user.getUp_list().get(0).setpHp(up_hp - (damage)*2);
				System.out.println("��hp : " + user.getUp_list().get(0).getpHp());
			}
		}          
	}









	//���ϸ� ĳġ ���
	public void catchP(User user) {

		for(int i=0; i<user.getUi_list().size(); i++) {
			if(user.getUi_list().get(i).getiType() == 0) {

			}
		}
	}

	public void selectS() {

	}



}