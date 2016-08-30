import java.io.*;
import java.util.*;


/**
 * Created by NIslam on 8/26/16.
 */
public class Ford_Fulkerson_adjmatrix {
    /** The name of the file that encodes the given network **/
    private String filename;

    /** The Graph on which Ford-Fulkerson Algorithm will run **/
    private Network net;

    public Ford_Fulkerson_adjmatrix(String s){
        filename = s;
    }

    /**
     * Read in network from file
     */

    public void readNetworkFromFile() {
        FileReader fr = null;
        try {
            try {
                fr = new FileReader(filename);
                Scanner in = new Scanner(fr);

                // get num of vertices
                String line = in.nextLine();
                int numVertices = Integer.parseInt(line);
                System.out.println("No of Vertices: "+numVertices);

                // create a new network with desired number of vertices
                net = new Network(numVertices);
                // now add the edges

                while(in.hasNextLine()){
                    line = in.nextLine();
                    String [] tokens = line.split("[( )]+");
                    int u = Integer.parseInt(tokens[0]);
                    // get corresponding Vertex object
                    Vertex uu = net.getVertexByIndex(u);
                    int i =1;


                    int v = Integer.parseInt(tokens[1]);
                    Vertex vv = net.getVertexByIndex(v);
                    // get capacity c of (u, v)
                    int c = Integer.parseInt(tokens[2]);
                    net.addEdge(uu,vv, c);

                }
            } finally {
                if ( fr != null)
                    fr.close();
            }
        } catch (IOException e){
            System.err.println("IO Error:");
            System.err.println(e);
            System.exit(1);
        }
    } // ends here


    /**
     * Execute ford Fulkerson Algorithm on the constructed network
     */

    public void fordfulkerson() throws IOException {
        int newFlow = 0;

        // Initialization; Set the flow everywhere to 0 initially
        for (int v = 0; v < net.getNumVertices(); v++) {
            Vertex vv = net.getVertexByIndex(v);

            for (int u = 0; u < net.getNumVertices(); u++) {
                Vertex vu = net.getVertexByIndex(u);
                Edge e = net.getAdjMatrixEntry(vv, vu);

                if (e != null)
                    e.setFlow(newFlow);
            }
        }


        for (;;) {  // while an augmenting path exists
            residualGraph resG = new residualGraph(net);
            LinkedList<Edge> augmPath = resG.findAugmentingPath();

            resG.printResG();
            System.out.println("Augmenting path: ");
            //printAugPath(augmPath);

            if (augmPath == null) // if there is no augm path, then we have found the max flow
                break;
            else {
                // print augmPath
                printAugPath(augmPath);
                newFlow = minC(augmPath); // minimum capacity of all edges in the augm Path
                for( int i=0; i < augmPath.size(); i++){
                    // set the corresponding edges with the new flow
                    net.updateFlow(augmPath.get(i), newFlow);
                }
            }
        }
    }

    public void printAugPath(LinkedList<Edge> edges){
        System.out.println("Augment path : ");
        for(int i=0;i< edges.size(); i++){
            System.out.print(edges.get(i).getSourceVertex()+" ");
        }
    }

    public int minC(LinkedList<Edge> edges){
        int minCapacity = edges.get(0).getCapacity();

        for(int i =1; i < edges.size(); i++){
            int currCapacity = edges.get(i).getCapacity();
            //minCapacity = Math.min(currCapacity, minCapacity);
            if ( currCapacity < minCapacity)
                minCapacity = currCapacity;
        }
        return minCapacity;
    }

    /**
     * Print the results of the execution
     */

    public void PrintResults() {
        if (net.isFlow()) {
            if (net.isFlow()) {
                System.out.println("The assignment is a valid flow");
                System.out.println("A maximum flow has value: " + net.getValue());
                System.out.println("The flows along the edges are as follows:");
                net.printFlow();
            } else
                System.out.println("The assignment is not a valid flow");
        }
    }


}
