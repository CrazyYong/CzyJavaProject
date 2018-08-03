package 线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by czy on 2018/8/3.
 * 1.newFixedThreadPool
 * 创建固定大小的线程池。每次提交一个任务,就会启一个线程来接客,直到线程池的线程数量达到线程池的上限。
 */
public class PoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i = 0; i<5; i++) {

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        executorService.shutdown();
    }
}
