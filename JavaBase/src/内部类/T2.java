package 内部类;

/**
 * Created by czy on 2018/8/3.
 * 2静态内部类
 * Java中的静态内部类在构造的时候并不需要外部类的引用，
 * 因此静态的内部类不会持有外部类的引用，并且静态内部类只能访问外部类的静态成员变量和方法。
 */
public class T2 {
    /**
     * @param args
     */
    public  int k=3;
    private static String string="Java";
    protected float j=1.5f;

    public static void show(){
        System.out.println("show");
    }
    private void add(){
        System.out.println("add");
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        //Child c = t2.new Child();//非法
        Child c = new Child();
        c.test();
    }


    static class Child{
        public int i;

        public void test(){
//            System.out.println("k=:"+k);//不能访问外部类非静态变量
            System.out.println("string:"+string);
            //add(); //不能访问外部类的非静态方法
//            System.out.println("j=:"+j);
            show();
        }
    }
}
/**
 * Java的非静态内部类的这种创建方式，会隐式地持有外部类的引用，
 * 而且默认情况下这个引用是强引用，因此，如果内部类的生命周期长于外部类的生命周期，
 * 程序很容易就产生内存泄漏（你认为垃圾回收器会回收掉外部类的实例，但由于内部类持有外部类的引用，导致垃圾回收器不能正常工作）。
 * 为了避免这种情况的发生，
 * 你可以在内部类的内部显示持有一个外部类的软引用(或弱引用)，并通过构造方法的方式传递进来，在内部类的使用过程中，先判断一下外部类是否被回收
 **/