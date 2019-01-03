 

import java.util.ArrayList;
/**
 * Class to set all the characteristics of the player
 * Name, health, inventory, etc.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    public String playerName;
    ArrayList<Item> inventory  = new ArrayList<Item>();

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        playerName = null;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(String name)
    {
        playerName = name;
    }

    public boolean has(Item item) // goes through inventory to see if player has a torch.
    {   
        if (item.getName().equals("bare hand")) return true;
        for (int i=0; i < inventory.size(); i++)
            if (inventory.get(i).getName().equals(item.getName())||inventory.get(i).has(item)) return true;
        return false;
    }

    public boolean has(String item) // goes through inventory to see if player has a torch.
    {
        for (int i=0; i < inventory.size(); i++)
            if (inventory.get(i).getName().equals(item)) return true;
        return false;
    }

    public void remove(Item item)
    {
        for (int i = 0; i < inventory.size(); i++)
            if (inventory.get(i).getName().equals(item.getName())) inventory.remove(i);
    }

    public void printInv()
    {
        if (inventory.size()==0) print("You are empty-handed.");
        else System.out.println("> You are carrying: "+inventory);
    }

    public void add(Item x)
    {
        inventory.add(x);
    }

    public ArrayList<Item> getInv() {return inventory;}

    public void removeAll()
    {
        while (inventory.size()>0) inventory.remove(0);
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
