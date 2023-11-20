package ver0_0_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Trade_bg extends JFrame{
	private Image screenBG;
	JFrame base;
	private JPanel background;
	private String gameStart = "";
	JButton ready;
	JButton exit;
	JButton witchMarket, humanMarket;
	JLabel day;
	
	public Trade_bg(JFrame base, String room) {
		setBase(base);
		String imagePath = "images/trade/bg/" + room + ".png";
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
        
        base.setBackground(Color.WHITE);
        base.setTitle("무역겜 기본 창");
        base.setContentPane(background);
        base.setVisible(true);
	}
	
	public void changeBG(JFrame base, String room) {
		base.remove(background);
		background = null;
		String imagePath = "images/trade/bg/" + room + ".png";
		File img = new File(imagePath);
		if(img.isFile()) {
			screenBG = new ImageIcon(imagePath).getImage();
		}else {
			JOptionPane.showMessageDialog(null, room + ".png 이미지 로딩 오류");
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
	
	public void setBase(JFrame base) {
		this.base = base;
	}
	public JPanel getBG() { //JPanel background
		return background;
	}
	
	public void setBgColor() {
		File marketProgress = new File("scripts/ect/progress.witchmoney");
		int wmProgress = 0, hmProgress = 0;
		try{
			BufferedReader br = new BufferedReader(new FileReader(marketProgress.getPath()));
			for(int i = 0; i < 3; i++) {
				int temp = Integer.parseInt(br.readLine());
				if(i==0) continue;
				if(i==1) hmProgress = temp;
				if(i==2) wmProgress = temp;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		if(hmProgress > wmProgress) {
			base.setBackground(Color.decode("#b1e0ba"));
		}else if(hmProgress < wmProgress) {
			base.setBackground(Color.decode("#c9c2f2"));
		}else {
			base.setBackground(Color.decode("#C0D7EA"));
		}
//		background.repaint();
	}
	
	public void choiceMarket() {
		ImageIcon hm = new ImageIcon("images/trade/bg/hmButton.png");
		ImageIcon hmRollover = new ImageIcon("images/trade/bg/hmButtonRollover.png");
		humanMarket = new JButton();
		humanMarket.setIcon(hm);
		humanMarket.setBounds(200, 300, 600, 600);
		humanMarket.setRolloverIcon(hmRollover);
		humanMarket.setPressedIcon(hmRollover);
		humanMarket.setBorderPainted(false);
		humanMarket.setContentAreaFilled(false);
		humanMarket.setFocusPainted(false);
		humanMarket.addActionListener(e -> {
			gameStart = "HumanMarket";
		});
		
		ImageIcon wm = new ImageIcon("images/trade/bg/wmButton.png");
		ImageIcon wmRollover = new ImageIcon("images/trade/bg/wmButtonRollover.png");
		witchMarket = new JButton();
		witchMarket.setIcon(wm);
		witchMarket.setBounds(1100, 300, 600, 600);
		witchMarket.setRolloverIcon(wmRollover);
		witchMarket.setPressedIcon(wmRollover);
		witchMarket.setBorderPainted(false);
		witchMarket.setContentAreaFilled(false);
		witchMarket.setFocusPainted(false);
		witchMarket.addActionListener(e -> {
			gameStart = "WitchMarket";
		});
		
		background.add(humanMarket);
		background.add(witchMarket);
		background.repaint();
	}
	
	public String watiChoice() {
		while(true) {
			try {
				Thread.sleep(1);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(gameStart != "") {
				background.remove(humanMarket);
				background.remove(witchMarket);
				background.repaint();
				return gameStart;
			}
		}
	}
}
