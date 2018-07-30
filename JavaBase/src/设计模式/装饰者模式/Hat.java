package 设计模式.装饰者模式;

/**
 * 帽子装饰
 */
public class Hat extends AbstractClothes{

    public Hat(AbstractPerson abstractPerson) {
        super(abstractPerson);
    }

    @Override
    public void show() {
        super.show();
        say();
    }

    public void say(){
        System.out.println("我展示一个帽子");

    }
}
