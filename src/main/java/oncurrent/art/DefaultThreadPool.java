package oncurrent.art;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: guodong
 * @Date: 2019/2/17
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    private static final int MAX_WORKER_NUMBERS = 10;
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    private static final int MIN_WORKER_NUMBERS = 1;

    private final LinkedList<Job> jobs = new LinkedList<>();
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    private int workNumber = DEFAULT_WORKER_NUMBERS;
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        workNumber = num > MAX_WORKER_NUMBERS?MAX_WORKER_NUMBERS:num<MIN_WORKER_NUMBERS?MIN_WORKER_NUMBERS:num;
        initializeWorkers(workNumber);
    }

    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    @Override
    public void execute(Job job) {
        if(job != null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    public void shutdown() {
        for(Worker worker:workers){
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs){
            if( (num+this.workNumber)>MAX_WORKER_NUMBERS ){
                num = MAX_WORKER_NUMBERS - this.workNumber;
            }
            initializeWorkers(num);
            this.workNumber += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if(num>=this.workNumber){
                throw new IllegalArgumentException("beyond workNum");
            }
            int count = 0;
            while(count < num){
                Worker worker = workers.get(1);
                if(workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
            this.workNumber -= count;
        }
    }


    @Override
    public int getJobSize() {
        return jobs.size();
    }

    //消费任务
    class Worker implements Runnable {

        private volatile boolean running = true;


        @Override
        public void run() {
            while(running){
                Job job = null;
                synchronized (jobs){
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if(job != null ){
                    try {
                        job.run();
                    } catch (Exception e) {
                        //忽略Job执行中的Exception
                    }
                }
            }
        }

        public void shutdown(){
            this.running = false;
        }
    }
}
