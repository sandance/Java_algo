import


public class bfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String [] nm = br.readLine().split(" ");
        int n = Integer.valueOf(nm[0]);
        int m = Integer.valueOf(nm[1]);

        List<Integer> [] graph = new List[n];

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }

        // add edges

        for(int i=0;i<m;i++) {
            String [] lo = br.readLine().split(" ");
            int a = Integer.valueOf(lo[0]);
            int b = Integer.valueOf(lo[1]);

            graph[a].add(b);
            graph[b].add(a);

        }
        //added edges

        boolean [] visited = new boolean[n];

        for(int i=0; i < visited.length; i++){
            visited[i] = false;
        }

        // Create a queue for bfs

        Queue<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and queue it
        System.out.println("Enter the node from which you want to traverse");
        int s = Integer.parseInt(br.readLine());

        visited[s] = true;
        queue.add(s);


        while(!queue.isEmpty()) {

            s = queue.remove();
            System.out.print(s + " ");

           // If adjacent has not been visited , then mark it visited and queue it

            for(int i=0;i< graph[s].size();i++){
               int p = graph[s].get(i);
               if (!visited[p]){
                   visited[p] = true;
                   queue.add(p);
               }
            }

        }






    }
}