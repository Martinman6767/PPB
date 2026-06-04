
/**
 * Write a description of class GameMenu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner; 
import java.io.*;
public class GameMenu
{
    private Player player; 
    
    public void runGameMenu()
    {
        boolean bolTryCatch;
        byte bytChoice = 0; 
        do
        {
            System.out.println("\n=== POKÉMON TERMINAL PROGRESSION ===");
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
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
            if (bytChoice != 1 && bytChoice != 2 && bytChoice != 3)             
                {
                System.out.println("Error.  Please enter choice as either 1 or 2 or 3");
                bolTryCatch = true;
            }
        }while(bolTryCatch);
        
        if (bytChoice == 1) 
        {
            if (HandleLogin()) 
            {
                runGameHub();
            }
        } 
        else if (bytChoice == 2)
        {
            Register();
        } 
        else if (bytChoice == 3) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }
    public void Register()
    {
        boolean bolCheck = true; 
        System.out.println("Create an account \nEnter Username: ");
        File userFile = null;
        do{
            String strUsername = new Scanner (System.in).next(); 
            userFile = new File(strUsername + ".txt");
            if (userFile.exists()) {
                System.out.println("[ERROR] Username already exists!");
                bolCheck = true; 
            }
            else 
            {
                bolCheck = false; 
            }
        }while(bolCheck); 
        
        System.out.println("Enter Password: ");
        
        String strPassword = new Scanner (System.in).next(); 
        
        System.out.println("\nChoose your Starter Pokémon:");
        
        System.out.println("1. Charmander\n2. Bulbasaur\n3. Squirtle");

        byte bytStarter = new Scanner (System.in).nextByte(); 
        
        boolean bolTryCatch;
        
        do
        {
            try
            {
                bytStarter = new Scanner(System.in).nextByte();
                 
                //if it runs - set boolean to false to stop loop
                bolTryCatch = false;
                 
            }
            catch(Exception e)
            {
                System.out.println("Error.  Please enter Choice as a whole number");
                //set boolean to true - to loop again
                bolTryCatch = true;
                 
            }
            if(bytStarter <0)
            {
                System.out.println("Error.  Please enter choice as a positive number");
                //update boolean to true to loop again
                bolTryCatch = true;
            }
            if (bytStarter != 1 && bytStarter != 2 && bytStarter != 3)             
                {
                System.out.println("Error.  Please enter choice as either 1 or 2 or 3");
                bolTryCatch = true;
            }
        }while(bolTryCatch);
        
        Pokemon starter;
        if (bytStarter == 2) 
        {
            starter = new Pokemon("Bulbasaur", "Grass", (short)55, (short)9);
        }
        else if (bytStarter == 3) 
        {
            starter = new Pokemon("Squirtle", "Water", (short)53, (short)10);
        }
        else 
        {
            starter = new Pokemon("Charmander", "Fire", (short)50, (short)12);
        }
        
        try(FileWriter writer = new FileWriter(userFile))
        {
            writer.write(strPassword + "\n");
            writer.write(starter.getName() + "\n");
            writer.write(starter.getType() + "\n");
            writer.write(starter.getMaxHp() + "\n");
            writer.write(starter.getAttack() + "\n");
        }
        catch (IOException e)
        {
            
        }
    }
    public boolean HandleLogin()
    {
        return true; 
    }
    public void runGameHub()
    {
        
    }
    
    
}
   
