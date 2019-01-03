 

import java.util.ArrayList;
/**
 * Write a description of class Container here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Item
{
    // instance variables
    int level;

    /**
     * Constructor for objects of class Item
     */
    public Weapon(String names, String[] aliass, boolean canMoves, int levels)
    {
        super(names,aliass,canMoves);
        level = levels;
    }
    
    public boolean isContainer() {return false;}
    public boolean isOpen() {return false;}
    public void open() {}
    public void close() {}
    public boolean isKnown() {return false;}
    public void setKnown(boolean x) {}
    public ArrayList<Item> getContents() {return null;}
    public boolean isCharacter() {return false;}
    public void add(Item item){}
    public void printItems(){}
    public boolean has(Item item){return false;}
    public void remove(Item item){}
    public boolean isWeapon() {return true;}

    
    public int level() {return level;}
    
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
