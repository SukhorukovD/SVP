package collections;

public class WorkRunner implements Runnable {

    private ResourcePool parentThread;

    public WorkRunner(ResourcePool parentThread){
        this.parentThread = parentThread;
    }

    @Override
    public void run() {
        while (parentThread.isWorking) {
            Runnable nextTask = parentThread.tasks.poll();
            if (nextTask != null) {
                nextTask.run();
            }
        }
    }
}