package ver0_0_1;

import java.util.HashMap;
import javax.swing.JFrame;

/* 무역게임 기능을 합친 완성형 클래스 */

public class Trade_main {
	Trade_main(JFrame base, HashMap<String, Integer> item){
		Trade_bg bg = new Trade_bg(base, "choice_market");
		bg.setBgColor();
		bg.choiceMarket();
		String market = bg.watiChoice();
		bg.changeBG(base, market);
		Trade_customer customer = new Trade_customer(bg.getBG(), market);
		customer.comeCustomer();
		Trade_bgm bgm = new Trade_bgm(market);
		try {
			System.out.println("어...");
			Thread.sleep(10000);
			bgm.endBgm();
		}catch(InterruptedException e) {
			System.out.println("응 끝.");
		}
		System.out.println("왜 안끝나악");
	}
}