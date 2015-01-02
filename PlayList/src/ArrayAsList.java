import java.util.*;


/**
 * Created by nazmul on 12/15/14.
 */
public class ArrayAsList {
    public static void main(String [] args) {
        Double [] weeklyTemperature = {31.1, 30.0, 32.5, 34.9, 33.7, 27.8};
        //List<Double> temperatures = Arrays.asList(weeklyTemperature);
        //List<Double> temperatures = Arrays.asList(weeklyTemperature);

        List<Double> temperatures = new ArrayList<Double>(Arrays.asList(weeklyTemperature));
        temperatures.add(32.3);

        System.out.println("Maximum temperature: "+ Collections.max(temperatures));
        System.out.println("Minimum temperature  "+Collections.min(temperatures));

    }

}
