package ver0_0_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame {
    private final Timer timer;
    private int xCoordinate;

    public Test() {
        setTitle("Image Movement Example");
        setSize(1920, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel을 생성하고 ActionListener를 등록합니다.
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawImages(g);
            }
        };

        // 타이머를 생성하고 ActionListener를 등록합니다.
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveImage();
                panel.repaint();
            }
        });

        // JPanel을 프레임에 추가합니다.
        add(panel);

        // JFrame을 표시하고 타이머를 시작합니다.
        setVisible(true);
        timer.start();
    }

    // 이미지를 그리는 메서드
    private void drawImages(Graphics g) {
        // 이미지 파일 경로에 따라 수정하세요.
    	System.out.println("홀리몰리");
        ImageIcon imageA = new ImageIcon("images/trade/human/electricguitar.png");
        ImageIcon imageB = new ImageIcon("images/trade/bg/table.png");

        // 이미지 A를 그립니다.
        g.drawImage(imageA.getImage(), xCoordinate, 0, null);

        // 이미지 B를 그립니다.
        g.drawImage(imageB.getImage(), 0, 200, null);
    }

    // 이미지를 이동시키는 메서드
    private void moveImage() {
        xCoordinate += 1;  // 오른쪽으로 1씩 이동
        if (xCoordinate > getWidth()) {
            xCoordinate = -100;  // 화면을 벗어나면 다시 시작
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }
}
