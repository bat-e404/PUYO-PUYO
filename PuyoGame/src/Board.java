import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel {
    public static final int BOARD_WIDTH = 6;
    public static final int BOARD_HEIGHT = 12;
    public static final int BLOCK_SIZE = 30;

    private Timer looper;

    private Color[][] board = new Color[BOARD_WIDTH][BOARD_HEIGHT];

    public Board(){
        looper = new Timer(500, new ActionListener() {
            int n = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(n++);
            }
        });

        looper.start();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Color de fondo
        g.setColor(new Color(34,40,49));
        g.fillRect(0,0, getWidth(), getHeight());

        g.setColor(new Color(221,221,221));
        for(int i = 0; i <= BOARD_HEIGHT ; i++){
            g.drawLine(0, BLOCK_SIZE * i,BLOCK_SIZE * BOARD_WIDTH, BLOCK_SIZE * i);
        }

        g.setColor(new Color(221,221,221));
        for(int j = 0;  j <= BOARD_WIDTH ; j++){
            g.drawLine(BLOCK_SIZE * j,0, BLOCK_SIZE * j, BLOCK_SIZE * BOARD_HEIGHT );
        }

    }
}
