package rhythmGame;

import java.awt.Graphics;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Background extends JFrame{
	ImageIcon icon, icon2;
	public Background() {
		String imagePath = "images/rhythm/bg/main_game.png";
		String imagePath2 = "images/rhythm/enemy/red.png";
		File img = new File(imagePath);
		if(img.isFile()) {
			icon = new ImageIcon(imagePath);	
			icon2 = new ImageIcon(imagePath2);
		}else {
			JOptionPane.showMessageDialog(null, "이미지 로딩 오류");
			System.exit(0);
		}
       
        //배경 Panel 생성후 컨텐츠페인으로 지정      
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, this);
                g.drawImage(icon2.getImage(), 695, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("리듬겜 기본 창");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setContentPane(background);
        setVisible(true);
	}
}
