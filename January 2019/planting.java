import java.io.*;
import java.util.StringTokenizer;

public class planting {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("planting.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
        int n = Integer.parseInt(in.readLine());
        int[] numConnect = new int[n];
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            numConnect[Integer.parseInt(st.nextToken())- 1] ++;
            numConnect[Integer.parseInt(st.nextToken())- 1] ++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, numConnect[i]);
        }
        if (n < 3) {
            out.println(n);
        } else {
            out.println(max + 1);
        }
        out.close();
    }
}
