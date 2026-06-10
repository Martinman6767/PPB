
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
    //Player object
    private Player player; 
    
    //Here grabs the trainer information for each battle
    private Trainer getOpponentForLevel(byte level) 
    {
        //check what numebr level you are at and chose the correct trainer
        //the following action will be the same for everysingle case
        if (level == 1)
        {
            //create an instance of the trainer
            Trainer t = new Trainer("Rick");
            
            //calls a add pokemon method to add this pokemon information to the array
            t.AddPokemon(new Pokemon("Rattata", "Normal", (short)40, (short)7));
            
            //return this trainer with the appropriate informations or pokemons added
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
            Trainer t = new Trainer("Elite trainer");
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
            Trainer t = new Trainer("Sailor Jeff");
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
            Trainer t = new Trainer("Red");
            t.AddPokemon(new Pokemon("Pikachu", "Electric", (short)220, (short)120));
            return t;
        }
    }
    //this lauches the menue where you chose your options of what you want to do
    public void runGameMenu()
    {
        //check if loops ends
        boolean bolTryCatch;
        
        //to store choise
        byte bytChoice = 0; 
        
        //do while and try catch to 
        do
        {
            //output messages
            System.out.println("\n=== POKEMON MENU PROGRESSION ===");
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Exit");
            System.out.println("4. ReadRules");
            System.out.print("Choose an option: ");
            
            //try ctach loop
            try
            {
                //populate varibale               
                bytChoice = new Scanner(System.in).nextByte();
                 
                //if it runs - set boolean to false to stop loop
                bolTryCatch = false;
                 
            }
            catch(Exception e)
            {
                //output message
                System.out.println("[Error]Please enter Choice as a whole number");
                
                //set boolean to true - to loop again
                bolTryCatch = true;
                 
            }
            //makes sure it isn't megative
            if(bytChoice <0)
            {
                //output message
                System.out.println("[Error]Please enter choice as a positive number");
                
                //update boolean to true to loop again
                bolTryCatch = true;
            }
            if(bytChoice == 4)
            {
                bolTryCatch = true;
            }
            //checks if it one of the options
            if (bytChoice != 1 && bytChoice != 2 && bytChoice != 3 && bytChoice != 4)             
            {
                //output message
                System.out.println("[Error]Please enter choice as either 1 or 2 or 3 or 4");
                
                //update boolean to true to loop again
                bolTryCatch = true;
            }
            
        }while(bolTryCatch);
        
        //run methods based of choice
        if (bytChoice == 1) 
        {
            //runs login method and if it returns true than it starts game
            if (HandleLogin()) 
            {
                //run your game
                runGameHub();
            }
        } 
        else if (bytChoice == 2)
        {
            //runs register method and returns true to run the game
            if(Register())
            {
                //run your game
                runGameHub();
            }
        } 
        else if (bytChoice == 3) {
            //output message
            System.out.println("Goodbye!");
        }
    }
    public boolean Register()
    {
        //variabels 
        //used for loops
        boolean bolCheck = true; 
        
        //define file variable
        File userFile;
        
        //starter cgiiuce
        byte bytStarter = 0;
        
        //used for loop
        boolean bolTryCatch;
        
        //create a intance of a pokemon based on the started you picked
        Pokemon starter;
        
        //stores username
        String strUsername = "";
    
        //stores password
        String strPassword = ""; 
        
        //outputmessage
        System.out.println("Create an account \nEnter Username: ");
        do
        {
            //populate varaable 
            strUsername = new Scanner (System.in).next(); 
            //set the user file to your username 
            userFile = new File(strUsername + ".txt");
            
            //search if this file exists
            if (userFile.exists()) {
                //outputmessage
                System.out.println("[ERROR] Username already exists!");
                
                //is true
                bolCheck = true; 
            }
            else 
            {
                bolCheck = false; 
            }
        }while(bolCheck); 
        
        System.out.println("Enter Password: ");
        
        strPassword = new Scanner (System.in).next(); 
        
        System.out.println("\nChoose your Starter Pokémon:");
        
        System.out.println("1. Charmander\n2. Bulbasaur\n3. Squirtle");

        
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
        String strSavedPassword = "";
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
                    bolCheck = false; 
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
            System.out.println("ERROR");
            return false; 
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
            do 
            {
                System.out.println("\n=== GAME HUB ===");
                System.out.println("Trainer: " + this.player.toString());
                if(this.player.getPorg() < 8)
                {
                    System.out.println("Current Level Progress: Tier " + this.player.getPorg());
                }
                else
                {
                    System.out.println("Current Level Progress: FINAL CHAMPTION TIER");
                }
                System.out.println("--------------------------------");
                
                if(this.player.getPorg() < 8)
                {
                    System.out.println("1. Battle Next Tier (Level " + this.player.getPorg() + ")");
    
                }
                else
                {
                    System.out.println("1. Battle Next Tier (Level " + 8 + ")");
                }
                System.out.println("2. Rebattle an Old Level");
                System.out.println("3. Heal Pokémon Team");
                System.out.println("4. Log Out");
                System.out.print("What would you like to do? ");
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
                if(bytChoice == 1 && this.player.getParty().get(0).getCurrentHp() <= 0)
                {
                    System.out.println("Please heal your pokemon befor battle");
                    bolCheck = true;    
                }
            } while (bolCheck);
            if (bytChoice == 1)
            {
                
                Trainer opponent = getOpponentForLevel(this.player.getPorg());
                GameManager battleManager = new GameManager();
                boolean bolWin = battleManager.startBattle(this.player, opponent);
                if(bolWin == true)
                {
                    System.out.println("\n***VICTORY!*** You defeated " + opponent.getName() + "!");
                    System.out.println("Your pokemon has gained Damage and health");
                    short shrGain = (short)(this.player.getPorg() * 3);
                    short shrGainHealth = (short)(this.player.getPorg() * 5);
                    this.player.getParty().get(0).gainVictoryStats(shrGain, shrGainHealth);
                    this.player.advanceLevel();  
                    
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
                        bolCheck = false;
                    }
                    catch (Exception e)
                    {
                        System.out.println("[ERROR] Invalid level selection");
                        bolCheck = true;
                    }
                    if(bytChooselevel > (this.player.getPorg() - 1))
                    {
                        System.out.println("[ERROR] Invalid level selection");
                        bolCheck = true;
                    }
                }while(bolCheck);
                Trainer oldOpponent = getOpponentForLevel(bytChooselevel);
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

   
