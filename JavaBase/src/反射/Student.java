package 反射;

/**
 * Created by czy on 2018/7/31.
 */
public class Student {

    private String id;

    private String name;

    //构造函数1
    public Student(){
        System.out.println("构造函数 无参");
    }

    //构造函数2
    public Student(String id){
        this.id=id;
        System.out.println("构造函数 id:"+id);
    }

    //构造函数3
    public Student(String id,String name){
        this.id=id;
        this.name=name;
        System.out.println("构造函数 id : " + id  + " name: " + name);
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
}
