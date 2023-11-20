package ver0_0_1;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Trade_customer {
	int x;
	JPanel bg;
	JLabel customer, table;
	String market;
	
	Trade_customer(JPanel bg, String market){
		setBg(bg); setMarket(market.substring(0, market.length()-6));
	}
	
	public void comeCustomer() {
		paintCustomer();
	}
	
	public void paintCustomer() {
		String imagePath = "images/trade/bg/table.png";
		File img = new File(imagePath);
		if(img.isFile()) {
			setImage(setCustomer());
		}else {
			JOptionPane.showMessageDialog(null, "table.png 이미지 로딩 오류");
			System.exit(0);
		}
	}

	public JPanel getBg() {
		return bg;
	}
	public void setBg(JPanel bg) {
		this.bg = bg;
	}
	public JPanel getMarket() {
		return bg;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	
	public String setCustomer() {
		int line = 0;
		int i = 0;
		String customer = "";
		String filePath = "scripts/trade/"+market+".witchmoney";
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while(br.readLine() != null) line++;
			line = (int) (Math.random() * line) + 1;
		}catch(IOException e) {
			e.printStackTrace();
		}
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while(line != i++) customer = br.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	public void setImage(String customer) {
		this.customer = new JLabel(new ImageIcon("images/trade/"+market+"/" + customer + ".png"));
		this.table = new JLabel(new ImageIcon("images/trade/bg/table.png"));
		this.customer.setBounds(0, 280, 600, 800);
		this.table.setBounds(0, 480, 1920, 600);
		
		bg.add(this.table);
		bg.add(this.customer);
        bg.repaint();
	}
}
