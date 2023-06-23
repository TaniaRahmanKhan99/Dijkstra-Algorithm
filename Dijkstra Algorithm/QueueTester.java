package Default;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTester {

  public static void main(String[] args) {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(20);
    pq.add(14);
    pq.add(5);
    pq.remove();
    pq.remove();
    pq.add(2);
    pq.remove();
    pq.add(10);
    
    System.out.println(pq.toString());
    
    
    Queue<Integer> q = new LinkedList<>();
    q.add(20);
    q.add(14);
    q.add(5);
    q.remove();
    q.remove();
    q.add(2);
    q.remove();
    q.add(10);

    System.out.println(q.toString());
  }
}
