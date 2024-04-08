public class Background {
    private int[][] grid = new int[12][6];
    public Background(){
    }
    public void setSphereGrid(int x,int y, int element){
        grid[x][y] = element;
    }
    public int[][] getGrid() {
        return grid;
    }
}
