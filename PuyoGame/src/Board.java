import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Board extends JPanel implements KeyListener  {

    private static int  FPS = 60;
    private static int delay = FPS / 100;

    public static final int BOARD_WIDTH = 6;
    public static final int BOARD_HEIGHT = 12;
    public static final int BLOCK_SIZE = 30;

    private Timer looper;
    private int x = 2, deltaX = 0, y = 0;
    private boolean collision = false;
    private int normal = 600;
    private int fast = 50;
    private int delayTimeForMovement = normal;
    private  long beginTime;

    Background background = new Background();
    private int [][] gridBackground = background.getGrid();
    Sphere elemento = new Sphere();
    private int [][] gridSphere = elemento.getGrid();
    Map<Point,String> renderImg = new HashMap<>();

    public Board(){

        looper = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                repaint();// Solicitud de repintar
            }
        });
        looper.start();

        unionGrid();
        getGrid();
    }

    public void unionGrid(){
        gridBackground[0][2] = gridSphere[1][1];
        gridBackground[0][3] = gridSphere[1][2];
    }

    public void getGrid(){
        for (int i = 0; i < gridBackground.length; i++){
            for (int j = 0; j < gridBackground[i].length; j++){
                if(gridBackground[i][j] != 0){
                    renderImg.put(new Point(j,i), elemento.getImagePath(gridBackground[i][j]));
                }
            }

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

        // Iterar sobre el mapa
        for (Map.Entry<Point, String> entry : renderImg.entrySet()) {
            BufferedImage img = null;
            int x = entry.getKey().x;
            int y = entry.getKey().y;
            String valorCoordenadas = entry.getValue();
            try {
                img = ImageIO.read(new File(String.valueOf(valorCoordenadas)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g.drawImage(img, x * BLOCK_SIZE, y * BLOCK_SIZE, 30, 30, null );
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
        Point claveAModificar = renderImg.keySet().iterator().next();

        if(e.getKeyCode() == KeyEvent.VK_S){
            delayTimeForMovement = fast;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println(claveAModificar);
            claveAModificar.x += 1;
            System.out.println(Arrays.deepToString(gridBackground));
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            claveAModificar.x -= 1;
            System.out.println(Arrays.deepToString(gridBackground));
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
