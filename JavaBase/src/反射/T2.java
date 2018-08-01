package 反射;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by czy on 2018/7/31.
 *四种获取成员属性的方法
 *Field getField(String name)    根据变量名，返回一个具体的具有public属性的成员变量
  Field[] getFields()    返回具有public属性的成员变量的数组
  Field getDeclaredField(String name)    根据变量名，返回一个成员变量（不分public和非public属性）
  Field[] getDelcaredField()    返回所有成员变量组成的数组（不分public和非public属性）
 */
public class T2 {

    public static void main(String[] args){
        try {
            //创建类
            Class<?> class1 = Class.forName("反射.Person");

            //创建实例
            Object person=class1.newInstance();

            //获得id属性
            Field idField = class1.getDeclaredField("id");

            //打破封装  实际上setAccessible是启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问
            //由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的
            idField.setAccessible( true );

            //给id属性赋值
            idField.set(person,"100");

            //获取setName()方法
            Method setName=class1.getDeclaredMethod("setName", String.class);
            //打破封装
            setName.setAccessible(true);

            //调用setName方法
            setName.invoke(person,"jack");

            //获取name字段
            Field nameField = class1.getDeclaredField("name");
            //打破封装
            nameField.setAccessible(true);

            //打印person的id值
            String id_=(String)idField.get(person);
            System.out.println("id: " + id_ );

            //打印person的name值
            String name_=(String)nameField.get(person);
            System.out.println("name:"+name_);

            //获取getName方法
            Method getName=class1.getDeclaredMethod("getName");
            //打破封装
            getName.setAccessible(true);

            //执行getName方法，并且接受返回值
            String name_2=(String)getName.invoke(person);
            System.out.println("name2:"+name_2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (NoSuchFieldException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
