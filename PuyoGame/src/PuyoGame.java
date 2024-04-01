import javax.swing.JFrame;

public class PuyoGame {
    // Tamaño de la ventana del juego
    public static final int WIDTH = 445, HEIGHT = 629;
    private Board board;
    private JFrame window;
    public PuyoGame(){
        window = new JFrame("Puyo Puyo");
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        board = new Board();
        window.add(board);
        window.setVisible(true);
    }
    public static void main(String[] args){
        new PuyoGame();
    }
}
