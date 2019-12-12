import java.util.ArrayList;

class AllHero{
    static final int BASIC_DAMAGE = 10;
    private String name = "默认名";
    protected int heroLv = 0;
    protected int x = 1;

    AllHero(String name,int heroLv){
        System.out.println("创建了一位角色");
        this.name = name;
        this.heroLv = heroLv;
        System.out.println(getName());
    }
    AllHero(){
        System.out.println("调用父类hero的默认无参构造函数");
        System.out.println(getName());
    }
    public String getName(){
        return name;
    }
    public int getHeroLv(){
        return heroLv;
    }
    void attack(){
        System.out.println("普通攻击：造成" + heroLv*BASIC_DAMAGE + "点伤害。");
    }
}

class Worriers extends AllHero{
    Worriers(String name,int heroLv){
        super(name, heroLv);
        System.out.println("调用Worriers类构造函数");
    }
    Worriers(){
        super("zhangsan",1);
        System.out.println(this.getName());
        System.out.println("倍率：" + this.x);
        x = 2;
        System.out.println("倍率：" + this.x);

    };
    @Override
    void attack(){
        System.out.println("物理攻击：造成真实伤害" + heroLv*BASIC_DAMAGE + "点");
    }
    void attack(int doubleAttack){
        System.out.println("物理攻击：暴击伤害！" + heroLv*BASIC_DAMAGE*doubleAttack + "点！");
    }
}
class Wizard extends AllHero{
    Wizard(String name, int heroLv) {
        super(name, heroLv);
    }

    @Override
    void attack(){
        System.out.println("魔法攻击：造成额外伤害" + heroLv*BASIC_DAMAGE*BASIC_DAMAGE+ "点");
    }
}
/**
 * @author ZHZ
 */
public class DuoTai {
    public static void main(String[] args){

        Worriers a = new Worriers("战士",5);
        Worriers c = new Worriers();
        Wizard b = new Wizard("法师",5);
        ArrayList<AllHero> heroList = new ArrayList<>();
        heroList.add(a);
        heroList.add(b);
        heroList.add(c);
        for(AllHero d : heroList){
            d.attack();
        }
    }
}
