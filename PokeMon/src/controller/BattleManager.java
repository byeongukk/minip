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
	private Pokemon poke;     //랜덤 포켓몬
	private Pokemon mypoke;   //내 포켓몬
	private int num;
	private int damage;
	private BattleSkillPage bsp;



	//현재 포켓몬 보여주는 부분
	public void showP(PInfoPage pip, User user) {
		JTextArea[] jta = new JTextArea[4];
		JLabel[] jl = new JLabel[4];

		this.pip = pip;
		ArrayList<Pokemon> up_list = (ArrayList<Pokemon>) user.getUp_list(); //0217-02
		//0217-02 기본으로 포켓몬 이미지 4개 생성
		for(int i=0; i<4; i++) {

			jl[i] = new JLabel();
			jta[i] = new JTextArea();
			jta[i].setText("\t포켓몬 이름 : "+ " " + "\n"
					+"\t레    벨 : " + " " + "\n"
					+"\t등    급 : " + " " + "\n"
					+"\t스 피 드 : " + " " + "\n"
					+"\t최대체력 : " + " " + "\n"
					+"\t체    력  : " +" " + "\n"
					+"\t최대경험치 : " + " " + "\n"
					+"\t현재경험치 : " + " " + "\n");

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

			//이미지 클릭시 포켓몬 이름을 저장하도록 함
			jl[i].setName(up_list.get(i).getpName());
			jta[i].setText("\t포켓몬 이름 : "+ up_list.get(i).getpName() + "\n"
					+"\t레    벨 : " + up_list.get(i).getpLevel() + "\n"
					+"\t등    급 : " + up_list.get(i).getGrade() + "\n"
					+"\t스 피 드 : " + up_list.get(i).getpSpeed() + "\n"
					+"\t최대체력 : " + up_list.get(i).getpMaxHp() + "\n"
					+"\t체    력  : " +up_list.get(i).getpHp() + "\n"
					+"\t최대경험치 : " + up_list.get(i).getpMaxExp()+ "\n"
					+"\t현재경험치 : " + up_list.get(i).getExp() + "\n");
			jta[i].setEditable(false);
		}

		//0217-02
		/*for(int i=0; i<4; i++) {

    	  if(user.getUp_list().get(i) == null) {
    		  jl[i] = new JLabel();
        	  jta[i] = new JTextArea();
    		  jta[i].setText("\t포켓몬 이름 : "+ " " + "\n"
   	               +"\t레    벨 : " + " " + "\n"
   	               +"\t등    급 : " + " " + "\n"
   	               +"\t스 피 드 : " + " " + "\n"
   	               +"\t체    력  : " +" " + "\n");
   	         jta[i].setEditable(false);
    		  jl[i].setIcon(new ImageIcon("images/userMenuImages/pInfo4.png"));
    	  }else {
    		  jl[i] = new JLabel();
        	  jta[i] = new JTextArea();

    	         num = user.getUp_list().get(i).getpNo();
    	         jl[i].setIcon(new ImageIcon("images/userMenuImages/pBook/"+num+".png"));


    	         jta[i].setText("\t포켓몬 이름 : "+ user.getUp_list().get(i).getpName() + "\n"
    	               +"\t레    벨 : " + user.getUp_list().get(i).getpLevel() + "\n"
    	               +"\t등    급 : " + user.getUp_list().get(i).getGrade() + "\n"
    	               +"\t스 피 드 : " + user.getUp_list().get(i).getpSpeed() + "\n"
    	               +"\t체    력  : " +user.getUp_list().get(i).getpHp() + "\n");
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


	//포켓몬 생성 기능
	//0217-02
	//0217-03
	public void randomP(User user) {
		//System.out.println(user.getuName());

		int randomIndex = new Random().nextInt(10);
		int randomLevel = new Random().nextInt(10)+1;
		//0217-02 user.getEp_list().set(0, pd.getpList().get(randomIndex));
		//적 포켓몬리스트 초기화
		user.getEp_list().clear();
		//새로운 적 포켓몬 생성
		user.getEp_list().add(pd.getpList().get(randomIndex)); //0217-02

		//포켓몬 속성 정의
		user.getEp_list().get(0).setpLevel(randomLevel);
		user.getEp_list().get(0).setExp(randomLevel);
		user.getEp_list().get(0).setpHp(randomLevel);
		user.getEp_list().get(0).setpSpeed(randomLevel);
		user.getEp_list().get(0).setExp(randomLevel);



		//포켓몬 스킬 정의
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
		System.out.println("배틀");
		System.out.println("적 HP : " + user.getEp_list().get(0).getpHp());
		System.out.println("내 HP : " + user.getUp_list().get(0).getpHp());


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


	//내 포켓몬이 공격
	public void atkMP(User user, int damage) {
		System.out.println(damage);
		System.out.println(user.getUp_list().get(0).getpName());
		int ep_hp = user.getEp_list().get(0).getpHp();
		System.out.println("메소드호출");


		//내 포켓몬이 일반속성
		if(user.getUp_list().get(0).getpType() == 0 || (user.getUp_list().get(0).getpType() == user.getEp_list().get(0).getpType())) {
			user.getEp_list().get(0).setpHp(ep_hp - damage);
			System.out.println("적hp : " + user.getEp_list().get(0).getpHp());
		} 
		//내 포켓몬이 불속성
		else if(user.getUp_list().get(0).getpType() == 1) {
			//상대가 노말
			if(user.getEp_list().get(0).getpType() == 0) {
				user.getEp_list().get(0).setpHp(ep_hp - damage);
				System.out.println("적hp : " + user.getEp_list().get(0).getpHp());
			}
			//상대가 물일 때
			if(user.getEp_list().get(0).getpType() == 2) {
				user.getEp_list().get(0).setpHp(ep_hp - (damage)/2);
				System.out.println("적hp : " + user.getEp_list().get(0).getpHp());
			}
			//상대가 풀일 때
			if(user.getEp_list().get(0).getpType() == 3) {
				user.getEp_list().get(0).setpHp(ep_hp - (damage)*2);
				System.out.println("적hp : " + user.getEp_list().get(0).getpHp());
			}
		}
		//내 포켓몬이 물속성
		else if(user.getUp_list().get(0).getpType() == 2) {
			//상대가 노말
			if(user.getEp_list().get(0).getpType() == 0) {
				user.getEp_list().get(0).setpHp(ep_hp - damage);
				System.out.println("적hp : " + user.getEp_list().get(0).getpHp());
			}
			//상대가 불일 때
			if(user.getEp_list().get(0).getpType() == 1) {
				user.getEp_list().get(0).setpHp(ep_hp- (damage)*2);
				System.out.println("적hp : " + user.getEp_list().get(0).getpHp());
			}
			//상대가 풀일 때
			if(user.getEp_list().get(0).getpType() == 3) {
				user.getEp_list().get(0).setpHp(ep_hp- (damage)/2);
				System.out.println("적hp : " + user.getEp_list().get(0).getpHp());
			}
		}
		//내 포켓몬이 풀속성
		else if(user.getUp_list().get(0).getpType() == 3) {
			//상대가 노말
			if(user.getEp_list().get(0).getpType() == 0) {
				user.getEp_list().get(0).setpHp(ep_hp - damage);
				System.out.println("적hp : " + user.getEp_list().get(0).getpHp());
			}
			//상대가 불일 때
			if(user.getEp_list().get(0).getpType() == 1) {
				user.getEp_list().get(0).setpHp(ep_hp - (damage)/2);
				System.out.println("적hp : " + user.getEp_list().get(0).getpHp());
			}
			//상대가 풀일 때
			if(user.getEp_list().get(0).getpType() == 3) {
				user.getEp_list().get(0).setpHp(ep_hp - (damage)*2);
				System.out.println("적hp : " + user.getEp_list().get(0).getpHp());
			}
		}      


	}

	//상대 포켓몬이 공격
	public void atkEP(User user) {

		int random = new Random().nextInt(4);
		int up_hp = user.getUp_list().get(0).getpHp();
		int damage = user.getEp_list().get(0).getpSkill().get(random).getsAtt()+ user.getEp_list().get(0).getpLevel()*3;


		//랜덤 포켓몬이 노말
		if(user.getEp_list().get(0).getpType() == 0 || (user.getEp_list().get(0).getpType() == user.getUp_list().get(0).getpType())) {
			user.getUp_list().get(0).setpHp(up_hp - damage);
			System.out.println("내hp : " + user.getUp_list().get(0).getpHp());
		}

		//랜덤 포켓몬이 불속성
		else if(user.getEp_list().get(0).getpType() == 1) {
			//내가 노말
			if(user.getUp_list().get(0).getpType() == 0) {
				user.getUp_list().get(0).setpHp(up_hp - damage);
				System.out.println("내hp : " + user.getUp_list().get(0).getpHp());
			}
			//내가 물일 때
			if(user.getUp_list().get(0).getpType() == 2) {
				user.getUp_list().get(0).setpHp(up_hp - (damage)/2);
				System.out.println("내hp : " + user.getUp_list().get(0).getpHp());
			}
			//내가 풀일 때
			if(user.getUp_list().get(0).getpType() == 3) {
				user.getUp_list().get(0).setpHp(up_hp - (damage)*2);
				System.out.println("내hp : " + user.getUp_list().get(0).getpHp());
			}
		}
		//랜덤 포켓몬이 물속성
		else if(user.getEp_list().get(0).getpType() == 2) {
			//내가 노말
			if(user.getUp_list().get(0).getpType() == 0) {
				user.getUp_list().get(0).setpHp(up_hp - damage);
				System.out.println("내hp : " + user.getUp_list().get(0).getpHp());
			}
			//내가 불일 때
			if(user.getUp_list().get(0).getpType() == 1) {
				user.getUp_list().get(0).setpHp(up_hp- (damage)*2);
				System.out.println("내hp : " + user.getUp_list().get(0).getpHp());
			}
			//내가 풀일 때
			if(user.getUp_list().get(0).getpType() == 3) {
				user.getUp_list().get(0).setpHp(up_hp- (damage)/2);
				System.out.println("내hp : " + user.getUp_list().get(0).getpHp());
			}
		}
		//랜덤 포켓몬이 풀속성
		else if(user.getEp_list().get(0).getpType() == 3) {
			//내가 노말
			if(user.getUp_list().get(0).getpType() == 0) {
				user.getUp_list().get(0).setpHp(up_hp - damage);
				System.out.println("내hp : " + user.getUp_list().get(0).getpHp());
			}
			//내가 불일 때
			if(user.getUp_list().get(0).getpType() == 1) {
				user.getUp_list().get(0).setpHp(up_hp - (damage)/2);
				System.out.println("내hp : " + user.getUp_list().get(0).getpHp());
			}
			//내가 풀일 때
			if(user.getUp_list().get(0).getpType() == 3) {
				user.getUp_list().get(0).setpHp(up_hp - (damage)*2);
				System.out.println("내hp : " + user.getUp_list().get(0).getpHp());
			}
		}          
	}









	//포켓몬 캐치 기능
	public void catchP(User user) {

		for(int i=0; i<user.getUi_list().size(); i++) {
			if(user.getUi_list().get(i).getiType() == 0) {

			}
		}
	}

	public void selectS() {

	}



}