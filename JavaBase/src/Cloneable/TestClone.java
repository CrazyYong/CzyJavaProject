package Cloneable;

import org.junit.Test;

/**
 * Created by cmx on 2018/3/14.
 */
public class TestClone implements Cloneable{
    int a;
    double b;

    TestClone  cloneTest(){
        try {
            return (TestClone)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not allowed.");
        }

        return this;
    }

    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not allowed.");
        }

        return this;
    }

    @Test
    public void test(){
        TestClone x1 = new TestClone();
        TestClone x2;
        x1.a=10;
        x1.b=20.98;
        x2=x1.cloneTest();//clone x1
        System.out.println("x1: " + x1.a + " " + x1.b);
        System.out.println("x2: " + x2.a + " " + x2.b);
    }


    @Test
    public void test2(){
        TestClone x1 = new TestClone();
        TestClone x2;
        x1.a=10;
        x1.b=20.98;
        x2=(TestClone)x1.clone();
        System.out.println("x1: " + x1.a + " " + x1.b);
        System.out.println("x2: " + x2.a + " " + x2.b);

    }

}
