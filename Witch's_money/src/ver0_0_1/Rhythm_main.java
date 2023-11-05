package ver0_0_1;

import javax.swing.JFrame;

/* 리듬게임을 합친 완성형 클래스 */

public class Rhythm_main extends Thread{
	private JFrame base;

	private Rhythm_bg main;
	private Rhythm_bottomBar bt;
	private Rhythm_selectMusic music;
	
	Rhythm_main(JFrame base) {
		setBase(base);
		setMain(new Rhythm_bg(getBase(), "main_game"));
		setBt(new Rhythm_bottomBar(main.getBG(), 73));
		bt.startProgress();
		music = new Rhythm_selectMusic(main.getBG());

		while(true) {
			if(music.isEndMusic()) {
				main.changeBG(getBase(), "result");
				break;
			}
		}
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
	
	public Rhythm_bottomBar getBt() {
		return bt;
	}
	
	public void setBt(Rhythm_bottomBar bt) {
		this.bt = bt;
	}
	
	public Rhythm_selectMusic getMusic() {
		return music;
	}
	
	public void setMusic(Rhythm_selectMusic music) {
		this.music = music;
	}
}
