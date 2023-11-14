package ver0_0_1;

import java.util.HashMap;

import javax.swing.JFrame;

/* 리듬게임과 무역게임을 합치는 클래스 */

public class Cooperation extends Thread{
	private JFrame base = new JFrame();
	private HashMap<String, Integer> item = new HashMap<>();
	private Rhythm_main rg;
	private Trade_main tg;
	private Thread rhythmGame;
	private Thread tradeGame;
	
	Cooperation(){
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		base.setTitle("마녀의 생활고");
		base.setExtendedState(JFrame.MAXIMIZED_BOTH);
		base.setUndecorated(true);
		base.setLocationRelativeTo(null);
		base.setLayout(null);
		base.setVisible(true);
		
		while(true) startGame();
		
	}
	
	public JFrame getFrame() {
		return base;
	}
	
	public void startGame() {
		rhythmGame = new Thread(new Runnable() {
			@Override
			public void run() {
				rg = new Rhythm_main(getFrame());
			}
		});
		
		tradeGame = new Thread(new Runnable() {
			@Override
			public void run() {
				item = rg.getItem();
				rg.setItem(null);
				rg = null;
				tg = new Trade_main(getFrame(), item);
				
			}
		});
		
		try {
				rhythmGame.start();
				rhythmGame.join();
				
				tradeGame.start();
				tradeGame.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
