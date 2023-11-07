package ver0_0_1;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Rhythm_bottomBar extends Thread{
	private double musicTime;
	private JLabel progress;
	private ImageIcon star;
	private int x, y;
	private double move_x;
	private double speed;
	private Thread progressing;
	
	Rhythm_bottomBar(JPanel bottom, double musicTime){
		setMusicTime(musicTime); setX(56); setY(966); setSpeed(musicTime);
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
						move_x = progress.getX();
						while(true) {
							if(move_x + speed > 1762) {
								move_x = 1762;
							}else {
								move_x += speed;
							}
							Thread.sleep(200);
							progress.setLocation((int)move_x, 966);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		});
		
		startProgress();
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

	public double getMusicTime() {
		return musicTime;
	}

	public void setMusicTime(double musicTime) {
		this.musicTime = musicTime;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double musicTime) {
		this.speed = 1705.0/(musicTime*5.0);
	}

}
