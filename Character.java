import java.util.ArrayList;
/**
 * Write a description of class Container here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Item
{
    // instance variables
    boolean isAlive =true;
    int level;

    /**
     * Constructor for objects of class Item
     */
    public Character(String names, String[] aliass, boolean canMoves, int levels)
    {
        super(names,aliass,canMoves);
        level = levels;
    }
    public boolean isAlive(){return isAlive;}
    public String getName(){return super.getName();}
    public boolean is(Item item) {return super.is(item);}
    public boolean canMove() {return super.canMove();}
    public String[] getAlias(){return super.getAlias();}
    public boolean isContainer() {return false;}
    public boolean isOpen() {return false;}
    public void open() {}
    public void close() {}
    public boolean isKnown() {return false;}
    public void setKnown(boolean x) {}
    public ArrayList<Item> getContents() {return null;}
    public boolean isCharacter() {return true;}
    public void add(Item item){}
    public void printItems(){}
    public boolean has(Item item){return false;}
    public void remove(Item item){}
    public String toString()
    {
        if (isAlive) return getName();
        else return "dead "+getName();
    }
    public boolean isWeapon() {return false;}
    
    public void killWith(Item weapon)
    {
        if (weapon.level()<level) print("A "+weapon+" is not powerful enough to kill the "+getName()+"!");
        else{
            if (weapon.getName().equals("bare hand")) print("You strangle the rat and beat it to a pulp.");
            isAlive=false;
        }
    }
    
    public void die()
    {
        print("With a puff of smoke, the "+getName()+"'s carcass disappears.");
    }
    
    private void print(String str)//method reformats System.out.println() to automatically insert line breaks.
    {
        if (str.length() <= 64) System.out.println("> "+str);
        else {
            int prev = 0;
            int y = 0;
            int x = 1;
            
            for (int i = 0; i<str.length(); i++){
                if (str.charAt(i) == ' '){
                    y=i;
                }
                if (i/x > 64){
                    if (x==1) System.out.println("> "+str.substring(prev,y+1));
                    else System.out.println("  "+str.substring(prev,y+1));
                    prev = y+1;
                    x++;
                }
            }
            System.out.println("  "+str.substring(prev,str.length()));
        }
    }
    
    
}
