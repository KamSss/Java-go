package hero;

import attack.MagicAttack;
import attack.NormalAttack;

/**
 * @author ZHZ
 */
public class Magic extends Hero {
    public Magic(){
        attack = new MagicAttack();
    }
    @Override
    public void display(){
        System.out.println("我是一名法师");
    }
}
