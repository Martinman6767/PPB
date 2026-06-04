
/**
 * Write a description of class Gamemanager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
public class GameManager
{
    private Player player;
    private Trainer opponent; 
    
    private Pokemon active; 
    private Pokemon activeEnemy;
    
    boolean bolBattleRunning;
    byte bytTurnCounter;
    
    GameManager()
    {
        this.bolBattleRunning = false; 
        this.bytTurnCounter = 0; 
    }
 
    public void startBattle(Player player, Trainer opponent)
    {
        this.player = player;
        this.opponent = opponent;
        this.bolBattleRunning = true; 
        this.bytTurnCounter = 1; 
        
        this.active = player.getParty().get(0); 
        this.activeEnemy = opponent.getParty().get(0); 
        
        System.out.println("==================Battle Started==================");
        System.out.println(opponent.getName() + " wants to battle!");
        System.out.println("You sent out "+ active.getName());
        while(bolBattleRunning)
        {
            RunChoice(); 
        }
    }
    public void RunChoice()
    {
        System.out.println("\n--- Turn " + bytTurnCounter + " ---");
        System.out.println("Enemy: " + activeEnemy.getName() + " (HP: " + activeEnemy.getCurrentHp() + "/" + activeEnemy.getMaxHp() + ")");
        System.out.println("You: " + active.getName() + " (HP: " + active.getCurrentHp() + "/" + active.getMaxHp() + ")");

        boolean bolTryCatch;
        byte bytChoice = 0; 
        do
         {
             System.out.println("1. Fight\n2. Run");
             System.out.print("Choose an action: ");
             try
             {
                bytChoice = new Scanner(System.in).nextByte();
                 
                //if it runs - set boolean to false to stop loop
                bolTryCatch = false;
                 
             }
             catch(Exception e)
             {
                System.out.println("Error.  Please enter Choice as a whole number");
                //set boolean to true - to loop again
                bolTryCatch = true;
                 
             }
             if(bytChoice <0)
             {
                System.out.println("Error.  Please enter choice as a positive number");

                //update boolean to true to loop again
                bolTryCatch = true;
             }
             else if (bytChoice != 1 || bytChoice != 2)
             {
                System.out.println("Error.  Please enter choice as either 1 or 2");
                
                bolTryCatch = true;
             }
        }while(bolTryCatch);
        
        if(bytChoice == 1)
        {
            System.out.println("\n" + active.getName() + " attacks for " + active.getAttack() + " damage!");
            activeEnemy.TakeDamage(active.getAttack());

            if (activeEnemy.Fainted()) 
            {
                System.out.println(activeEnemy.getName() + " fainted! You win!");
                bolBattleRunning = false;
                return;
            }
            System.out.println(activeEnemy.getName() + " attacks back for " + activeEnemy.getAttack() + " damage!");
            active.TakeDamage(activeEnemy.getAttack());
            if (active.Fainted()) 
            {
                System.out.println(active.getName() + " fainted! You lost the battle...");
                bolBattleRunning = false;
                return;
            }
        }
        else if (bytChoice == 2) {
            System.out.println("You fled from the battle!");
            bolBattleRunning = false;
        }
    }
}
    
