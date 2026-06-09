
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
    private byte bytLevel;
    private short shrHPmax;
    private short shrHPcurrent;
    private short shrAttack;
    private short shrExpCurrent;
    private short shrExpNeed;
    
    Pokemon(String x, String y, short z, short e    )
    {
        this.strName = x;
        this.strType = y;
        this.bytLevel = 1;
        this.shrHPmax = z;
        this.shrHPcurrent = z;
        this.shrAttack = e;
        this.shrExpCurrent = 0;
        this.shrExpNeed = 100;
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
    public byte getLevel()
    {
        return this.bytLevel;
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