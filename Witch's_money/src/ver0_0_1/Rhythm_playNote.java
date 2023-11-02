package ver0_0_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Rhythm_playNote extends Thread{
	private long bpm;
	private String musicName;
	private String filePath = "scripts/rhythm/";
	private ArrayList<Integer> line1 = new ArrayList<Integer>();
	private ArrayList<Integer> line2 = new ArrayList<Integer>();
	private ArrayList<Integer> line3 = new ArrayList<Integer>();
	private ArrayList<Integer> line4 = new ArrayList<Integer>();
	
	Rhythm_playNote(String title, JPanel bg){
		setMusicName(title); setFilePath(filePath + musicName + ".witchmoney");
		
		File note = new File(filePath);
		try(BufferedReader reader = new BufferedReader(new FileReader(note.getPath()))){
			String line;
			int lineNum = 1;
			while((line = reader.readLine()) != null) {
				switch(lineNum) {
				case 1: 
					this.bpm = Long.parseLong(line);
					break;
				case 2:
					for (int i = 0; i < line.length(); i++) {
			            char digitChar = line.charAt(i);
			            int digit = Character.getNumericValue(digitChar);
			            line1.add(digit);
			        }
					break;
				case 3:
					for (int i = 0; i < line.length(); i++) {
			            char digitChar = line.charAt(i);
			            int digit = Character.getNumericValue(digitChar);
			            line2.add(digit);
			        }
					break;
				case 4:
					for (int i = 0; i < line.length(); i++) {
			            char digitChar = line.charAt(i);
			            int digit = Character.getNumericValue(digitChar);
			            line3.add(digit);
			        }
					break;
				case 5:
					for (int i = 0; i < line.length(); i++) {
			            char digitChar = line.charAt(i);
			            int digit = Character.getNumericValue(digitChar);
			            line4.add(digit);
			        }
					break;
				default : JOptionPane.showMessageDialog(null, "노트를 불러오는 중 에러가 발생하였습니다.");
				}
				lineNum++;
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		Thread note1 = new Thread(new Runnable() {
			@Override
			public void run() {
				int len = line1.size();
				for(int i = 0; i < len; i++) {
					try {
						Thread.sleep(bpm);
						if(line1.get(i) == 1) {
							new Rhythm_moveMonster(bg, 1);
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread note2 = new Thread(new Runnable() {
			@Override
			public void run() {
				int len = line2.size();
				for(int i = 0; i < len; i++) {
					try {
						Thread.sleep(bpm);
						if(line2.get(i) == 1) {
							new Rhythm_moveMonster(bg, 2);
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread note3 = new Thread(new Runnable() {
			@Override
			public void run() {
				int len = line3.size();
				for(int i = 0; i < len; i++) {
					try {
						Thread.sleep(bpm);
						if(line3.get(i) == 1) {
							new Rhythm_moveMonster(bg, 3);
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread note4 = new Thread(new Runnable() {
			@Override
			public void run() {
				int len = line4.size();
				for(int i = 0; i < len; i++) {
					try {
						Thread.sleep(bpm);
						if(line4.get(i) == 1) {
							new Rhythm_moveMonster(bg, 4);
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		note1.start();
		note2.start();
		note3.start();
		note4.start();
	}
	
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musinName) {
		this.musicName = musinName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
