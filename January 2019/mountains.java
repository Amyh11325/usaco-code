import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mountains {
    static class P implements Comparable<P> {
        int x, y;

        P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(P o) {
            return o.y -  o.x - (y - x) ;
        }
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
        int m = Integer.parseInt(in.readLine());
        int ans = m;
        P[] graph = new P[m];
        int maxY = 0;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[i] = new P(x, y);
            maxY = y > maxY ? y : maxY;
        }
        Arrays.sort(graph);
        int cur = 0;
        //System.out.println(Arrays.toString(graph));

        for(int i = 1; i < graph.length; i++) {
            int dx = Math.abs(graph[cur].x - graph[i].x);
            if (graph[cur].y - dx >= graph[i].y) {
                ans--;
            } else {
                cur = i;
            }
        }
        out.println(ans);
        out.close();

    }
}
        /*int cur = 0;
        while(graph[cur].y != maxY) {
            cur++;
        }
        int highestM = cur;*/

/*        for (int i = 0; i < )

        for (int i = highestM - 1; i >= 0 ; i--) {
            int dx = graph[cur].x - graph[i].x;
            if (graph[cur].y - dx >= graph[i].y) {
                ans--;
            } else {
                cur = i;
            }
        }
        cur = highestM;
        for (int i = highestM + 1; i < m ; i++) {
            int dx = graph[i].x - graph[cur].x;
            if (graph[cur].y - dx >= graph[i].y) {
                ans--;
            } else {
                cur = i;
            }
        }
        out.println(ans);
        out.close();*/


/*import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mountains {
    private static int ans;

    static class P implements Comparable<P>{
        int x, y;
        P (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(P o) {
            return x - o.x;
        }
    }
    public static void removeM (P[] graph, int highestM, int beg, int end) {

        int cur = highestM;


        for (int i = highestM - 1; i >= beg ; i--) {
            int dx = graph[cur].x - graph[i].x;
            if (graph[cur].y - dx <= 0) {
                int highestI = 0;
                for (int j = i; j >= 0; j--) {
                    highestI = 0;
                    if (graph[highestI].y < graph[j].y)
                        highestI = j;
                }
                removeM(graph, highestI, beg, i);
                break;
            }
            if (graph[cur].y - dx >= graph[i].y) {
                ans--;
            } else {
                cur = i;
            }
        }
        cur = highestM;
        for (int i = highestM + 1; i < end ; i++) {
            int dx = graph[i].x - graph[cur].x;
            if (graph[cur].y - dx <= 0) {
                int highestI = 0;
                for (int j = i; j >= 0; j--) {
                    highestI = 0;
                    if (graph[highestI].y < graph[j].y)
                        highestI = j;
                }
                removeM(graph, highestI, i + 1, end);
                break;
            }
            if (graph[cur].y - dx >= graph[i].y) {
                ans--;
            } else {
                cur = i;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("out.txt")));
        int m = Integer.parseInt(in.readLine());
        ans = m;
        P[] graph = new P[m];
        int maxY = 0;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[i] = new P(x, y);
            maxY = y > maxY? y: maxY;
        }
        Arrays.sort(graph);
        int cur = 0;
        while(graph[cur].y != maxY) {
            cur++;
        }
        int highestM = cur;
        removeM(graph, highestM, 0, m);
        /*for (int i = highestM - 1; i >= 0 ; i--) {
            int dx = graph[cur].x - graph[i].x;
            if (graph[cur].y - dx <= 0) {
                for (int j = i; j >= 0; j--) {
                    int highest
                }
            }
            if (graph[cur].y - dx >= graph[i].y) {
                ans--;
            } else {
                cur = i;
            }
        }
        cur = highestM;
        for (int i = highestM + 1; i < m ; i++) {
            int dx = graph[i].x - graph[cur].x;
            if (graph[cur].y - dx >= graph[i].y) {
                ans--;
            } else {
                cur = i;
            }
        }
        System.out.println(ans);
        out.close();
    }
}*/
