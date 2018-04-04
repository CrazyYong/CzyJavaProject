package DesignMode.FactoryMode;

/**
 * Created by czy on 2018/4/4.
 */
public class RoujiaMoStore {

    private SimpleRouJiaMoFactroy factroy;

    public RoujiaMoStore(SimpleRouJiaMoFactroy factroy)
    {
        this.factroy = factroy;
    }

    /**
     * 根据传入类型卖不同的肉夹馍
     *
     * @param type
     * @return
     */
    public RouJiaMo sellRouJiaMo(String type)
    {
        RouJiaMo rouJiaMo = factroy.createRouJiaMo(type);
        rouJiaMo.prepare();
        rouJiaMo.fire();
        rouJiaMo.pack();
        return rouJiaMo;
    }
}
