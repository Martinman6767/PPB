
/**
 * Write a description of class Trainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Trainer
{
    private String strName; 
    private ArrayList<Pokemon> Party= new ArrayList<Pokemon>();
    Trainer(String x)
    {
        this.strName = x;
    }
    
    public void AddPokemon(Pokemon p)
    {
        Party.add(p);
    }
    
    public ArrayList<Pokemon> getParty()
    {
        return this.Party;
    }
    
    public String getName()
    {
        return this.strName;
    }

}