package 设计模式.单例模式;

/**
 * Created by czy on 2018/7/31.
 * 方式4 改进性能  双重校验
 *
 * 首先判断m4 是不是为null，如果为null，加锁初始化；如果不为null，直接返回 m4 。整个设计，进行了双重校验。
 *
 * 优点：

    1、满足单线程单例

    2、满足多线程单例

    3、性能问题得以优化

 缺点：
    1、第一次加载时反应不快，由于java内存模型一些原因偶尔失败
 */
public class M4 {
    private static M4 m4;

    private M4(){

    }

    public static M4 get(){
        if(m4==null){
            synchronized (M4.class){
                if (m4==null){
                    m4=new M4();
                }
            }
        }

        return m4;
    }
}
