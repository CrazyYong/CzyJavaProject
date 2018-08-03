package 线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by czy on 2018/8/3.
 * 2.newSingleThreadExecutor
 *  创建只有一个线程的线程池。问题来了, 一个线程的线程池和普通创建一个线程一样么？当然不一样.线程销毁问题。
 */
public class PoolDemo3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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
