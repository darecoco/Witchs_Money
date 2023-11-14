package ver0_0_1;

import java.util.HashMap;

import javax.swing.JFrame;

/* 리듬게임을 합친 완성형 클래스 */

public class Rhythm_main extends Thread{
	private JFrame base;
	private HashMap<String, Integer> item = new HashMap<>();
	private Rhythm_bg main;
	private Rhythm_selectMusic music;
	private Rhythm_result res;
	
	Rhythm_main(JFrame base) {
		setBase(base);
		setMain(new Rhythm_bg(getBase(), "main_start5"));
		main.setLobby();
		main.startGame();
		main.changeBG(base, "main_game");

		setMusic(new Rhythm_selectMusic(main.getBG()));

		while(true) {
			if(music.isEndMusic()) {
				main.changeBG(getBase(), "result");
				break;
			}
		}
		setItem(music.getItems());
		music = null;
		setRes(new Rhythm_result(main.getBG(), getItem().get("blue"), getItem().get("red")));
		
		// 스페이스바 입력을 대기
        res.getSpace();
        base = null;
        main = null;
        res = null;
	}//생성자
	
	public JFrame getBase() {
		return base;
	}
	
	public void setBase(JFrame base) {
		this.base = base;
	}
	
	public Rhythm_bg getMain() {
		return main;
	}
	
	public void setMain(Rhythm_bg main) {
		this.main = main;
	}
	public Rhythm_selectMusic getMusic() {
		return music;
	}
	
	public void setMusic(Rhythm_selectMusic music) {
		this.music = music;
	}

	public Rhythm_result getRes() {
		return res;
	}

	public void setRes(Rhythm_result res) {
		this.res = res;
	}

	public HashMap<String, Integer> getItem() {
		return item;
	}

	public void setItem(HashMap<String, Integer> item) {
		this.item = item;
	}
}
