import store.NormalBuyer;
import store.Store;
import store.VipBuyer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ZHZ
 */
public class ProgramTest {
    public static void main(String[] args) {
        System.out.println();

        Store s = new Store();
        VipBuyer v = new VipBuyer(s);
        NormalBuyer n = new NormalBuyer(s);
        //changed默认为false，不做推送，调用setchanged的时候才能推送。
        s.setChanged();
        s.setMessage("关门,","4天后打折优惠");
        s.removeObserver(n);
        s.setMessage("开门营业,","今日会员7折");
    }
}
