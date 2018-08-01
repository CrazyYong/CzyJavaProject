package 反射;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by czy on 2018/7/31.
 *四种获取成员方法的方法
 * Method getMethod(String name, Class[] params)    根据方法名和参数，返回一个具体的具有public属性的方法
   Method[] getMethods()    返回所有具有public属性的方法数组
   Method getDeclaredMethod(String name, Class[] params)    根据方法名和参数，返回一个具体的方法（不分public和非public属性）
   Method[] getDeclaredMethods()    返回该类中的所有的方法数组（不分public和非public属性）
 */
public class T3 {
    public static void main(String[] args) {

        try {
            //创建类
            Class<?> class1 = Class.forName("反射.Util");

            //获取 nameField 属性
            Field nameField = class1.getDeclaredField( "name" ) ;
            //获取 nameField 的值
            String name_ = (String) nameField.get( nameField ) ;
            //输出值
            System.out.println( name_ );


            //没有返回值，没有参数
            Method getTipMethod1 = class1.getDeclaredMethod( "getTips"  ) ;
            getTipMethod1.invoke( null  ) ;

            //有返回值，没有参数
            Method getTipMethod2 = class1.getDeclaredMethod( "getTip"  ) ;
            String result_2 = (String) getTipMethod2.invoke( null  ) ;
            System.out.println( "返回值： "+ result_2 );

            //没有返回值，有参数
            Method getTipMethod3 = class1.getDeclaredMethod( "getTip" , String.class  ) ;
            String result_3 = (String) getTipMethod3.invoke( null , "第三个方法"  ) ;
            System.out.println( "返回值： "+ result_3 );

            //有返回值，有参数
            Method getTipMethod4 = class1.getDeclaredMethod( "getTip" , int.class ) ;
            String result_4 = (String) getTipMethod4.invoke( null  , 1 ) ;
            System.out.println( "返回值： "+ result_4 );

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace() ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
