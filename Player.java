
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Trainer
{
    private String strPass;    
    private int intProg; 
    
    Player(String x, String y)
    {
        super(x);
        this.strPass = y;
        this.intProg = 1;
    }
}