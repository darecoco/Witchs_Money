package ver0_0_1;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Rhythm_bottomBar extends Thread{
	private long musicTime;
	private JLabel progress;
	private ImageIcon star;
	private int x, y;
	private int move_x;
	private Thread progressing;
	
	Rhythm_bottomBar(JPanel bottom, long musicTime){
		setMusicTime(musicTime); setX(56); setY(966);
		String imagePath = "images/rhythm/bg/progressStar.png";
		File img = new File(imagePath);
		if(img.isFile()) {
			star = new ImageIcon(imagePath);		
		}else {
			JOptionPane.showMessageDialog(null, "이미지 로딩 오류");
			System.exit(0);
		}
		progress = new JLabel(star);
		
		progress.setBounds(x, y, 100, 100);
		bottom.add(progress);
		bottom.repaint();
		
		progressing = new Thread(new Runnable() {
			@Override
			public void run() {
					try {
						while(true) {
							move_x = progress.getX();
							move_x += 5;
							Thread.sleep(500);
							progress.setLocation(move_x, 966);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		});
	}
	
	public void startProgress() {
		progressing.start();
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public long getMusicTime() {
		return musicTime;
	}

	public void setMusicTime(long musicTime) {
		this.musicTime = musicTime;
	}

}
