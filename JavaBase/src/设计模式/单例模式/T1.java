package 设计模式.单例模式;

/**
 * Created by czy on 2018/7/31.
 *
 * 总结：

 1、上面的7中方法，都实现了某种程度的单例，各有利弊，根据使用的场景不同，需要满足的特性不同，选取合适的单例方法才是正道。

 2、对线程要求严格，对资源要求不严格的推荐使用：1    饿汉式

 3、对线程要求不严格，对资源要求严格的推荐使用：2    懒汉式

 4、对线程要求稍微严格，对资源要求严格的推荐使用：4  双重加锁

 5、同时对线程、资源要求非常严格的推荐使用：5 、 6
 */
public class T1 {

    public static void main(String[] args) {
/**
 * 方式2 （懒汉式）
 * 这种模式，可以做到单例模式，但是只是在单线程中是单例的，如果在多线程中操作，可能出现多个实例。
 * 测试：启动20个线程，然后在线程中打印 M2 实例的内存地址
 */
        for ( int i = 0 ;  i < 40 ; i ++ ) {
            new Thread( new Runnable() {

                @Override
                public void run() {
                    System.out.println( M2.get().hashCode() );
                }
            }).start();

        }

    }
}
