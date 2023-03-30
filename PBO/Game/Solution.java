import java.io.*;
import java.util.*;

class Character {
    long Health;
    long Damage;

    public Character(long health, long damage) {
        this.Health = health;
        this.Damage = damage;
    }
    
}

class Monster {
    long Health;
    long Damage;

    public Monster(long health, long damage) {
        this.Health = health;
        this.Damage = damage;
    }
}

class Coin {
    long Coins;
    long Damage;
    long Health;
    
    
    public Coin(long coins, long damage, long health) {
        this.Coins = coins;
        this.Damage = damage;
        this.Health = health;
        
    }
}


public class Solution {

    public static long hpChar, attChar, hpMon, attMon, coins, hpCoin, attCoin;
    public static String bug;
    
    public static void battle(long hpChar, long attChar, long hpMon, long attMon, long coins, long attCoin, long hpCoin) {
        long longTurnCharToDie = (long)Math.ceil((double)hpChar / attMon);
        long longTurnMonToDie = (long)Math.ceil((double)hpMon / attChar);
        
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCase = input.nextInt(); input.nextLine();
        //System.out.println(testCase);
        Character[] arrayChar = new Character[testCase];
        Monster[] arrayMon = new Monster[testCase];
        Coin[] arrayCoin = new Coin[testCase];
        for (int i = 0; i < testCase; i++) {
            hpChar = input.nextLong();
            //System.out.println(hpChar);
            attChar = input.nextLong();
            //System.out.println(attChar);
            hpMon = input.nextLong();
            //System.out.println(hpMon);
            attMon = input.nextLong();
            //System.out.println(attMon);
            coins = input.nextLong();
            //System.out.println(coins);
            attCoin = input.nextLong();
            //System.out.println(hpCoin);
            hpCoin = input.nextLong();
            //System.out.println(attCoin);
            arrayChar[i] = new Character(hpChar, attChar);
            arrayMon[i] = new Monster(hpMon, attMon);
            arrayCoin[i] = new Coin(coins, attCoin, hpCoin);
            Character player = arrayChar[i];
            Monster musuh = arrayMon[i];  
            Coin buff = arrayCoin[i];
            boolean check1 = true;
            /*
            while(check1) {
                if (buff.Coins > 0 && buff.Coins % 2 == 1) {
                    player.Damage += buff.Damage;
                    buff.Coins--;
                    check1 = true;
                
                } else if (buff.Coins > 0 && buff.Coins % 2 == 0) {
                    player.Health += buff.Health;
                    buff.Coins--;
                    check1 = true;
                } else {
                    check1 = false;
                }
            }

            while (player.Health > 0 && musuh.Health > 0) {
                musuh.Health -= player.Damage;
                if (musuh.Health <= 0) {
                    System.out.println("YES");
                    break;
                }
                player.Health -= musuh.Damage;
                if (player.Health <= 0) {
                    System.out.println("NO");
                }
            }
            */
        }
    }
}