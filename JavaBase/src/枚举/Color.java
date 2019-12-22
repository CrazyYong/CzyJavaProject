package 枚举;

/**
 * Created by cmx on 2018/3/9.
 */
//如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。而且 Java 要求必须先定义 enum 实例。
public enum Color {
    RED("红色",1),GREEN("绿色",2),BLANK("白色",3),YELLOW("黄色",4);
    //成员变量
    private String name;
    private int index;
    //构造方法
    private Color(String name,int index){
        this.name=name;
        this.index=index;
    }
    //普通方法
    public static String getName(int index){
        for(Color c:Color.values()){
            if(c.getIndex()==index){
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

//覆盖方法
    @Override
    public String toString() {
        return this.index+"--"+this.name;
    }
}
