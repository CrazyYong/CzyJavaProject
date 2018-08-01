package 反射;

/**
 * Created by czy on 2018/7/31.
 */
public class Person implements InterFace{
    private String id;

    private String name;

    private String age;

    /**
     * 构造函数1
     */
    public Person(){

    }

    /**
     * 构造函数2
     */
    public Person(String id){

    }

    /**
     * 构造函数3
     */
    public Person(String id,String name){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 静态方法
     */
    public static void update(){

    }


    @Override
    public void read() {

    }
}
