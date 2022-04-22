package queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: yangbo
 * @Date: 2022-04-21-16:24
 * @Description:  queue  deque
 */
public class QueueDeque {
    
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();   
        queue.add(1);
        queue.add(2);
        queue.add(3);
        
        queue.remove();
        
        AtomicInteger integer = new AtomicInteger(1);
        
    }
}
