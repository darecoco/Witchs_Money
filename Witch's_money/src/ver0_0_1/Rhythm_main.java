package ver0_0_1;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/* 리듬게임을 합친 완성형 클래스 */

public class Rhythm_main extends Thread{
	Rhythm_main(JFrame base) {
		Rhythm_bg main = new Rhythm_bg(base, "main_game");
		Rhythm_moveMonster enemy = new Rhythm_moveMonster(main.getBG(), 690, -100);
		Rhythm_moveMonster enemy2 = new Rhythm_moveMonster(main.getBG(), 825, -50);
		Rhythm_moveMonster enemy3 = new Rhythm_moveMonster(main.getBG(), 960, -10);
		Rhythm_moveMonster enemy4 = new Rhythm_moveMonster(main.getBG(), 1097, 0);
		Thread musicThread = new Thread(new Runnable() {
			@Override
	        public void run() {
				Rhythm_selectMusic music = new Rhythm_selectMusic();
			}
		});
//		music.musicStart();
		musicThread.start();
		enemy.moveStart();
//		enemy2.moveStart();
//		enemy3.moveStart();
//		enemy4.moveStart();
	}
}
