package 内部类;

/**
 * Created by czy on 2018/8/3.
 * 非静态内部类
 * Java的非静态内部类在构造的时候，会将外部类的引用传递进来，并且作为内部类的一个属性，
 * 因此，内部类会隐式地持有其外部类的引用。
 * 也就是非静态内部类在构造的时候需要有一个外部类的实例传递进来进行构造，不能像普通的Java类那样直接就可以通过 new来生成
 */
public class T1 {
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
       T1 t1 = new T1();
       //合法的非静态内部类的构造方式
        Child c = t1.new Child();
        //Child c = new Child()这不是合法的构造方式
        c.test();
    }


    /**
     * 并且非静态的内部类可以访问外部类的所有成员变量与方法，
     * 包括静态的成员变量与方法,执行内部类Child的test()方法就可以得到下面的结果：
     */
    class Child{
        public int i;

        public void test(){
            System.out.println("k=:"+k);
            System.out.println("string:"+string);
            add();
            System.out.println("j=:"+j);
            show();
        }
    }
}
