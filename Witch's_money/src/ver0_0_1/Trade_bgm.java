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
	private String bgm;
	private String market;
	private Clip clip;
	private boolean isRunning = true;
	
	Trade_bgm(String market){
		setMarket(market);
		setBgm();
	}
	
	public void setMarket(String market) {
		this.market = market;
	}
	public void setBgm() {
		if(market.equals("HumanMarket")) bgm = "Smoke Jacket Blues - TrackTribe";
		else if(market.equals("WitchMarket")) bgm = "Wehrmut - Godmode";
		else bgm = "Landing - Public Memory";
	}
	public void startBgm() {
		try {
            File musicFile = new File("audio/trade/"+bgm+".wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);

            clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

            while (isRunning) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            clip.stop();
            clip = null;
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
	}
	public void endBgm() {
		isRunning = false;
	}
}