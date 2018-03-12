package Reflect;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by cmx on 2018/3/12.
 */
public class Person {
    String name;
    private int age;

    public Person(){
        System.out.println("无参构造器");
    }


     Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @param age  类型用Integer，不用int
     */
    public void setName(String name , int age){
        System.out.println("name: " + name);
        System.out.println("age:"+ age);

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 反射机制获取类有三种方法
     */
    @Test
    public void testGetClass() throws ClassNotFoundException {
        Class clazz = null;

        //1 直接通过类名.Class的方式得到
        clazz = Person.class;
        System.out.println("通过类名: " + clazz);

        //2 通过对象的getClass()方法获取,这个使用的少（一般是传的是Object，不知道是什么类型的时候才用）
        Object obj = new Person();
        clazz = obj.getClass();
        System.out.println("通过getClass(): " + clazz);

        //3 通过全类名获取，用的比较多，但可能抛出ClassNotFoundException异常
        clazz = Class.forName("Reflect.Person");
        System.out.println("通过全类名获取: " + clazz);
    }

    /**
     * Class类的newInstance()方法，创建类的一个对象。
     */
    @Test
    public void testNewInstance()
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class clazz = Class.forName("Reflect.Person");

        //使用Class类的newInstance()方法创建类的一个对象
        //实际调用的类的那个 无参数的构造器（这就是为什么写的类的时候，要写一个无参数的构造器，就是给反射用的）
        //一般的，一个类若声明了带参数的构造器，也要声明一个无参数的构造器
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }


    /**
     * ClassLoader类装载器
     */
    @Test
    public void testClassLoader1() throws ClassNotFoundException, IOException {
        //1、获取一个系统的类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统的类加载器-->" + classLoader);

        //2、获取系统类加载器的父类加载器(扩展类加载器（extensions classLoader）)
        classLoader = classLoader.getParent();
        System.out.println("扩展类加载器-->" + classLoader);

        //3、获取扩展类加载器的父类加载器
        //输出为Null,无法被Java程序直接引用
        classLoader = classLoader.getParent();
        System.out.println("启动类加载器-->" + classLoader);

        //

        //4、测试当前类由哪个类加载器进行加载 ,结果就是系统的类加载器
        classLoader = Class.forName("Reflect.Person").getClassLoader();
        System.out.println("当前类由哪个类加载器进行加载-->"+classLoader);

        //5、测试JDK提供的Object类由哪个类加载器负责加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println("JDK提供的Object类由哪个类加载器加载-->" + classLoader);
    }

    @Test
    public void testGetResourceAsStream() throws ClassNotFoundException, IOException {
//          这么写的话，文件需要放到src目录下
        //       InputStream in = new FileInputStream("test.properties");

        //5、关于类加载器的一个主要方法
        //调用getResourceAsStream 获取类路径下的文件对应的输入流
        InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream("com/java/reflection/test.properties");
        System.out.println("in: " +in);

        Properties properties = new Properties();
        properties.load(in);

        String driverClass = properties.getProperty("dirver");
        String jdbcUrl = properties.getProperty("jdbcUrl");
        //中文可能会出现乱码，需要转换一下
        String user = new String(properties.getProperty("user").getBytes("ISO-8859-1"), "UTF-8");
        String password = properties.getProperty("password");

        System.out.println("diverClass: "+driverClass);
        System.out.println("user: " + user);
    }

    @Test
    public void testMethod() throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("Reflect.Person");

        //1、得到clazz 对应的类中有哪些方法,不能获取private方法
        Method[] methods =clazz.getMethods();
        System.out.print("getMethods: ");
        for (Method method : methods){
            System.out.print(method.getName() + ", ");
        }

        //2、获取所有的方法(且只获取当前类声明的方法，包括private方法）
        Method[] methods2 = clazz.getDeclaredMethods();
        System.out.print("\ngetDeclaredMethods: ");
        for (Method method : methods2){
            System.out.print(method.getName() + ", ");
        }

        //3、获取指定的方法
        Method method = clazz.getDeclaredMethod("setName",String.class);//第一个参数是方法名，后面的是方法里的参数
        System.out.println("\nmethod : " + method);

        Method method2 = clazz.getDeclaredMethod("setName",String.class ,int.class);//第一个参数是方法名，后面的是方法里的参数
        System.out.println("method2: " + method2);

        //4、执行方法！
        Object obj = clazz.newInstance();
        method2.invoke(obj, "changwen", 22);
    }


    /**
     * Field: 封装了字段的信息
     */
    @Test
    public void testField() throws
            ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Class clazz = Class.forName("Reflect.Person");

        //1、获取字段
        //1.1 获取Field的数组,私有字段也能获取
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            System.out.print(field.getName() + ", ");
        }

        //1.2 获取指定名字的Field（如果是私有的，见下面的4)
        Field field = clazz.getDeclaredField("name");
        System.out.println("\n获取指定Field名=: " + field.getName());

        Person person = new Person("ABC", 12);
        //2、获取指定对象的Field的值
        Object val = field.get(person);
        System.out.println("获取指定对象字段'name'的Field的值=： " + val);

        //3、设置指定对象的Field的值
        field.set(person, "changwen2");
        System.out.println("设置指定对象字段'name'的Field的值=: " + person.name);

        //4、若该字段是私有的，需要调用setAccessible(true)方法
        Field field2 = clazz.getDeclaredField("age");
        field2.setAccessible(true);
        System.out.println("获取指定私有字段名=: " + field2.getName());
    }
}
