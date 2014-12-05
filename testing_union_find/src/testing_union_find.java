import java.util.*;


public class testing_union_find {

    private  int[] parent;
    private int [] rank;


    public int find ( int i){
        int p = parent[i];
        if (i==p)
            return i;
        return parent[i] = find(p);

    }

    public testing_union_find(int max){
        parent = new int[max];
        rank = new int [max];

        for(int i=0; i < max; i++)
            parent[i] = i;

    }

    public void union(int i, int j){

        int root1 = find(i);
        int root2 = find(j);



        if (root1 == root2) return;

        if ( rank[root1] > rank[root2]) {
            parent[root2] = root1;
        }
        else if ( rank[root2] > rank[root1]){
                parent[root1] = root2;
            }
        else {
            parent[root2] = root1;
            rank[root1]++;



        }
    }
    public String toString() {
    return "<UnionFind\np " + Arrays.toString(parent) + "\nr " + Arrays.toString(rank) + "\n>";
  }

    public static  void main(String[] args) {

        testing_union_find uf = new testing_union_find(5);
        uf.union(1,2);
        uf.union(3,4);
        uf.union(1,0);
        uf.union(1,3);
        uf.find(4);
        System.out.println("find 4");
        System.out.println(uf);

    }








}