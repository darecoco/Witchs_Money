package rhythmGame;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MoveMonster{
	/* 처음 줄 690 800
	 * 두 번째 줄 825 800
	 * 세 번째 줄 960 800
	 * 네 번째 줄 1097 800*/
	private ImageIcon monster;
	private JLabel enemy;
	
	public MoveMonster(JPanel bg, int x, int y) {
		String imagePath = "images/rhythm/enemy/red.png";
		File img = new File(imagePath);
		if(img.isFile()) {
			monster = new ImageIcon(imagePath);		
		}else {
			JOptionPane.showMessageDialog(null, "이미지 로딩 오류");
			System.exit(0);
		}
		enemy = new JLabel(monster);
		
		// enemy 절대 위치
        enemy.setBounds(x, y, monster.getIconWidth(), monster.getIconHeight());
        bg.add(enemy);
        bg.repaint();
	}
	
	JLabel getRed() {
		return enemy;
	}
}
