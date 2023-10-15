package ver0_0_1;

/* 리듬게임을 합친 완성형 클래스 */

public class Rhythm_main{
	public static void main(String[] args) {
		Rhythm_bg bg = new Rhythm_bg();
		Rhythm_moveMonster enemy = new Rhythm_moveMonster(bg.getBG(), 690, -100);
		Rhythm_moveMonster enemy2 = new Rhythm_moveMonster(bg.getBG(), 825, -50);
		Rhythm_moveMonster enemy3 = new Rhythm_moveMonster(bg.getBG(), 960, -10);
		Rhythm_moveMonster enemy4 = new Rhythm_moveMonster(bg.getBG(), 1097, 0);
		
		enemy.moveStart();
	}
}
