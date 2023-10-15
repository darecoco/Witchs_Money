package rhythmGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MoveMonster{
	/* 처음 줄 690 800
	 * 두 번째 줄 825 800
	 * 세 번째 줄 960 800
	 * 네 번째 줄 1097 800*/
	private ImageIcon monster;
	private JLabel enemy;
	private Timer timer;
	
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
        
     // 타이머를 사용하여 이미지 이동
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int move_y = enemy.getY();
                // y 좌표를 업데이트하여 이미지 이동
                move_y += 5; // y 좌표를 10 픽셀씩 이동

                // 이미지의 위치를 업데이트
                enemy.setLocation(x, move_y);

                // 화면 다시 그리기
                bg.repaint();
            }
        });

	}
	
	JLabel getRed() {
		return enemy;
	}
	
	void moveStart() {
		timer.start();
	}
}
