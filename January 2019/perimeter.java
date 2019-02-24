import java.awt.*;
import java.io.*;
import java.util.*;

public class perimeter {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Status {
        Point pos = new Point (0, 0);
        int perim;
        int area;
        Status (int x, int y, int perim, int area) {
            pos.x = x;
            pos.y = y;
            this.perim = perim;
            this.area = area;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        int n = Integer.parseInt(in.readLine());
        Queue<Status> q = new LinkedList<>();
        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '.')
                    map[i][j] = false;
                else
                    map[i][j] = true;
            }
        }
        int largestA = 0, largestP = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j]) {
                    q.add(new Status(i, j, 0, 1));
                    visited[i][j] =true;
                    int p = 0;
                    int a = 1;
                    while(!q.isEmpty()) {
                        Status cur = q.remove();
                      /*  for (int k = 0; k < 4; k++) {
                            if (cur.pos.x + dx[k] < 0 || cur.pos.x + dx[k] >= n || cur.pos.y + dy[k] < 0 || cur.pos.y + dy[k] >=n || !map[cur.pos.x + dx[k]][cur.pos.y + dy[k]])
                                p++;
                        }*/
                      //  boolean added = false;
                        for (int k = 0; k < 4; k++) {
                            Status next = new Status(cur.pos.x + dx[k], cur.pos.y + dy[k], cur.perim, cur.area++); // p of new space not included, area included
                            if (next.pos.x < 0 || next.pos.x >= n) {
                                p++;
                                continue;
                            }
                            if (next.pos.y < 0 || next.pos.y >= n) {
                                p++;
                                continue;
                            }
                            if (visited[next.pos.x][next.pos.y])
                                continue;
                            if (!map[next.pos.x][next.pos.y]) {
                                p++;
                                continue;
                            }
                           // added = true;
                            a++;
                            visited[next.pos.x][next.pos.y] = true;
                            q.add(next);
                        }
                        if (q.size() == 0) {
                            if (a > largestA) {
                                largestA = a;
                                largestP = p;
                            } else if (a == largestA && p < largestP) {
                                largestP = p;
                            }
                        }
                    }
                }
            }
        }
        out.println(largestA + " " + largestP);
        out.close();
    }
}
