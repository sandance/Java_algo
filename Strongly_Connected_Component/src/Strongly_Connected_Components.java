
import java.io.IOException;
import java.io.*;




public class Strongly_Connected_Components {


    public static int sum(int a, int b){
        return a + b;
    }

    public static  void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);


        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int result = sum(n,m);
        System.out.println(result);



    }
}