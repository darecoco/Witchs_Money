package ver0_0_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class Rhythm_selectMusic {
	private int selectedMusic = 0;
	private String selectedMusicName = "";
	private Thread musicThread;
	
	public Rhythm_selectMusic(JPanel bg) {
		setSelectedMusic();
		String filePath = "./scripts/rhythm/music.witchmoney"; // 파일 경로를 지정하세요
	    int lineNumberToRead = selectedMusic; // 읽고 싶은 줄 번호

	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        int lineNumber = 0;
	        while ((line = br.readLine()) != null) {
	            lineNumber++;
	            if (lineNumber == lineNumberToRead) {
	                System.out.println("Line " + lineNumberToRead + " : " + line);
	                selectedMusicName = line;
	                break; // 원하는 줄을 찾았으므로 반복문 종료
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace(); // 예외 메시지 출력
	    }
	    
	    CountDownLatch latch = new CountDownLatch(1);
                try {
                	System.out.println("돌입");
                    File audioFile = new File("audio/rhythm/" + selectedMusicName + ".wav");
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start();

                    // 음악 재생이 완료되면 CountDownLatch 카운트 감소
                    clip.addLineListener(event -> {
                        if (event.getType() == javax.sound.sampled.LineEvent.Type.STOP) {
                            latch.countDown();
                        }
                    });

                    new Rhythm_playNote(selectedMusicName, bg);

                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                    e.printStackTrace();
                    latch.countDown(); // 예외 발생 시도 CountDownLatch 카운트 감소
                }

        // CountDownLatch가 0이 될 때까지 대기
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	public int getSelectedMusic() {
		return selectedMusic;
	}

	public void setSelectedMusic() {
		this.selectedMusic = (int) (Math.random() * 0) + 1;
	}
	
	public void musicStart() {
		musicThread.start();
	}
}
