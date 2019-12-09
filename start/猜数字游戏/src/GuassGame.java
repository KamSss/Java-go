import sun.plugin.viewer.context.PluginAppletContext;

import java.util.Scanner;

//class Ai{
//    int target;
//    void setTarget{
//        target = (int)(100 * Math.random());
//    }
//    void showRes{
//
//    }
//}

class Player{
    int num;
    int iGuess(){
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        System.out.println("i guess the number is: " + num);
        return num;
    }
    boolean isWin(int target){
        if(target < num){
            System.out.print("your number is too high ");
        }
        else if(target > num){
            System.out.print("your number is too low ");
        }
        return target == num;
    }
}

class GameStart {
    Player p1;

    void play() {
        p1 = new Player();
        int target = (int) (100 * Math.random());
        System.out.println("welcome to GameOfGuessNumber,plz input your number:");
        while (true) {
            int tmp = p1.iGuess();
            if (p1.isWin(target)) {
                System.out.println("bingo！");
                break;
            }
            System.out.println(",plz guess again.");
        }
    }
}
