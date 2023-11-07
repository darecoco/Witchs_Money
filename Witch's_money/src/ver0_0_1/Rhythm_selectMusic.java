package ver0_0_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
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
	private Rhythm_playNote note;
	private boolean endMusic = false;
	private String filePath = "./scripts/rhythm/music.witchmoney";
	private HashMap<String, Integer> items = new HashMap<>();
	
	public Rhythm_selectMusic(JPanel bg) {
		setSelectedMusic();

	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        int lineNumber = 0;
	        while ((line = br.readLine()) != null) {
	            lineNumber++;
	            if (lineNumber == selectedMusic) {
	                System.out.println("Line " + selectedMusic + " : " + line);
	                selectedMusicName = line;
	                break; // 원하는 줄을 찾았으므로 반복문 종료
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace(); // 예외 메시지 출력
	    }
	    
	    CountDownLatch latch = new CountDownLatch(1);
                try {
                    File audioFile = new File("audio/rhythm/" + selectedMusicName + ".wav");
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start();

                    // 음악 재생이 완료되면 CountDownLatch 카운트 감소
                    clip.addLineListener(event -> {
                        if (event.getType() == javax.sound.sampled.LineEvent.Type.STOP) {
                        	// 브금 끝나면 실행되는 부분
                        	setItems(note.getItems());
                        	deleteNote();
                        	setEndMusic(true);
                        	System.out.println("음악 끝남");
                            latch.countDown();
                        }
                    });
                    note = new Rhythm_playNote(selectedMusicName, bg);
                    System.out.println(note.getMusicTime());
                    new Rhythm_bottomBar(bg, note.getMusicTime());
                    startNote();

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

	public boolean isEndMusic() {
		return endMusic;
	}

	public void setEndMusic(boolean endMusic) {
		this.endMusic = endMusic;
	}

	public int getSelectedMusic() {
		return selectedMusic;
	}

	public void setSelectedMusic() {
		int line = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while(br.readLine() != null) line++;
		}catch(IOException e) {
			e.printStackTrace();
		}
//		this.selectedMusic = (int) (Math.random() * line) + 1;
		this.selectedMusic = 5;
	}
	
	public void musicStart() {
		musicThread.start();
	}
	
	public void startNote() {
		note.startNote();
	}
	
	public void deleteNote() {
		note = null;
	}
	
	public HashMap<String, Integer> getItems() {
		return items;
	}
	
	public void setItems(HashMap<String, Integer> items) {
		this.items = items;
	}
}
