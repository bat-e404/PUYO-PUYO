import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class Board extends JPanel {
    public static final int BOARD_WIDTH = 6;
    public static final int BOARD_HEIGHT = 12;
    public static final int BLOCK_SIZE = 30;


    private int[][] board = new int[BOARD_WIDTH][BOARD_HEIGHT];
    private Timer looper;
    private int x = 2, y = 0;
    private BufferedImage img1, img2;
    private Sphere element = new Sphere();

    List<Map.Entry<Integer, String>> lista = new ArrayList<>(element.dualSpheres.entrySet());
    public Board(){

        looper = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                y++;
                repaint();// Solicitud de repintar
            }
        });

        looper.start();

        try{
            if (lista.size() >= 2) {
                img1 = ImageIO.read(new File(lista.get(0).getValue()));
                img2 = ImageIO.read(new File(lista.get(1).getValue()));
            } else {
                System.out.println("La lista no tiene al menos dos elementos.");
            }
        }catch(IOException e){
            e.printStackTrace();
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



    }
}
