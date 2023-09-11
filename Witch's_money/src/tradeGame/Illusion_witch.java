package tradeGame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Illusion_witch extends JFrame{
	private int frame[] = {1, 2, 3, 4, 3, 2};
	private ImageIcon icon;
	private String image_name = "C:\\WitchMoney\\Witch's_money\\src\\images\\witch_illustion";
	JPanel witch = new JPanel() {
		public void paintComponent(Graphics g) {
			g.drawImage(icon.getImage(),0, 0, 600, 800,null);
		}
	};
	public static void main(String[] args) {
		
	}
}
