package rhythmGame;

/* 리듬게임을 합친 완성형 클래스 */

public class Rhythm_main{
	public static void main(String[] args) {
		Background bg = new Background();
		MoveMonster enemy = new MoveMonster(bg.getBG(), 690, -100);
		MoveMonster enemy2 = new MoveMonster(bg.getBG(), 825, -50);
		MoveMonster enemy3 = new MoveMonster(bg.getBG(), 960, -10);
		MoveMonster enemy4 = new MoveMonster(bg.getBG(), 1097, 0);
		
		enemy.moveStart();
	}
}
