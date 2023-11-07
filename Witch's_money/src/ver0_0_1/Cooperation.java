package ver0_0_1;

import javax.swing.JFrame;

/* 리듬게임과 무역게임을 합치는 클래스 */

public class Cooperation extends Thread{
	private JFrame base = new JFrame();
	
	Cooperation(){
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		base.setTitle("마녀의 생활고");
		base.setExtendedState(JFrame.MAXIMIZED_BOTH);
		base.setUndecorated(true);
		base.setLocationRelativeTo(null);
		base.setLayout(null);
		base.setVisible(true);
		
		Thread rhythmGame = new Thread(new Runnable() {
			@Override
			public void run() {
				Rhythm_main rg = new Rhythm_main(getFrame());
			}
		});
		
		Thread tradeGame = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("언제 출력되는감");
				
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
	
	JFrame getFrame() {
		return base;
	}
}
