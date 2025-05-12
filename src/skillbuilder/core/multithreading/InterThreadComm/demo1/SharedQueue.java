package skillbuilder.core.multithreading.InterThreadComm.demo1;

import java.util.LinkedList;
import java.util.Queue;

class SharedQueue {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // wait if queue is full
        }
        queue.add(value);
        System.out.println("Produced: " + value);
        notify(); // notify waiting consumers
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // wait if queue is empty
        }
        int value = queue.poll();
        System.out.println("Consumed: " + value);
        notify(); // notify waiting producers
        return value;
    }
}
