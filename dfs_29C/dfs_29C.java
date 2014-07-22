import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.io.InputStream;




public class MailStamps(){

        HashMap<Integer, ArrayList<Integer> > mp;
        mp = new HashMap<Integer,ArrayList<Integer> > ();

        public void solve(int testNumber, PandaScanner in , PrintWriter out) {
            int n = in.nextInt();

            for(int i=0;i<n;i++){
              int x = in.nextInt();
              int y = in.nextInt();

              if(!mp.containsKey(x)) {
                    ArrayList<Integer> list = new ArrayList<Integer> ();
                    list.add(y);
                    mp.put(x,list);


              }else {
                    ArrayList<Integer> list = mp.get(x);
                    list.add(y);
                    mp.put(x,list);

              }

              if(!mp.containsKey(y)) {
                    ArrayList <Integer> list = new ArrayList<Integer> ();
                    list.add(x);
                    mp.put(y,list);

              }else {
                    ArrayList<Integer> list = mp.get(x);
                    list.add(x);
                    mp.put(y,list);
              }

            }

            HashSet<Integer> vis = new HashSet<Integer> ();
            int src=-1, dest =-1;

            for(Integer node: mp.keySet()){
                if(mp.get(node).size() ==1) {
                    if(src==-1)
                        src = node;
                    else
                        dest = node; // dest will always get updated
                }

            }

            //BFS starts here

            Queue<Integer> q = new LinkedList<Integer>();
            q.add(src);

            vis.add(src);

            while(!q.isEmpty()) {
                Integer frnt = q.poll();

                if(frnt!=dest){
                    System.out.print(frnt+" ");
                }else
                    System.out.println(frnt);
                // Going through all adjacent nodes for each node
                for(Integer num: mp.get(frnt)){
                // If it is not already visited
                    if(!vis.contains(num)){
                        q.add(num);
                        vis.add(num);

                    }

                }

            }







        }
}


public class dfs_29C {



    public static void main(String[] args) {
        InputStream inputStream =System.in;
        OutputStream outputStream = System.out;

        PandaScanner in = new PandaScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        MailStamps solver = new MailStamps();

        solver.solve(1,in,out);
        out.close();

    }
}


// Input taking class By Abdelrahman_Asal

Class PandaScanner {
public BufferedReader br;
public StringTokenizer st;
public InputStream in;

public PandaScanner(InputStream in){
        br=new BufferedReader(new InputStreamReader(this.in=in));

        }

public String nextLine() {
        try {
        return br.readLine();
        }
        catch (Exception e){
        return null
        }
        }

public String next() {

        if(st==null || !st.hasMoreTokens()) {
        st = new StringTokenizer(nextLine().trim());
        return next();
        }

        return st.nextToken();

        }

public int nextInt() {
        return Integer.parseInt(next());
        }

        }

