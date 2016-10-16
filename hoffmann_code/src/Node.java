/**
 * Created by nazmul on 12/7/14.
 */
public class Node implements Comparable<Node> {
    private  int freq;
    private char data;
    Node left;
    Node right;

    public Node(int key, char iData, Node leftNode, Node rightNode){
        freq = key;
        data = iData;
        left = leftNode;
        right = rightNode;

    }

    public int getFreq(){
        return freq;
    }

    public void setFreq(int key){
        freq = key;
    }

    public char getData(){
        return data;
    }

    public void setData(char iData)
    {
        data = iData;
    }

    public int compareTo(Node node){
        return this.freq - node.freq;
    }



}
