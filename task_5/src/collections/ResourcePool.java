package collections;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;


public class ResourcePool implements Executor {

    protected Queue<Runnable> tasks = new ConcurrentLinkedQueue<>();

    protected volatile boolean isWorking = true;

    public ResourcePool(int nThreads) {
        for (int i = 0; i < nThreads; i++) {
            new Thread(new WorkRunner(this)).start();
        }
    }

    @Override
    public void execute(Runnable command) {
        if (isWorking) {
            tasks.offer(command);
        }
    }

    public void stop() {
        isWorking = false;
    }
}