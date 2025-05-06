package skillbuilder.core.multithreading.InterThreadComm;

class Producer extends Thread {
    private SharedQueue shared;

    public Producer(SharedQueue shared) {
        this.shared = shared;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                shared.produce(i);
                Thread.sleep(100); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
