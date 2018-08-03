package 线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by czy on 2018/8/3.
 * 2.newScheduledThreadPool
 *  创建一个大小不受限的线程池。提供定时、周期地执行任务能力。
 */
public class PoolDemo4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(2);

        for (int i = 0; i < 5; i++) {

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
