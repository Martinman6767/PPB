
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Trainer
{
    private String strPass;    
    private byte bytProg; 
    
    Player(String x, String y)
    {
        super(x);
        this.strPass = y;
        this.bytProg = 1;
    }
    public void advanceLevel()
    {
        this.bytProg++; 
    }
    public int getPorg()
    {
        return this.bytProg; 
    }
    public void setProg(byte x)
    {
        this.bytProg = x; 
    }
    public String getPassword()
    {
        return this.strPass;
    }
}