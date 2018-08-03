package 线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by czy on 2018/8/3.
 * 2.newScheduledThreadPool
 *  创建一个大小不受限的线程池。提供定时、周期地执行任务能力。
 *  定时周期执行
 */
public class PoolDemo5 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        long initialDelay = 1, delay = 1;

        // 应用启动1S后,每隔1S执行一次

        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, initialDelay, delay, TimeUnit.SECONDS);

        // 应用启动1S后,每隔2S执行一次
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, initialDelay, delay, TimeUnit.SECONDS);
    }
}


