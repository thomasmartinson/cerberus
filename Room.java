 

import java.util.ArrayList;
/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Room
{
    private boolean isNew, isDiff, isDark;
    private final String name;
    private String info;
    private int north, south, east, west, up, down;
    private final int ID;
    private ArrayList<Item> itemsOnFloor;
    public Room(int n, int s, int e, int w, int u, int d, String name, 
            String info, int ID)
    {
        isDiff = true;
        isNew = true;

        this.name = name;
        this.info = info;
        north = n;
        south = s;
        east = e;
        west = w;
        up = u;
        down = d;
        this.ID = ID;
        itemsOnFloor = new ArrayList();
    }
    
    public int getNorth() {return north;}
    public void setNorth(int room){north = room;}
    public int getSouth() {return south;}
    public void setSouth(int room){south = room;}
    public int getEast() {return east;}
    public void setEast(int room){east = room;}
    public int getWest() {return west;}
    public void setWest(int room){west = room;}
    public int getUp() {return up;}
    public void setUp(int room){up = room;}
    public int getDown() {return down;}
    public void setDown(int room){down = room;}
    public String getName() {return name;}
    public int getID() {return ID;}
    public boolean isDark() {return isDark;}
    public void setDark(boolean x) {isDark=x;}    
    public ArrayList<Item> getItems() {return itemsOnFloor;}
    
    public void add(Item item) {
        itemsOnFloor.add(item);
    }
    
    public void remove(Item item)
    {
        for (int i = 0; i < itemsOnFloor.size(); i++)
            if (itemsOnFloor.get(i).getName().equals(item.getName())) itemsOnFloor.remove(i);
            else if (itemsOnFloor.get(i).has(item)) 
                if (itemsOnFloor.get(i).isOpen())itemsOnFloor.get(i).remove(item);
                else print("You don't see a "+item+" here.");            
    }
    
    public void removeAll()
    {
        for (int i=itemsOnFloor.size()-1;i>=0; i--)
            if (itemsOnFloor.get(i).canMove()) itemsOnFloor.remove(i);
    }
    
    public void setNew(boolean x)
    {
        isNew = x;
    }
    public boolean isNew() {return isNew;}
    
    public void setDiff(boolean x)
    {
        isDiff = x;
    }
    public boolean isDiff() {return isDiff;}
    
    public void setInfo(String x)
    {
        info = x;
    }
    
    public boolean has(Item item) // goes through itemsOnFloor to see if room has a torch.
    {
        for (Item itemOnFloor : itemsOnFloor)
            if (itemOnFloor.getName().equals(item.getName())) return true;
            else if (itemOnFloor.isContainer())
                if (itemOnFloor.has(item)) return true;
        return false;
    }
}
