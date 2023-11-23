package ver0_0_1;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Trade_line {
	JPanel bg;
	JButton wine, purple, violet;
	JLabel question, info, tmpPanel, line, speechBubble;
	String potion;
	HashMap<String, Integer> item;
	boolean next;
	
	Trade_line(JPanel background, HashMap<String, Integer> item){
		this.next = false;
		setBg(background);
		setItem(item);
		choicePotion();
	}
	
	public void ended() {
		waitClick();
		line.setText("딱 제가 찾던 거였어요~");
		waitClick();
		line.setText("여기, 5000원이에요~");
		waitClick();
	}
	
	public void readingLine() {
		speechBubble = new JLabel(new ImageIcon("images/trade/bg/speechBubble.png"));
		speechBubble.setBounds(655, 50, 1070, 560);
		
		line = new JLabel();
		line.setBounds(700, 65, 1045, 535);
		line.setFont(new Font("EASTARJET Heavy", Font.PLAIN, 60));
		line.setHorizontalAlignment(JLabel.CENTER);
		line.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                next = true;
            }
        });
		
		bg.add(line);
		bg.add(speechBubble);
		
		try (BufferedReader br = new BufferedReader(new FileReader("scripts/trade/tourist.witchmoney"))) {
			String script = "temp";
			while((script = br.readLine()) != null){
				line.setText(script);
				waitClick();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void waitClick() {
		while(!next) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		next = false;
	}
	
	public void choicePotion() {
		tmpPanel = new JLabel(new ImageIcon("images/trade/bg/whitePanel.png"));
		tmpPanel.setBounds(56, 102, 1807, 875);
		
		info = new JLabel("빨강:"+item.get("red").toString()+"  파랑:"+item.get("blue").toString());
		info.setFont(new Font("EASTARJET Heavy", Font.PLAIN, 100));
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setBounds(119, 800, 1700, 150);
		
		ImageIcon winebt = new ImageIcon("images/trade/bg/wineButton.png");
		ImageIcon winebtRollover = new ImageIcon("images/trade/bg/wineButtonRollover.png");
		wine = new JButton();
		wine.setIcon(winebt);
		wine.setBounds(119, 290, 500, 500);
		wine.setRolloverIcon(winebtRollover);
		wine.setPressedIcon(winebtRollover);
		wine.setBorderPainted(false);
		wine.setContentAreaFilled(false);
		wine.setFocusPainted(false);
		wine.addActionListener(e -> {
			potion = "wine";
			changeNum(15, 10);
		});
		
		ImageIcon purplebt = new ImageIcon("images/trade/bg/purpleButton.png");
		ImageIcon purplebtRollover = new ImageIcon("images/trade/bg/purpleButtonRollover.png");
		purple = new JButton();
		purple.setIcon(purplebt);
		purple.setBounds(710, 290, 500, 500);
		purple.setRolloverIcon(purplebtRollover);
		purple.setPressedIcon(purplebtRollover);
		purple.setBorderPainted(false);
		purple.setContentAreaFilled(false);
		purple.setFocusPainted(false);
		purple.addActionListener(e -> {
			potion = "purple";
			changeNum(15, 15);
		});
		
		ImageIcon violetbt = new ImageIcon("images/trade/bg/violetButton.png");
		ImageIcon violetbtRollover = new ImageIcon("images/trade/bg/violetButtonRollover.png");
		violet = new JButton();
		violet.setIcon(violetbt);
		violet.setBounds(1301, 290, 500, 500);
		violet.setRolloverIcon(violetbtRollover);
		violet.setPressedIcon(violetbtRollover);
		violet.setBorderPainted(false);
		violet.setContentAreaFilled(false);
		violet.setFocusPainted(false);
		violet.addActionListener(e -> {
			potion = "violet";
			changeNum(10, 15);
		});
		
		bg.add(info);
		bg.add(wine);
		bg.add(purple);
		bg.add(violet);
		bg.add(tmpPanel);
	}
	
	public void hidePanel() {
		wine.setVisible(false);
		purple.setVisible(false);
		violet.setVisible(false);
		tmpPanel.setVisible(false);
		info.setVisible(false);
		
		bg.repaint();
	}
	
	public void showPanel() {
		wine.setVisible(true);
		purple.setVisible(true);
		violet.setVisible(true);
		tmpPanel.setVisible(true);
		info.setVisible(true);
		
		bg.repaint();
	}
	
	public void setBg(JPanel bg) {
		this.bg = bg;
		bg.setLayout(null);
	}
	public void setItem(HashMap<String, Integer> item) {
		this.item = item;
	}
	public void changeNum(int red, int blue) {
		if(item.get("blue") - blue >= 0 && item.get("red") - red >= 0) {
			item.put("blue", item.get("blue") - blue);
			item.put("red", item.get("red") - red);
			info.setText("빨강:"+item.get("red").toString()+"  파랑:"+item.get("blue").toString());
			hidePanel();
		}
	}
}