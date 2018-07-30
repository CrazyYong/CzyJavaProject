package 设计模式.装饰者模式;


/**
 * 鞋子装饰物
 */
public class Shoes extends AbstractClothes{

    public Shoes(AbstractPerson abstractPerson) {
        super(abstractPerson);
    }

    @Override
    public void show() {
        super.show();
        say();
    }

    public void say(){
        System.out.println("我展示一双鞋子");
    }
}
