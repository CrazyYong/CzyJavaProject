package DesignMode;

/**
 * Created by czy on 2018/4/4.
 * 单例 饿汉模式
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    public static Singleton getInstance()
    {
        return instance ;
    }
}
