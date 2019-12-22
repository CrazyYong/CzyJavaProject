package 容器;

import java.util.*;

/**
 * ArrayList内部其实还是一个数组来维护的
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("czy");
        strList.add("cpSir");
        strList.add("1991");
        strList.add("man");

//    1:迭代器
        /**
         * 迭代器的好处
         *
         * 为什么要通过迭代器这种方式访问元素呢？直接使用size()/get(index)语法不也可以吗？在一些场景下，确实没有什么差别，两者都可以。不过，foreach语法更为简洁一些，更重要的是，迭代器语法更为通用，它适用于各种容器类。
         *
         * 此外，迭代器表示的是一种关注点分离的思想，将数据的实际组织方式与数据的迭代遍历相分离，是一种常见的设计模式。需要访问容器元素的代码只需要一个Iterator接口的引用，不需要关注数据的实际组织方式，可以使用一致和统一的方式进行访问。
         *
         * 而提供Iterator接口的代码了解数据的组织方式，可以提供高效的实现。在ArrayList中, size/get(index)语法与迭代器性能是差不多的，但在后续介绍的其他容器中，则不一定，比如LinkedList，迭代器性能就要高很多。
         *
         * 从封装的思路上讲，迭代器封装了各种数据组织方式的迭代操作，提供了简单和一致的接口。
         */

        /**
         * forEach循环
         * Iterator迭代器，方法有
         *  boolean hasNext();
         *     E next();
         *     void remove();
         *     hasNext()判断是否还有元素未访问，next()返回下一个元素，remove()删除最后返回的元素
         */
        for (String str : strList) {
            System.out.println(str);
        }

        Iterator<String> iterator = strList.iterator();
        while (iterator.hasNext()){
//            iterator.remove();    需要注意的是，调用remove方法前必须先调用next  iterator.next()
            System.out.println(iterator.next());
        }

        /**
         * ListIterator
         * 比Iterator增加了一些方法
         * 向前遍历、添加元素、修改元素、返回索引位置等
         * boolean hasPrevious();
         *     E previous();
         *     int nextIndex();
         *     int previousIndex();
         *     void set(E e);
         *     void add(E e);
         *
         *     listIterator()方法返回的迭代器从0开始，而listIterator(int index)方法返回的迭代器从指定位置index开始（）
         */
        /*倒序*/
        ListIterator<String> listIterator = strList.listIterator(strList.size());

        while (listIterator.hasPrevious()){
            System.out.println("ListIterator:"+listIterator.previous());
        }

        /*正序*/
        ListIterator<String> listIterator2 = strList.listIterator();
        while (listIterator2.hasNext()){
            System.out.println("ListIterator:"+listIterator2.next());
        }

//  2：ArrayList实现的接口
        /**
         * (1)
         * Collection接口
         * Collection表示一个数据集合，数据间没有位置或顺序的概念，接口定义为：
         * public interface Collection<E> extends Iterable<E> {
         *     int size();
         *     boolean isEmpty();
         *     boolean contains(Object o);
         *     Iterator<E> iterator();
         *     Object[] toArray();
         *     <T> T[] toArray(T[] a);
         *     boolean add(E e);
         *     boolean remove(Object o);
         *     boolean containsAll(Collection<?> c);
         *     boolean addAll(Collection<? extends E> c);
         *     boolean removeAll(Collection<?> c);
         *     boolean retainAll(Collection<?> c);
         *     void clear();
         *     boolean equals(Object o);
         *     int hashCode();
         * }
         */

        /**
         * （2）
         * List:List表示有顺序或位置的数据集合，它扩展了Collection，增加的主要方法有：
         * boolean addAll(int index, Collection<? extends E> c);
         * E get(int index);
         * E set(int index, E element);
         * void add(int index, E element);
         * E remove(int index);
         * int indexOf(Object o);
         * int lastIndexOf(Object o);
         * ListIterator<E> listIterator();
         * ListIterator<E> listIterator(int index);
         * List<E> subList(int fromIndex, int toIndex);
         */

        /**
         * (3)
         * RandomAccess:RandomAccess的定义为
         *public interface RandomAccess {
         * }
         * 没有定义任何代码。这有什么用呢？这种没有任何代码的接口在Java中被称之为标记接口，用于声明类的一种属性。
         * 这里，实现了RandomAccess接口的类表示可以随机访问，可随机访问就是具备类似数组那样的特性，数据在内存是连续存放的，根据索引值就可以直接定位到具体的元素，访问效率很高
         */

        /**
         * (4)
         * ArrayList的其他方法
         * 构造方法
         * ArrayList还有两个构造方法
         * public ArrayList(int initialCapacity)
         * public ArrayList(Collection<? extends E> c)
         * 第一个方法以指定的大小initialCapacity初始化内部的数组大小，代码为：
         *
         * this.elementData = new Object[initialCapacity];
         * 在事先知道元素长度的情况下，或者，预先知道长度上限的情况下，使用这个构造方法可以避免重新分配和拷贝数组。
         *
         * 第二个构造方法以一个已有的Collection构建，数据会新拷贝一份。
         *
         */
        ArrayList<Integer> integers = new ArrayList<>(5);
        ArrayList<Integer> integerArrayList = new ArrayList<>(integers);

        /**
         * （5）与数组的相互转换
         * public Object[] toArray()
         * public <T> T[] toArray(T[] a)
         *
         * 第一个方法返回是Object数组，代码为：
         *
         * public Object[] toArray() {
         *     return Arrays.copyOf(elementData, size);
         * }
         *
         *第二个方法返回对应类型的数组，如果参数数组长度足以容纳所有元素，就使用该数组，否
         * 则就新建一个数组，
         * 比如：
         */
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(123);
        intList.add(456);
        intList.add(789);

        Integer[] arrA = new Integer[3];
        intList.toArray(arrA);
        Integer[] arrB = intList.toArray(new Integer[0]);

        System.out.println(Arrays.equals(arrA, arrB));

        /**
         * (6)Arrays中有一个静态方法asList可以返回对应的List
         */
        Integer[] a ={1,2,3};
        List<Integer> list = Arrays.asList(a);
        /*
        * 需要注意的是，这个方法返回的List，它的实现类并不是本节介绍的ArrayList，而是Arrays类的一个内部类，在这个内部类的实现中，
        * 内部用的的数组就是传入的数组，没有拷贝，也不会动态改变大小，所以对数组的修改也会反映到List中，对List调用add/remove方法会抛出异常。
        * */
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(a));
        list1.indexOf(1);

        /**
         * 总结
         * 对于ArrayList，它的特点是：内部采用动态数组实现，这决定了：
         *
         * 可以随机访问，按照索引位置进行访问效率很高，用算法描述中的术语，效率是O(1)，简单说就是可以一步到位。（因为内部是数组的原因）
         * 除非数组已排序，否则按照内容查找元素效率比较低，具体是O(N)，N为数组内容长度，也就是说，性能与数组长度成正比。(因为是循环查找)
         * 添加元素的效率还可以，重新分配和拷贝数组的开销被平摊了，具体来说，添加N个元素的效率为O(N)。
         * 插入和删除元素的效率比较低，因为需要移动元素，具体为O(N)。（因为内部是数组的原因）
         */
    }
}
