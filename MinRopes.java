import java.util.*;

public class Main {
    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int A[] = {5,17,100,11};
        
        for(int i=0;i<A.length;i++) pq.add(A[i]);
        
        int cost = 0;
        
        
        while(pq.size()>1) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            cost += min1 + min2;
            pq.add(min1 + min2);
        }
        
        System.out.println(cost);
        
    }
}
