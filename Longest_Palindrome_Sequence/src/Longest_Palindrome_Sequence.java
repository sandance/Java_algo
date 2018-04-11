import java.awt.datatransfer.SystemFlavorMap;
import java.io.*;
import java.util.*;


/**
 *
 *
 * https://www.youtube.com/watch?v=_nCsPn7_OgI
 */
public class Longest_Palindrome_Sequence {

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

    public static String Recursive_LPS(String s,int st,int lt){
        if ( st > lt) return "";
        if ( st==lt ) return s.charAt(st) + "";
        if (s.charAt(st) == s.charAt(lt))
            return s.charAt(st) + Recursive_LPS(s,st+1,lt-1) + s.charAt(lt);

        String a = Recursive_LPS(s,st+1,lt);
        String b = Recursive_LPS(s,st,lt-1);

        //System.out.println(a.length()+"other"+b.length());
        return (a.length() > b.length()) ? a:b ;
    }

    public static int Recursive_Longest_Palindrome(String str,int st, int lt){
        // base case 1: if there is only one character
        if(st==lt)
            return 1;
        // base case 2: If there are 2 characters and both are same
        if (str.charAt(st)== str.charAt(lt) && st+1 == lt){
            return 2;
        }

        // if first and last character matches
        if(str.charAt(st) == str.charAt(lt)){
            return Recursive_Longest_Palindrome(str,st+1,lt-1) +2;
        }

        // if first and last character does not match
        return Math.max(Recursive_Longest_Palindrome(str, st, lt - 1), Recursive_Longest_Palindrome(str, st + 1, lt));


    }
    public static void display(int [][] dp, int n){
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] +"\t");
            }
            System.out.println();
        }
    }

    public static int Palindrome_LCS(String str, int st, int lt){
        int n = str.length();
        int [][] dp = new int [n][n];

        int i,j;
        /* All Sub strings with single character will be a palindrome of size 1 */
        for(int k=0;k<n;k++)
            dp[k][k] = 1;

        for(int cl = 1; cl < n; cl++) {
            for(i=0;i < n - cl; i++){
                j = i + cl;

                System.out.println("i:  "+ i + " and "+ str.charAt(i) + " j: "+ j +" and "+ str.charAt(j));
                if(str.charAt(i) ==str.charAt(j) && cl==1){
                    dp[i][j] = 2;
                }

                else if (str.charAt(i) == str.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;

                }else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
            }
            //display(dp,n);
            //System.out.println("\n\n" );
        }
        display(dp,n);
        return dp[0][n-1];
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);

        String str = in.next();

        //char [] strArr = str.toCharArray();

       // int max = Recursive_Longest_Palindrome(str, 0, str.length() - 1);

        //System.out.println(max);
        /* For Recursive solution, works but you will get TLE */
        /*
        String str_max = Recursive_LPS(str,0,str.length()/2-1);
        String str_2nd_max = Recursive_LPS(str,str.length()/2,str.length()-1);




        //System.out.println("Longest String " + str_max.length() + "2nd largest " + str_2nd_max.length());

        //int product = str_max.length() * str_2nd_max.length();
        */
        int str1_len = Palindrome_LCS(str, 0, str.length() - 1);

        //System.out.println(str.substring(0, str.length() / 2));
        //int str2_len = Palindrome_LCS(str.substring(str.length() / 2 ,str.length()),str.length()/2,str.length());
        //System.out.println(str.substring(str.length()/2,str.length()));

        //System.out.println(str1_len+ "\t" + str2_len);
        //int product = str1_len * str2_len;
        System.out.println(str1_len);

    }

}