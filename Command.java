 

import java.util.ArrayList;
/**
 * Write a description of class Command here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Command
{
    // instance variables - replace the example below with your own
    private String command, verb, object, means, conj;
    private int index;
    
    private String[] verbs = new String[]{"talk to","get","take","drop","let go","unlock","open","break","look","l","i","inv","inventory","score","help","open","close",
        "shut","snatch","eat","munch","devour","put","place","talk","speak","converse with","kill","fight","stab","drop","light","ignite","burn","give","arthur","king arthur",
        "excalibur","excaliber","break","destroy","cut","smash", "hi","hello"};

    
    /**
     * Constructor for objects of class Command
     */
    public Command()
    {
        command = "";
        verb = "";
        object = "";
        means = "";
        conj = "";
        index = -1;
    }
   
    public String getCommand(){return command;}
    public String getObject(){return object;}
    public String getVerb(){return verb;}
    public String getMeans(){return means;}
    public String getConj(){return conj;}
    public int getIndex(){return index;}
    
    public boolean hasVerb(){return !verb.equals("");}
    
    public boolean isTakeAll() {return isTake() && object.equals("all");}
    public boolean isDropAll() {return isDrop() && object.equals("all");}
    
    public boolean isDirection(){return isNorth() || isSouth() || isEast() || isWest() || isUp() || isDown();}
    public boolean isNorth(){return command.equals("n") || command.equals("go n") || command.equals("north") || command.equals("go north");}    
    public boolean isSouth(){return command.equals("s") || command.equals("go s") || command.equals("south") || command.equals("go south");}
    public boolean isEast(){return command.equals("e") || command.equals("go e") || command.equals("east") || command.equals("go east");}
    public boolean isWest(){return command.equals("w") || command.equals("go w") || command.equals("west") || command.equals("go west");}
    public boolean isUp(){return command.equals("u") || command.equals("go u") || command.equals("up") || command.equals("go up");}    
    public boolean isDown(){return command.equals("d") || command.equals("go d") || command.equals("down") || command.equals("go down");}
    
    public boolean hasObject(){return !object.equals("");}
    public boolean hasMeans(){return !means.equals("");}
    
    
    public boolean isOther(){
        return isInv() || isHelp()|| isScore() || isLook();
    }
    
    public boolean isInv(){return verb.equals("inv") || verb.equals("inventory") || verb.equals("i");}
    public boolean isHelp(){return verb.equals("help");}
    public boolean isScore(){return verb.equals("score");}
    public boolean isLook(){return verb.equals("look")||verb.equals("l");}
    public boolean isDrop(){return verb.equals("drop")||verb.equals("let go");}
    public boolean isTalk(){return verb.equals("talk")||verb.equals("speak")||verb.equals("converse with")||verb.equals("talk to");}
    public boolean isOpen(){return verb.equals("open");}
    public boolean isClose(){return verb.equals("close")||verb.equals("shut");}
    public boolean isKill(){return verb.equals("kill")||verb.equals("fight")||verb.equals("stab");}
    public boolean isEat(){return verb.equals("eat")||verb.equals("munch")||verb.equals("bite");}
    public boolean isPut(){return verb.equals("put")||verb.equals("place")||verb.equals("drop");}
    public boolean isTake(){return verb.equals("get") || verb.equals("take");}
    public boolean isLight(){return verb.equals("light")||verb.equals("ignite")||verb.equals("burn");}
    public boolean isGive(){return verb.equals("give");}
    public boolean isArthur() {return verb.equals("arthur")||verb.equals("king arthur")||verb.equals("excalibur")||verb.equals("excaliber");}
    public boolean isBreak() {return verb.equals("break")||verb.equals("destroy")||verb.equals("cut")||verb.equals("smash");}
    public boolean isHi() {return verb.equals("hi")||verb.equals("hello");}
    
    public boolean objIsItem(Item x)
    {
        for (int i=0; i<x.getAlias().length;i++) 
            if (object.equals(x.getAlias()[i]))return true;
        return false;
    }
    public boolean meansIsItem(Item x)
    {
        for (int i=0; i<x.getAlias().length;i++) 
            if (means.equals(x.getAlias()[i]))return true;
        return false;
    }
    
    public boolean isItem(ArrayList<Item> items)
    {
        for (int i=0; i<items.size(); i++)
        if (objIsItem(items.get(i))) return true;
        return false;
    }
    public Item objToItem(ArrayList<Item> items)
    {
        for (int i=0; i<items.size(); i++)
        if (objIsItem(items.get(i))) return items.get(i);
        return null;
    }
    public Item meansToItem(ArrayList<Item> items)
    {
        for (int i=0; i<items.size(); i++)
        if (meansIsItem(items.get(i))) return items.get(i);
        return null;
    }
    
    public String lastWord()
    {
        int index = 0;
        for (int i=0; i<command.length(); i++)
            if (command.charAt(i)==' ') {
                index = i;
            }
        return command.substring(index+1,command.length());
    }
    
    public boolean isNoun(String x,ArrayList<Item> items)
    {
        String noun="";
        for (int i=0;i<items.size();i++)
            for (int k=0;k<items.get(i).getAlias().length;k++){
                noun = items.get(i).getAlias()[k];
                if (x.length()>=noun.length() && x.substring(0,noun.length()).equals(noun)){return true;}
            }
        return false;
     }
    public String toNoun(String x,ArrayList<Item> items)
    {
        String noun="";
        for (int i=0;i<items.size();i++)
            for (int k=0;k<items.get(i).getAlias().length;k++){
                noun = items.get(i).getAlias()[k];
                if (x.length()>=noun.length() && x.substring(0,noun.length()).equals(noun)){return items.get(i).getAlias()[k];}
            }
        return null;
    }
    
    public void setCommand(String x,ArrayList<Item> items)
    {
        verb = "";
        object = "";
        means = "";
        conj = "";
        index = -1;
        
        command = x.trim().toLowerCase();
        if (command.length()>2 && command.substring(0,3).equals("say")) command = command.substring(3,command.length());
        removeConjunctions();
        
        removeSpaces();
        command = command.trim();
        
        verb = "";
        for (int i=0; i<verbs.length; i++)
            if (verbs[i].length()<=command.length()){
                if (command.substring(0,verbs[i].length()).equals(verbs[i]) && (command.length() == verbs[i].length() || command.charAt(verbs[i].length())==' ')) {
                    verb = verbs[i]; break;
                }
            }
          
        if (verb.equals("") || verb.equals(command)) object="";
        else {
            if (isNoun(command.substring(verb.length()+1,command.length()),items))object = toNoun(command.substring(verb.length()+1,command.length()),items);
            else object = "";
        }
        if (!isTalk()){
        for (int i=0;i<command.length()-3;i++)
            if (command.substring(i,i+4).equals(" in ")) {conj = "in"; index = i+4;break;}
            else if (command.substring(i,i+4).equals(" on ")) {conj = "on"; index = i+4;break;}
            else if (command.substring(i,i+4).equals(" to ")) {conj = "to"; index = i+4;break;}
            else if (i<command.length()-5 && command.substring(i,i+6).equals(" with ")) {conj = "with";index=i+6; break;}
        }
        if (index > 0 && isNoun(command.substring(index,command.length()),items))means = toNoun(command.substring(index,command.length()),items);
            else means = "";
    }
    
    public void removeConjunctions()
    {
        int x = 0;
        boolean hasConjunctions = true;
        while (hasConjunctions){
        for (int i=0; i<command.length();i++){
            if (i<command.length()-4){
                if (command.substring(i,i+5).equals(" the ")) {cutCommand(i+1,i+4); x++; break;}
                if (command.substring(i,i+5).equals(" dat ")) {cutCommand(i+1,i+4); x++; break;}
            }
            if (i<command.length()-3){
                if (command.substring(i,i+4).equals("walk")) {cutCommand(i,i+4); x++; break;}
                if (command.substring(i,i+4).equals(" an ")) {cutCommand(i+1,i+3); x++; break;}
                if (command.substring(i,i+4).equals(" of ")) {cutCommand(i+1,i+3); x++; break;}
                if (command.substring(i,i+4).equals(" at ")) {cutCommand(i+1,i+3); x++; break;}

            }
            if (i<command.length()-2){
                if (command.substring(i,i+3).equals(" a ")) {cutCommand(i+1,i+2);  x++;break;}
            }
            
        }
        if (x>0) x=0;
        else hasConjunctions = false;
        }
    }
    
    public void cutCommand(int start, int end) {command = command.substring(0,start)+command.substring(end,command.length());}
    
    public void removeSpaces()
    {
        int x = 0;
        boolean hasSpaces = true;
        while (hasSpaces){
        for (int i=0; i<command.length();i++){
            if (command.charAt(i) == ' ' && command.charAt(i+1) == ' ' ){
                cutCommand(i+1,i+2); x++; break;
            }
        }
        if (x>0) x=0;
        else hasSpaces = false;
        }
    }
}
