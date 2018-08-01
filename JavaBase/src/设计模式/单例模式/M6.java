package 设计模式.单例模式;

/**
 * Created by czy on 2018/7/31.
 * 方式6 静态内部类
 *
 * 优点：
   1、资源利用率高，不执行getInstance()不被实例，可以执行该类其他静态方法
 */
public class M6 {

    private M6(){

    }

    private static class M6Holder{
        /**
         * 静态初始化器,由JVM来保证线程的安全
         */
        private static M6 m6 = new M6();
    }

    public static M6 getInstance(){

        return M6Holder.m6;
    }
}
