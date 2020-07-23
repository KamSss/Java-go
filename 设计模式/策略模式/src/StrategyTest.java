import attack.CrossAttack;
import attack.MagicAttack;
import hero.Hero;
import hero.Worrier;

/**
 * @author ZHZ
 */
public class StrategyTest {
    public static void main(String[] args){
        Hero worrier = new Worrier();
        worrier.display();
        worrier.attack();
        worrier.setAttack(new MagicAttack());
        worrier.attack();
        worrier.setAttack(new CrossAttack());
        worrier.attack();
    }
}
