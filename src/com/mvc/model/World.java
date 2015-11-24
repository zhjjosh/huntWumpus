
package com.mvc.model;

import java.util.ArrayList;
import java.util.Stack;

public class World extends Graph {

    private Room wumpus;
    private Room flyingBird;
    private Room location;
    private Room monster;
    private Layout layout;
    private int monsterStatus;
    
    public World( Layout ly ) {
        super( ly.getRooms() );
        this.layout = ly; 
        wumpus = ly.getWumpusLocation();
        location = ly.getPlayerLocation();
        flyingBird = ly.getFlyingBirdLocation();
        monster = ly.getMonsterLocation();
        monsterStatus = 0;
    }
    
    public String MonsterCheck() {
        monsterStatus++;
        if (location.equals(flyingBird)){
            return "1";
        }else if (location.equals(monster)){
            if (monsterStatus%3 == 1){
                return "2";
            }else if (monsterStatus%3 == 2){
                return "3";
            }else{
                 return "4";
            }
        }else if (location.equals(wumpus)){
            return "5";
        }else {
            return "0";
        }
        
    }
    
    public String getFlyingBirdText(String s) {
        return "There is a flying bird in this room " + s + ".\nYou are told that the wumpus is "+ distance( location, wumpus )+" rooms away";
    }
    
    public String getSleepMonsterText(String s) {
        return "There is a Monster in room " + s + ", but it is sleeping now.\nYou have opened the tresure box, which send you to a room which is just beside Wumpus";
    }
    
    public String getHappyMonsterText(String s) {
        return "There is a Monster in room " + s + ". It is very happy now.\nYou can go through the room, but you cannot open the tresure box";
    }
    
    public String getAngryMonsterText(String s) {
        return "There is a Monster in  room " + s + ". It is very angry now.\nYou cannot open the treasure box.\nthe monter will send you to another room randomly";
    }
    
    public String getWumpusText(String s) {
        return "Wumpus is in this room " + s + ", You are killed..\nPlease click continue to try again or click exit to leave the game";
    }
    public String getVictoryText(String s) {
        return "Wumpus has been killed. You have won the game.\nPlease click continue to try again \nor click exit to leave the game";
    }
    
    public Room getRoom( String r) {
        return (Room) getNode( r );
    }

    public boolean enter(Room r) { 
	ArrayList <Edge> ale = getLocation().edges;
	for ( Edge e : ale ) {
            if ( ( r.getLabel()).equals( e.to ) ) {
		setLocation(r);
		return true;
            }
	}
	return false;
    }
    
    public void enterRoom(String s) { 
        setLocation(this.getLayout().getPlayerCurrentLocation(s));
    }

    public String describe() {
	String s = getLocation().describe();
	s += "\nThere are no creature in this room";
	return s;
    }
    
     public String[] getRooms() {
	ArrayList <Edge>  ale = getLocation().edges;
        String[] rooms = new String[3];
        int i = 0;
        while ( i < 3){
            rooms[i] = ale.get(i).to;
            i++;
        }
        return rooms;
    }

    public boolean shoot( Room r ) {
	if ( ( r.getLabel() ).equals(getWumpus().getLabel()) )
            return true;
	Stack <Edge> sp = findShortestPath(getLocation(), r );
	//to do: traverse the path; if it passes through the wumpus room, return true
	return false;
    }

    public String shortestPath( Room to ) {
	Stack <Edge> es = findShortestPath(getLocation(), to );
	String path = "";
	while ( !es.empty() ) {
            Edge e = es.pop();
            path += "\t"+e.from+" to "+e.to+"\n";
	}
	return path;
    }

    /**
     * @return the wumpus
     */
    public Room getWumpus() {
        return wumpus;
    }

    /**
     * @param wumpus the wumpus to set
     */
    public void setWumpus(Room wumpus) {
        this.wumpus = wumpus;
    }

    /**
     * @return the location
     */
    public Room getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Room location) {
        this.location = location;
    }

    /**
     * @return the layout
     */
    public Layout getLayout() {
        return layout;
    }

    /**
     * @param layout the layout to set
     */
    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    /**
     * @return the flyingBird
     */
    public Room getFlyingBird() {
        return flyingBird;
    }

    /**
     * @param flyingBird the flyingBird to set
     */
    public void setFlyingBird(Room flyingBird) {
        this.flyingBird = flyingBird;
    }

    /**
     * @return the monster
     */
    public Room getMonster() {
        return monster;
    }

    /**
     * @param monster the monster to set
     */
    public void setMonster(Room monster) {
        this.monster = monster;
    }
    
}
