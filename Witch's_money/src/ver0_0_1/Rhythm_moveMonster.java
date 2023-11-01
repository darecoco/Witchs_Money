package ver0_0_1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	private int move_y;
	private int speed;
	private Thread line;
	private JPanel bg;
	private Random random = new Random();
	
	public Rhythm_moveMonster(JPanel bg, int lineNum, int speed) {
		setX(linePoint[lineNum-1]); setY(-150); setBg(bg); setLineNum(lineNum); setSpeed(speed);
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
        				move_y = enemy.getY();
        				move_y += speed;
        				line.sleep(7);
        				enemy.setLocation(x, move_y);
//        				if(move_y > 900) {
//        					reset();
//        				}
        				bg.repaint();
        			}//while
        			
        		}catch (InterruptedException e) {
        			System.err.print(e.getMessage());
        		}//try catch
        		
        	}//run
        });
        moveStart();

	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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
	
	void reset() {
		bg.removeKeyListener(this);
		enemy.setVisible(false);
		enemy = null;
		line.stop();
		bg.repaint();
	}

    @Override
    public void keyPressed(KeyEvent e) {
    	switch(lineNum) {
    	case 1:
    		if (e.getKeyCode() == KeyEvent.VK_V && move_y >= 650) {
    			//1번줄 : V
    			System.out.println("1번눌림");
    			reset();
    		}
    	case 2:
    		if (e.getKeyCode() == KeyEvent.VK_B && move_y >= 650) {
    			//2번줄 : B
    			System.out.println("2번눌림");
    			reset();
    		}
    	case 3:
    		if (e.getKeyCode() == KeyEvent.VK_N && move_y >= 650) {
    			//3번줄 : N
    			System.out.println("3번눌림");
    			reset();
    		}
    	case 4:
    		if (e.getKeyCode() == KeyEvent.VK_M && move_y >= 650) {
    			//4번줄 : M
    			System.out.println("4번눌림");
    			reset();
    		}
    	}
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
    public void randomMonster() {
    	int index;
    	if(lineNum%2 == 1) {
    		index = random.nextInt(2);
    		index = index == 0 ? 0 : 1;
    	}else {
    		index = random.nextInt(2);
    		index = index == 0 ? 2 : 3;
    	}
    	String imagePath = "images/rhythm/enemy/"+ monsterName.get(index) +".png";
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
