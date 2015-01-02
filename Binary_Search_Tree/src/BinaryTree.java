import java.io.*;
import java.util.*;

public class BinaryTree {

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
        //Node node = new Node();


        Binary_Search_Tree btree = new Binary_Search_Tree();
        System.out.println("Enter number of elements of Binary Tree");


        int n = in.nextInt();

        for(int i=0;i<n;i++) {
            btree.insert(in.nextInt(),in.nextDouble());
        }

        System.out.println("Elements inserted");
        System.out.println("Enter value to find");

        int value = in.nextInt();
        Node found = btree.find(value);

        if (found != null){
            System.out.println("Found : ");
            found.displayNode();
            System.out.println("\n");

        }
        else
            System.out.print("Could not find : " + value +"\n");


        /* Delete item from Binary search Tree */

        System.out.println("Enter value to delete");
        value = in.nextInt();

        boolean didDelete = btree.delete(value);

        if(didDelete)
            System.out.println("deleted " + value + "\n");
        else
            System.out.println(" could not delete ");


        //System.out.println("InOrder Binary Tree");
        //btree.InOrder();










    }

}