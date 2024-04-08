import java.util.Random;

public class Stock {
    private static Stock instance;
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

    private Random random = new Random();
    // Patron singleton
    private Stock(){/* Constructor que evita la creacion de instancias del exterior */}
    //Instancia unica
    public static Stock getInstance(){
        if(instance == null){
            instance = new Stock();
        }
        return instance;
    }
    public int[] getPairSpheres(){
        int numberRow = random.nextInt(10);
        int numberColum = random.nextInt(2);

        int[] randomSpheres = new int[2];

        if(numberColum == 0){
            randomSpheres[0] = stockSpheresCombination[numberRow][0];
            randomSpheres[1] = stockSpheresCombination[numberRow][1];
        }

        if(numberColum == 1){
            randomSpheres[1] = stockSpheresCombination[numberRow][1];
            randomSpheres[0] = stockSpheresCombination[numberRow][0];
        }

        return randomSpheres;
    };
}
