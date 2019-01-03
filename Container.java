import java.util.ArrayList;
/**
 * Write a description of class Container here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Container extends Item
{
    // instance variables
    private boolean isOpen = false;
    private boolean isKnown = false;
    private ArrayList<Item> contents = new ArrayList<Item>();

    /**
     * Constructor for objects of class Item
     */
    public Container(String names, String[] aliass, boolean canMoves)
    {
        super(names,aliass,canMoves);
    }
    
    public String getName()
    {
        return super.getName();
    }
    
    public boolean is(Item item) {return super.is(item);}
    public boolean canMove() {return super.canMove();}
    public String[] getAlias(){return super.getAlias();}
    public boolean isContainer() {return true;}
    public boolean isOpen() {return isOpen;}
    public void open() {isOpen = true;}
    public void close() {isOpen = false;}
    public boolean isKnown() {return isKnown;}
    public void setKnown(boolean x) {isKnown = x;}
    public ArrayList<Item> getContents() {return contents;}
    public boolean isCharacter() {return false;}
        public boolean isWeapon() {return false;}
    
    public void add(Item item)
    {
        contents.add(item);
    }
    public void printItems()
    {
        if (contents.size()==0 || !isKnown) ;
        else {
            System.out.println("  The "+getName()+" contains:");
            for (int i=0;i<contents.size();i++){
                System.out.println("    a "+contents.get(i));
                if (contents.get(i).isContainer()) contents.get(i).printItems();
            }
        }
    }
    
    public boolean has(Item item)
    {
        for (int i=0;i<contents.size();i++){
            if (contents.get(i).is(item)) return true;
            else if (contents.get(i).isContainer())
                if (contents.get(i).has(item)) return true;
        }
        return false;
    }
    
    public void remove(Item item)
    {
        for (int i=0;i<contents.size();i++){
            if (contents.get(i).is(item)) contents.remove(i);
            else if (contents.get(i).has(item)) 
                if (contents.get(i).isOpen())contents.get(i).remove(item);
                else print("The "+contents.get(i)+" is closed.");
        }
    }
    
    public String toString(){return super.toString();}
    
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
