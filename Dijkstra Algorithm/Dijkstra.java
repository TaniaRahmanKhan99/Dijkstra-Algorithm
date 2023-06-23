package Default;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
  int[][] G;
  int[] distance;
  int[] parent;
  String[] color;

  public Dijkstra(int[][] G) {
    this.G = G;

    distance = new int[G.length];
    parent = new int[G.length];
    color = new String[G.length];

    for (int i = 0; i < distance.length; i++) {
      distance[i] = 9999999;
      parent[i] = -1;
      color[i] = "white";
    }
  }

  public int min_dist(PriorityQueue<Integer> pq) {
    if (pq.size() == 1) return pq.remove();

    // System.out.println(pq.toString() + ": " + pq.size());
    Object[] queue_array = pq.toArray();
    // System.out.println(Arrays.toString(queue_array));

    int index = -1;
    int min_val = 9999999;
    for (int i = 0; i < queue_array.length; i++) {
      if (min_val > distance[(int) queue_array[i]]) {
        min_val = distance[(int) queue_array[i]];
        index = (int) queue_array[i];
      }
    }
    pq.remove(index);
    return index;
  }

  public int[] get_parent() {
    return parent;
  }

  public int[] dijkstra(int start) {
    distance[start] = 0;
    parent[start] = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(start);
    color[start] = "grey";

    while (!pq.isEmpty()) {
      int u = min_dist(pq);
      // System.out.println("visiting: " + u); // test line

      for (int v = 1; v < G.length; v++) {
        if (G[u][v] > 0) {
          if (distance[v] > G[u][v] + distance[u]) {
            distance[v] = G[u][v] + distance[u];
            parent[v] = u;
          }

          if (color[v].equals("white")) {
            pq.add(v);
            color[v] = "grey";
          }
        }
      }
      color[u] = "black";
    }

     System.out.println(Arrays.toString(distance)); // test line
    // System.out.println(Arrays.toString(parent)); // test line
    // System.out.println(Arrays.toString(color)); // test line

    return distance;
  }
}
