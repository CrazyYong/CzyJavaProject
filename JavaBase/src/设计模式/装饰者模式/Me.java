package 设计模式.装饰者模式;

/**
 * 定义一个具体的人，就是被装饰者
 */
public class Me implements AbstractPerson{
    @Override
    public void show() {
        System.out.println("什么都没穿，我展示的裸体");
    }
}
