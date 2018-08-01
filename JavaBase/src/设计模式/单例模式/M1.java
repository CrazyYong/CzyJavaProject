package 设计模式.单例模式;

/**
 * Created by czy on 2018/7/31.
 * 方式1：饿汉模式
 * 优点：在未调用getInstance() 之前，实例就已经创建了，天生线程安全
 * 缺点：如果一直没有调用getInstance() , 但是已经创建了实例，造成了资源浪费。
 */
public class M1 {

    private static  M1 m1 = new M1();

    private M1(){

    }

    public static M1 getInstance(){

        return m1;
    }
}
