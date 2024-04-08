import java.util.HashMap;
import java.util.Map;

public class Sphere {
    // Espacio que tiene mi Sphere
    private int[][] grid;
    // Map que contendra las rutas de las imagenes
    private final Map<Integer, String> imagePaths = new HashMap<>();
    public Sphere(){
        this.grid = new int[3][3];
        Stock stock = Stock.getInstance();
        setGrid(stock.getPairSpheres());
        initializeImagePaths();
    }

    // Metodo para fijar elemento
    public void setGrid(int[] randomSphere){
        this.grid[1][1] = randomSphere[0];
        this.grid[1][2] =  randomSphere[1];
    }
    // Metodo que me obtiene el arreglo
    public int[][] getGrid(){
        return this.grid;
    }
    // Metodo que me retorna el elemento
    public int getNumber(int row, int column){
        return this.grid[row][column];
    }
    public String getImagePath(int sphereNumber){
        return imagePaths.get(sphereNumber);
    }
    // Metodo que me agrega las imagenes en el Map
    private void initializeImagePaths() {
        imagePaths.put(1, "images/puyoBlue.png");
        imagePaths.put(2, "images/puyoGreen.png");
        imagePaths.put(3, "images/puyoRed.png");
        imagePaths.put(4, "images/puyoYellow.png");
    }
}
