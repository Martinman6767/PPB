
/**
 * Write a description of class Pokemon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pokemon 
{
    private String strName;
    private String strType;
    private short shrHPmax;
    private short shrHPcurrent;
    private short shrAttack;
    
    Pokemon(String x, String y, short z, short e)
    {
        this.strName = x;
        this.strType = y;
        this.shrHPmax = z;
        this.shrHPcurrent = z;
        this.shrAttack = e;
    }
    
    public void TakeDamage(short shrdamage)
    {
        this.shrHPcurrent -= shrdamage; 
        if(this.shrHPcurrent<0)
        {
            this.shrHPcurrent = 0;
        }
        
    }
    public boolean Fainted()
    {
        if(this.shrHPcurrent <= 0)
        {
            return true; 
        }
        else 
        {
            return false; 
        }
    }
    public void gainVictoryStats(short hpIncrease, short atkIncrease)
    {
        this.shrHPmax += hpIncrease;
        this.shrAttack += atkIncrease;
        this.shrHPcurrent = this.shrHPmax; // Fully heal up with your new max stats!
        
        System.out.println(this.strName + " grew stronger!");
        System.out.println("-> Max HP is now: " + this.shrHPmax);
        System.out.println("-> Attack is now: " + this.shrAttack);
        }
    public void heal()
    {
        this.shrHPcurrent = shrHPmax; 
    }
    public String getType()
    {
        return this.strType; 
    }
    public String getName() 
    { 
        return this.strName; 
    }
    public short getAttack() 
    { 
        return this.shrAttack; 
    }
    public int getCurrentHp() 
    { 
        return this.shrHPcurrent; 
    }
    public int getMaxHp() 
    { 
        return this.shrHPmax; 
    }
}