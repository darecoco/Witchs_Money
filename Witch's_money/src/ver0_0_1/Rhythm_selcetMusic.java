package ver0_0_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

public class Rhythm_selcetMusic {
	private int selectedMusic = 0;
	private String selectedMusicName = "";
	private Timer timer;
	
	public Rhythm_selcetMusic() {
		setSelectedMusic();
		String filePath = "./src/ver0_0_1/music.witchmoney"; // 파일 경로를 지정하세요
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
	    
//	    File audioFile = new File("audio/rhythm/" + selectedMusicName); // 배경 음악 파일 경로
//	    String mp3Path = audioFile.getPath();
	    try {
            File audioFile = new File("audio/rhythm/" + selectedMusicName); // 배경 음악 파일 경로
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY); // 무한 반복
            clip.start();

            // 배경 음악이 재생되는 동안 다른 작업 수행
            timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	int i = 0;
                	for(i = 0; i < 100; i++) {
                		System.out.println(i);
                		timer.stop();
                		timer.restart();
                	}
                }
            });
            timer.start();

            // 배경 음악 종료
            clip.stop();
            clip.close();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
//	    try {
//            Bitstream bitstream = new Bitstream(new FileInputStream(mp3Path));
//            javazoom.jl.decoder.Decoder decoder = new javazoom.jl.decoder.Decoder();
//
//            // Player 인스턴스를 생성하고 초기화
//            AdvancedPlayer player = new AdvancedPlayer(new FileInputStream(mp3Path));
//
//            // 재생이 끝났을 때의 동작을 정의
//            player.setPlayBackEvent(new PlaybackEventAdapter() {
//                @Override
//                public void playbackFinished(PlaybackEvent evt) {
//                    if (evt.getFrame().equals(PlaybackEvent.Stopped)) {
//                        // 재생이 끝나면 원하는 동작을 수행
//                        System.out.println("Playback Finished");
//                    }
//                }
//            });
//
//            player.play();
//        } catch (JavaLayerException | IOException e) {
//            e.printStackTrace();
//        }
	}

	public int getSelectedMusic() {
		return selectedMusic;
	}

	public void setSelectedMusic() {
		this.selectedMusic = (int) (Math.random()*2) + 1;
	}
	
	public static void main(String[] args) {
		new Rhythm_selcetMusic();
	}
}
