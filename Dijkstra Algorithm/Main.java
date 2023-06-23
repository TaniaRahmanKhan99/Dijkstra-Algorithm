package Default;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void case2(String file_loc) {
        Scanner sc = open_file(file_loc);
        if (sc == null) System.exit(1);

        int n, m, x, q;
        int[][] graph;

        while (sc.hasNext()) {
            n = sc.nextInt();
            // System.out.println(n); // test line
            m = sc.nextInt();
            // System.out.println(m); // test line
            x = sc.nextInt();
            // System.out.println(x); // test line
            q = sc.nextInt();
            // System.out.println(q); // test line
            graph = new int[m][m];
        }
    }

    public static void case1(String file_loc) {
        Scanner sc = open_file(file_loc);
        if (sc == null) System.exit(1);

        int n, m, x, q;
        int[][] graph;

        while (sc.hasNext()) {
            n = sc.nextInt();
            // System.out.println(n); // test line
            m = sc.nextInt();
            // System.out.println(m); // test line
            x = sc.nextInt();
            // System.out.println(x); // test line
            q = sc.nextInt();
            // System.out.println(q); // test line
            graph = new int[m + 1][m + 1];

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                // System.out.println(u); // test line
                int v = sc.nextInt();
                // System.out.println(v); // test line
                int w = sc.nextInt();
                // System.out.println(w); // test line

                graph[u][v] = w;
                graph[v][u] = w;
            }

//       print_graph(graph); // test line

            for (int i = 0; i < q; i++) {
                int source = sc.nextInt();
                // System.out.println(source); // test line
                int target = sc.nextInt();
                // System.out.println(target); // test line

                Dijkstra d = new Dijkstra(graph);
                int[] dist = d.dijkstra(source);
                System.out.println("min dist: " + dist[target]);
//
//        int[] parent = d.get_parent();
//        // System.out.println("parent: " + Arrays.toString(parent));
//
//        int path = short_path(dist, parent, source, target);
//        System.out.println(path);
            }
        }
    }

    public static int short_path(int[] d, int[] p, int s, int t) {
        if (t == s) return d[t];
        return d[t] + short_path(d, p, s, p[t]);
    }

    public static void print_graph(int[][] g) {
        for (int i = 0; i < g.length; i++) {
            System.out.println(Arrays.toString(g[i]));
        }
    }

    public static Scanner open_file(String fl) {
        try {
            Scanner sc = new Scanner(new File(fl));
            return sc;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {

        System.out.println("Case 1:");

        // for PC location
        String file_loc = "C:\\Users\\Alimus Sifar\\Documents\\IntelliJ IDEA Projects\\Java\\src\\Default\\input.txt";
        // for android location
//    String file_loc = "/storage/emulated/0/JavaNIDE/Java/app/src/main/java/Default/input.txt";
        case1(file_loc);

        System.out.println("Case 2:");

        // for PC location
        // String file_loc = "C:\\Users\\Alimus Sifar\\Documents\\IntelliJ IDEA
        // Projects\\Java\\src\\Default\\input2.txt";
        // for android location
        // String file_loc = "/storage/emulated/0/JavaNIDE/Java/app/src/main/java/Default/input2.txt";
        case2(file_loc);
    }
}
