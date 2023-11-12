package ver0_0_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Rhythm_playNote extends Thread{
	private JPanel bg;
	private long bpm;
	private double musicTime;
	private String musicName;
	private String filePath = "scripts/rhythm/";
	private ArrayList<Integer> line1 = new ArrayList<Integer>();
	private ArrayList<Integer> line2 = new ArrayList<Integer>();
	private ArrayList<Integer> line3 = new ArrayList<Integer>();
	private ArrayList<Integer> line4 = new ArrayList<Integer>();
	private Thread note1;
	private Thread note2;
	private Thread note3;
	private Thread note4;
	private HashMap<String, Integer> items = new HashMap<> ();
	
	Rhythm_playNote(String title, JPanel bg){
		setMusicName(title); setFilePath(filePath + musicName + ".witchmoney"); setBg(bg); setBaseItems();
		
		File note = new File(filePath);
		try(BufferedReader reader = new BufferedReader(new FileReader(note.getPath()))){
			String line;
			int lineNum = 1;
			while((line = reader.readLine()) != null) {
				switch(lineNum) {
				case 1: 
					this.bpm = Long.parseLong(line);
					System.out.println("맨 윗줄 : " + bpm);
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
				case 6:
					this.musicTime = Double.parseDouble(line);
					break;
				default : JOptionPane.showMessageDialog(null, "노트를 불러오는 중 에러가 발생하였습니다.");
				}
				lineNum++;
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		note1 = new Thread(new Runnable() {
			@Override
			public void run() {
				int len = line1.size();
				for(int i = 0; i < len; i++) {
					try {
						Thread.sleep(bpm);
						if(line1.get(i) == 1) {
							Thread temp1 = new Thread(new Runnable() {
								@Override
								public void run() {
									Rhythm_moveMonster l1 = new Rhythm_moveMonster(bg, 1);
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									items.put("red", items.get("red") + l1.getItems());
								}
							});
							temp1.start();
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		note2 = new Thread(new Runnable() {
			@Override
			public void run() {
				int len = line2.size();
				for(int i = 0; i < len; i++) {
					try {
						Thread.sleep(bpm);
						if(line2.get(i) == 1) {
							Thread temp2 = new Thread(new Runnable() {
								@Override
								public void run() {
									Rhythm_moveMonster l2 = new Rhythm_moveMonster(bg, 2);
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									items.put("blue", items.get("blue") + l2.getItems());
								}
							});
							temp2.start();
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		note3 = new Thread(new Runnable() {
			@Override
			public void run() {
				int len = line3.size();
				for(int i = 0; i < len; i++) {
					try {
						Thread.sleep(bpm);
						if(line3.get(i) == 1) {
							Thread temp3 = new Thread(new Runnable() {
								@Override
								public void run() {
									Rhythm_moveMonster l3 = new Rhythm_moveMonster(bg, 3);
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									items.put("red", items.get("red") + l3.getItems());
								}
							});
							temp3.start();
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		note4 = new Thread(new Runnable() {
			@Override
			public void run() {
				int len = line4.size();
				for(int i = 0; i < len; i++) {
					try {
						Thread.sleep(bpm);
						if(line4.get(i) == 1) {
							Thread temp4 = new Thread(new Runnable() {
								@Override
								public void run() {
									Rhythm_moveMonster l4 = new Rhythm_moveMonster(bg, 4);
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									items.put("blue", items.get("blue") + l4.getItems());
								}
							});
							temp4.start();
						}
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	public void startNote() {
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
	public double getMusicTime() {
		return musicTime;
	}
	public void setMusicTime(double musicTime) {
		this.musicTime = (double)musicTime;
	}
	public JPanel getBg() {
		return bg;
	}
	public void setBg(JPanel bg) {
		this.bg = bg;
	}
	public HashMap<String, Integer> getItems() {
		return items;
	}
	public void setBaseItems() {
		items.put("red", 0);
		items.put("blue", 0);
	}
	
}
