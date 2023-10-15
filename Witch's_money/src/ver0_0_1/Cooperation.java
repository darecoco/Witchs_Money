package ver0_0_1;

import javax.swing.JFrame;

/* 리듬게임과 무역게임을 합치는 클래스 */

public class Cooperation{
	private JFrame base = new JFrame();
	
	Cooperation(){
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		base.setTitle("리듬겜 기본 창");
		base.setExtendedState(JFrame.MAXIMIZED_BOTH);
		base.setUndecorated(true);
		base.setLocationRelativeTo(null);
		base.setLayout(null);
		base.setVisible(true);
		
		new Rhythm_bg(getFrame());
	}
	
	JFrame getFrame() {
		return base;
	}
}
