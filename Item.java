import java.util.ArrayList;
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables
    private String name;
    private String[] alias;
    private boolean canMove;

    /**
     * Constructor for objects of class Item
     */
    public Item(String names, String[] aliass, boolean canMoves)
    {
        name = names;
        alias = aliass;
        canMove = canMoves;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String[] getAlias(){return alias;}
    public boolean is(Item item) {return name.equals(item.getName());}
    public boolean canMove() {return canMove;}
    public boolean isContainer() {return false;}
    public boolean isOpen() {return false;}
    public void open() {}
    public void close() {}
    public void add(Item item) {}
    public boolean has(Item item) {return false;}
    public void remove(Item item) {}
    public void printItems(){}
    public boolean isKnown() {return false;}
    public void setKnown(boolean x) {}    
    public ArrayList<Item> getContents() {return null;}
    public boolean isCharacter() {return false;}
    public boolean isWeapon() {return false;}
    public void killWith(Item weapon){}
    public int level(){return -1;}
    
    public String toString()
    {
        return name;
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
