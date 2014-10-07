import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by keks on 27.09.14.
 *
 * Calcutaion class
 */


public class Calculator {

    /**
     * Input parameters parsing
     *
     * @return list of Spots
     */
    private static List<Spot> getSpotsList(String[] inputParams) {
        List<Spot> spots = new ArrayList<Spot>();
        for (int i = 0; i < inputParams.length + 1 / 2; ++i) { // two params per single spot (x, y)
            spots.add(new Spot(Double.parseDouble(inputParams[i]), Double.parseDouble(inputParams[++i])));
        }
        return spots;
    }

    /**
     * calculation
     *
     * @return smallest destination between teo spots
     */
    public static double clculate(String[] inputParams) {
        Spot[] spots = getSpotsList(inputParams).toArray(new Spot[0]);
        List<Double> distances = new ArrayList<Double>();
        for (int i = 0; i < spots.length; i++) {
            for (int n = i + 1; n < spots.length; n++) {
                // each spot compares with each other without permutations,
                // using geometric formula ((x2 - x1)^2 + (y2 - y1)^2)^0.5
                distances.add(Math.sqrt(Math.pow(spots[n].getX() - spots[i].getX(), 2) + Math.pow(spots[n].getY() - spots[i].getY(), 2)));
            }
        }
        Collections.sort(distances);
        return distances.get(0);
    }
}
