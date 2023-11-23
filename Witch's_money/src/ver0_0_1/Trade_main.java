package ver0_0_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;

/* 무역게임 기능을 합친 완성형 클래스 */

public class Trade_main extends Thread{
	private HashMap<String, Integer> item;
	private Trade_bgm bgm;
	
	Trade_main(JFrame base, HashMap<String, Integer> item){
		setItem(item);
		Trade_bg bg = new Trade_bg(base, "choice_market");
		bg.setBgColor();
		bg.choiceMarket();
		String market = bg.watiChoice();
		bg.changeBG(base, market);
		setBgm(new Trade_bgm(market));
		Trade_customer customer = new Trade_customer(bg.getBG(), market, item);
		Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
            	customer.comeCustomer();
            }
        });
		
        // 두 번째 메소드를 실행하는 쓰레드 생성
        Thread thread2 = new Thread(new Runnable() {
			@Override
            public void run() {
				bgm.startBgm();
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
        	while(thread1.isAlive()) {
        		Thread.sleep(1);
        	}
        	bgm.endBgm();
            thread2.join();
        }catch (InterruptedException e) {
        	e.printStackTrace();
        }finally{
        	try {
                // 파일을 읽기 위한 BufferedReader 생성
                BufferedReader reader = new BufferedReader(new FileReader("scripts/ect/progress.witchmoney"));
                String firstLine = reader.readLine();

                BufferedWriter writer = new BufferedWriter(new FileWriter("scripts/ect/progress.witchmoney"));
                int days = Integer.parseInt(firstLine) + 1;
                writer.write(Integer.toString(days));
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.newLine();
                    writer.write(line);
                }
                reader.close();
                writer.close(); // 파일 쓰기 종료
                return;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
	}
	
	public void setItem(HashMap<String, Integer> item) {
		this.item = item;
	}
	public void setBgm(Trade_bgm bgm) {
		this.bgm = bgm;
	}
}