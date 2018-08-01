package 设计模式.单例模式;

/**
 * Created by czy on 2018/7/31.
 * 方式3 用synchronized  加锁同步
 *
 * synchronized修饰的同步块可是要比一般的代码段慢上几倍的！如果存在很多次get()的调用，那性能问题就不得不考虑了！
 *
 * 优点：
    1、满足单线程的单例
    2、满足多线程的单例
 * 缺点：
    1、性能差
 */
public class M3 {
    private static M3 m3;

    private M3(){

    }

    public synchronized static M3 get(){
        if (m3==null){
            m3=new M3();
        }

        return m3;
    }
}
