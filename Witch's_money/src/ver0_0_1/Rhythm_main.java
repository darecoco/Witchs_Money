package ver0_0_1;

import javax.swing.JFrame;

/* 리듬게임을 합친 완성형 클래스 */

public class Rhythm_main extends Thread{
	Rhythm_main(JFrame base) {
		Rhythm_bg main = new Rhythm_bg(base, "main_game");
		Rhythm_moveMonster[] enermy = new Rhythm_moveMonster[] {
				new Rhythm_moveMonster(main.getBG(), 1, 7),
				new Rhythm_moveMonster(main.getBG(), 2, 7),
				new Rhythm_moveMonster(main.getBG(), 3, 7),
				new Rhythm_moveMonster(main.getBG(), 4, 7)
		};
		for(Rhythm_moveMonster pls : enermy) {}
		Thread musicThread = new Thread(new Runnable() {
			@Override
	        public void run() {
				Rhythm_selectMusic music = new Rhythm_selectMusic();
			}
		});
		musicThread.start();
	}
}
