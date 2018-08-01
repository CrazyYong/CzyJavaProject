package 多线程;

/**
 * Created by czy on 2018/8/1.
 */
public class Person {

    static Person person;

    /**
     * 类锁
     */
    public void run1(){
        synchronized (Person.class){
            System.out.println(Thread.currentThread().getName()+"11-->"+"a");
        }
    }

    /**
     * 类锁
     * 静态方法锁，是类锁
     */

    public synchronized static void run11(){

    }

    /**
     * 类锁
     */
    public static void run(){
        synchronized (Person.class){

        }
    }

    /**
     * 对象锁
     */
    public void run2(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+ "  22-->  " + "a" );
        }
    }

    /**
     * 对象锁
     * 普通方法锁是对象锁
     */
    public synchronized void run3(){
        System.out.println( Thread.currentThread().getName()  + "  33-->  " + "a" );
    }


}
