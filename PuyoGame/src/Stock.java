import java.util.*;

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
    Object[][] dualSpheres = new Object[2][2];
    public void getImagesPaths(int[][]randomSpheres){

        dualSpheres[0][0] = randomSpheres[0][0];
        dualSpheres[1][0] = randomSpheres[0][1];

        for(int i = 0; i < dualSpheres.length; i++){
            dualSpheres[i][1] = imagePaths.get(dualSpheres[i][0]);
        }

        System.out.println(Arrays.deepToString(dualSpheres));


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
