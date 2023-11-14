package ver0_0_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Rhythm_bg{
	private Image screenBG;
	private JPanel background;
	private int gameStart = 0;
	JButton ready;
	JButton exit;
	JLabel day;
	
	public Rhythm_bg(JFrame base, String room) {
		String imagePath = "images/rhythm/bg/" + room + ".png";
		File img = new File(imagePath);
		if(img.isFile()) {
			screenBG = new ImageIcon(imagePath).getImage();
		}else {
			JOptionPane.showMessageDialog(null, "이미지 로딩 오류");
			System.exit(0);
		}
		
		//배경 Panel 생성후 컨텐츠페인으로 지정      
        background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(screenBG, 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        
        base.setTitle("리듬겜 기본 창");
        base.setContentPane(background);
        base.setVisible(true);
	}
	
	JPanel getBG() { //JPanel background
		return background;
	}
	
	void changeBG(JFrame base, String room) {
		base.remove(background);
		background = null;
		String imagePath = "images/rhythm/bg/" + room + ".png";
		File img = new File(imagePath);
		if(img.isFile()) {
			screenBG = new ImageIcon(imagePath).getImage();
		}else {
			JOptionPane.showMessageDialog(null, "이미지 로딩 오류");
			System.exit(0);
		}
		
		//배경 Panel 생성후 컨텐츠페인으로 지정      
        background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(screenBG, 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        
        base.setTitle("리듬겜 기본 창");
        base.setContentPane(background);
        base.setVisible(true);
	}
	
	void setLobby() {
		settingDay();
		settingLobby();
	}
	
	void settingDay() {
		File progress = new File("scripts/ect/progress.witchmoney");
		String days = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(progress.getPath()));
			days = br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		day = new JLabel(days + "일 차");
		day.setBounds(690, 960, 200, 90);
		day.setFont(new Font("Nanum SuJubEunDaeHagSaeng", Font.PLAIN, 80));
		day.setForeground(Color.BLACK);
		day.setHorizontalAlignment(JLabel.CENTER);
		
		background.add(day);
		background.repaint();
	}
	
	void settingLobby() {
		ready = new JButton("게임 시작");
//		JButton help = new JButton("게임 방법");
		exit = new JButton("나가기");
		ready.setBounds(1405, 680, 300, 80);
//		help.setBounds(1405, 820, 300, 80);
		exit.setBounds(1405, 950, 300, 80);
		
		ready.setBorderPainted(false);
		exit.setBorderPainted(false);
		
		ready.addActionListener(e ->{
			this.gameStart = 1;
		});
//		help.addActionListener(e -> {
//			return;
//		});
		exit.addActionListener(e -> {
			int select =JOptionPane.showConfirmDialog(background, "정말로 게임에서 나가시겠습니까?", "게임종료", JOptionPane.YES_NO_OPTION);
			if(select == 0) {
				System.exit(0);
			}
		});
		
		background.add(ready);
//		background.add(help);
		background.add(exit);
		
		background.repaint();
	}
	
	void startGame() {
		while(gameStart != 1) {
			try {
				Thread.sleep(1);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ready = null;
		exit = null;
		day = null;
	}
}
