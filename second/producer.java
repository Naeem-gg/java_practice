class producer {
    public static void main(String args[]) {
        SyncProcess p = new SyncProcess();
        // an instance of parallel is created
        new Producer(p);
        // Run the thread for producer
        new Consumer(p);
        // Run consumer thread
    }
}
class SyncProcess {
    int n;
    boolean flag = false;

    // PRODUCER
    synchronized void put(int n) {
        if (flag) {
            // Entry
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.n = n;
        System.out.println("Producer:" + n); // Critical Section
        flag = true;
        notify(); // Exit from the
        // critical section
    }

    // ICONSUMER
    synchronized int get() {
        // Consume a value
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Consumer :" + n);
        flag = false;
        // Exit from the
        notify();
        return (n);
        // critical
    }
}

class Producer implements Runnable {
    SyncProcess p;

    Producer(SyncProcess p) {
        this.p = p;
        new Thread(this).start();
    }

    public void run() {
        // infinite running thread for Producer
        int i = 0;
        while (true)
            p.put(i++);
    }
}

class Consumer implements Runnable {
    // Thread for consumer process
    SyncProcess p;

    Consumer(SyncProcess p) {
        // Constructor
        this.p = p;
        new Thread(this).start();
    }

    public void run() {
        // infinite running thread for Consumer
        while (true)
            p.get();
    }
}
