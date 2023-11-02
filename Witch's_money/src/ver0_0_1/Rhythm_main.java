package ver0_0_1;

import javax.swing.JFrame;

/* 리듬게임을 합친 완성형 클래스 */

public class Rhythm_main extends Thread{
	Rhythm_main(JFrame base) {
		Rhythm_bg main = new Rhythm_bg(base, "main_game");
		int plss[] = new int[] {0,1,1,1,1,1,1,1};
//		Rhythm_moveMonster[] enermy = new Rhythm_moveMonster[] {
//				new Rhythm_moveMonster(main.getBG(), 1),
//				new Rhythm_moveMonster(main.getBG(), 2),
//				new Rhythm_moveMonster(main.getBG(), 3),
//				new Rhythm_moveMonster(main.getBG(), 4)
//		};
		
		Thread test = new Thread(new Runnable() {
			@Override
			public void run() {
				int len = plss.length;
				for(int i = 0; i < len; i++) {
					try {
						Thread.sleep(500);
						if(plss[i] == 1) {
							new Rhythm_moveMonster(main.getBG(), 1);
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
//		for(Rhythm_moveMonster pls : enermy) {}//생성자만 실행
		
		Thread musicThread = new Thread(new Runnable() {
			@Override
	        public void run() {
				Rhythm_selectMusic music = new Rhythm_selectMusic(main.getBG());
			}
		});
		musicThread.start();
		test.start();
	}
}
