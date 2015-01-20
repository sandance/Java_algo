import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nazmul on 1/13/15.
 */
public class IP_converter {

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

        /**
         * validates the ip address , 1 for success , 0 for invalid ip address
         * @param ip
         * @return flag
         */
        public static int validator(String ip){
            String regex = "\\b((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)(\\.)){3}(25[0-5]|[0-4]\\d|[01]?\\d\\d?)\\b";

            if(Pattern.matches(regex, ip)){
                return 1;
            }else
                return 0;
        }

        public static void IP_Converter(String ip){
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(ip);

            long sum =0,i=3;
            while(matcher.find()){
                sum += Integer.parseInt(matcher.group())*Math.pow(256,i--);


                //i--;
                //System.out.println(Integer.parseInt(matcher.group())*Math.pow(256,i--));
            }
            System.out.println(sum);
        }

        public static void main(String[] args) throws IOException {
            Scanner in = new Scanner();
            PrintWriter out = new PrintWriter(System.out);

            String str = in.next();

        /*
         String str1 = "123.123.123.456";
         String str2 = "blahbah";
         String str3 = "10.255.211.10";
         */

            int flag = validator(str);

            //System.out.println(flag);


            if(flag==1){
            /* valid */

                IP_Converter(str);
            }else {
                System.out.println ("Unable to convert");
            }


        }

}

