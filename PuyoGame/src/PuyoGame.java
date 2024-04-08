import javax.swing.*;

public class PuyoGame {
    // Tamaño de la ventana del juego
    public static final int WIDTH = 285, HEIGHT = 405;
    private Board board;
    private JFrame window;
    public PuyoGame() {
        window = new JFrame("Puyo Puyo");
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        board = new Board();

        window.add(board);
        window.addKeyListener(board);
        window.setVisible(true);
    }


    public static void main(String[] args){
        new PuyoGame();
    }
}
