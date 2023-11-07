package ver0_0_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rhythm_result{
	private JPanel bg;
	private int cyan;
	private int ruddy;
	private boolean goNext;

	public Rhythm_result(JPanel bg, int cyan, int ruddy){
		setBg(bg); setCyan(cyan); setRuddy(ruddy); setGoNext(false);
		JLabel blue = new JLabel(Integer.toString(getCyan()));
		JLabel red = new JLabel(Integer.toString(getRuddy()));

		blue.setBounds(455, 656, 300, 150);
		red.setBounds(1050, 656, 300, 150);
		blue.setFont(new Font("EASTARJET Heavy", Font.PLAIN, 150));
		blue.setHorizontalAlignment(JLabel.CENTER);
		blue.setForeground(Color.cyan);
		red.setFont(new Font("EASTARJET Heavy", Font.PLAIN, 150));
		red.setHorizontalAlignment(JLabel.CENTER);
		red.setForeground(Color.red);

		getBg().add(blue);
		getBg().add(red);
	}

	public JPanel getBg() {
		return bg;
	}

	public void setBg(JPanel bg) {
		this.bg = bg;
	}

	public int getCyan() {
		return cyan;
	}

	public void setCyan(int blue) {
		this.cyan = blue;
	}

	public int getRuddy() {
		return ruddy;
	}

	public void setRuddy(int red) {
		this.ruddy = red;
	}

	public boolean isGoNext() {
		return goNext;
	}

	public void setGoNext(boolean goNext) {
		this.goNext = goNext;
	}
	
	public void getSpace() {
		getBg().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setGoNext(true);
				System.out.println(isGoNext());
				return;
			}
		});

		getBg().requestFocus();
		
		while(true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if(goNext) {
				break;
			}
		}
		
	}
}
