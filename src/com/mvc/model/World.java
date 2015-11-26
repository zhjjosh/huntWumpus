
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
        wumpus = layout.getWumpusLocation();       
        monster = layout.getMonsterLocation();
        flyingBird = layout.getFlyingBirdLocation();
        location = layout.getPlayerLocation();
        monsterStatus = 0;
    }
    
    public String MonsterCheck(boolean check) {
        if (check){
            setMonsterStatus(getMonsterStatus() + 1);
        }
        if (getLocation().equals(getFlyingBird())){
            return "1";
        }else if (getLocation().equals(getMonster())){
            if (getMonsterStatus()%3 == 1){
                return "2";
            }else if (getMonsterStatus()%3 == 2){
                return "3";
            }else{
                 return "4";
            }
        }else if (getLocation().equals(getWumpus())){
            return "5";
        }else {
            return "0";
        }
        
    }
    
    public String getFlyingBirdText(String s) {
        return "There is a flying bird in this room " + s + ".\nYou are told that the wumpus is "+ distance(getLocation(), getWumpus())+" rooms away";
    }
    
    public String getSleepMonsterText(String s) {
        return "There is a Monster in room " + s + ", but it is sleeping now.\nYou have opened the tresure box,\nwhich send you to a room which is just beside Wumpus";
    }
    
    public String getHappyMonsterText(String s) {
        return "There is a Monster in room " + s + ". It is very happy now.\nYou can go backto the previous room, \nbut you cannot open the tresure box";
    }
    
    public String getAngryMonsterText(String s) {
        return "There is a Monster in  room " + s + ". It is very angry now.\nYou cannot open the treasure box.\nThe monter will send you to another room randomly";
    }
    
    public String getWumpusText(String s) {
        return "Wumpus is in this room " + s + ", You are killed..\nPlease click continue to try again \nor click exit to leave the game";
    }
    
    public String getVictoryText() {
        return "Wumpus has been killed. You have won the game.\nPlease click continue to try again \nor click exit to leave the game";
    }
    
    public String getShootFailedText() {
        return "Wrong room. Wumpus came to your room and killed you.\nPlease click continue to try again \nor click exit to leave the game";
    }
    
    public void setFlyingBird(){
        setFlyingBird(getLayout().getFlyingBirdLocation());
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
	ArrayList <Edge>  wumpusEdge = getWumpus().edges;
        ArrayList <Edge>  monsterEdge = getMonster().edges;
        boolean creatureCheck = false;
        int i = 0;
        while (i<3){
            if (wumpusEdge.get(i).to.equals(location.getLabel())){
                s += "\nI smell a wumpus";
                creatureCheck = true;
            }
            i++;
        }
        
        i = 0;
        while (i<3){
            if (monsterEdge.get(i).to.equals(location.getLabel())){
                s += "\nMonster nearby";
                 creatureCheck = true;
            }
            i++;
        }
        
        if (!creatureCheck){
            s += "\nThere are no creature in this room";
        }
        
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
     
     public String getWumpusRoom() {
	ArrayList <Edge>  ale = getWumpus().edges;
        return ale.get(0).to;
    }
     
     public String getRandomRoom() {
        return getLayout().generateRandom();
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

    /**
     * @return the monsterStatus
     */
    public int getMonsterStatus() {
        return monsterStatus;
    }

    /**
     * @param monsterStatus the monsterStatus to set
     */
    public void setMonsterStatus(int monsterStatus) {
        this.monsterStatus = monsterStatus;
    }
    
}
