package rhythmGame;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MoveMonster{
	/* 처음 줄 695 815
	 * 두 번째 줄 825 950
	 * 세 번째 줄 965 1085
	 * 네 번째 줄 1100 1225*/
	private ImageIcon monster;
	private JLabel enemy;
	
	public MoveMonster(JPanel bg) {
		String imagePath = "images/rhythm/enemy/red.png";
		File img = new File(imagePath);
		if(img.isFile()) {
			monster = new ImageIcon(imagePath);		
		}else {
			JOptionPane.showMessageDialog(null, "이미지 로딩 오류");
			System.exit(0);
		}
		enemy = new JLabel(monster);
		enemy.setLocation(300, 400);
		bg.add(enemy);
		System.out.println("살려주세요");
	}
}
