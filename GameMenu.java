
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
    private Trainer getOpponentForLevel(int level) 
    {
        if (level == 1) 
        {
            Trainer t = new Trainer("BugCatcher");
            t.AddPokemon(new Pokemon("Rattata",     "Normal", (short)40, (short)7));
            return t;
        }
        else 
        {
            Trainer t = new Trainer("Martin");
            t.AddPokemon(new Pokemon("Pidgey", "Flying", (short)48, (short)10));
            return t;
        }
    }
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
            writer.write(this.player.getPorg());
            System.out.println("\nAccount created successfully!");
        }
        catch (IOException e)
        {
            System.out.println("[ERROR] System could not write profile file.");
        }
        
    }
    public boolean HandleLogin()
    {
        System.out.println("=== LOG IN ===");
        System.out.println("Enter Username: ");
        
        boolean bolCheck = false; 
        String strUserName;

        do
        {
            strUserName = new Scanner(System.in).nextLine();
        
            File userFile = new File(strUserName + ".txt");
            if(!userFile.exists())
            {
                System.out.println("This username dosn't exist. Please renter username");
                bolCheck = true;
            }
        }while (bolCheck);
        
        File userFile = new File(strUserName + ".txt");
        
        System.out.println("Enter Password: ");
   
        String strSavedPassword = "";
        
        
        
        try 
        {
            Scanner scanner = new Scanner(new FileReader(userFile));
            strSavedPassword = scanner.nextLine();
            do
            {
                String strPassword = new Scanner(System.in).nextLine();
                if(strPassword.equals(strSavedPassword))
                {
                    this.player = new Player(strUserName, strPassword);
                    
                    String pName = scanner.nextLine();
                    String pType = scanner.nextLine();
                    short pHp = Short.parseShort(scanner.nextLine());
                    short pAtk = Short.parseShort(scanner.nextLine());
                    this.player.setProg(Byte.parseByte(scanner.nextLine()));
                    
                    Pokemon loadedMon = new Pokemon(pName, pType, pHp, pAtk);
                    this.player.AddPokemon(loadedMon);
                }
                    else
                {
                    System.out.println("Password entered was incorrect");
                    bolCheck = true; 
                }
            }while(bolCheck); 
        } 
        
        catch (FileNotFoundException e) 
        {    
            e.printStackTrace();
        }
        return true; 
        }
    public void runGameHub()
    {
        byte bytChoice = 0;
        boolean bolCheck = true;
        System.out.println("\n=== GAME HUB ===");
        System.out.println("Trainer: " + this.player.getName());
        System.out.println("Current Level Progress: Tier " + this.player.getPorg());
        System.out.println("--------------------------------");
        System.out.println("1. Battle Next Tier (Level " + this.player.getPorg() + ")");
        System.out.println("2. Rebattle an Old Level");
        System.out.println("3. Heal Pokémon Team");
        System.out.println("4. Log Out");
        System.out.print("What would you like to do? ");
        do 
        {
            try 
            {
                bytChoice = new Scanner(System.in).nextByte();
                bolCheck = false;
            } 
            catch (Exception e) 
            {
                System.out.println("[ERROR] Please enter a valid whole number.");
                bolCheck = true;
            }
            if (bytChoice < 1 || bytChoice > 4) 
            {
                System.out.println("[ERROR] Please select an option between 1 and 4.");
                bolCheck = true;

            }
        } while (bolCheck);
        if (bytChoice == 1)
        {
            Trainer opponent = getOpponentForLevel(this.player.getPorg());
            this.player.getParty().get(0).heal();
                
            GameManager battleManager = new GameManager();
            boolean bolWin = battleManager.startBattle(this.player, opponent);
            if(bolWin == true)
            {
                System.out.println("\n***VICTORY!*** You defeated " + opponent.getName() + "!");
                this.player.advanceLevel(); 
                savePlayerProgress();
            }
            else
            {
                System.out.println("Wah Wah you lost ");
            }
        }
        
    }
    public void savePlayerProgress()
    {
        File userFile = new File(this.player.getName() + ".txt");
        Pokemon leadMon = this.player.getParty().get(0);
        
        try (FileWriter writer = new FileWriter(userFile))
        {
                writer.write(this.player.getPassword() + "\n");
                writer.write(leadMon.getName() + "\n");
                writer.write(leadMon.getType() + "\n");
                writer.write(leadMon.getMaxHp() + "\n");
                writer.write(leadMon.getAttack() + "\n");
                writer.write(this.player.getPorg() + "\n"); 
        }
        catch (IOException e)
        {
            System.out.println("[ERROR] Auto-save failed.");
        }
    }
    }

   
