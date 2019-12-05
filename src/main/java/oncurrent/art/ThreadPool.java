package oncurrent.art;

/**
 * @Author: guodong
 * @Date: 2019/2/17
 */
public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);
    void shutdown();
    void addWorkers(int num);
    void removeWorker(int num);
    int getJobSize();
}
