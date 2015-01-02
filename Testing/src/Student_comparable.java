import java.io.*;
import java.util.*;



class Student implements Comparable<Student>{
    String id;
    String name;
    Double cgpa;

    public Student(String studentId, String studentName, double studentCGPA){
        id = studentId;
        name = studentName;
        cgpa = studentCGPA;

    }

    public String toString() {
        return "\n" + id + "\t" +name +"\t" +cgpa;
    }

    public int compareTo(Student that){
        return this.id.compareTo(that.id);
    }
}

public class Student_comparable {

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

        Student [] students = {
                                new Student("cs011", "Lennon ", 3.1),
                                new Student("cs021", "McCartney", 3.4),
                                new Student("cs012", "Harrison ", 2.7),
                                new Student("cs022", "Starr ", 3.7 )};

        System.out.println("Before sorting by student ID");
        System.out.println("Student-ID \t Name \t CGPA (for 4.0) ");

        System.out.println(Arrays.toString(students));

        Arrays.sort(students);

        System.out.println("After sorting by student ID");
        System.out.println("Student-ID \t Name \t CGPA (for 4.0) ");
        System.out.println(Arrays.toString(students));

    }

}