package ver0_0_1;

import java.util.HashMap;
import javax.swing.JFrame;

/* 무역게임 기능을 합친 완성형 클래스 */

public class Trade_main {
	Trade_main(JFrame base, HashMap<String, Integer> item){
		Trade_bg bg = new Trade_bg(base, "choice_market");
		bg.setBgColor();
		bg.choiceMarket();
	}
}