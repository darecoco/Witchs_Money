package ver0_0_1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
	private int blue=0, red=0;
	private Thread line;
	private JPanel bg;
	private Random random = new Random();
	
	public Rhythm_moveMonster(JPanel bg, int lineNum) {
		setX(linePoint[lineNum-1]); setY(-150); setBg(bg); setLineNum(lineNum);
		randomMonster();
		
		// enemy 절대 위치
        enemy.setBounds(x, y, monster.getIconWidth(), monster.getIconHeight());
        
        bg.addKeyListener(this);
        bg.setFocusable(true);
        bg.requestFocus();
        bg.add(enemy);
        
        line = new Thread(new Runnable() {
        	@Override
        	public void run() {
        		try {
        			
        			while(true) {
        				move_y = enemy.getY();
        				move_y += 7;
        				line.sleep(7);
        				enemy.setLocation(x, move_y);
        				if(move_y > 900) {
        					reset();
        				}
        			}//while
        			
        		}catch (InterruptedException e) {
        			judge(getLineNum(), enemy.getY()); //노트 점수 매기기
        		}finally{
        			bg.remove(enemy);
        			bg.repaint();
        			enemy = null;
        		}
        	}//run
        });
        moveStart();

	}
	
	public int getItems() {
		if(getLineNum() % 2 == 0) {
			return this.blue;
		}else{
			return this.red;
		}
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
		line.interrupt();
	}
	
	void judge(int line, int y) {
		if(line % 2 == 0) { // 짝수 : 파랑줄
			if(y <= 685) {
				this.blue += 3;
			}else if(y <= 740) {
				this.blue += 5;
			}else if(y <= 820) {
				this.blue += 3;
			}else {
				this.blue += 1;
			}
		}else{ //홀수 : 빨강줄
			if(y <= 685) {
				this.red += 3;
			}else if(y <= 740) {
				this.red += 5;
			}else if(y <= 820) {
				this.red += 3;
			}else {
				this.red += 1;
			}
		}
	}

    @Override
    public void keyPressed(KeyEvent e) {
    	switch(lineNum) {
    	case 1:
    		if (e.getKeyCode() == KeyEvent.VK_V && move_y >= 650) {
    			//1번줄 : V
    			reset();
    		}
    		break;
    	case 2:
    		if (e.getKeyCode() == KeyEvent.VK_B && move_y >= 650) {
    			//2번줄 : B
    			reset();
    		}
    		break;
    	case 3:
    		if (e.getKeyCode() == KeyEvent.VK_N && move_y >= 650) {
    			//3번줄 : N
    			reset();
    		}
    		break;
    	case 4:
    		if (e.getKeyCode() == KeyEvent.VK_M && move_y >= 650) {
    			//4번줄 : M
    			reset();
    		}
    		break;
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
