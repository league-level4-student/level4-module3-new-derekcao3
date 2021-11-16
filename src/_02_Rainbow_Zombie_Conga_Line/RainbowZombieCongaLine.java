package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;

    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	congaLine.getHead().setValue(dancer);
    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	congaLine.getTail().setValue(dancer);
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	Node<Zombie> node= congaLine.getHead();
    	for (int i = 0; i < position; i++) {
			node = node.getNext();
		}
    	node.setValue(dancer);
    }

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	Node<Zombie> node= congaLine.getHead();
    for (int i = 0; i < congaLine.size(); i++) {
		if(node.getValue().getZombieHatColor().equals(dancer.getZombieHatColor())) {
			congaLine.remove(i); 
		}
		node = node.getNext();
	}
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {
       	Node<Zombie> node= congaLine.getHead();
        for (int i = 0; i < congaLine.size(); i++) {
    		if(node.getValue().getZombieHatColor().equals(dancer.getZombieHatColor())) {
    			congaLine.remove(i); 
    			break;
    		}
    		node = node.getNext();
    	}
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	Zombie zombie1 = new Zombie(dancer.getZombieHatColor());
    	Zombie zombie2 = new Zombie(dancer.getZombieHatColor());
    	congaLine.getHead().setValue(zombie1);
    	Node<Zombie> node= congaLine.getHead();
        for (int i = 0; i < congaLine.size()/2; i++) {
    		node = node.getNext();
    	}
        node.getNext().setValue(zombie2);
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {
    	Zombie zombie1 = new Zombie(ZombieHatColor.R);
    	Zombie zombie2 = new Zombie(ZombieHatColor.O);
    	Zombie zombie3 = new Zombie(ZombieHatColor.Y);
    	Zombie zombie4 = new Zombie(ZombieHatColor.G);
    	Zombie zombie5 = new Zombie(ZombieHatColor.B);
    	Zombie zombie6 = new Zombie(ZombieHatColor.I);
    	Zombie zombie7 = new Zombie(ZombieHatColor.V);
    	congaLine.add(dancer);
    	congaLine.add(zombie1);
    	congaLine.add(zombie2);
    	congaLine.add(zombie3);
    	congaLine.add(zombie4);
    	congaLine.add(zombie5);
    	congaLine.add(zombie6);
    	congaLine.add(zombie7);
    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
