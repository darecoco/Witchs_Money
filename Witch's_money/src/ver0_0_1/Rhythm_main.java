package ver0_0_1;

import javax.swing.JFrame;

/* 리듬게임을 합친 완성형 클래스 */

public class Rhythm_main extends Thread{
	Rhythm_main(JFrame base) {
		Rhythm_bg main = new Rhythm_bg(base, "main_game");
		Rhythm_bottomBar bt = new Rhythm_bottomBar(main.getBG(), 1);
		
		Thread musicThread = new Thread(new Runnable() {
			@Override
	        public void run() {
				Rhythm_selectMusic music = new Rhythm_selectMusic(main.getBG());
			}
		});
		musicThread.start();
		bt.startProgress();
	}
}
