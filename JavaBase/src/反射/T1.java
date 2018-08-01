package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by czy on 2018/7/31.
 * 三种初始化方式
 */
public class T1 {
    public static void main(String[] args){
        //第一种方法
        try {
            Class<?> class1=Class.forName("反射.Person");
            System.out.println(class1);

            //获取所有的公共方法:getMethods
            Method[] methods=class1.getMethods();
            for (Method method:methods){
                System.out.println(method);
            }


            //获取所有实现的接口:getInterface()
            Class<?>[] class4=class1.getInterfaces();
            for(Class<?> iner:class4){
                System.out.println(iner);
            }

            //获取父类:getSuperclass()
            Class<?> superClasss=class1.getSuperclass();
            System.out.println(superClasss);


            //获取所有构造函数:getConstructors()
            Constructor<?>[] constructors =class1.getConstructors();
            for(Constructor<?> constructor:constructors){
                System.out.println(constructor);
            }

            /**
             * 获取所有属性:getDeclareFields()
             * getDeclaredFields()获得某个类的所有申明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
             */
            Field[] fields = class1.getDeclaredFields();
            for (Field field:fields){
                System.out.println(field);
            }

            /**
             * getFields()获得某个类的所有的公共（public）的字段，包括父类。
             */

            Field[] fields1 = class1.getFields();
            for (Field field:fields1){
                System.out.println(field);
            }


            try {
                //创建实例化:相当于new了一个对象
                Object object =class1.newInstance();

                //向下转型 通过反射，获取对象实例，并且操作对象的方法
                Person person =(Person)object;
                person.setId("100");
                person.setName("cpsir");
                System.out.println("id: " + person.getId() + " name: " + person.getName()  );

                //获取id属性
                Field idField = class1.getDeclaredField("id");

                //id这个属性是私有的
                //打破封装  实际上setAccessible是启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问
                //由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的
                idField.setAccessible( true );

                //给id属性赋值
                idField.set(person,"100");

                //打印pseron的属性值
                System.out.println(idField.get(person));



            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //第二种方法
        Class<?> class2=Person.class;

        //第三种方法
        Person person=new Person();
        Class<?> class3=person.getClass();

        System.out.println(class2);
        System.out.println(class3);
    }
}
