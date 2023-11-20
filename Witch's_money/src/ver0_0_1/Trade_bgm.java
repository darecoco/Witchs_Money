package ver0_0_1;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Trade_bgm {
	String bgm;
	String market;
	Clip clip;
	
	Trade_bgm(String market){
		setMarket(market);
		setBgm();
		try {
            File musicFile = new File("audio/trade/"+bgm+".wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);

            clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

            while (true) {
                try {
                    Thread.sleep(1000); // 1초마다 체크
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
	}
	
	public void setMarket(String market) {
		this.market = market;
	}
	public void setBgm() {
		if(market.equals("HumanMarket")) bgm = "Smoke Jacket Blues - TrackTribe";
		else if(market.equals("WitchMarket")) bgm = "Wehrmut - Godmode";
		else bgm = "Landing - Public Memory";
	}
	public void endBgm() {
		System.out.println("어랏");
		clip.stop();
	}
}