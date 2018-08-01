package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by czy on 2018/7/31.
 * Class类提供了四个public方法，用于获取某个类的构造方法。
 * Constructor getConstructor(Class[] params)     根据构造函数的参数，返回一个具体的具有public属性的构造函数
   Constructor getConstructors()     返回所有具有public属性的构造函数数组
   Constructor getDeclaredConstructor(Class[] params)     根据构造函数的参数，返回一个具体的构造函数（不分public和非public属性）
   Constructor getDeclaredConstructors()    返回该类中所有的构造函数数组（不分public和非public属性）
 */
public class T4 {
    public static void main(String[] args) {
     //创建类
        try {
            //创建类
            Class<?> class1=Class.forName("反射.Student");

            //无参构造函数
            Object object = class1.newInstance();

            //有参构造函数：一个参数
            Constructor<?> constructor =class1.getDeclaredConstructor(String.class);
            constructor.newInstance("1000");

            //有参构造函数：两个参数
            Constructor<?> constructor2=class1.getDeclaredConstructor(String.class,String.class);
            constructor2.newInstance("1001","jack");



        } catch (InstantiationException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
