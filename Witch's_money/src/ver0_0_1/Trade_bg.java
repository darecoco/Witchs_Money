package ver0_0_1;

import java.awt.Graphics;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Trade_bg extends JFrame{
	ImageIcon icon;
	public Trade_bg(int width, int height) {
		String imagePath = "images/testImage.png";
		File img = new File(imagePath);
		if(img.isFile()) {
			icon = new ImageIcon(imagePath);			
		}else {
			JOptionPane.showMessageDialog(null, "이미지 로딩 오류");
			System.exit(0);
		}
       
        //배경 Panel 생성후 컨텐츠페인으로 지정      
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, width, height, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("무역겜 기본 창");
        setSize(width, height);
        setVisible(true);
        setContentPane(background);
	}
}
