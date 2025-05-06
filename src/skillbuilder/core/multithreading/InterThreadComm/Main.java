package skillbuilder.core.multithreading.InterThreadComm;

public class Main {
    public static void main(String[] args) {
        SharedQueue shared = new SharedQueue();
        Producer producer = new Producer(shared);
        Consumer consumer = new Consumer(shared);

        producer.start();
        consumer.start();
    }
    /*
    OUTPUT:
Produced: 0
Consumed: 0
Produced: 1
Consumed: 1
Produced: 2
Produced: 3
Consumed: 2
Produced: 4
Consumed: 3
Produced: 5
Produced: 6
Consumed: 4
Produced: 7
Consumed: 5
Produced: 8
Produced: 9
Consumed: 6
Consumed: 7
Consumed: 8
Consumed: 9
     */
}
