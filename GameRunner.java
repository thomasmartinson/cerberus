
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Runner, use this class to play the game.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameRunner
{
    private static boolean win = false;
    private static boolean lose = false;
    private static int score = 0;
    private static int moves = 0;


    private static Room throneRoom = new Room(0,0,0,0,0,2,"THRONE ROOM","You are in the throne room. A king sits in his high seat, looking greatly concerned. A grand stairway leads down.", 1);
    private static Room cellar = new Room(3,0,4,9,1,0,"CELLAR","You stand in a dank dungeon of a place. Through a heavy gate to the north, you can see a room gleaming with treasures. A corridor leads east and west, but the west exit is blocked by heavy wooden boards. A small marble pedestal stands in the middle of the room before the gate. A stairway leads up.",2);
    private static Room treasury = new Room(0,2,0,0,0,0,"TREASURY","All around, the room is filled from top to bottom with gold and precious jewels. In the center of the room sits an exquisite crown.",3);
    private static Room eastCorridor = new Room(0,0,5,2,0,0,"EAST CORRIDOR","This passageway leads east and west.",4);
    private static Room ratRoom = new Room(7,0,0,4,0,6,"RAT ROOM","An enormous menacing rat sits on a mound at the center of the room. A rat-sized hole leads downward. There are exits to the north and west.",5);
    private static Room ratHole = new Room(0,0,0,0,5,0,"RAT PIT","You crouch in the dwelling place of the rat. On the floor there is a huge bone, a coin, and a box of matches. The hole exits upward.",6);
    private static Room tntRoom = new Room(0,5,0,0,0,0,"DYNAMITE ROOM","Here the passage ends. On the north side of the room there is a large barrel labeled 'TNT', with a fuse extending about a foot. A passage leads south.",7);
    private static Room armory = new Room(0,7,0,0,0,0,"ARMORY","You enter some sort of ancient armory. Almost every item here has rusted away or was destroyed in the explosion, except for an ancient axe leaning against the far wall. A smoldering hole leads south.",8);
    private static Room westCorridor = new Room(0,0,2,10,0,0,"WEST CORRIDOR","This passageway leads west and east.",9);
    private static Room trollBridge = new Room(0,0,9,11,0,0,"TROLL BRIDGE","You stand on a bridge that crosses a large ravine. A grumpy-looking troll sits ahead of you. The bridge continues west, and a passageway leads east.",10);
    private static Room mustyCave = new Room(13,0,10,12,0,0,"MUSTY CAVE","You stand in the middle of an old cave. Moss grows on all of the walls. The cave continues west, and a bridge leads east. To the north the cave branches off. From this passage you hear low grumbling and snarling.",11);
    private static Room swordInTheStone = new Room(0,0,11,0,0,0,"SWORD IN THE STONE","The cave reaches a dead end here. In the middle of the room there is a mighty sword stuck in a stone by the blade. Scrawled on the cave wall are the words 'SAY MY NAME'.",12);
    private static Room cerberusLair = new Room(0,11,0,0,0,0,"CERBERUS'S LAIR","You stand before an enormous three-headed dog. The cavernous room is almost filled with the beast's colossal form. Cerberus bares all three sets of his teeth, letting out a low but ferocious growl. You catch a glimpse of a golden chest behind the beast's hind legs. An exit is to the south.",13);
    
    private static Room currentRoom = throneRoom;

    private static Player player = new Player();

    private static String[] xchest = new String[]{"chest","box","golden","golden chest"};
    private static String[] xsatchel = new String[]{"satchel"};
    private static String[] xmisc = new String[]{"all"};
    private static String[] xboard = new String[]{"boarded-up passageway","board","boards"};
    private static String[] xbone = new String[]{"giant bone","bone","big bone","enormous bone"};
    private static String[] xorb = new String[]{"magical glowing orb","orb","sphere,","magic orb","glowing orb","magical orb"};
    private static String[] xmatches = new String[]{"box of matches","matches","match"};
    private static String[] xcoin = new String[]{"coin","money"};
    private static String[] xcrown = new String[]{"exquisite crown", "crown", "hat"};
    private static String[] xtnt = new String[]{"barrel of dynamite","tnt","dynamite","barrel","dynamite barrel","fuse"};
    private static String[] xpedestal = new String[]{"marble pedestal","marble","pedestal"};
    private static String[] xhands = new String[]{"bare hands","fist","fists","hand","hands","punch"};
    private static String[] xaxe = new String[]{"ancient axe","axe"};
    private static String[] xsword = new String[]{"mighty sword","sword","excalibur","excaliber"};
    private static String[] xking = new String[]{"king","man"};
    private static String[] xrat = new String[]{"giant rat","rat"};
    private static String[] xtroll = new String[]{"troll","grumpy-looking troll","grumpy troll"};
    private static String[] xcerberus = new String[]{"cerberus","dog","three-headed dog","beast"};

    private static Container chest = new Container("chest",xchest,false);
    private static Container satchel = new Container("satchel",xsatchel,true);
    private static Item misc = new Item("misc",xmisc,true);
    private static Item board = new Item("boarded-up passageway",xboard,false);
    private static Item bone = new Item("giant bone",xbone,true);
    private static Item orb = new Item("magical glowing orb",xorb,true);
    private static Item matches = new Item("box of matches",xmatches,true);
    private static Item coin = new Item("coin",xcoin,true);
    private static Item crown = new Item("exquisite crown",xcrown,true);
    private static Item tnt = new Item("barrel of dynamite",xtnt,false);
    private static Item pedestal = new Item("marble pedestal",xpedestal,false);
    private static Weapon hands = new Weapon("bare hand",xhands,false,0);
    private static Weapon axe = new Weapon("ancient axe",xaxe,true,3);
    private static Weapon sword = new Weapon("mighty sword",xsword,true,5);
    private static Character king = new Character("king",xking,false,5);
    private static Character rat = new Character("giant rat",xrat,false,0);
    private static Character troll = new Character("grumpy-looking troll",xtroll,false,3);
    private static Character cerberus = new Character("Cerberus",xcerberus,false,5);

    private static ArrayList<Item> items = new ArrayList<Item>();
    private static ArrayList<Room> rooms = new ArrayList<Room>();

    private static boolean hasSpoken = false;
    private static boolean hasBoard = true;
    private static boolean isPinned = false;
    private static boolean hasOrb = false;
    private static boolean hasTroll = true;
    private static boolean hasDog = true;

    private static String input = "";
    private static boolean play = true;

    private static Command command = new Command();
    private static Scanner in = new Scanner (System.in);

    public GameRunner()
    {

    }

    private static void start(){
        throneRoom.add(king);
        cellar.add(board);cellar.add(pedestal);
        treasury.add(crown);
        ratRoom.add(rat);
        ratHole.add(bone);ratHole.add(matches);ratHole.add(coin);
        tntRoom.add(tnt);
        armory.add(axe);
        trollBridge.add(troll);
        swordInTheStone.add(sword);
        cerberusLair.add(cerberus);cerberusLair.add(chest);chest.add(orb);

        items.add(chest);items.add(matches);items.add(axe);
        items.add(satchel);items.add(coin);items.add(sword);
        items.add(misc);items.add(crown);items.add(king);
        items.add(board);items.add(tnt);items.add(rat);
        items.add(bone);items.add(pedestal);items.add(troll);
        items.add(orb);items.add(hands);items.add(cerberus);

        
    }

    private static void testCommand()
    {
        start(); print("");
        while (!input.equals("stop")){
            input = in.nextLine();
            command.setCommand(input,items);
            System.out.println("Command: "+command.getCommand());
            System.out.println("Verb: "+command.getVerb());
            System.out.println("Object: "+command.getObject());
            System.out.println("Conj: "+command.getConj());
            System.out.println("Index: "+command.getIndex());
            System.out.println("Means: "+command.getMeans());
        }
    }

    public static void main(String[] args)
    {
        start();
        print("TYPE 'HELP' AT ANY TIME FOR INSTRUCTIONS.");
        while (play){
            while (!win && !lose)//loops once for every turn until the game is over
            {
                saveRooms();
                if (currentRoom==cellar && player.has(orb)) {print("CELLAR");print("As soon as you walk into the room, the magic orb glows brightly and floats onto the pedestal. The gates to the treasury crash open.");hasOrb=true;player.remove(orb);cellar.add(orb);}
                else currentRoom.printInfo();//prints the description of the current room at every turn
                saveRooms();
                currentRoom.setNew(false);
                saveRooms();
                input = in.nextLine();
                saveRooms();
                command.setCommand(input,items);
                saveRooms();
                if (command.getVerb().equals("")){
                    if (command.isDirection())move();
                    else print("There was no verb in that sentence!");
                }
                else if (command.hasVerb())act();
                else print("Command not recognized. Please try again.");
                moves++;
                saveRooms();
            }

            if (lose) {
                print("You died with a score of "+score+"/100 Play again?");

                int q = 0;
                while (q==0){
                    input = in.nextLine().trim().toLowerCase();
                    if (input.equals("yes")) {q++; lose=false;restart();}
                    else if (input.equals("no")) {q++; play = false;}
                    else print("Command not recognized. Please try again.");
                }
            }
            if (win) {
                print("Congratulations! You have won the game with a score of "+score+"/100! Play again?");

                int q = 0;
                while (q==0){
                    input = in.nextLine().trim().toLowerCase();
                    if (input.equals("yes")) {q++; win=false;restart();}
                    else if (input.equals("no")) {q++; play = false;}
                    else print("Command not recognized. Please try again.");
                }
            }
        }
    }

    private static void act()
    {
        if (command.isTake()) take();
        else if (command.isDrop()) drop();
        else if (command.isOpen()) open();
        else if (command.isClose()) close();
        else if (command.isEat()) eat();
        else if (command.isPut()) put();
        else if (command.isOther()) other();
        else if (command.isTalk()) talk();
        else if (command.isKill()) kill();
        else if (command.isGive()) give();
        else if (command.isLight()) light();
        else if (command.isArthur()) arthur();
        else if (command.isBreak()) destroy();
        else if (command.isHi()) hi();
        else print("code went poopy.");
        //else if (command.is
    }
    
    private static void hi(){print("Hello!");}
    
    private static void talk()
    {
        if (command.getObject().equals("")) print("Whom do you want to talk to?");
        else if (!currentRoom.has(command.objToItem(items))) print("You don't see a "+command.meansToItem(items)+" here.");
        else if (!command.objToItem(items).isCharacter()) print("Are you really so lonely that you speak to inanimate objects?");
        else if (command.objToItem(items).is(king)){hasSpoken=true;print("King: 'Adventurer! I need your help. I left my crown in the treasury beneath the palace, but a great beast took my magic orb, which is the key to the treasury. Given that I am an incompetent NPC, I need you to take on this quest. Type 'help' at anytime for further instructions. Get me my crown!'");}
        else if (command.objToItem(items).is(rat)){score=score+15;ratRoom.remove(rat);print("Struck by sudden diplomatic inspiration, you attempt to solve your problem with the rat through open dialogue. After sitting down and conferencing with the hideous monster, the two of you settle your differences, and agree to let each other live. The rat then disappears in a puff of smoke.");}
        else if (command.objToItem(items).is(troll)){print("Troll: 'This is my bridge! If you want to pass my bridge, you must pay a toll! Cash only! We don't accept credit cards or checks!'");}
        else if (command.objToItem(items).is(cerberus)){print("Cerberus only growls in response. He looks ready to eat you.");}
    }
    
    private static void arthur(){
        if (currentRoom==swordInTheStone && !player.has(sword)) {print("At the invocation of that powerful name, the sword glows white-hot and flies into your hand.");currentRoom.remove(sword);player.add(sword);score=score+10;}
        else print("I hear he has a thing with swords and stones.");
    }
    private static void destroy()
    {
        if (command.getObject().equals("") && command.getMeans().equals("")) print("What do you want to break?");
        else if (command.getMeans().equals("")) print("What do you want to break the "+command.objToItem(items)+" with?");
        else if (command.getObject().equals("")) print("What do you want to break with the "+command.meansToItem(items)+"?");
        else if (!currentRoom.has(command.meansToItem(items))&&!player.has(command.meansToItem(items))) print("You don't see a "+command.meansToItem(items)+" here.");
        else if (!currentRoom.has(command.objToItem(items)) && !player.has(command.objToItem(items))) print("You don't have a "+command.objToItem(items)+".");
        else if (!command.objToItem(items).is(board)) print("You can't break that.");
        else if (!command.meansToItem(items).is(axe)) print("You can't break anything with a "+command.meansToItem(items)+"!");
        else {print("With a heavy stroke, you smash the barrier to pieces. The ancient axe, utterly spent, crumbles in your hands.");currentRoom.remove(board);player.remove(axe);score = score+10;}
    }
    
    private static void light()
    {
        if (command.getObject().equals("") && command.getMeans().equals("")) print("What do you want to light?");
        else if (command.getMeans().equals("")) print("What do you want to light the "+command.objToItem(items)+" with?");
        else if (command.getObject().equals("")) print("What do you want to light with the "+command.meansToItem(items)+"?");
        else if (!currentRoom.has(command.meansToItem(items))&&!player.has(command.meansToItem(items))) print("You don't have a "+command.meansToItem(items)+".");
        else if (!currentRoom.has(command.objToItem(items)) && !player.has(command.objToItem(items))) print("You don't see a "+command.objToItem(items)+"here.");
        else if (!command.objToItem(items).is(tnt)) print("You can't light that.");
        else if (!command.meansToItem(items).is(matches)) print("You can't light anything with a "+command.meansToItem(items)+"!");
        else {print("You ignite the fuse to the dynamite, and take cover on the opposite side of the room. The dynamite explodes and leaves a smoldering hole on the north side of the wall.");tntRoom.setNorth(8);tntRoom.remove(tnt);score=score+10;}
    }
    
    private static void kill()
    {
        if (command.getObject().equals("") && command.getMeans().equals("")) print("What do you want to kill?");
        else if (command.getMeans().equals("")) print("What do you want to kill the "+command.objToItem(items)+" with?");
        else if (command.getObject().equals("")) print("What do you want to kill with the "+command.meansToItem(items)+"?");
        else if (!currentRoom.has(command.meansToItem(items))&&!player.has(command.meansToItem(items))) print("You don't see a "+command.meansToItem(items)+" here.");
        else if (!currentRoom.has(command.objToItem(items)) && !player.has(command.objToItem(items))) print("You don't have a "+command.objToItem(items)+".");
        else if (!command.objToItem(items).isCharacter()) print("How can you kill that which does not live?");
        else if (!command.meansToItem(items).isWeapon()) print("You can't kill anything with a "+command.meansToItem(items)+"!");
        else if (player.has(command.meansToItem(items))){
            if (currentRoom==ratRoom && currentRoom.has(rat)){rat.killWith(command.meansToItem(items));
                if (!rat.isAlive()) {print("The rat's dead body disappears in a cloud of smoke.");ratRoom.remove(rat);score=score+15;}
            }
            else if (currentRoom==trollBridge){troll.killWith(command.meansToItem(items));}
            else if (currentRoom==cerberusLair) {cerberus.killWith(command.meansToItem(items));
                if (!cerberus.isAlive()) {print("With one mighty strike, you cut off all three heads of Cerberus. The beast lets out a horrible roar, and then breathes ist last. The mighty carcass in a sudden puff of smoke.");cerberusLair.remove(cerberus);score=score+25;}
            }
            else if (currentRoom==throneRoom) {king.killWith(command.meansToItem(items));
                if (!king.isAlive()) {print("With one swift stab, you kill your greatest enemy, the king. You now rule the kingdom!");score=score+20; win=true;}
            }
            else print("code went poopy.");
        }
        else print("code went poopy.");
    }
    
    private static void give()
    {
        if (command.getObject().equals("") && command.getMeans().equals("")) print("What do you want to give?");
        else if (command.getMeans().equals("")) print("What do you want to give the "+command.objToItem(items)+" to?");
        else if (command.getObject().equals("")) print("What do you want to give to the "+command.meansToItem(items)+"?");
        else if (!currentRoom.has(command.meansToItem(items))&&!player.has(command.meansToItem(items))) print("You don't see a "+command.meansToItem(items)+" here.");
        else if (!player.has(command.objToItem(items))) print("You don't have a "+command.objToItem(items)+".");
        else if (!command.meansToItem(items).isCharacter()) print("Why do you want to give anything to an inanimate object?");
        else if (player.has(command.objToItem(items))){
            if (currentRoom==trollBridge && command.objToItem(items).is(coin)) {print("The troll gratefully accepts your payment and giddily hops off the bridge. He'll probably use that coin to buy more booze.");trollBridge.remove(troll);player.remove(coin);score=score+10;}
            else if (currentRoom==cerberusLair && command.objToItem(items).is(bone)){print("Cerberus's eyes light up when he sees his beloved bone. You toss it to him and he chomps on it greedily. Distracted, he no longer is guarding the chest.");hasDog=false;}
            else if (currentRoom==throneRoom && command.objToItem(items).is(crown)){print("King: 'You have successfully retrieved my crown! Excellent work, adventurer!"); score=score+20;win=true;}
            else {print("The "+command.meansToItem(items)+" is surprised by your sudden generosity.");player.remove(command.objToItem(items));}
        }
        else print("code went poopy.");
    }
    
    private static void put()
    {
        if (command.getObject().equals("") && command.getMeans().equals("")) print("What do you want to put?");
        else if (command.getMeans().equals("")) print("Where do you want to put the "+command.objToItem(items)+"?");
        else if (command.getObject().equals("")) print("What do you want to put in the "+command.meansToItem(items)+"?");
        else if (!command.meansToItem(items).isContainer()) print("Good luck trying to put anything in a "+command.meansToItem(items)+"!");
        else if (!currentRoom.has(command.meansToItem(items))&&!player.has(command.meansToItem(items))) print("You don't see a "+command.meansToItem(items)+" here.");
        else if (!currentRoom.has(command.objToItem(items)) && !player.has(command.objToItem(items))) print("You don't have a "+command.objToItem(items)+".");
        else if (!command.meansToItem(items).isOpen()) print("The "+command.meansToItem(items)+" is closed.");
        else if (command.meansToItem(items).is(command.objToItem(items))) print("You attempt that incredible feat by turning the "+command.objToItem(items)+" inside out. It doesn't do much good.");
        else if (player.has(command.objToItem(items))){
            print("Done."); player.remove(command.objToItem(items)); command.meansToItem(items).add(command.objToItem(items));
        }
        else if (currentRoom.has(command.objToItem(items))){
            if (command.objToItem(items).canMove()) {
                print("Done."); currentRoom.remove(command.objToItem(items)); command.meansToItem(items).add(command.objToItem(items));
            }
            else print("You can't pick up the "+command.objToItem(items)+".");
        }
        else print("code went poopy.");
    }

    private static void move()
    {
        if (currentRoom==throneRoom && command.isDown() && !hasSpoken)
            print("King: 'Do not leave yet, I need to talk to you.'");
        else if (isPinned) print("You can't move while you are pinned under the rat!");
        else if (currentRoom==ratRoom && (command.isDown()||command.isNorth()) && ratRoom.has(rat)){
            print("You try to go that way, but the rat suddenly pounces on you!"); isPinned = true;}
        else if (currentRoom==cellar && command.isNorth() && !hasOrb) print("You push on the gates but they won't budge. The key might have something to do with that pedestal.");
        else if (currentRoom==cellar && command.isWest() && hasBoard) print("The boards are very solid, and won't budge. You need some heavy tool to break them.");
        else if (currentRoom==trollBridge && hasTroll && command.isWest()) {print("The troll blocks your way.");print("Troll: 'This is my bridge! If you want to pass my bridge, you must pay a toll! Cash only! We don't accept credit cards or checks!'");} 
        else if (currentRoom==cerberusLair && command.isNorth() && hasDog) {print("You run towards the chest, but Cerberus sees you and immediately gobbles you up with his three jaws. Bad move.");lose=true;}
        else if (command.isNorth()) goTo(currentRoom.getNorth());
        else if (command.isSouth()) goTo(currentRoom.getSouth());
        else if (command.isEast()) goTo(currentRoom.getEast());
        else if (command.isWest()) goTo(currentRoom.getWest());
        else if (command.isUp()) goTo(currentRoom.getUp());
        else if (command.isDown()) goTo(currentRoom.getDown());
        else print("code went poopy :(");
    }

    private static void goTo(int ID)
    {
        if (ID == 0) print("You can't go that way.");
        else {
            currentRoom.setDiff(true);
            for (int i=0; i<rooms.size(); i++)
                if (rooms.get(i).getID() == ID)
                    currentRoom = rooms.get(i);
        }
    }

    private static void take()
    {
        if (command.isTakeAll()){
            int x = 0;
            for (int i=0; i<currentRoom.getItems().size(); i++){
                if (currentRoom.getItems().get(i).canMove()){
                    if (x==0)System.out.println("> "+currentRoom.getItems().get(i)+": taken.");
                    else System.out.println("  "+currentRoom.getItems().get(i)+": taken.");
                    player.add(currentRoom.getItems().get(i));
                    x++;
                }
                else {//if you aren't allowed to take that item
                    if (x==0)System.out.println("> "+currentRoom.getItems().get(i)+": You can't take that.");
                    else System.out.println("  "+currentRoom.getItems().get(i)+": You can't take that.");
                    x++;
                }
            }
            currentRoom.removeAll();
        }
        else {
            if (command.getObject().equals("")) print("What do you want to take?");            
            else if (player.has(command.objToItem(items))) print("You already have a "+command.objToItem(items)+".");
            else if (!currentRoom.has(command.objToItem(items))) print("You don't see a "+command.objToItem(items)+" here.");
            else if (currentRoom==swordInTheStone && command.objToItem(items).is(sword)) print("You tug at the hilt with all your might, but the sword remains stuck.");
            else if (!command.objToItem(items).canMove()) print("You can't move the "+command.objToItem(items)+".");
            else {
                currentRoom.remove(command.objToItem(items));
                if (!currentRoom.has(command.objToItem(items))){print("Taken.");player.add(command.objToItem(items));}
            }
        }
    }

    private static void drop(){
        if (command.isDropAll()){
            int x = 0;
            for (int i=0; i<player.getInv().size(); i++){
                if (x==0)System.out.println("> "+player.getInv().get(i)+": dropped.");
                else System.out.println("  "+player.getInv().get(i)+": dropped.");
                currentRoom.add(player.getInv().get(i));
                x++;
            }
            player.removeAll();
        }
        else {
            if (!command.hasObject()) print("What do you want to open?");
            else if (!player.has(command.objToItem(items)))print("You don't have a "+command.objToItem(items)+".");
            else{
                player.remove(command.objToItem(items));
                currentRoom.add(command.objToItem(items));
                print("Dropped.");
            }
        }
    }

    private static void open()
    {
        if (!command.hasObject()) print("What do you want to open?");
        else if (!player.has(command.objToItem(items)) && !currentRoom.has(command.objToItem(items))) print("You don't see a "+command.objToItem(items)+" here.");
        else if (!command.objToItem(items).isContainer()) print("You can't open that.");
        else if (command.objToItem(items).isOpen()) print("That is already open.");
        else if (hasDog && currentRoom==cerberusLair) {print("You run towards the chest, but Cerberus sees you and immediately gobbles you up with his three jaws. Bad move.");lose=true;}
        else if (!command.objToItem(items).isKnown()){
            if (command.objToItem(items).getContents().size()==0) print("Opened.");
            else {
                print("Opening the "+command.objToItem(items)+" reveals:");
                for (int i=0;i<command.objToItem(items).getContents().size();i++) System.out.println("    a "+command.objToItem(items).getContents().get(i));
            }
            command.objToItem(items).open();command.objToItem(items).setKnown(true);
        }
        else{
            command.objToItem(items).open();
            print("Opened.");
        }
    }

    private static void close()
    {
        if (!command.hasObject()) print("What do you want to close?");
        else if (!player.has(command.objToItem(items)) && !currentRoom.has(command.objToItem(items))) print("You don't see a "+command.objToItem(items)+" here.");
        else if (!command.objToItem(items).isContainer()) print("You can't close that.");
        else if (!command.objToItem(items).isOpen()) print("That is already closed.");
        else{
            command.objToItem(items).close();
            print("Closed.");
        }
    }

    private static void eat(){
        if (!command.hasObject()) print("What do you want to eat?");
        else if (!player.has(command.objToItem(items)) && !currentRoom.has(command.objToItem(items))) print("You don't have a "+command.objToItem(items)+".");
        else if (command.objToItem(items).is(bone)){player.remove(bone);currentRoom.remove(bone);print("Assuming your inner canine, you devour the bone.");}
        else print("You can't eat that.");
    }

    private static void other()
    {
        if (command.isInv()) player.printInv();
        if (command.isScore()) print("Your score is "+score+"/100");
        if (command.isHelp()) 
        {
            print("To play, enter a commmand that consists of an actionable verb, and an object. Actionable verbs include (but aren't limited to):");
            System.out.println("      TALK");
            System.out.println("      TAKE");
            System.out.println("      DROP");
            System.out.println("      BREAK");
            System.out.println("      OPEN");
            System.out.println("      CLOSE");
            System.out.println("      EAT");
            System.out.println("      KILL");
            System.out.println("      LIGHT");
            System.out.println("      GIVE <item> TO <character>");
            System.out.println("      PUT <item> IN <container>");
            print("Enter N, S, E, W, U, D to navigate between rooms.");
            print("Type LOOK to see the room description.");
            print("Type INV to view your inventory.");
            print("Type SCORE to view your score.");
        }
        if (command.isLook()){
            currentRoom.setDiff(true);
            currentRoom.setNew(true);
            currentRoom.printInfo();
        }
    }

    private static void restart()
    {

    }

    private static void print(String str)//method reformats System.out.println() to automatically insert line breaks.
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

    private static void saveRooms()
    {
        if (!trollBridge.has(troll)) {hasTroll=false;trollBridge.setInfo("You stand on a bridge that crosses a large ravine. The bridge continues west, and a passageway leads east.");}
        if (!cellar.has(board)) {hasBoard=false;cellar.setInfo("You stand in a dank dungeon of a place. Through a heavy gate to the north, you can see a room gleaming with treasures. A corridor leads east and west. A small marble pedestal stands in the middle of the room before the gate. A stairway leads up.");}
        if (!ratRoom.has(rat)) {isPinned=false;ratRoom.setInfo("A rat-sized hole leads downward. There are exits to the north and west.");}
        if (cellar.has(orb)) {hasOrb=true;cellar.setInfo("You stand in a dank dungeon of a place. A glownig orb sits on small marble pedestal. A heavy gate opens to the north to a room full of treasure. A corridor leads east and west. A stairway leads up.");}
        if (!cerberusLair.has(cerberus)) {hasDog=false;mustyCave.setInfo("You stand in the middle of an old cave. Moss grows on all of the walls. The cave continues west, and bridge leads east. To the north the cave branches off.");cerberusLair.setInfo("You stand in a huge empty cave. There is a golden chest at the far end of the room. An exit is to the south.");}
        if (!tntRoom.has(tnt)) {tntRoom.setInfo("A passage leads south, and there is a smoldering hole in the wall to the north.");}
        if (!swordInTheStone.has(sword)) {swordInTheStone.setInfo("The cave reaches a dead end here. In the middle of the room there is a mighty sword stuck in a stone by the blade. Scrawled on the cave wall are the words 'SAY MY NAME'.");}
        if (!ratHole.has(bone)) {ratHole.setInfo("You crouch in the dwelling place of the rat. The hole exits upward.");}
        while (rooms.size()>0)rooms.remove(0);
        rooms.add(throneRoom);
        rooms.add(cellar);
        rooms.add(treasury);
        rooms.add(eastCorridor);
        rooms.add(ratRoom);
        rooms.add(ratHole);
        rooms.add(tntRoom);
        rooms.add(armory);
        rooms.add(westCorridor);
        rooms.add(trollBridge);
        rooms.add(mustyCave);
        rooms.add(swordInTheStone);
        rooms.add(cerberusLair);
    }

}
