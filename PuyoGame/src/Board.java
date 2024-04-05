import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class Board extends JPanel implements KeyListener {
    private static int  FPS = 60;
    private static int delay = FPS / 100;

    public static final int BOARD_WIDTH = 6;
    public static final int BOARD_HEIGHT = 12;
    public static final int BLOCK_SIZE = 30;


    private int[][] board = new int[BOARD_WIDTH][BOARD_HEIGHT];
    private Timer looper;
    private int x = 2, deltaX = 0, y = 0;
    private boolean collision = false;
    private int normal = 600;
    private int fast = 50;
    private int delayTimeForMovement = normal;
    private  long beginTime;
    private BufferedImage img1, img2;
    private Sphere element = new Sphere();


    public Board(){

        looper = new Timer(delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                repaint();// Solicitud de repintar
            }
        });

        looper.start();

        try{
            img1 = ImageIO.read(new File(String.valueOf(element.dualSpheres[0][1])));
            img2 = ImageIO.read(new File(String.valueOf(element.dualSpheres[1][1])));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    private void update(){
        if(collision){
            return;
        }
        // Delimitar movimiento en Horizontal
        if(x + deltaX < 5 && x + deltaX >= 0){
            x += deltaX;
        }
        deltaX = 0;
        if(System.currentTimeMillis() - beginTime > delayTimeForMovement){
            if(y < 11 && y >= 0){
                y++;
            }else {
                collision = true;
            }

            beginTime = System.currentTimeMillis();
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Color de fondo
        g.setColor(new Color(34,40,49));
        g.fillRect(0,0, getWidth(), getHeight());

        if (img1 != null) {
            g.drawImage(img1,x*BLOCK_SIZE,y*BLOCK_SIZE, 30,30, null);
        }
        if (img2 != null) {
            g.drawImage(img2,x*BLOCK_SIZE+30,y*BLOCK_SIZE, 30,30, null);
        }

        g.setColor(new Color(221,221,221));
        for(int i = 0; i <= BOARD_HEIGHT ; i++){
            g.drawLine(0, BLOCK_SIZE * i,BLOCK_SIZE * BOARD_WIDTH, BLOCK_SIZE * i);
        }

        g.setColor(new Color(221,221,221));
        for(int j = 0;  j <= BOARD_WIDTH ; j++){
            g.drawLine(BLOCK_SIZE * j,0, BLOCK_SIZE * j, BLOCK_SIZE * BOARD_HEIGHT );
        }

        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_S){
            delayTimeForMovement = fast;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            deltaX = 1;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            deltaX = -1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_S){
            delayTimeForMovement = normal;
        }

    }
}
