package rhythmGame;

/* 리듬게임을 합친 완성형 클래스 */

public class Rhythm_main{
	public static void main(String[] args) {
		Background bg = new Background();
		MoveMonster enemy = new MoveMonster(bg.getBG());
	}
}
