import java.io.*;
import java.util.*;

public class HackRankSearch1 {

    public static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }


        public long nextLong() {
            return Long.parseLong(next());
        }


        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }


        public String nextLine() {
            st = null;

            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        HashSet<Integer> hashSet = new HashSet<Integer>();

        int n = in.nextInt();

        int [] array = new int [n];
        for(int i=0;i<n;i++){
            array[i] = in.nextInt();
            //hashMap.put(array[i],0);
        }

       for(int i=0;i<array.length ;i++){
           if(!hashSet.contains(array[i]))
               hashSet.add(array[i]);
           else
               hashSet.remove(array[i]);
       }


        Iterator i = hashSet.iterator();

        while(i.hasNext()){
            //i.next();
            System.out.println(i.next());
        }


    }

}