package 设计模式.单例模式;

/**
 * Created by czy on 2018/7/31.
 * 测试 方式7 枚举获取
 */
public class T2 {
    public static void main(String[] args) {
 for(int i=0;i<20;i++){
     new Thread(new Runnable() {
         @Override
         public void run() {

             System.out.println(M7.INSTANCE.hashCode());
         }
     }).start();
 }
    }
}
