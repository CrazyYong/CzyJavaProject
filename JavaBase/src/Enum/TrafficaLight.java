package Enum;

/**
 * Created by cmx on 2018/3/9.
 */

enum Signal{
    GREEN,YELLOW,RED
}

public class TrafficaLight {
    Signal color = Signal.RED;
    public void change(){
        switch (color){
            case RED:
                color=Signal.RED;
                break;
            case YELLOW:
                color=Signal.YELLOW;
                break;

            case GREEN:
                color=Signal.GREEN;
                break;
        }
    }
}
