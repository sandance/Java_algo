import java.io.IOException;

/**
 * Created by NIslam on 8/29/16.
 */
public class Ford_Fulkerson_Main {

    public static void main(String [] args) throws IOException {
        // construct by passing filename as constructor
        Ford_Fulkerson_adjmatrix fordFulk = new Ford_Fulkerson_adjmatrix(args[0]);

        // read network from file given by first argument
        fordFulk.readNetworkFromFile();

        // apply ford-Fulkerson algorithm
        fordFulk.fordfulkerson();

        fordFulk.PrintResults();
    }
}
