import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by NIslam on 9/30/17.
 */
public class Add_Two_Numbers_LeetCode {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
            int sum = 0;
            LinkedList<Integer> newlist = new LinkedList<Integer>();

            //ListIterator<Integer> listIterator = l1.listIterator();
            for (int i = 0; i < l1.size(); i++) {
                sum = l1.get(i) + l2.get(i);
                newlist.push(sum);

            }

            for (int i = 0; i < newlist.size(); i++) {
                System.out.println(newlist.get(i) + " ");
            }
        }

    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();

        LinkedList<Integer> first = new LinkedList<Integer>();
        LinkedList<Integer> second = new LinkedList<Integer>();

        System.out.println("Enter size of first linked List");
        int N1 = in.nextInt();
        System.out.println("Enter size of second List");
        int N2 = in.nextInt();

        for(int i=0; i < N1; i++ ){
            first.push(in.nextInt());
        }

        for(int i=0; i < N2; i++){
            second.push(in.nextInt());
        }


    }
}
