import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Stock {

    private static final int[][] stockSpheresCombination = {
            {1,2},
            {1,3},
            {1,4},
            {2,3},
            {2,4},
            {3,4},
            {1,1},
            {2,2},
            {3,3},
            {4,4}
    };
    private final Map<Integer, String> imagePaths = new HashMap<>();
    {
        imagePaths.put(1,"puyoBlue.png");
        imagePaths.put(2,"puyoGreen.png");
        imagePaths.put(3,"puyoRed.png");
        imagePaths.put(4,"puyoYellow.png");
    }
    private Random random = new Random();
    public Map<Integer,String> dualSpheres = new HashMap<>();
    public void getImagesPaths(int[][]randomSpheres){
        for(int i = 0; i < randomSpheres[0].length; i++){
            dualSpheres.put(i,imagePaths.get(randomSpheres[0][i]));
        }
    }
    public void generatePairSpheres(){
        int numberRow = random.nextInt(10);
        int numberColum = random.nextInt(2);

        int[][] randomSpheres = new int[1][2];

        if(numberColum == 0){
            randomSpheres[0][0] = stockSpheresCombination[numberRow][0];
            randomSpheres[0][1] = stockSpheresCombination[numberRow][1];
        }

        if(numberColum == 1){
            randomSpheres[0][0] = stockSpheresCombination[numberRow][1];
            randomSpheres[0][1] = stockSpheresCombination[numberRow][0];
        }
        getImagesPaths(randomSpheres);
    };



}
