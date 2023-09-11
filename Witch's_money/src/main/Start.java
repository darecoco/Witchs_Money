package main;

import java.awt.*;
import javax.swing.*;

public class Start extends JFrame{
	ImageIcon icon;
	public Start(int width, int height) {
		icon = new ImageIcon("C:\\WitchMoney\\Witch's_money\\src\\images\\littleNR.png");
       
        //배경 Panel 생성후 컨텐츠페인으로 지정      
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, width, height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
		
        setContentPane(background);
        
		setTitle("기본 창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setVisible(true);
	}
}
