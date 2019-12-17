package hero;

import attack.Attack;

/**
 * @author ZHZ
 */
public abstract class Hero{
    Attack attack;

    public void attack(){
        attack.attackBehavior();
    }

    public void setAttack(Attack at) {
        System.out.println("改变攻击行为");
        this.attack = at;
    }

    public void display(){}
}
