package attack;

/**
 * @author ZHZ
 */
public class NormalAttack implements Attack  {
    @Override
    public void attackBehavior() {
        System.out.println("物理攻击");
    }
}
