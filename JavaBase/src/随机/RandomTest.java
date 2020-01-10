package 随机;
import java.util.Arrays;
import java.util.Random;

/**
 * 随机
 */
public class RandomTest {
    public static void main(String[] args) {
        /**
         * Math.random
         * 其实内部事调用了Random类的静态方法 newxDouble()
         * Java中，对随机最基本的支持是Math类中的静态方法random，它生成一个0到1的随机数，类型为double，包括0但不包括1，比如，随机生成并输出3个数：
         */
        for (int i = 0; i < 3; i++) {
            System.out.println(Math.random());
        }

        /**
         * Random
         * 基本用法
         * Random类提供了更为丰富的随机方法，它的方法不是静态方法，使用Random，先要创建一个Random实例，看个例子：
         */
        /*
         * nextInt()产生一个随机的int，可能为正数，也可能为负数，nextInt(100)产生一个随机int，范围是0到100，包括0不包括100。
         * */
        Random rnd = new Random();
        System.out.println(rnd.nextInt());
        System.out.println(rnd.nextInt(100));

        /*
        * 随机生成一个long
            public long nextLong()
            随机生成一个boolean
            public boolean nextBoolean()
            产生随机字节
            public void nextBytes(byte[] bytes)
            随机产生的字节放入提供的byte数组bytes，字节个数就是bytes的长度。
            产生随机浮点数，从0到1，包括0不包括1
            public float nextFloat()
            public double nextDouble()
        * */

        /*
        * 设置种子
        * 除了默认构造方法，Random类还有一个构造方法，可以接受一个long类型的种子参数：
            public Random(long seed)
            种子决定了随机产生的序列，种子相同，产生的随机数序列就是相同的。看个例子：
            *
            * 种子为20160824，产生5个0到100的随机数，输出为：
                69 13 13 94 50
                *
                * 我们需要知道的基本原理是，随机数基于一个种子，种子固定，随机数序列就固定，默认构造方法中，种子是一个真正的随机数。
        * */
        Random rnd1 = new Random(20160824);
        for(int i=0;i<5;i++){
            System.out.print(rnd1.nextInt(100)+" ");
        }

        /*
        * 随机密码
        * 随即生成6位数密码
        * */
        System.out.println(randomPassword());

    }

    public static String randomPassword(){
        char[] chars = new char[6];
        Random rnd = new Random();
        for(int i=0; i<6; i++){
            chars[i] = (char)('0'+rnd.nextInt(10));
        }
        return new String(chars);
    }
}
