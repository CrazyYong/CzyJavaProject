package 设计模式.单例模式;

/**
 * Created by czy on 2018/7/31.
 * 方式5 volatile 关键字，解决双重校验带来的弊端
 *
 * 假设没有关键字volatile的情况下，两个线程A、B，都是第一次调用该单例方法，线程A先执行 m5 = new M5()，
 * 该构造方法是一个非原子操作，编译后生成多条字节码指令，由于JAVA的指令重排序，可能会先执行 m5 的赋值操作，
 * 该操作实际只是在内存中开辟一片存储对象的区域后直接返回内存的引用，之后 m5 便不为空了，但是实际的初始化操作却还没有执行，
 * 如果就在此时线程B进入，就会看到一个不为空的但是不完整
 * （没有完成初始化）的 M5对象，所以需要加入volatile关键字，禁止指令重排序优化，从而安全的实现单例。
 *
 * 补充：看了图片加载框架 Glide (3.7.0版) 源码，发现glide 也是使用volatile 关键字的双重校验实现的单例，可见这种方法是值得信赖的
 */
public class M5 {
    private static volatile M5 m5=null;

    private M5(){

    }

    public static M5 getInstance(){
        if (m5==null){
            synchronized (M5.class){
                if(m5==null){
                    m5=new M5();
                }
            }
        }

        return m5;
    }
}
