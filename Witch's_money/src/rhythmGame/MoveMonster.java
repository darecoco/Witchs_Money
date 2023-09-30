package rhythmGame;

import java.awt.Graphics;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MoveMonster extends JFrame{
	/* 처음 줄 695 815
	 * 두 번째 줄 825 950
	 * 세 번째 줄 965 1085
	 * 네 번째 줄 1100 1225*/
	ImageIcon monster;
	public MoveMonster() {
		String imagePath = "images/rhythm/enemy/red.png";
		File img = new File(imagePath);
		if(img.isFile()) {
			monster = new ImageIcon(imagePath);		
		}else {
			JOptionPane.showMessageDialog(null, "이미지 로딩 오류");
			System.exit(0);
		}
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("리듬겜 기본 창");
        setLocationRelativeTo(null);
        setContentPane(background);
        setVisible(true);
	}
}
