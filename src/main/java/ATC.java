import java.util.concurrent.ConcurrentLinkedQueue;

public class ATC {
    private static ATC instance;
    private volatile ConcurrentLinkedQueue<String> queue;

    public ATC() {
        queue = new ConcurrentLinkedQueue<>();
    }

    public static ATC getInstance() {
        if (instance == null) {
            instance = new ATC();
        }
        return instance;
    }

    public String getCall() {
        return queue.poll();
    }

    public void addCall(String call) {
        queue.add(call);
    }

    public int getCallLeft() {
        return queue.size();
    }
}

