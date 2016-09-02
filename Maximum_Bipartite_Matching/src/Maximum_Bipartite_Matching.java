import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by NIslam on 8/31/16.
 */
public class Maximum_Bipartite_Matching {
    public static int M, N;


    public static boolean bpm(int [][] bpGraph, int u, boolean [] seen, int [] matchR ){

        /*
        A DFS based recursive function that returns true if a matching for a vertex u is accessible
         */

        // Try every job one by one
        for (int v=0; v < N;v++){
            // if applicant u is interested in job v
            // and v is not visited
            //int flag=0
            //if (seen[v]) flag=0 else flag =1;
            if (bpGraph[u][v] == 1 && !seen[v]){
                // mark as visited
                seen[v] = true;
                /**
                 * If job v is not assigned to an applicant or
                 * previously assigned applicant for job v has an
                 * alternate job available .
                 *
                 * Since v is marked as visited in the above line,
                 * matchR[v]  in the following recursive call will not get
                 * job v again
                 */

                if (matchR[v] < 0 || bpm(bpGraph, matchR[v], seen, matchR)){
                    matchR[v] = u;
                    return true;
                }

            }
        }
        return  false;

    }
    public static int maxBPM(int [][] bpGraph){
        /*
        An array to keep track of the applicants assigned to jobs
        The value of matchR[i] is the applicant number assigned to job i
        The value -1 indicates nobody is assigned
         */
        int [] matchR = new int [M];
        // Initially all jobs are available
        Arrays.fill(matchR, -1);

        int result =0; // No. of jobs assigned to applicants

        for(int u=0; u < M; u++){
            boolean [] seen = new boolean[N];

            Arrays.fill(seen,false);

            // find if applicant 'u' can get a job
            if (bpm(bpGraph, u, seen, matchR)){
                result++;
            }

        }
        return result;

    }



    public static void main(String[] args) throws IOException {
        String filename=args[0];
        FileReader fr=null;
        int [][] graph;

        try {
            fr = new FileReader(filename);
            Scanner in = new Scanner(fr);

            // get number of Vertices
            String nxtline;

            nxtline = in.nextLine();
            String [] ls = nxtline.split(" ");
            M = Integer.parseInt(ls[0]);
            N = Integer.parseInt(ls[1]);

            int numVertices=M;
            graph = new int [M][N];

            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    graph[i][j] = 0;
                }
            }

            String line=null;
            while(in.hasNextLine()){
                line = in.nextLine();
                String [] tokens = line.split(" ");
                int u = Integer.parseInt(tokens[0]);
                int v = Integer.parseInt(tokens[1]);
                //int c = Integer.parseInt(tokens[2]);
                // if there is an edge put weight as 1
                graph[u][v] = 1;

            }

        }finally {
            if ( fr !=null) fr.close();
        }

        Maximum_Bipartite_Matching m = new Maximum_Bipartite_Matching();
        System.out.println ("Maximum no of applicants can get job is: "+m.maxBPM(graph));



    }
}
