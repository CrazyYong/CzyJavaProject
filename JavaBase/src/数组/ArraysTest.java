package 数组;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 数组是存储多个同类型元素的基本数据结构，数组中的元素在内存连续存放，可以通过数组下标直接定位任意元素，
 * 相比我们在后续章节介绍的其他容器，效率非常高。
 * <p>
 * 数组操作是计算机程序中的常见基本操作，Java中有一个类Arrays，包含一些对数组操作的静态方法，
 * 本节主要就来讨论这些方法，我们先来看怎么用，然后再来看它们的实现原理。
 * 学习Arrays的用法，我们就可以避免重新发明轮子，直接使用，学习它的实现原理，我们就可以在需要的时候，自己实现它不具备的功能。
 */
public class ArraysTest {
    public static void main(String[] args) {
        /**
         * 1:toString
         * Arrays的toString方法可以方便的输出一个数组的字符串形式，方便查看，
         * 它有九个重载的方法，包括八种基本类型数组和一个对象类型数组，这里列举两个：
         * public static String toString(int[] a)
         * public static String toString(Object[] a)
         */
        int[] arr = {9, 8, 3, 4};
        System.out.println(Arrays.toString(arr));

        String[] strArr = {"hello", "world"};
        System.out.println(Arrays.toString(strArr));

        /**
         * 2：数组排序-基本类型
         * 排序是一个非常常见的操作，同toString一样，对每种基本类型的数组，Arrays都有sort方法(boolean除外)，如
         * public static void sort(int[] a)
         * public static void sort(double[] a)
         */
        String[] arr2 = {"hello", "world", "Break", "abc"};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        /**
         * 3:数组排序-自定义比较器
         * sort还有另外两个重载方法，可以接受一个比较器作为参数：
         * public static <T> void sort(T[] a, Comparator<? super T> c)
         * public static <T> void sort(T[] a, int fromIndex, int toIndex,
         *                                 Comparator<? super T> c)
         *
         * 这个方法可以支持所有对象类型，只要传递这个类型对应的比较器就可以了。Comparator就是比较器，它是一个接口，定义是：
         * public interface Comparator<T> {
         *     int compare(T o1, T o2);
         *     boolean equals(Object obj);
         * }
         * 最主要的是compare这个方法，它比较两个对象，返回一个表示比较结果的值，-1表示o1小于o2，0表示相等，1表示o1大于o2。
         *
         * 排序是通过比较来实现的，sort方法在排序的过程中，需要对对象进行比较的时候，就调用比较器的compare方法。
         * String类有一个public静态成员，表示忽略大小写的比较器：
         *
         * public static final Comparator<String> CASE_INSENSITIVE_ORDER
         *                                      = new CaseInsensitiveComparator();
         *
         * 传递比较器Comparator给sort方法，体现了程序设计中一种重要的思维方式，将不变和变化相分离，
         * 排序的基本步骤和算法是不变的，但按什么排序是变化的，sort方法将不变的算法设计为主体逻辑，而将变化的排序方式设计为参数，允许调用者动态指定，
         * 这也是一种常见的设计模式，它有一个名字，叫策略模式，不同的排序方式就是不同的策略。
         */
        /*从小到大*/
        String[] arr3 = {"hello", "world", "Break", "abc"};
        Arrays.sort(arr3, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(arr3));

        /*从大到小排序*/
        String[] arr4 = {"hello", "world", "Break", "abc"};
        Arrays.sort(arr4, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareToIgnoreCase(o1);
            }
        });
        System.out.println(Arrays.toString(arr4));
     /*
    * Collections类中有两个静态方法，可以返回逆序的Comparator，如
    * public static <T> Comparator<T> reverseOrder()
      public static <T> Comparator<T> reverseOrder(Comparator<T> cmp)
      * 这样，上面字符串忽略大小写逆序排序的代码可以改为：
    * */
        String[] arr5 = {"hello", "world", "Break", "abc"};
        Arrays.sort(arr5, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Arrays.toString(arr));

        /**
         * 4:二分查找
         * Arrays包含很多与sort对应的查找方法，可以在已排序的数组中进行二分查找，
         * 所谓二分查找就是从中间开始找，如果小于中间元素，则在前半部分找，否则在后半部分找，每比较一次，要
         * 么找到，要么将查找范围缩小一半，所以查找效率非常高。
         * 二分查找既可以针对基本类型数组，也可以针对对象数组，对对象数组，也可以传递Comparator，也都可以指定查找范围，如下所示：
         */
        /*针对int数组
        * public static int binarySearch(int[] a, int key)
          public static int binarySearch(int[] a, int fromIndex, int toIndex,int key)
        * */

        /*针对对象数组
        * public static int binarySearch(Object[] a, Object key)
        * */

        /*
        * 自定义比较器
        * public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c)
         * */
        /*如果能找到，binarySearch返回找到的元素索引，比如说：*/
        int[] arr6 = {3,5,7,13,21};
        System.out.println(Arrays.binarySearch(arr6,13));

        /*如果没有找到返回一个负数
        * 这个负数等于：-(插入点+1)，插入点表示，如果在这个位置插入没找到的元素，可以保持原数组有序，比如说：
        * 输出为-4，表示插入点为3，如果在3这个索引位置处插入11，可以保持数组有序，即数组会变为：{3,5,7,11,13,21}
        * */
        int[] arr7 = {3,5,7,13,21};
        System.out.println(Arrays.binarySearch(arr7, 11));
        /*
        * 需要注意的是，binarySearch针对的必须是已排序数组，如果指定了Comparator，需要和排序时指定的Comparator保持一致，
        * 另外，如果数组中有多个匹配的元素，则返回哪一个是不确定的。
        * */

        /**
         * 5.数组拷贝
         * public static long[] copyOf(long[] original, int newLength)
         * public static <T> T[] copyOf(T[] original, int newLength)
         * 后面那个是泛型用法，这里表示的是，这个方法可以支持所有对象类型，参数是什么数组类型，返回结果就是什么数组类型。
         *
         * newLength表示新数组的长度，如果大于原数组，则后面的元素值设为默认值。回顾一下默认值，对于数值类型，值为0，对于boolean，值为false，对于char，值为'\0'，对于对象，值为null。
         */
        String[] arr8 = {"hello", "world"};
        String[] newArr = Arrays.copyOf(arr8, 3);
        System.out.println(Arrays.toString(newArr));

        /*
        * 除了copyOf方法，Arrays中还有copyOfRange方法，以支持拷贝指定范围的元素，如：
        * public static int[] copyOfRange(int[] original, int from, int to)
        * from表示要拷贝的第一个元素的索引，新数组的长度为to-from，to可以大于原数组的长度，如果大于，与copyOf类似，多出的位置设为默认值。
        * */
        int[] arr9= {0,1,3,5,7,13,19};
        int[] subArr1 = Arrays.copyOfRange(arr9,2,5);
        int[] subArr2 = Arrays.copyOfRange(arr9,5,10);
        System.out.println(Arrays.toString(subArr1));
        System.out.println(Arrays.toString(subArr2));

        /**
         * 6.数组比较
         * 支持基本类型和对象类型，如下所示：
         *
         * public static boolean equals(boolean[] a, boolean[] a2)
         * public static boolean equals(double[] a, double[] a2)
         * public static boolean equals(Object[] a, Object[] a2)
         * 只有数组长度相同，且每个元素都相同，才返回true，否则返回false。对于对象，相同是指equals返回true。
         */

        /**
         * 7.填充值
         * Arrays包含很多fill方法，可以给数组中的每个元素设置一个相同的值：
         * public static void fill(int[] a, int val)
         *
         * 也可以给数组中一个给定范围的每个元素设置一个相同的值：
         * public static void fill(int[] a, int fromIndex, int toIndex, int val)
         */
        int[] arr10 = {3,5,7,13,21};
        Arrays.fill(arr,2,4,0);
        System.out.println(Arrays.toString(arr10));

        /**
         * 8.哈希值
         * 针对数组，计算一个数组的哈希值：
         * public static int hashCode(int a[])
         *
         * 回顾一下，String计算hashCode的算法也是类似的，数组中的每个元素都影响hash值，位置不同，影响也不同，使用31一方面产生的哈希值更分散，另一方面计算效率也比较高。
         */
        System.out.println("计算hash值"+Arrays.hashCode(arr10));

        /**
         * 9.
         * Apache有一个开源包(http://commons.apache.org/proper/commons-lang/)，
         * 里面有一个类ArrayUtils (位于包org.apache.commons.lang3)，里面实现了更多的常用数组操作，
         */
    }
}
