package ver0_0_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Rhythm_moveMonster implements KeyListener{
	/* 처음 줄 690 800
	 * 두 번째 줄 825 800
	 * 세 번째 줄 960 800
	 * 네 번째 줄 1097 800*/
	private ImageIcon monster;
	private JLabel enemy;
	private ArrayList<String> monsterName = new ArrayList<String>(Arrays.asList("red1", "red2", "blue1", "blue2"));
	private int lineNum;
	private int[] linePoint = {690, 825, 960, 1097};
	private int x, y;
	private Thread line;
	private JPanel bg;
	
	public Rhythm_moveMonster(JPanel bg, int lineNum) {
		setX(linePoint[lineNum-1]); setY(-200); setBg(bg); setLineNum(lineNum);
		randomMonster();
		
		// enemy 절대 위치
        enemy.setBounds(x, y, monster.getIconWidth(), monster.getIconHeight());
        
        bg.addKeyListener(this);
        bg.setFocusable(true);
        bg.requestFocus();
        bg.add(enemy);
        bg.repaint();
        
        line = new Thread(new Runnable() {
        	@Override
        	public void run() {
        		try {
        			
        			while(true) {
        				int move_y = enemy.getY();
        				move_y += 5;
        				line.sleep(7);
        				enemy.setLocation(x, move_y);
        				if(move_y > 800) {
        					reset(x, y);
        				}
        				bg.repaint();
        			}//while
        			
        		}catch (InterruptedException e) {
        			System.err.print(e.getMessage());
        		}//try catch
        		
        	}//run
        });

	}
	
	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setBg(JPanel bg) {
		this.bg = bg;
	}

	JLabel getRed() {
		return enemy;
	}
	
	void moveStart() {
		line.start();
	}
	
	void reset(int x, int y) {
		enemy.setLocation(x, y);
	}

    @Override
    public void keyPressed(KeyEvent e) {
    	switch(lineNum) {
    	case 1:
    		if (e.getKeyCode() == KeyEvent.VK_V) {
    			//1번줄 : V
    			System.out.println("1번눌림");
    		}
    	case 2:
    		if (e.getKeyCode() == KeyEvent.VK_B) {
    			//2번줄 : B
    			System.out.println("2번눌림");
    		}
    	case 3:
    		if (e.getKeyCode() == KeyEvent.VK_N) {
    			//3번줄 : N
    			System.out.println("3번눌림");
    		}
    	case 4:
    		if (e.getKeyCode() == KeyEvent.VK_M) {
    			//4번줄 : M
    			System.out.println("4번눌림");
    		}
    	}
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
    public void randomMonster() {
    	String imagePath = "images/rhythm/enemy/"+ monsterName.get(0) +".png";
		File img = new File(imagePath);
		if(img.isFile()) {
			monster = new ImageIcon(imagePath);		
		}else {
			JOptionPane.showMessageDialog(null, "이미지 로딩 오류");
			System.exit(0);
		}
		enemy = new JLabel(monster);
    }
}
