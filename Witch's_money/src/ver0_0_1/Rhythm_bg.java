package ver0_0_1;

import java.awt.Graphics;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Rhythm_bg{
	private ImageIcon icon;
	private JPanel background;
	
	public Rhythm_bg(JFrame base, String room) {
		String imagePath = "images/rhythm/bg/" + room + ".png";
		File img = new File(imagePath);
		if(img.isFile()) {
			icon = new ImageIcon(imagePath);
		}else {
			JOptionPane.showMessageDialog(null, "이미지 로딩 오류");
			System.exit(0);
		}
       
        //배경 Panel 생성후 컨텐츠페인으로 지정      
        background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        
        base.setTitle("리듬겜 기본 창");
        base.setContentPane(background);
        base.setVisible(true);
        
        Rhythm_moveMonster enemy = new Rhythm_moveMonster(getBG(), 690, -100);
		Rhythm_moveMonster enemy2 = new Rhythm_moveMonster(getBG(), 825, -50);
		Rhythm_moveMonster enemy3 = new Rhythm_moveMonster(getBG(), 960, -10);
		Rhythm_moveMonster enemy4 = new Rhythm_moveMonster(getBG(), 1097, 0);
		enemy.moveStart();
	}
	
	JPanel getBG() { //JPanel background
		return background;
	}
}
