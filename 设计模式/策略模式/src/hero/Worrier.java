package hero;

import attack.Attack;
import attack.MagicAttack;
import attack.NormalAttack;

/**
 * @author ZHZ
 */
public class Worrier extends Hero {
    public Worrier(){
        attack = new NormalAttack();
    }
    @Override
    public void display(){
        System.out.println("我是一名战士");
    }
}
