
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
    private Trainer getOpponentForLevel(byte level) 
    {
        if (level == 1)
        {
            Trainer t = new Trainer("BugCatcher Rick");
            t.AddPokemon(new Pokemon("Rattata", "Normal", (short)40, (short)7));
            return t;
        }
        else if (level == 2)
        {
            Trainer t = new Trainer("Martin");
            t.AddPokemon(new Pokemon("Pidgey", "Flying", (short)48, (short)10));
            return t;
        }
        else if (level == 3)
        {
            Trainer t = new Trainer("Camper Liam");
            t.AddPokemon(new Pokemon("Geodude", "Rock", (short)55, (short)13));
            return t;
        }
        else if (level == 4)
        {
            Trainer t = new Trainer("Leader Brock");
            t.AddPokemon(new Pokemon("Onix", "Rock", (short)70, (short)16));
            return t;
        }
        else if (level == 5)
        {
            Trainer t = new Trainer("Picnicker Diana");
            t.AddPokemon(new Pokemon("Nidoran", "Poison", (short)75, (short)18));
            return t;
        }
        else if (level == 6)
        {
            Trainer t = new Trainer("Sailor Duncan");
            t.AddPokemon(new Pokemon("Machop", "Fighting", (short)85, (short)22));
            return t;
        }
        else if (level == 7)
        {
            Trainer t = new Trainer("Leader Misty");
            t.AddPokemon(new Pokemon("Starmie", "Water", (short)95, (short)26));
            return t;
        }
        else 
        {
            Trainer t = new Trainer("Ace Trainer Red");
            t.AddPokemon(new Pokemon("Pikachu", "Electric", (short)110, (short)32));
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
            if(Register())
            {
                runGameHub();
            }
        } 
        else if (bytChoice == 3) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }
    public boolean Register()
    {
        boolean bolCheck = true; 
        System.out.println("Create an account \nEnter Username: ");
        File userFile;
        String strUsername = "";
        do{
            strUsername = new Scanner (System.in).next(); 
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

        byte bytStarter = 0;
        
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
            writer.write("\n" + 1);
            System.out.println("\nAccount created successfully!");
            this.player = new Player(strUsername, strPassword);
            this.player.AddPokemon(starter);
            this.player.setProg((byte)1); 
            return true;
        }
        catch (IOException e)
        {
            System.out.println("[ERROR] System could not write profile file.");
            return false;
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
            else 
            {
                bolCheck = false;
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
        boolean bolLoop = true;
        
        do
        {
            System.out.println("\n=== GAME HUB ===");
            System.out.println("Trainer: " + this.player.getName());
            if(this.player.getPorg() < 8)
            {
                System.out.println("Current Level Progress: Tier " + this.player.getPorg());
            }
            else
            {
                System.out.println("Current Level Progress: FINAL CHAMPTION TIER");
            }
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
                if(bytChoice == 2 && this.player.getPorg() <= 1)
                {
                    System.out.println("[ERROR] You haven't cleared any old levels to rebattle yet!");
                    bolCheck = true;
                }
                if(bytChoice == 1 && this.player.getPorg() > 8)
                {
                    System.out.println("\n==================================================");
                    System.out.println("?CONGRATULATIONS! You are already the CHAMPION! ");
                    System.out.println("You have cleared the main story campaign.");
                    System.out.println("You can still use Option 2 to rebattle past trainers.");
                    System.out.println("==================================================");
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
                    System.out.println("Your pokemon has gained Damage and health");
                    short shrGain = (short)(this.player.getPorg() * 3);
                    short shrGainHealth = (short)(this.player.getPorg() * 5);
                    this.player.getParty().get(0).gainVictoryStats(shrGain, shrGainHealth);
                    if(this.player.getPorg() < 8)
                    {
                       this.player.advanceLevel();  
                    }
                    
                    savePlayerProgress();
                    
                }
                else
                {
                    System.out.println("Wah Wah you lost ");
                }
                bolLoop = true;
            }
            else if (bytChoice == 2)
            {
                System.out.print("Enter an old level number to rebattle (1 to " + (this.player.getPorg() - 1) + "): ");
                byte bytChooselevel = 0;
                do
                {
                    try 
                    {
                        bytChooselevel = new Scanner(System.in).nextByte();
                    }
                    catch (Exception e)
                    {
                        System.out.println("[ERROR] Invalid level selection");
                    }
                    if(bytChooselevel > (this.player.getPorg() - 1))
                    {
                        System.out.println("[ERROR] Invalid level selection");
                    }
                }while(bolCheck);
                Trainer oldOpponent = getOpponentForLevel(bytChooselevel);
                this.player.getParty().get(0).heal();
                GameManager battleManager = new GameManager();
                battleManager.startBattle(this.player, oldOpponent);
                System.out.println("Your pokemon has gained Damage and health");
                short shrGain = (short)(bytChooselevel * 3);
                short shrGainHealth = (short)(bytChooselevel * 5);
                this.player.getParty().get(0).gainVictoryStats(shrGain, shrGainHealth);
                System.out.println("\nRebattle completed successfully.");
                bolLoop = true;
            }
            else if (bytChoice == 3)
            {
                this.player.getParty().get(0).heal();
                System.out.println("\n[POKÉCENT] Your Pokémon team was restored to full health!");
                bolLoop = true;
            }
            else if (bytChoice == 4)
            {
                savePlayerProgress();
                System.out.println("Saving and logging out... See you next time!");
                bolLoop = false; 
            }
        }while(bolLoop);
        
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

   
